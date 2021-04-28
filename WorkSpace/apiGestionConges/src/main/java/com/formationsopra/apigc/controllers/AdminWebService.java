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

import com.formationsopra.apigc.entities.Admin;
import com.formationsopra.apigc.repositories.AdminRepository;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminWebService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@GetMapping(value = "/list", produces = "application/json")
	public List<Admin> getAll() {
		return adminRepository.findAll();
	}

	@GetMapping(value = "/get/{pId}", produces = "application/json")
	public Admin getOne(@PathVariable("pId") Integer id) {
		return adminRepository.getOne(id);
	}

	@PostMapping(value = "/add", produces = "application/json")
	public Admin addOne(@RequestBody Admin admin) {
		try {
			Admin temp = adminRepository.save(admin);
			return temp;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@PutMapping(value = "/update", produces = "application/json")
	public Admin updateOne(@RequestBody Admin admin) {
		return adminRepository.save(admin);
	}

	@DeleteMapping(value = "/delete/{pId}", produces = "application/json")
	public boolean deleteOne(@PathVariable("pId") Integer id) {
		try {
			adminRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@DeleteMapping(value = "/delete", produces = "application/json")
	public boolean delete(@RequestBody Admin admin) {
		try {
			adminRepository.delete(admin);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
