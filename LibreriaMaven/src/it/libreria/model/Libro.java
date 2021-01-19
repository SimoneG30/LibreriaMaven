package it.libreria.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "libro")
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "descrizione")
	private String descrizione;
	@Column(name = "prezzosingolo")
	private int prezzoSingolo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "acquisto_id")
	private Acquisto acquisto;
	@ManyToMany
	@JoinTable(name = "libro_genere", joinColumns = @JoinColumn(name = "libro_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "genere_id", referencedColumnName = "ID"))
	private Set<Genere> generi = new HashSet<>(0);
	
	public Libro() {
		
	}

	public Libro(String descrizione, int prezzoSingolo) {
		super();
		this.descrizione = descrizione;
		this.prezzoSingolo = prezzoSingolo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getPrezzoSingolo() {
		return prezzoSingolo;
	}

	public void setPrezzoSingolo(int prezzoSingolo) {
		this.prezzoSingolo = prezzoSingolo;
	}

	public Acquisto getAcquisto() {
		return acquisto;
	}

	public void setAcquisto(Acquisto acquisto) {
		this.acquisto = acquisto;
	}

	public Set<Genere> getGeneri() {
		return generi;
	}

	public void setGeneri(Set<Genere> generi) {
		this.generi = generi;
	}
	
	@Override
	public String toString() {
		return "Libro [id=" + id + ", descrizione=" + descrizione + ", prezzosingolo=" + prezzoSingolo + "]";
	}
	
	
}
