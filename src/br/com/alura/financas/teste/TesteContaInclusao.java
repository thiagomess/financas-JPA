package br.com.alura.financas.teste;

import javax.persistence.EntityManager;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class TesteContaInclusao {

	// Adiciona uma conta na tabela conta
	public static void main(String[] args) {
		
		Conta conta = new Conta();
		
		conta.setTitular("Thiago");
		conta.setAgencia("1234");
		conta.setNumero("28746");
		conta.setBanco("Bradesco");
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		
		em.close();
	}

}
