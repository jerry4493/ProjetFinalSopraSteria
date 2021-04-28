package com.formationsopra.apigc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formationsopra.apigc.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
