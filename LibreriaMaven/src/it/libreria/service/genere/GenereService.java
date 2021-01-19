package it.libreria.service.genere;

import java.util.List;

import it.libreria.dao.genere.GenereDAO;
import it.libreria.model.Acquisto;
import it.libreria.model.Genere;
import it.libreria.model.Libro;



public interface GenereService {

	public List<Genere> listAll() throws Exception;

	public Genere caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Genere genereInstance) throws Exception;

	public void inserisciNuovo(Genere genereInstance) throws Exception;

	public void rimuovi(Genere genereInstance) throws Exception;
		
	public List<Genere> cercaGenerePerLibro(Libro libroInput);
	
	public List<Genere> cercaGeneriPerDescrizione(String genereInput);

	public List<Genere> trovaTutteLeGeneriDaAcquisto(Acquisto acquistoInput) throws Exception;


	// per injection
	public void setGenereDAO(GenereDAO genereDAO);
	
}
