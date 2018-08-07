package br.com.alura.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.modelo.TipoMovimentacao;



/*Testando Consulta usando o JPQL, onde a instrução e a manipulação do BD fica nesta classe e a exibição no console fica na classe TesteJPQLUsandoDAO
 * 
 * Documentacao JPQL:   https://docs.oracle.com/html/E13946_04/ejb3_langref.html#ejb3_langref_select
*/

public class MovimentacaoDAO {
	
	private EntityManager em;
	
	public MovimentacaoDAO(EntityManager em) {
		this.em = em;
	}

	public List<Movimentacao> getMovimentacaoConta(TipoMovimentacao saida, Conta conta) {

		String jpql = "select m from Movimentacao m where m.conta = :pConta" +
				" and m.tipo = :pTipo"+
				" order by m.valor desc ";
				
				TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
			    query.setParameter("pConta", conta);
			    query.setParameter("pTipo", saida);
			    
				List<Movimentacao> resultados = query.getResultList();
				
		
		
		return resultados;
	}

}
