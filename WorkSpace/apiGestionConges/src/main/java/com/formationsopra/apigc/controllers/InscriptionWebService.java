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

import com.formationsopra.apigc.repositories.LoginRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/inscription")
public class InscriptionWebService {

	@Autowired
	private LoginRepository loginRepository;
	@Autowired
	private RoleLoginRepository roleLoginRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/{login}")
	public boolean checkLogin(@PathVariable("login") String login) {
		Optional<Login> opt= loginRepository.findByLogin(login);
		return opt.isPresent();
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public void inscription(@RequestBody Login login) {
		login.setEnable(true);
		login.setPassword(passwordEncoder.encode(login.getPassword()));
		loginRepository.save(login);
		RoleLogin roleLogin=new RoleLogin();
		roleLogin.setLogin(login);
		roleLogin.setRole(Role.ROLE_USER);
		roleLoginRepository.save(roleLogin);
	}
}
