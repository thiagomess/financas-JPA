package br.com.alura.financas.teste;

import javax.persistence.EntityManager;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TesteMovimentacaoConta {

	//Testando relacionamento bidirecional, video 1, aula 7
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Movimentacao movimentacao = em.find(Movimentacao.class, 3);
		Conta conta = movimentacao.getConta();
		
		System.out.println(conta.getTitular());
		
		// Para conseguir receber o seu tamanho, é nessario criar o atributo public List<Movimentacao> movimentacoes, sendo @OneToMany(mappedBy="conta")
		//E na classe Movimentação anotar no atributo conta, a anotação @ManyToOne
		System.out.println(conta.getMovimentacoes().size());
		
		em.getTransaction().commit();
		em.close();
		
		
	}

}
