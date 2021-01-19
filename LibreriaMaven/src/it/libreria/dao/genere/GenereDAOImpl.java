package it.libreria.dao.genere;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.libreria.model.Acquisto;
import it.libreria.model.Genere;
import it.libreria.model.Libro;

public class GenereDAOImpl implements GenereDAO{

	private EntityManager entityManager;

	@Override
	public List<Genere> list() throws Exception {
		return entityManager.createQuery("from Genere", Genere.class).getResultList();
	}

	@Override
	public Genere getById(Long id) throws Exception {
		return entityManager.find(Genere.class, id);
	}

	@Override
	public void update(Genere genereInput) throws Exception {
		if (genereInput == null) {
			throw new Exception("Problema valore in input");
		}
		genereInput = entityManager.merge(genereInput);
	}


	@Override
	public void insert(Genere genereInput) throws Exception {
		if (genereInput == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(genereInput);
	}

	@Override
	public void delete(Genere genereInput) throws Exception {
		if (genereInput == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(genereInput));
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;		
	}

	@Override
	public List<Genere> findAllByDescrizione(String descrizioneInput) {
		TypedQuery<Genere> query = entityManager.createQuery("from Genere g where g.descrizione = ?1", Genere.class);
		return query.setParameter(1, descrizioneInput).getResultList();
	}

	@Override
	public List<Genere> findAllByLibro(Libro libroInput) {
		TypedQuery<Genere> query = entityManager.createQuery("select g FROM Genere g join g.libri l where l = :genere",Genere.class);
		query.setParameter("libro", libroInput);
		return query.getResultList();
	}

	@Override
	public List<Genere> findAllByAcquisto(Acquisto acquistoInput) {
		TypedQuery<Genere> query = entityManager.createQuery("select g FROM Genere g left join fetch g.libri l left join fetch l.acquisto a where a = :acquisto",Genere.class);
		query.setParameter("acquisto", acquistoInput);
		return query.getResultList();
	}

}
