package br.com.alura.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.modelo.TipoMovimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TesteNamedQuery {
	
	/*Testando Consulta usando o JPQL
	 * 
	 * Documentacao JPQL:   https://docs.oracle.com/html/E13946_04/ejb3_langref.html#ejb3_langref_select
	*/
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		//Deste modo é possivel pegar a query pelo @namedQuery que esta na classe Movimentacao.
	    TypedQuery<Movimentacao> query = em.createNamedQuery("movimentacoes", Movimentacao.class); 
	    query.setParameter("pConta", conta);
	    query.setParameter("pTipo", TipoMovimentacao.SAIDA);
	    
		List<Movimentacao> resultados = query.getResultList();
	    
	    for (Movimentacao movimentacao : resultados) {
			System.out.println("Descricao: " + movimentacao.getDescricao() );
			System.out.println("Conta_id: " + movimentacao.getConta().getId());
			System.out.println("----------------------");
		}
		
		em.getTransaction().commit();
		em.close();
		
	}

}
