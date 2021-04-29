package com.formationsopra.apigc.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.formationsopra.apigc.entities.Employe;
import com.formationsopra.apigc.repositories.EmployeRepository;
import com.formationsopra.apigc.security.CustomUserDetails;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthWebService {
	@Autowired
	EmployeRepository employeRepository;
	@ResponseStatus(HttpStatus.ACCEPTED)
	@GetMapping("/login")
	public Employe login(@AuthenticationPrincipal CustomUserDetails cud ) {
	
		return employeRepository.findEmployeByLogin(cud.getLogin().getId());
	}
}
