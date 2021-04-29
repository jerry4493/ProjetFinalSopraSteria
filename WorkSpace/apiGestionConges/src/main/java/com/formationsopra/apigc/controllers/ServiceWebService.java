package com.formationsopra.apigc.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formationsopra.apigc.entities.Service;
import com.formationsopra.apigc.repositories.ServiceRepository;

@RestController
@RequestMapping("/service")
@CrossOrigin(origins = "*")
public class ServiceWebService {

	@Autowired
	private ServiceRepository serviceRepository;

	@GetMapping(value = "/list", produces = "application/json")
	public List<Service> getAll() {
		return serviceRepository.findAll();
	}

	@GetMapping(value = "/get/{pId}", produces = "application/json")
	public Optional<Service> getOne(@PathVariable("pId") Integer id) {
		return serviceRepository.findById(id);
	}

	@PostMapping(value = "/add", produces = "application/json")
	public Service addOne(@RequestBody Service service) {
//		if (br.hasErrors()) {
//			// throw new FormateurInvalidException();
//			System.out.println("Il y a une erreur dans l'ajout du service !");
//		}
		return serviceRepository.save(service);
	}

	@PutMapping(value = "/update", produces = "application/json")
	public Service updateOne(@RequestBody Service service) {
		return serviceRepository.save(service);
	}

	@DeleteMapping(value = "/delete/{pId}", produces = "application/json")
	public boolean deleteOne(@PathVariable("pId") Integer id) {
		try {
			serviceRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@DeleteMapping(value = "/delete", produces = "application/json")
	public boolean delete(@RequestBody Service service) {
		try {
			serviceRepository.delete(service);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
