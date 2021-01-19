package it.libreria.service.acquisto;

import java.util.List;

import it.libreria.dao.acquisto.AcquistoDAO;
import it.libreria.model.Acquisto;
import it.libreria.model.Genere;


public interface AcquistoService {

	public List<Acquisto> listAll() throws Exception;

	public Acquisto caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Acquisto acquistoInstance) throws Exception;

	public void inserisciNuovo(Acquisto acquistoInstance) throws Exception;

	public void rimuovi(Acquisto acquistoInstance) throws Exception;
	
	public List<Acquisto> findAllAcquistiByGenere(Genere genereInput) throws Exception;

	// per injection
	public void setAcquistoDAO(AcquistoDAO acquistoDAO);
	
}
