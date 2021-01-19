package it.libreria.service.acquisto;

import java.util.List;

import javax.persistence.EntityManager;

import it.libreria.dao.EntityManagerUtil;
import it.libreria.dao.acquisto.AcquistoDAO;
import it.libreria.model.Acquisto;
import it.libreria.model.Genere;

public class AcquistoServiceImpl implements AcquistoService {

	private AcquistoDAO acquistoDAO;

	@Override
	public List<Acquisto> listAll() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			acquistoDAO.setEntityManager(entityManager);
			return acquistoDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Acquisto caricaSingoloElemento(Long id) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			acquistoDAO.setEntityManager(entityManager);
			return acquistoDAO.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void aggiorna(Acquisto acquistoInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			acquistoDAO.setEntityManager(entityManager);
			acquistoDAO.update(acquistoInstance);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void inserisciNuovo(Acquisto acquistoInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			acquistoDAO.setEntityManager(entityManager);
			acquistoDAO.insert(acquistoInstance);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void rimuovi(Acquisto acquistoInstance) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Acquisto> findAllAcquistiByGenere(Genere genereInput) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAcquistoDAO(AcquistoDAO acquistoDAO) {
		this.acquistoDAO = acquistoDAO;		
	}

}
