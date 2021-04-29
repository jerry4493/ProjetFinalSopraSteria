package com.formationsopra.apigc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formationsopra.apigc.entities.Conges;

@Repository
public interface CongesRepository extends JpaRepository<Conges, Integer> {
	
	//public List<Conges> findAllByEmployeId(Integer id);

}

