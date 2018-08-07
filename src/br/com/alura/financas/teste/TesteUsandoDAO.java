package br.com.alura.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.alura.financas.dao.MovimentacaoDAO;
import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.modelo.TipoMovimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TesteUsandoDAO {
	
	/*Testando Consulta usando o JPQL, onde a instrução e a manipulação do BD fica na classe MovimentacaoDAO
	 * 
	 * Documentacao JPQL:   https://docs.oracle.com/html/E13946_04/ejb3_langref.html#ejb3_langref_select
	*/
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		
		MovimentacaoDAO dao = new MovimentacaoDAO(em);
		List<Movimentacao> resultados = dao .getMovimentacaoConta(TipoMovimentacao.SAIDA, conta);
	    
	    for (Movimentacao movimentacao : resultados) {
			System.out.println("Descricao: " + movimentacao.getDescricao() );
			System.out.println("Conta_id: " + movimentacao.getConta().getId());
			System.out.println(movimentacao.getConta().getTitular());
			System.out.println("---------------------------");
		}
		
		em.getTransaction().commit();
		em.close();
		
	}

}
