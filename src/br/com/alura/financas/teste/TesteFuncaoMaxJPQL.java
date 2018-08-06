package br.com.alura.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class TesteFuncaoMaxJPQL {
	
	/*
	 * Testando Funcoes usando o JPQL - Valor Maior
	 * 
	 * Documentacao JPQL:
	 * https://docs.oracle.com/html/E13946_04/ejb3_langref.html#ejb3_langref_select
	 * Documentacao Funcoes:
	 * https://docs.oracle.com/cd/E19502-01/819-3669/6n5sg7ca4/index.html
	 */
	
	public static void main(String[] args) {
		
		EntityManager em =  new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		String jpql = "select max(m.valor) from Movimentacao m where m.conta = :pConta";
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		
		BigDecimal resultado = (BigDecimal) query.getSingleResult();
		
		System.out.println("Resultado: " + resultado);
		
		
		em.getTransaction().commit();
		em.close();
	}

}
