package com.formationsopra.apigc.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "conges")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@SequenceGenerator(name = "seqConges", sequenceName = "seq_conges", initialValue = 10, allocationSize = 1)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Conges.class)
@JsonSerialize
public class Conges implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8616944159904289315L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqConges")
	private Integer id;
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	private TypeConge typeConges;
	@NotNull
	@Column(name = "date_demande", length = 15, nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateDemande;
	@NotNull
	@Column(name = "date_debut", length = 15, nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateDebut;
	@NotNull
	@Column(name = "date_fin", length = 15, nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateFin;
	@NotEmpty
	@Lob
	@Type(type = "org.hibernate.type.TextType")
	private String motif;

	@ManyToOne
	@JoinColumn(name = "employe_id", referencedColumnName = "id")
	private Employe employe;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "statut")
	private StatutValidation statutValidation;
	


	public Conges() {
	}

	public StatutValidation getStatutValidation() {
		return statutValidation;
	}

	public void setStatutValidation(StatutValidation statutValidation) {
		this.statutValidation = statutValidation;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDateDemande() {
		return dateDemande;
	}

	public void setDateDemande(LocalDate dateDemande) {
		this.dateDemande = dateDemande;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public TypeConge getTypeConges() {
		return typeConges;
	}

	public void setTypeConges(TypeConge typeConges) {
		this.typeConges = typeConges;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
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
		Conges other = (Conges) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
