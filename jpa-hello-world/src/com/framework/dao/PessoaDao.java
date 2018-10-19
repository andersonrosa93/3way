package com.framework.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.framework.model.Pessoa;

public class PessoaDao {

	EntityManager entityManager;

	// Nossa classe PessoaDao segue o padrão de projeto
	// Singleton que garante que apenas uma instancia dessa
	// classe será criada durante toda a aplicação

	private static PessoaDao instance;

	public static PessoaDao getInstance() {
		if (instance == null) {
			instance = new PessoaDao();
		}

		return instance;
	}

	private PessoaDao() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-hello-world");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();

		}

		return entityManager;
	}

	public void persist(Pessoa Pessoa) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(Pessoa);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}

	}

}
