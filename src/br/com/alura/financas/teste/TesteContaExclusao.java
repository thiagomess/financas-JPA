package br.com.alura.financas.teste;

import javax.persistence.EntityManager;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class TesteContaExclusao {
	
	//Busca um cliente e efetua a exclusao

	public static void main(String[] args) {

		EntityManager em =  new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class, 8);
//		Movimentacao movimentacao = em.find(Movimentacao.class, 2); // removendo uma movimentacao
//		em.remove(movimentacao);
		em.remove(conta);
		
		System.out.println(conta.getTitular());
		
		em.getTransaction().commit();
		em.close();

	}

}
