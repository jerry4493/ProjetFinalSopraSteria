package com.formationsopra.apigc.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "service")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@SequenceGenerator(name = "seqService", sequenceName = "seq_service", initialValue = 10, allocationSize = 1)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Service.class)
@JsonSerialize
public class Service implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4896302198779264168L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqService")
	private Integer id;
	@NotEmpty
	@Column(name = "nom", unique = true, nullable = false)
	private String nom;
	@NotEmpty
	@OneToMany(mappedBy = "service", fetch = FetchType.EAGER)
	private List<Employe> employes;

	public Service() {
		super();
	}

	public Service(String nom, List<Employe> employes) {
		super();
		this.nom = nom;
		this.employes = employes;
	}

	public Service(Integer id, String nom, List<Employe> employes) {
		super();
		this.id = id;
		this.nom = nom;
		this.employes = employes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
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
		Service other = (Service) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Service [id=" + id + ", nom=" + nom + ", employes=" + employes + "]";
	}

}
