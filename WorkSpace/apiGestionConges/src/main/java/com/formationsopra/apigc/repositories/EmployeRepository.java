package com.formationsopra.apigc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.formationsopra.apigc.entities.Employe;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Integer> {

	// récupérer les employés en fonction d'un manager
	@Query("select emp from Employe emp where emp.manager.id=:id")
	public List<Employe> findAllEmployeByManagerId(@Param("id") Integer id);

	// récupérer les employés en fonction d'un service
	@Query("select emp from Employe emp left join fetch emp.login where emp.service.id=:id and emp.login.role='ROLE_USER'")
	public List<Employe> findAllEmployeByServiceId(@Param("id") Integer id);

	// récupérer les employés en fonction d'un service
	@Query("select emp from Employe emp left join fetch emp.login where emp.service.id=:id and emp.login.role='ROLE_MANAGER'")
	public List<Employe> findAllManagerByServiceId(@Param("id") Integer id);

	// récupérer les managers
	@Query("select emp from Employe emp left join fetch emp.login where emp.login.role='ROLE_MANAGER'")
	public List<Employe> findAllManager();

	// récupérer les employes
	@Query("select emp from Employe emp  left join fetch emp.login where emp.login.role='ROLE_USER'")
	public List<Employe> findAllUser();

}
