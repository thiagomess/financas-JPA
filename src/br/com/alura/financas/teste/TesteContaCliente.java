package br.com.alura.financas.teste;

import javax.persistence.EntityManager;

import br.com.alura.financas.modelo.Cliente;
import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;


//Adiciona um cliente na tabela Cliente

public class TesteContaCliente {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setId(3);
		
		Cliente cliente = new Cliente();
		cliente.setNome("Thiago Gomes");
		cliente.setEndereco("Rua Fulano, 123");
		cliente.setProfissao("Programador");
		cliente.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(cliente);
		
		em.getTransaction().commit();
		em.close();
	

	}

}
