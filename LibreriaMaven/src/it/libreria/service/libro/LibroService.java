package it.libreria.service.libro;

import java.util.List;

import it.libreria.dao.libro.LibroDAO;
import it.libreria.model.Genere;
import it.libreria.model.Libro;



public interface LibroService {

	public List<Libro> listAll() throws Exception;

	public Libro caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Libro libroInstance) throws Exception;

	public void inserisciNuovo(Libro libroInstance) throws Exception;

	public void rimuovi(Libro libroInstance) throws Exception;

	public void aggiungiGenere(Libro libroInstance, Genere genereInstance) throws Exception;
	
	public void nuovoLibroConGenere(Libro libroInstance, Genere genereInstance) throws Exception;
	
	public List<Libro> cercaLibroPerGenere(Genere genereInput) throws Exception;

	public List<Libro> cercaLibriPerDescrizione(String descrizioneInput) throws Exception;
	
	public Long sommaPrezziLibriConGenere(Genere genereInput) throws Exception;

	// per injection
	public void setLibroDAO(LibroDAO libroDAO);
}
