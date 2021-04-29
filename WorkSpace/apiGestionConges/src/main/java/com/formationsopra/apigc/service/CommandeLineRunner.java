package com.formationsopra.apigc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.formationsopra.apigc.repositories.LoginRepository;
@Service
public class CommandeLineRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		encryptpwd();
	}

	@Autowired
	PasswordEncoder encoder;
	@Autowired
	LoginRepository loginrepository;

	private void encryptpwd() {
		loginrepository.findAll().stream().forEach(login -> {
			login.setPassword(encoder.encode(login.getPassword()));
			loginrepository.save(login);
		});
		;
	}

}
