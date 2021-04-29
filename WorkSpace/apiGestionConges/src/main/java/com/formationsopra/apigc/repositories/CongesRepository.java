package com.formationsopra.apigc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.formationsopra.apigc.entities.Conges;
import com.formationsopra.apigc.entities.Employe;

@Repository
public interface CongesRepository extends JpaRepository<Conges, Integer> {
	
	// récupérer un employe en fonction d'un login
	@Query("select cong from Conges cong left join fetch cong.employe where cong.employe.manager.id=:id")
	public List<Conges> findCongesByManager(@Param("id") Integer id);
	
//	select *
//	from conges cong
//	left join employe emp on cong.employe_id=emp.id
//	where emp.manager_id = 11;

}

