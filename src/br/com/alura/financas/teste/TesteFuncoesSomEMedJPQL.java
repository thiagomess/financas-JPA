package br.com.alura.financas.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.TipoMovimentacao;
import br.com.alura.financas.util.JPAUtil;
import net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Substitutor.ForAttachment;

public class TesteFuncoesSomEMedJPQL {
	
	/*
	 * Testando Funcoes usando o JPQL - Soma e Media
	 * 
	 * Documentacao JPQL:
	 * https://docs.oracle.com/html/E13946_04/ejb3_langref.html#ejb3_langref_select
	 * Documentacao Funcoes:
	 * https://docs.oracle.com/cd/E19502-01/819-3669/6n5sg7ca4/index.html
	 */

	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		//Instrução calcula a soma
		String jpqlSoma = "select sum(m.valor) from Movimentacao m where m.conta = :pConta" +
		" and m.tipo = :pTipo";
		
		//Instrução calcula a Media
		String jpqlMedia = "select avg(m.valor) from Movimentacao m where m.conta = :pConta" +
		" and m.tipo = :pTipo "
			+ "group by day(m.data), month(m.data), year(m.data)"; //Dessa forma é possivel organizar as movimentações por data
		
	    Query querySoma = em.createQuery(jpqlSoma);
	    querySoma.setParameter("pConta", conta);
	    querySoma.setParameter("pTipo", TipoMovimentacao.SAIDA);
	    
	    TypedQuery<Double> queryMedia = em.createQuery(jpqlMedia,Double.class);//TypedQuery é mais seguro, pois força o tipo do resultado como retorno.
	    queryMedia.setParameter("pConta", conta);
	    queryMedia.setParameter("pTipo", TipoMovimentacao.SAIDA);
	    
	    
	    BigDecimal soma =  (BigDecimal) querySoma.getSingleResult(); 
		List<Double> medias =  (List<Double>) queryMedia.getResultList(); 
		
		System.out.println("------------------------");
		System.out.println("A soma é: " + soma);
		System.out.println("A media do dia 05 é: " + medias.get(0));
		System.out.println("A media do dia 06 é: " + medias.get(1));
		
//		for (Double result : medias) {
//			System.out.println("A media é: " + result);
//		}
		

		
	    

		em.getTransaction().commit();
		em.close();
		
		
		
	}

}
