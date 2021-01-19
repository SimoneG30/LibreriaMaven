package it.libreria.service;

import it.libreria.dao.MyDAOFactory;
import it.libreria.service.acquisto.AcquistoService;
import it.libreria.service.acquisto.AcquistoServiceImpl;
import it.libreria.service.genere.GenereService;
import it.libreria.service.genere.GenereServiceImpl;
import it.libreria.service.libro.LibroService;
import it.libreria.service.libro.LibroServiceImpl;

public class MyServiceFactory {

	private static LibroService libroServiceInstance;
	private static GenereService genereServiceInstance;
	private static AcquistoService acquistoServiceInstance;
	
	public static LibroService getLibroServiceInstance() {
		if (libroServiceInstance == null)
			libroServiceInstance = new LibroServiceImpl();

		libroServiceInstance.setLibroDAO(MyDAOFactory.getLibroDAOInstance());
		return libroServiceInstance;
	}
	
	public static GenereService getGenereServiceInstance() {
		if (genereServiceInstance == null)
			genereServiceInstance = new GenereServiceImpl();
		
		genereServiceInstance.setGenereDAO(MyDAOFactory.getGenereDAOInstance());
		return genereServiceInstance;
	}
	
	public static AcquistoService getAcquistoServiceInstance() {
		if (acquistoServiceInstance == null)
			acquistoServiceInstance = new AcquistoServiceImpl();
		
		acquistoServiceInstance.setAcquistoDAO(MyDAOFactory.getAcquistoDAOInstance());
		return acquistoServiceInstance;
	}
}
