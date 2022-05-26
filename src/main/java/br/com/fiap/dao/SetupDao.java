package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Setup;

public class SetupDao {
	
	//@Inject
	//EntityManager em;
	
	EntityManagerFactory factory = 
			Persistence.createEntityManagerFactory("progamer-persistence-unit");
	EntityManager em = 
			factory.createEntityManager();

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
