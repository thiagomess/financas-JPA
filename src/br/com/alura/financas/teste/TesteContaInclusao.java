package br.com.alura.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class TesteContaInclusao {
	
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
