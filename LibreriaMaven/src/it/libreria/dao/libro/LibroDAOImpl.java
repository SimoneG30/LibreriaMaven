package it.libreria.dao.libro;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.libreria.model.Acquisto;
import it.libreria.model.Genere;
import it.libreria.model.Libro;

public class LibroDAOImpl implements LibroDAO{

	private EntityManager entityManager;

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Libro> list() throws Exception {
		return entityManager.createQuery("from Libro", Libro.class).getResultList();
	}

	@Override
	public Libro getById(Long id) throws Exception {
		return entityManager.find(Libro.class, id);
	}

	@Override
	public void update(Libro libroInput) throws Exception {
		if (libroInput == null) {
			throw new Exception("Problema valore in input");
		}
		libroInput = entityManager.merge(libroInput);
	}

	@Override
	public void insert(Libro libroInput) throws Exception {
		if (libroInput == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(libroInput);
	}
	
	@Override
	public void delete(Libro libroInput) throws Exception {
		if (libroInput == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(libroInput));
	}


	@Override
	public List<Libro> findAllByGenere(Genere genereInput) {
		TypedQuery<Libro> query = entityManager.createQuery("select l FROM Libro l join l.generi g where g = :genere",Libro.class);
		query.setParameter("genere", genereInput);
		return query.getResultList();
	}

	@Override
	public List<Libro> findAllByAcquisto(Acquisto acquistoInput) {
		TypedQuery<Libro> query = entityManager.createQuery("select l FROM Libro l join l.acquisto a where a = :acquisto",Libro.class);
		query.setParameter("acquistoInput", acquistoInput);
		return query.getResultList();
	}

	@Override
	public List<Libro> findAllByDescrizione(String descrizioneInput) {
		TypedQuery<Libro> query = entityManager.createQuery("from Libro l where l.descrizione = ?1", Libro.class);
		return query.setParameter(1, descrizioneInput).getResultList();
	}

	@Override
	public Long sumAllByGenere(Genere genereInput) {
		TypedQuery<Long> query = entityManager.createQuery("select sum(l.prezzoSingolo) FROM Libro l join l.generi g where g = :genere",Long.class);
		query.setParameter("genere", genereInput);
		return query.getSingleResult();
	}
}
