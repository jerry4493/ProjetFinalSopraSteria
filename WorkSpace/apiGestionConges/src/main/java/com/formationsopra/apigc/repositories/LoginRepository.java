package com.formationsopra.apigc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formationsopra.apigc.entities.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {

}

