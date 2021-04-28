package com.formationsopra.apigc.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "admin")
@SequenceGenerator(name = "seqAdmin", sequenceName = "seq_admin", initialValue = 100, allocationSize = 1)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope=Admin.class )
@JsonSerialize
public class Admin extends Login implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7976218273596434508L;

	public Admin() {
		super();
	}

	public Admin(Integer id, @Email String email, @NotEmpty String password, Role role) {
		super(id, email, password, role);
	}

	public Admin(@Email String email, @NotEmpty String password, Role role) {
		super(email, password, role);
	}
	
	
	
}
