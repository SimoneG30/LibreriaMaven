package it.libreria.dao.acquisto;

import java.util.List;

import it.libreria.dao.IBaseDAO;
import it.libreria.model.Acquisto;
import it.libreria.model.Genere;

public interface AcquistoDAO extends IBaseDAO<Acquisto> {
	
	public List<Acquisto> findAllAcquistiByGenere(Genere genereInput);

}
