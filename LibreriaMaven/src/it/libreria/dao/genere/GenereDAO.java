package it.libreria.dao.genere;

import java.util.List;

import it.libreria.dao.IBaseDAO;
import it.libreria.model.Acquisto;
import it.libreria.model.Genere;
import it.libreria.model.Libro;

public interface GenereDAO extends IBaseDAO<Genere>{

	public List<Genere> findAllByDescrizione(String descrizioneInput);
	
	public List<Genere> findAllByLibro(Libro libroInput);

	public List<Genere> findAllByAcquisto(Acquisto acquistoInput);
	
}
