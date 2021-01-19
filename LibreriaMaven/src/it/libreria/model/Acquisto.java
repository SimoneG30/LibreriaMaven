package it.libreria.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "acquisto")
public class Acquisto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nomeacquirente")
	private String nomeAcquirente;
	@Column(name = "eta")
	private Integer etaAcquirente;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "acquisto")
	private Set<Libro> libriAcquistati = new HashSet<>();
	
	public Acquisto() {
		
	}

	public Acquisto(String nomeAcquirente, Integer etaAcquirente) {
		super();
		this.nomeAcquirente = nomeAcquirente;
		this.etaAcquirente = etaAcquirente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeAcquirente() {
		return nomeAcquirente;
	}

	public void setNomeAcquirente(String nomeAcquirente) {
		this.nomeAcquirente = nomeAcquirente;
	}

	public Integer getEtaAcquirente() {
		return etaAcquirente;
	}

	public void setEtaAcquirente(Integer etaAcquirente) {
		this.etaAcquirente = etaAcquirente;
	}

	public Set<Libro> getLibriAcquistati() {
		return libriAcquistati;
	}

	public void setLibriAcquistati(Set<Libro> libriAcquistati) {
		this.libriAcquistati = libriAcquistati;
	}
	
	@Override
	public String toString() {
		return "Acquisto [id=" + id + ", nomeacquirente=" + nomeAcquirente + ", etaacquirente=" + etaAcquirente + "]";
	}
	
	
	
}
