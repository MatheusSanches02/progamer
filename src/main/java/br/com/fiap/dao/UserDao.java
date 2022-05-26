package br.com.fiap.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.fiap.model.User;

public class UserDao {

	//@Inject
	//EntityManager em;

	EntityManagerFactory factory = 
			Persistence.createEntityManagerFactory("progamer-persistence-unit");
	EntityManager em = 
			factory.createEntityManager();
	
	public void create(User user) {
		
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		
		em.clear();
	}
	
	public List<User> listAll() {
		
		TypedQuery<User> query = 
				em.createQuery("SELECT u FROM User u", User.class);
		
		return query.getResultList();
		
	}
	
	public boolean exist(User user) {
		String jpql = "SELECT u FROM User u WHERE email=:email AND password=:password";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter("email", user.getEmail());
		query.setParameter("password", user.getPassword());
		
		try {
			query.getSingleResult();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
