package it.libreria.dao;

import it.libreria.dao.acquisto.AcquistoDAO;
import it.libreria.dao.acquisto.AcquistoDAOImpl;
import it.libreria.dao.genere.GenereDAO;
import it.libreria.dao.genere.GenereDAOImpl;
import it.libreria.dao.libro.LibroDAO;
import it.libreria.dao.libro.LibroDAOImpl;

public class MyDAOFactory {

	private static LibroDAO libroDAOInstance = null;
	private static GenereDAO genereDAOInstance = null;
	private static AcquistoDAO acquistoDAOInstance = null;

	public static LibroDAO getLibroDAOInstance() {
		if (libroDAOInstance == null)
			libroDAOInstance = new LibroDAOImpl();
		return libroDAOInstance;
	}
	
	public static GenereDAO getGenereDAOInstance() {
		if (genereDAOInstance == null)
			genereDAOInstance = new GenereDAOImpl();
		return genereDAOInstance;
	}
	
	public static AcquistoDAO getAcquistoDAOInstance() {
		if (acquistoDAOInstance == null)
			acquistoDAOInstance = new AcquistoDAOImpl();
		return acquistoDAOInstance;
	}

}
