package com.formationsopra.apigc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formationsopra.apigc.entities.Login;
import com.formationsopra.apigc.repositories.LoginRepository;

@RestController
@RequestMapping("/inscription")
@CrossOrigin(origins = "*")
public class InscriptionWebService {

	@Autowired
	private LoginRepository loginRepository;
	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//
//	@GetMapping("/{login}")
//	public boolean checkLogin(@PathVariable("login") String login) {
//		loginRepository.findBy
//		return true;
//	}
	
	//=============== CRUD
	@GetMapping(value = "/list", produces = "application/json")
	public List<Login> getAll() {
		return loginRepository.findAll();
	}

	@GetMapping(value = "/get/{pId}", produces = "application/json")
	public Login getOne(@PathVariable("pId") Integer id) {
		return loginRepository.getOne(id);
	}

	@PostMapping(value = "/add", produces = "application/json")
	public Login addOne(@RequestBody Login login) {
		try {
			Login temp = loginRepository.save(login);
			return temp;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@PutMapping(value = "/update", produces = "application/json")
	public Login updateOne(@RequestBody Login login) {
		return loginRepository.save(login);
	}

	@DeleteMapping(value = "/delete/{pId}", produces = "application/json")
	public boolean deleteOne(@PathVariable("pId") Integer id) {
		try {
			loginRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@DeleteMapping(value = "/delete", produces = "application/json")
	public boolean delete(@RequestBody Login login) {
		try {
			loginRepository.delete(login);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}