package com.formationsopra.apigc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.formationsopra.apigc.entities.Employe;
import com.formationsopra.apigc.entities.Login;
import com.formationsopra.apigc.entities.Role;
import com.formationsopra.apigc.entities.Service;
import com.formationsopra.apigc.repositories.EmployeRepository;
import com.formationsopra.apigc.repositories.LoginRepository;
import com.formationsopra.apigc.repositories.ServiceRepository;

@SpringBootApplication
public class ApiGestionCongesApplication implements CommandLineRunner {
	
	@Autowired
	private EmployeRepository empRepo;
	
	@Autowired
	private LoginRepository logRepo;
	
	@Autowired
	private ServiceRepository servRepo;

	public static void main(String[] args) {
		SpringApplication.run(ApiGestionCongesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Hello world!");
		
//		Login login1 = new Login("a@a.fr", "sopra", Role.ROLE_USER);
//		logRepo.save(login1);
//		Service service1 = new Service("informatique", null);
//		servRepo.save(service1);
//		Employe emp = new Employe("Julie", "ROBERT", null, null, null, null);
//		empRepo.save(emp);
		
//		List<Employe> listeEmploye = empRepo.findAll();
//		for (Employe employe : listeEmploye) {
//			System.out.println(employe);
//		}
//		List<Service> listeService = servRepo.findAll();
//		for (Service service : listeService) {
//			System.out.println(service.getNom());
//		}
	}

}
