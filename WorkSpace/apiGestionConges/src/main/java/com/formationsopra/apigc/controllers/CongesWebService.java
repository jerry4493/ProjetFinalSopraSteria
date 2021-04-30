package com.formationsopra.apigc.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formationsopra.apigc.entities.Conges;
import com.formationsopra.apigc.entities.StatutValidation;
import com.formationsopra.apigc.repositories.CongesRepository;

@RestController
@RequestMapping("/conges")
@CrossOrigin(origins = "*")
public class CongesWebService {

	@Autowired
	private CongesRepository congesRepository;

	@GetMapping(value = "/list", produces = "application/json")
	public List<Conges> getAll() {
		return congesRepository.findAll();
	}
	
	@GetMapping(value = "/list/employe/{id}", produces = "application/json")
	public List<Conges> getCongeByEmploye(@PathVariable("id") Integer id) {
		return congesRepository.findCongeByEmploye(id);
		
	}

	@GetMapping(value = "/get/{pId}", produces = "application/json")
	Optional<Conges> getOne(@PathVariable("pId") Integer id) {
		return congesRepository.findById(id);
	}

	@PostMapping(value = "/add", produces = "application/json")
	public ResponseEntity<Conges> addOne(@RequestBody Conges conges) {
		try {
			conges.setStatutValidation(StatutValidation.En_Attente);
			Conges temp = congesRepository.save(conges);
			return new ResponseEntity<Conges>(temp , HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@PutMapping(value = "/update/{id}", produces = "application/json")
	public Conges updateOne(@RequestBody Conges conges, @PathVariable("id") Integer id) {
		Conges congeEnBase = congesRepository.findById(id).get();
		congeEnBase.setMotif(conges.getMotif());
		return congesRepository.save(conges);
	}
	
	@PatchMapping(value = "/refus/{id}")
	public Conges refus(@PathVariable("id") Integer id, @RequestBody String motif) {
		Conges congeEnBase = congesRepository.findById(id).get();
		congeEnBase.setMotif(motif);
		congeEnBase.setStatutValidation(StatutValidation.Refuse);
		return congesRepository.save(congeEnBase);
		
	}
	
	@GetMapping(value = "/valide/{id}")
	public Conges valide(@PathVariable("id") Integer id) {
		Conges congeEnBase = congesRepository.findById(id).get();
		congeEnBase.setStatutValidation(StatutValidation.Valide);
		return congesRepository.save(congeEnBase);
		
	}

	@DeleteMapping(value = "/delete/{pId}", produces = "application/json")
	public boolean deleteOne(@PathVariable("pId") Integer id) {
		try {
			congesRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@DeleteMapping(value = "/delete", produces = "application/json")
	public boolean delete(@RequestBody Conges conges) {
		try {
			congesRepository.delete(conges);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@GetMapping(value = "/list/manager/{id}", produces = "application/json")
	public List<Conges> findCongesByManager(@PathVariable("id") Integer id) {
		return congesRepository.findCongesByManager(id);
	}

}