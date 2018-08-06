package br.com.alura.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TesteTodasAsMovimentacoesDasContas {

	
	//Efetua um Join usando o FETCH, onde altera o status de lazy para Eager, pode ser substituido
	//pelo parametro @ManyToOne(fetch = FetchType.EAGER)
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		//É usado o fetch antes do inner para alterar o estado de Lazy para EAGER, 
		//assim o JPA tras os resultados tudo de uma vez, ao inves de realizar varios selects
		String jpql =  "select distinct c from Conta c left join fetch c.movimentacoes";
		//O comando distinct evita que os dados sejam repetidos e o left join, tras todas as contas, independente se possui movimentacoes.
		
		Query query = em.createQuery(jpql);
		
		List<Conta> listaTodasAsContas = query.getResultList();
		
		for (Conta conta : listaTodasAsContas) {
			System.out.println("-------------------------------");
			System.out.println("Titular: " + conta.getTitular());
		for (Movimentacao	movimentacao : conta.getMovimentacoes()) {
				System.out.println("Movimentacao: " + movimentacao.getDescricao());
			}

		}
//		Outra forma de realizar a busca
//		for (Conta conta : listaTodasAsContas) {
//			
//			for (int i = 0; i < conta.getMovimentacoes().size(); i++) {
//				System.out.println("Titular: " + conta.getTitular());
//				System.out.println("Movimentação: " + conta.getMovimentacoes().get(i).getDescricao());
//				System.out.println("-------------------------------");
//			}
//		}
		
		em.getTransaction().commit();
		em.close();
	}
}
