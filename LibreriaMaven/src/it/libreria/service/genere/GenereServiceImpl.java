package it.libreria.service.genere;

import java.util.List;

import javax.persistence.EntityManager;

import it.libreria.dao.EntityManagerUtil;
import it.libreria.dao.genere.GenereDAO;
import it.libreria.model.Acquisto;
import it.libreria.model.Genere;
import it.libreria.model.Libro;

public class GenereServiceImpl implements GenereService{
	
	private GenereDAO genereDAO;
	
	@Override
	public void setGenereDAO(GenereDAO genereDAO) {
		this.genereDAO = genereDAO;
	}


	@Override
	public List<Genere> listAll() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			genereDAO.setEntityManager(entityManager);
			return genereDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Genere caricaSingoloElemento(Long id) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			genereDAO.setEntityManager(entityManager);
			return genereDAO.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void aggiorna(Genere genereInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			genereDAO.setEntityManager(entityManager);
			genereDAO.update(genereInstance);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void inserisciNuovo(Genere genereInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			genereDAO.setEntityManager(entityManager);
			genereDAO.insert(genereInstance);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void rimuovi(Genere genereInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			genereDAO.setEntityManager(entityManager);
			genereDAO.delete(genereInstance);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Genere> cercaGenerePerLibro(Libro libroInput) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			genereDAO.setEntityManager(entityManager);
			return genereDAO.findAllByLibro(libroInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}

	}

	@Override
	public List<Genere> cercaGeneriPerDescrizione(String genereInput) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			genereDAO.setEntityManager(entityManager);
			return genereDAO.findAllByDescrizione(genereInput);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}
	@Override
	public List<Genere> trovaTutteLeGeneriDaAcquisto(Acquisto acquistoInput) throws Exception {
			EntityManager entityManager = EntityManagerUtil.getEntityManager();
			try {
				genereDAO.setEntityManager(entityManager);
				return genereDAO.findAllByAcquisto(acquistoInput);
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			} finally {
				entityManager.close();
			}
		}



}
