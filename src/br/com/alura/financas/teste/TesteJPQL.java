package br.com.alura.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.modelo.TipoMovimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TesteJPQL {
	
	/*Testando Consulta usando o JPQL
	 * 
	 * Documentacao JPQL:   https://docs.oracle.com/html/E13946_04/ejb3_langref.html#ejb3_langref_select
	*/
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		String jpql = "select m from Movimentacao m where m.conta = :pConta" +
		" and m.tipo = :pTipo"+
		" order by m.valor desc ";
	    Query query = em.createQuery(jpql);
	    query.setParameter("pConta", conta);
	    query.setParameter("pTipo", TipoMovimentacao.ENTRADA);
	    
	    @SuppressWarnings("unchecked")
		List<Movimentacao> resultados = query.getResultList();
	    
	    for (Movimentacao movimentacao : resultados) {
			System.out.println("Descricao: " + movimentacao.getDescricao() );
			System.out.println("Conta_id: " + movimentacao.getConta().getId());
			System.out.println();
		}
		
		em.getTransaction().commit();
		em.close();
		
	}

}
