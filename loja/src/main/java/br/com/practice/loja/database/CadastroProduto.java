package br.com.practice.loja.database;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.practice.loja.dao.CategoriaDao;
import br.com.practice.loja.dao.ProdutoDao;
import br.com.practice.loja.modelo.Categoria;
import br.com.practice.loja.modelo.Produto;
import br.com.practice.loja.util.JPAUtil;

public class CadastroProduto {

	public static void main(String[] args) {
//		cadastrarProduto();
		
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao dao = new ProdutoDao(em);
		
		em.getTransaction().begin();
		
		//Consulta no banco de dados por ID
		Produto obj = dao.idConsult(9l);
		System.out.println(obj.getNome());
		
		List<Produto> lsProdutos = dao.consultEntity("Games");
		lsProdutos.forEach(p -> System.out.println(p.getNome() + " - " + p.getPreco()));
		
		BigDecimal bd = dao.consultPreco("Playstation 5");
		
		System.out.println(bd);
		
		em.getTransaction().commit();
		em.close();
	}

	//Método responsável por cadastrar o produto
	private static void cadastrarProduto() {
		
		Produto celular = new Produto();
		Produto mesa = new Produto();
		Produto game = new Produto();
		
		celular.setNome("Iphone 12 Pro Max");
		celular.setDescricao("Produto Novo, 64 Gb");
		celular.setPreco(new BigDecimal("8000"));
		celular.setCategoria(new Categoria(null, "Eletrônicos"));
		
		mesa.setNome("Mesa");
		mesa.setDescricao("Mesa em L para Computador");
		mesa.setPreco(new BigDecimal("150"));
		mesa.setCategoria(new Categoria(null, "Móveis"));
		
		game.setNome("Playstation 5");
		game.setDescricao("Produto Novo, 1TB");
		game.setPreco(new BigDecimal("2500"));
		game.setCategoria(new Categoria(null, "Games"));
		
		
		EntityManager em = JPAUtil.getEntityManager();
		
		ProdutoDao daoProduto = new ProdutoDao(em);
		CategoriaDao daoCategoria = new CategoriaDao(em);
		
		em.getTransaction().begin();
		
		daoProduto.salvar(celular);
		daoCategoria.salvar(celular.getCategoria());
		
		daoProduto.salvar(mesa);
		daoCategoria.salvar(mesa.getCategoria());
		
		daoProduto.salvar(game);
		daoCategoria.salvar(game.getCategoria());
		
		em.getTransaction().commit();
		em.close();
		
//		em.getTransaction().commit();	Commita as informações no banco de dados
//		em.close();		Fecha as transações do entity manager
//		em.flush();		//Sincroniza com o banco de dados, mas não commita
//		em.clear();		//Limpa todas as entidades gerenciadas pelo Entity Manager
		
//		em.merge(celulares);	Retorna uma referência de 'Detached' para 'Managed', mas ainda não traz a entidade para o estado managed
//		celulares = em.merge(celulares);	//Recupera a referência
	}
}
