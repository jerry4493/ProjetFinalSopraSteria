package com.formationsopra.apigc.entities;

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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "comges")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@SequenceGenerator(name = "seqConges", sequenceName = "seq_conges", initialValue = 100, allocationSize = 1)
public class Conges  {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqConges")
	private Integer id;

	@NotEmpty
	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	private String TypeConge;
	@NotEmpty
	@Column(name = "datedemande", length = 15, nullable = false)
	private LocalDate DateDemande;
	@NotEmpty
	@Column(name = "début", length = 15, nullable = false)
	private LocalDate DateDebut;
	@NotEmpty
	@Column(name = "fin", length = 15, nullable = false)
	private LocalDate DateFin;
	@NotEmpty
	private String motif;
	
	public Conges() {
		}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTypeConge() {
		return TypeConge;
	}


	public void setTypeConge(String typeConge) {
		TypeConge = typeConge;
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
	
