package it.libreria.dao.acquisto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import it.libreria.model.Acquisto;
import it.libreria.model.Genere;

public class AcquistoDAOImpl implements AcquistoDAO {

	private EntityManager entityManager;

	@Override
	public List<Acquisto> list() throws Exception {
		return entityManager.createQuery("from Acquisti", Acquisto.class).getResultList();
	}

	@Override
	public Acquisto getById(Long id) throws Exception {
		return entityManager.find(Acquisto.class, id);
	}

	@Override
	public void update(Acquisto acquistoInput) throws Exception {
		if (acquistoInput == null) {
			throw new Exception("Problema valore in input");
		}
		acquistoInput = entityManager.merge(acquistoInput);
	}

	@Override
	public void insert(Acquisto acquistoInput) throws Exception {
		if (acquistoInput == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(acquistoInput);
	}

	@Override
	public void delete(Acquisto acquistoInput) throws Exception {
		if (acquistoInput == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(acquistoInput));
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
		
	}

	@Override
	public List<Acquisto> findAllAcquistiByGenere(Genere genereInput) {
		TypedQuery<Acquisto> query = entityManager.createQuery("select a FROM Acquisto a left join fetch a.libriAcquistati l left join fetch l.generi g where g = :genere",Acquisto.class);
		query.setParameter("genere", genereInput);
		return query.getResultList();
	}

}
