package br.com.alura.financas.teste;

import java.math.BigDecimal;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.modelo.TipoMovimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TesteJPARelacionamentoBusca {

	//Busca uma conta e adiciona uma movimentacao efetuando o relacionamento entre elas.
	public static void main(String[] args) {

		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Viagem");
		movimentacao.setTipo(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("360.22"));

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		Conta conta = em.find(Conta.class, 5);

		em.persist(conta);
		movimentacao.setConta(conta);
		em.persist(movimentacao);

		em.getTransaction().commit();
		em.close();
	}

}
