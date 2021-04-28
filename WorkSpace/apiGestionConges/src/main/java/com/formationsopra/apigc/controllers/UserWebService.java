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
import com.formationsopra.apigc.entities.Employe;
import com.formationsopra.apigc.entities.Role;
import com.formationsopra.apigc.repositories.EmployeRepository;

@RestController
@RequestMapping("/employe")
@CrossOrigin(origins = "*")
public class UserWebService {

	@Autowired
	private EmployeRepository userRepository;

	@GetMapping(value = "/list", produces = "application/json")
	public List<Employe> getAllUser() {
		return userRepository.findAllEmploye();
	}

	@GetMapping(value = "/get/{pId}", produces = "application/json")
	public Employe getOne(@PathVariable("pId") Integer id) {
		return userRepository.getOne(id);
	}

	@PostMapping(value = "/add", produces = "application/json")
	public Employe addOne(@RequestBody Employe user) {
		try {
			Role role = user.getLogin().getRole();
			if (role != Role.ROLE_USER) {
				userRepository.save(user);
				System.out.println("Le role attribué n'est pas bon !");
			}else {
				System.out.println("Le role attribué est bon !");
			}
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@PutMapping(value = "/update", produces = "application/json")
	public Employe updateOne(@RequestBody Employe user) {
		return userRepository.save(user);
	}

	@DeleteMapping(value = "/delete/{pId}", produces = "application/json")
	public boolean deleteOne(@PathVariable("pId") Integer id) {
		try {
			userRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@DeleteMapping(value = "/delete", produces = "application/json")
	public boolean delete(@RequestBody Employe user) {
		try {
			userRepository.delete(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@GetMapping(value = "/list/{pId}", produces = "application/json")
	public List<Employe> getAllByManager(@PathVariable("pId") Integer id) {
		return userRepository.findAllEmployeByManagerId(id);
	}
	
	@GetMapping(value = "/list/{pId}", produces = "application/json")
	public List<Employe> getAllByService(@PathVariable("pId") Integer id, @PathVariable("pRole") String role) {
		return userRepository.findAllEmployeByServiceId(id, role);
	}

}
