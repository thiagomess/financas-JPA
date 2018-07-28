package br.com.alura.financas.teste;

import javax.persistence.EntityManager;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;


// Busca uma conta e efetua alteracao

public class TesteBuscaConta {

	public static void main(String[] args) {

		EntityManager em =  new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class, 7);
		
		conta.setTitular("Maria dos Santos Silva");
		
		System.out.println(conta.getTitular());
		
		em.getTransaction().commit();
		em.close();
		
		
		
		EntityManager em2 = new JPAUtil().getEntityManager();
		em2.getTransaction().begin();
		
		conta.setTitular("Paulo Roberto de Souza");
//		conta.setNumero("12345-6");
		
		em2.merge(conta);
		
		em2.getTransaction().commit();
		em2.close();
		
	}

}
