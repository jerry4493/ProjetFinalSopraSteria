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
	@Query("select emp from Employe emp where emp.manager_id=:id")
	public List<Employe> findAllEmployeByManagerId(@Param("id") Integer id);

	// récupérer les employés en fonction d'un service
	@Query("select emp from Employe emp left join fetch emp.login log where emp.service_id=:id and log.role=:role")
	public List<Employe> findAllEmployeByServiceId(@Param("id") Integer id, @Param("role") String role);

	// récupérer les employés en fonction d'un service
	@Query("select emp from Employe emp left join fetch emp.login log where emp.service_id=:id and log.role=:role")
	public List<Employe> findAllManagerByServiceId(@Param("id") Integer id, @Param("role") String role);

	// récupérer les managers
	@Query("select emp from Employe emp left join fetch emp.login log where log.role='ROLE_MANAGER'")
	public List<Employe> findAllManager();

	// récupérer les employes
	@Query("select emp from Employe emp  left join fetch emp.login log where log.role='ROLE_USER'")
	public List<Employe> findAllEmploye();

	
	
	
	//public List<Employe> findAllByManager(Integer id);

	//public List<Employe> findAllByService(Integer id);

}
