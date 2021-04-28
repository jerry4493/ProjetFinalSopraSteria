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
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "conges")
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

	@NotEmpty
	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	private TypeConge typeConges;
	@NotEmpty
	@Column(name = "date_demande", length = 15, nullable = false)
	private LocalDate DateDemande;
	@NotEmpty
	@Column(name = "date_debut", length = 15, nullable = false)
	private LocalDate DateDebut;
	@NotEmpty
	@Column(name = "date_fin", length = 15, nullable = false)
	private LocalDate DateFin;
	@Lob
	@Type(type = "org.hibernate.type.TextType")
	@NotEmpty
	private String motif;

	public Conges() {
	}

	public Conges(Integer id, @NotEmpty @NotEmpty TypeConge typeConge, @NotEmpty LocalDate dateDemande,
			@NotEmpty LocalDate dateDebut, @NotEmpty LocalDate dateFin, @NotEmpty String motif) {
		super();
		this.id = id;
		typeConges = typeConge;
		DateDemande = dateDemande;
		DateDebut = dateDebut;
		DateFin = dateFin;
		this.motif = motif;
	}

	public Conges(@NotEmpty @NotEmpty TypeConge typeConge, @NotEmpty LocalDate dateDemande, @NotEmpty LocalDate dateDebut,
			@NotEmpty LocalDate dateFin, @NotEmpty String motif) {
		super();
		typeConges = typeConge;
		DateDemande = dateDemande;
		DateDebut = dateDebut;
		DateFin = dateFin;
		this.motif = motif;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TypeConge getTypeConge() {
		return typeConges;
	}

	public void setTypeConge(TypeConge typeConge) {
		typeConges = typeConge;
	}

	public LocalDate getDateDemande() {
		return DateDemande;
	}

	public void setDateDemande(LocalDate dateDemande) {
		DateDemande = dateDemande;
	}

	public LocalDate getDateDebut() {
		return DateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		DateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return DateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		DateFin = dateFin;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
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
