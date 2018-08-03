package br.com.alura.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.financas.modelo.Categoria;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TesteConsultaJPQLComJOIN {

	// Testando consulta usando o JPQL fazendo um JOIN entre duas tabelas
	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		Categoria categoria = new Categoria();
		categoria.setId(1);

		String jpql = "select m from Movimentacao m join m.categoria c where c = :pCategoria";
		Query query = em.createQuery(jpql);
		query.setParameter("pCategoria", categoria);

		List<Movimentacao> resultados = query.getResultList();

		for (Movimentacao movimentacao : resultados) {
			System.out.println("-------------------------------");
			System.out.println("Descricao: " + movimentacao.getDescricao());
			System.out.println("Conta_ID: " + movimentacao.getId());
			System.out.println("Titular " + movimentacao.getConta().getTitular());
		for (Categoria categoria1 : movimentacao.getCategoria()) {
				System.out.println("categoria: " + categoria1.getNome());
			}

		}

		//// Outra forma de resolver o problema de buscar a categoria dentro da lista
		// for (Movimentacao movimentacao : resultados) {
		//
		// int contador = 0;
		// while (contador < movimentacao.getCategoria().size()) {
		// System.out.println("-------------------------------");
		// System.out.println("Categoria: " +
		// movimentacao.getCategoria().get(contador).getNome());
		// System.out.println("Descricao: " + movimentacao.getDescricao());
		// System.out.println("Conta_ID: " + movimentacao.getId());
		// System.out.println("Titular " + movimentacao.getConta().getTitular());
		//
		// contador++;
		// }
		//
		// }

		em.getTransaction().commit();
		em.close();
	}

}
