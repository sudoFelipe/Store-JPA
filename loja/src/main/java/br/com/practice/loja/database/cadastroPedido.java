package br.com.practice.loja.database;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.practice.loja.dao.CategoriaDao;
import br.com.practice.loja.dao.ClienteDao;
import br.com.practice.loja.dao.PedidoDao;
import br.com.practice.loja.dao.ProdutoDao;
import br.com.practice.loja.modelo.Categoria;
import br.com.practice.loja.modelo.Cliente;
import br.com.practice.loja.modelo.ItemPedido;
import br.com.practice.loja.modelo.Pedido;
import br.com.practice.loja.modelo.Produto;
import br.com.practice.loja.modelo.Relatorio;
import br.com.practice.loja.util.JPAUtil;

public class cadastroPedido {

	public static void main(String[] args) {

		cadastrarProduto();
		
		EntityManager em = JPAUtil.getEntityManager();
//		PedidoDao daoPedido = new PedidoDao(em);
		ProdutoDao daoProduto = new ProdutoDao(em);
		
//		Pedido pedido = em.find(Pedido.class, 1l);
		
		List<Produto> lsProdutos = new ArrayList<Produto>();
		
		lsProdutos = daoProduto.searchParameters("Game God Of War", new BigDecimal("150"), null);
		
//		ProdutoDao daoProduto = new ProdutoDao(em);
//		ClienteDao daoCliente = new ClienteDao(em);
//		
//		Produto produto = daoProduto.idConsult(13l);
//		Cliente cliente = daoCliente.idConsult(1l);
//		
//		Pedido pedido = new Pedido();
//		pedido.setCliente(cliente);
//		pedido.addItens(new ItemPedido(10, pedido, produto));
//		
//		Produto produto2 = daoProduto.idConsult(11l);
//		Cliente cliente2 = daoCliente.idConsult(5l);
//		
//		Pedido pedido2 = new Pedido();
//		pedido2.setCliente(cliente2);
//		pedido2.addItens(new ItemPedido(2, pedido2, produto2));
//		
//		
//		em.getTransaction().begin();
//		
//		daoCliente.salvar(cliente);
//		daoPedido.salvar(pedido);
//		
//		daoCliente.salvar(cliente2);
//		daoPedido.salvar(pedido2);
//		
//		em.getTransaction().commit();
//		
//		BigDecimal valorTotal = daoPedido.valorTotalVendido();
//		System.out.println("Valor Total: " + valorTotal);
//		
//		List<Relatorio> lsVendas = daoPedido.reportVendas();
//		lsVendas.forEach(System.out::println);
		
		em.close();
		
		lsProdutos.forEach(p -> System.out.println(p.getNome()));
	}

	
	//M??todo respons??vel por cadastrar o produto
	private static void cadastrarProduto() {
		
		Produto produto = new Produto();
		
		produto.setNome("Game God Of War");
		produto.setDescricao("Jogo");
		produto.setPreco(new BigDecimal("150"));
		produto.setCategoria(new Categoria(null, "Games"));
		
		Cliente cliente = new Cliente("Jo??ozinho", "69365487897");
		
		
		EntityManager em = JPAUtil.getEntityManager();
		
		ProdutoDao daoProduto = new ProdutoDao(em);
		CategoriaDao daoCategoria = new CategoriaDao(em);
		ClienteDao daoCliente = new ClienteDao(em);
		
		em.getTransaction().begin();
		
		daoProduto.salvar(produto);
		daoCategoria.salvar(produto.getCategoria());
		daoCliente.salvar(cliente);
		
		em.getTransaction().commit();
		em.close();
		
//			em.getTransaction().commit();	Commita as informa????es no banco de dados
//			em.close();		Fecha as transa????es do entity manager
//			em.flush();		//Sincroniza com o banco de dados, mas n??o commita
//			em.clear();		//Limpa todas as entidades gerenciadas pelo Entity Manager
		
//			em.merge(celulares);	Retorna uma refer??ncia de 'Detached' para 'Managed', mas ainda n??o traz a entidade para o estado managed
//			celulares = em.merge(celulares);	//Recupera a refer??ncia
	}
}
