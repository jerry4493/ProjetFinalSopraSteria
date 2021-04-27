package com.formationsopra.apigc.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "employes")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@SequenceGenerator(name = "seqEmploye", sequenceName = "seq_employe", initialValue = 100, allocationSize = 1)
public class Employe  {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEmploye")
	private Integer id;
	//@JsonView(Views.Common.class)
	@NotEmpty
	@Column(name = "prenom", length = 150, nullable = false)
	private String prenom;
	//@JsonView(Views.Common.class)
	@Column(name = "nom", length = 150)
	@NotEmpty
	private String nom;
	@NotEmpty
	private List<Conges> conges;
	@NotEmpty
	private Manager manager;
	@NotEmpty
	private Login login;
	@NotEmpty
	private Service service;
	
	public Employe() {
		}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Conges> getConges() {
		return conges;
	}

	public void setConges(List<Conges> conges) {
		this.conges = conges;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employe other = (Employe) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
	
