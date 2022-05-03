package br.com.fiap.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Setup;

public class SetupDao {
	
	@Inject
	EntityManager em;

	public void create(Setup setup) {
		
		em.getTransaction().begin();
		em.persist(setup);
		em.getTransaction().commit();
		
		em.clear();
	}
	
	public List<Setup> listAll() {
		
		TypedQuery<Setup> query = 
				em.createQuery("SELECT s FROM Setup s", Setup.class);
		
		return query.getResultList();
		
	}

}
