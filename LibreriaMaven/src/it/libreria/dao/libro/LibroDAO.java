package it.libreria.dao.libro;

import java.util.List;

import it.libreria.dao.IBaseDAO;
import it.libreria.model.Acquisto;
import it.libreria.model.Genere;
import it.libreria.model.Libro;

public interface LibroDAO extends IBaseDAO<Libro> {

	public List<Libro> findAllByGenere(Genere genereInput);
	
	public List<Libro> findAllByAcquisto(Acquisto acquistoInput);
	
	public List<Libro> findAllByDescrizione(String descrizioneInput);
	
	public Long sumAllByGenere(Genere genereInput);
}
