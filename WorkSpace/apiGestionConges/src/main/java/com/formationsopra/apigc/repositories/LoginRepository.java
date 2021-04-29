package com.formationsopra.apigc.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.formationsopra.apigc.entities.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
	public Optional <Login> findByEmail(String email);
//	@Query("select l from Login l where l.login=:login")
//	Optional<Login> findByLogin(@Param("login") String login);

}

