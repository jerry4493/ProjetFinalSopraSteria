package com.formationsopra.apigc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formationsopra.apigc.entities.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer> {

}

