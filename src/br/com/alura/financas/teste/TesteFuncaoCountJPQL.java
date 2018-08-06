package br.com.alura.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class TesteFuncaoCountJPQL {
	
	/*
	 * Testando Funcoes usando o JPQL - Count
	 * 
	 * Documentacao JPQL:
	 * https://docs.oracle.com/html/E13946_04/ejb3_langref.html#ejb3_langref_select
	 * Documentacao Funcoes:
	 * https://docs.oracle.com/cd/E19502-01/819-3669/6n5sg7ca4/index.html
	 */

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class, 2);
				
		String jpql = "select count(m) from Movimentacao m where m.conta = :pConta";
		
		TypedQuery<Long> query = em.createQuery(jpql, Long.class);
		query.setParameter("pConta", conta);
		
		Long quantidade = (Long) query.getSingleResult();
		
		System.out.println("\nTotal de movimentações: " + quantidade);
		
		
		
		em.getTransaction().commit();
		em.close();
		

	}

}
