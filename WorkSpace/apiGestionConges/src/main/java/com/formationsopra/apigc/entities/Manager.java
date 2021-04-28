package com.formationsopra.apigc.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "manager")
@SequenceGenerator(name = "seqManager", sequenceName = "seq_manager", initialValue = 10, allocationSize = 1)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Manager.class)
@JsonSerialize
public class Manager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6982293471466575993L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqManager")
	private Integer id;
	@NotEmpty
	@OneToMany(mappedBy = "manager", fetch = FetchType.LAZY)
	private List<Employe> employes;

	public Manager() {
		super();
	}

	public Manager(List<Employe> employes) {
		super();
		this.employes = employes;
	}

	public Manager(Integer id, List<Employe> employes) {
		super();
		this.id = id;
		this.employes = employes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		Manager other = (Manager) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
