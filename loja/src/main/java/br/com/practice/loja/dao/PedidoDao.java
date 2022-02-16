package br.com.practice.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.practice.loja.modelo.Pedido;
import br.com.practice.loja.modelo.Relatorio;
import lombok.AllArgsConstructor;

@AllArgsConstructor

public class PedidoDao {

	private EntityManager em;
	
	public void salvar(Pedido pedido) {
		this.em.persist(pedido);
	}

	public BigDecimal valorTotalVendido() {
		
		String sql = "SELECT SUM(p.valorTotal) FROM Pedido p";
		
		return em.createQuery(sql, BigDecimal.class).getSingleResult();
	}
	
	public List<Relatorio> reportVendas() {
		
		//Criação de uma instância da Entidade que não está sendo gerenciada pela JPA, servindo apenas para um relatório
		//Para criar uma instância devemos passar o endereço completo da classe usada
		String sql = "SELECT new br.com.practice.loja.modelo.Relatorio(produto.nome, SUM(item.quantidade), MAX(pedido.data)) FROM Pedido pedido "
				+ "JOIN pedido.itens item "
				+ "JOIN item.produto produto "
				+ "GROUP BY produto.nome ";
//				+ "ORDER BY item.quantidade DESC";
		
//		String sql = "SELECT produto.nome, SUM(item.quantidade), MAX(pedido.data) FROM Pedido pedido "
//				+ "JOIN pedido.itens item "
//				+ "JOIN item.produto produto "
//				+ "GROUP BY produto.nome "
//				+ "ORDER BY item.quantidade DESC";
		
		return em.createQuery(sql, Relatorio.class).getResultList();
	}
	
	public Pedido buscarPedidocomCliente(Long id) {
		
		return em.createQuery("SELECT p FROM Pedido p JOIN FETCH p.cliente WHERE p.id = :id", Pedido.class)
				.setParameter("id", id)
				.getSingleResult();
	}
}
