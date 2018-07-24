package br.com.alura.financas.teste;

import javax.persistence.EntityManager;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class TesteContaExclusao {

	public static void main(String[] args) {

		EntityManager em =  new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class, 1);
		em.remove(conta);
		
		System.out.println(conta.getTitular());
		
		em.getTransaction().commit();
		em.close();

	}

}
