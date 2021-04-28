package com.formationsopra.apigc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formationsopra.apigc.entities.Employe;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Integer> {
	
	public List<Employe> findAllByManagerId(Integer id);
	
	public List<Employe> findAllByServiceId(Integer id);
	
}


