package com.formationsopra.apigc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formationsopra.apigc.entities.Role;

public interface RoleLoginRepository extends JpaRepository<Role, Integer> {

}

