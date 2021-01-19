package it.libreria.service.libro;

import java.util.List;

import javax.persistence.EntityManager;

import it.libreria.dao.EntityManagerUtil;
import it.libreria.dao.libro.LibroDAO;
import it.libreria.model.Genere;
import it.libreria.model.Libro;

public class LibroServiceImpl implements LibroService{

	private LibroDAO libroDAO;

	@Override
	public void setLibroDAO(LibroDAO libroDAO) {
		this.libroDAO = libroDAO;
	}
	
	@Override
	public List<Libro> listAll() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			libroDAO.setEntityManager(entityManager);
			return libroDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}


	@Override
	public Libro caricaSingoloElemento(Long id) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			libroDAO.setEntityManager(entityManager);
			return libroDAO.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void aggiorna(Libro libroInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			libroDAO.setEntityManager(entityManager);
			libroDAO.update(libroInstance);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void inserisciNuovo(Libro libroInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			libroDAO.setEntityManager(entityManager);
			libroDAO.insert(libroInstance);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void rimuovi(Libro libroInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			libroDAO.setEntityManager(entityManager);
			libroDAO.delete(libroInstance);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override
	public void aggiungiGenere(Libro libroInstance, Genere genereInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();
			libroDAO.setEntityManager(entityManager);
			libroInstance = entityManager.merge(libroInstance);
			genereInstance = entityManager.merge(genereInstance);
			libroInstance.getGeneri().add(genereInstance);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public void nuovoLibroConGenere(Libro libroInstance, Genere genereInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();
			libroDAO.setEntityManager(entityManager);
			libroInstance = entityManager.merge(libroInstance);
			genereInstance = entityManager.merge(genereInstance);
			libroInstance.getGeneri().add(genereInstance);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public List<Libro> cercaLibroPerGenere(Genere genereInput) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			libroDAO.setEntityManager(entityManager);
			return libroDAO.findAllByGenere(genereInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}

	}


	@Override
	public List<Libro> cercaLibriPerDescrizione(String descrizioneInput) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			libroDAO.setEntityManager(entityManager);
			return libroDAO.findAllByDescrizione(descrizioneInput);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Long sommaPrezziLibriConGenere(Genere genereInput) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			libroDAO.setEntityManager(entityManager);
			return libroDAO.sumAllByGenere(genereInput);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}


}
