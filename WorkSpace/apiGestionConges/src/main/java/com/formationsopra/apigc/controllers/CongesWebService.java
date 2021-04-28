package com.formationsopra.apigc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formationsopra.apigc.entities.Conges;
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
	
	@GetMapping(value = "/get/{pId}", produces = "application/json")
	public Conges getOne(@PathVariable("pId") Integer id) {
		return congesRepository.getOne(id);
	}
	
	@PostMapping(value = "/add", produces = "application/json")
	public Conges addOne(@RequestBody Conges conges) {
		try {
			Conges temp = congesRepository.save(conges);
			return temp;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
		
		@PutMapping(value = "/update", produces = "application/json")
		public Conges updateOne(@RequestBody Conges conges) {
			return congesRepository.save(conges);
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
	
}