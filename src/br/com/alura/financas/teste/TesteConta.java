package br.com.alura.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.financas.modelo.Conta;

public class TesteConta {
	
	public static void main(String[] args) {
		
		Conta conta = new Conta();
		
		conta.setTitular("Thiago");
		conta.setAgencia("1234");
		conta.setNumero("28746");
		conta.setBanco("Bradesco");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
