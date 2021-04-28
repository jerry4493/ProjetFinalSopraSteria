package com.formationsopra.apigc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formationsopra.apigc.entities.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {

}

