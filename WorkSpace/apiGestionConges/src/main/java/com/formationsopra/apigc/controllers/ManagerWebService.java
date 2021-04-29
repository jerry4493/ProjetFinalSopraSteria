package com.formationsopra.apigc.controllers;

import java.util.List;
import java.util.Optional;

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

import com.formationsopra.apigc.entities.Employe;
import com.formationsopra.apigc.entities.Role;
import com.formationsopra.apigc.repositories.EmployeRepository;

@RestController
@RequestMapping("/manager")
@CrossOrigin(origins = "*")
public class ManagerWebService {

	@Autowired
	private EmployeRepository managerRepository;

	@GetMapping(value = "/list", produces = "application/json")
	public List<Employe> getAllManager() {
		return managerRepository.findAllManager();
	}

	@GetMapping(value = "/get/{pId}", produces = "application/json")
	public Optional<Employe> getOneManager(@PathVariable("pId") Integer id) {
		return managerRepository.findById(id);
	}

	@PostMapping(value = "/add", produces = "application/json")
	public Employe addOneManager(@RequestBody Employe manager) {
		try {
			Role role = manager.getLogin().getRole();
			if (role != Role.ROLE_MANAGER) {
				managerRepository.save(manager);
				System.out.println("Le role attribué n'est pas bon !");
			}else {
				System.out.println("Le role attribué est bon !");
			}
			return manager;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@PutMapping(value = "/update", produces = "application/json")
	public Employe updateOneManager(@RequestBody Employe manager) {
		return managerRepository.save(manager);
	}

	@DeleteMapping(value = "/delete/{pId}", produces = "application/json")
	public boolean deleteOne(@PathVariable("pId") Integer id) {
		try {
			managerRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@DeleteMapping(value = "/delete", produces = "application/json")
	public boolean delete(@RequestBody Employe manager) {
		try {
			managerRepository.delete(manager);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@GetMapping(value = "/list/{pId}", produces = "application/json")
	public List<Employe> getAllByService(@PathVariable("pId") Integer id) {
		return managerRepository.findAllManagerByServiceId(id);
	}

}