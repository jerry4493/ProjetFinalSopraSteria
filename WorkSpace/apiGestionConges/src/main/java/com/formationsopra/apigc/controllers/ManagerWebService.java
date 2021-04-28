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

import com.formationsopra.apigc.entities.Manager;
import com.formationsopra.apigc.repositories.ManagerRepository;

@RestController
@RequestMapping("/manager")
@CrossOrigin(origins = "*")
public class ManagerWebService {

	@Autowired
	private ManagerRepository managerRepository;
	

	@GetMapping(value = "/list", produces = "application/json")
	public List<Manager> getAll() {
		return managerRepository.findAll();
	}
	
	@GetMapping(value = "/get/{pId}", produces = "application/json")
	public Manager getOne(@PathVariable("pId") Integer id) {
		return managerRepository.getOne(id);
	}
	
	@PostMapping(value = "/add", produces = "application/json")
	public Manager addOne(@RequestBody Manager manager) {
		try {
			Manager temp = managerRepository.save(manager);
			return temp;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
		
		@PutMapping(value = "/update", produces = "application/json")
		public Manager updateOne(@RequestBody Manager manager) {
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
		public boolean delete(@RequestBody Manager manager) {
			try {
				managerRepository.delete(manager);
				return true;
			} catch (Exception e) {
			    e.printStackTrace();
			}
			return false;
		}
	
}