package com.murilo.cliente;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.murilo.cliente.model.Cliente;

public class Teste {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BancoPU");

	private static EntityManager entityManager = entityManagerFactory.createEntityManager();

	public static void main(String[] args) {

		// exemplo de Find
//		Cliente c = entityManager.find(Cliente.class, 1);
//		System.out.println("Nome: " + c.getNome());

		// exemplo de INSERT
//		Cliente c = new Cliente();
//		c.setNome("Facebook");
//		
//		entityManager.getTransaction().begin();
//		entityManager.persist(c);
//		entityManager.getTransaction().commit();

		// exemplo de DELETE
//		Cliente c = em.find(Cliente.class, 6);
//		entityManager.getTransaction().begin();
//		entityManager.remove(c);
//		entityManager.getTransaction().commit();

		// exemplo de MODIFY
//		Cliente c = new Cliente();
//		c.setId(1);
//		c.setNome("Instagram Inc.");
//		
//		entityManager.getTransaction().begin();
//		entityManager.merge(c);
//		entityManager.getTransaction().commit();

		// intrucoes JPQL
//		String jpql = "SELECT c FROM Cliente c";
//		TypedQuery<Cliente> typedQuery = entityManager.createQuery(jpql, Cliente.class);
//
//		List<Cliente> listCliente = typedQuery.getResultList();
//
//		for (Cliente cliente : listCliente) {
//			System.out.println(cliente.getId() + " - " + cliente.getNome());
//		}

		// intrucoes JPQL com condicao WHERE
//		String jpql = "SELECT c FROM Cliente c WHERE id = :idCliente";
//		int idCliente = 3;
//		
//		TypedQuery<Cliente> typedQuery = entityManager.createQuery(jpql, Cliente.class).setParameter("idCliente", idCliente);
//
//		List<Cliente> listCliente = typedQuery.getResultList();
//
//		for (Cliente cliente : listCliente) {
//			System.out.println(cliente.getId() + " - " + cliente.getNome());
//		}

		entityManager.getTransaction().begin();

		// executeUpdate() para DELETE
//		int idCliente = 2;
//
//		entityManager.createQuery("DELETE FROM Cliente c WHERE id = :idCliente").setParameter("idCliente", idCliente)
//				.executeUpdate();

		int idCliente = 3;

		entityManager.createQuery("UPDATE Cliente c SET nome = 'GOOGLE INC.' WHERE c.id = :idCliente")
				.setParameter("idCliente", idCliente).executeUpdate();

		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}
}
