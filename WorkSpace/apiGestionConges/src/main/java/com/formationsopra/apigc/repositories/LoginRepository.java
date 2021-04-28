package com.formationsopra.apigc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formationsopra.apigc.entities.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {

}

