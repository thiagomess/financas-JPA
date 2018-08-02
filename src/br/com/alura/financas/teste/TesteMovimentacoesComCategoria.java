package br.com.alura.financas.teste;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.alura.financas.modelo.Categoria;
import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.modelo.TipoMovimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TesteMovimentacoesComCategoria {
	
	
//	Efetua os relacionamentos entre Categoria, Conta e Movimentação (É criado uma tabela Movimentacao_categoria para efetuar os relacionamentos)
	
	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setId(2);
		
		Categoria categoria1 = new Categoria("Lazer");
		Categoria categoria2 = new Categoria("Negocios");
		
		Categoria categoria = new Categoria();
		categoria.setId(2);
		
		Movimentacao movimentacao1 = new Movimentacao();
		movimentacao1.setData(Calendar.getInstance()); //Data de Hoje
		movimentacao1.setTipo(TipoMovimentacao.SAIDA);
		movimentacao1.setDescricao("Viagem a SP");
		movimentacao1.setValor(new BigDecimal("210.0"));
		movimentacao1.setConta(conta);
		movimentacao1.setCategoria(Arrays.asList(categoria1, categoria2));
		
		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setData(Calendar.getInstance());
		movimentacao2.setTipo(TipoMovimentacao.SAIDA);
		movimentacao2.setDescricao("Viagem ao RJ");
		movimentacao2.setValor(new BigDecimal("350.0"));
		movimentacao2.setConta(conta);
		movimentacao2.setCategoria(Arrays.asList(categoria1, categoria2));
		
		Movimentacao movimentacao3 = new Movimentacao();
		movimentacao3.setData(Calendar.getInstance());
		movimentacao3.setTipo(TipoMovimentacao.ENTRADA);
		movimentacao3.setDescricao("Salario");
		movimentacao3.setValor(new BigDecimal("2500.0"));
		movimentacao3.setConta(conta);
		movimentacao3.setCategoria(Arrays.asList(categoria));
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.persist(categoria1);
		em.persist(categoria2);
		em.persist(movimentacao1);
		em.persist(movimentacao2);
		em.persist(movimentacao3);
		
/*		removendo atributos da tabela*/
//		Movimentacao mov = em.find(Movimentacao.class,12);
//		em.remove(mov);
		
		em.getTransaction().commit();
		em.close();
		
	}

}
