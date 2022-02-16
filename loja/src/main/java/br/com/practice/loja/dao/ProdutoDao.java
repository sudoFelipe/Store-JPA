package br.com.practice.loja.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.practice.loja.modelo.Produto;
import lombok.AllArgsConstructor;

@AllArgsConstructor

public class ProdutoDao {

	private EntityManager em;
	
	public void salvar(Produto produto) {
		this.em.persist(produto);
	}
	
	public void update(Produto produto) {
		produto = this.em.merge(produto);
	}
	
	public void delete(Produto produto) {
		this.em.remove(produto);
	}
	
	public Produto idConsult(Long id) {
		return this.em.find(Produto.class, id);
	}
	
//	JPQL - JAVA PERSISTENCE QUERY LANGUAGE
	public List<Produto> consultAll() {
		
		//createQuery - monta a query
		//getResultList - dispara a query no banco de dados
		
		//Lembre-se que a query é orientada a objetos e não a linguagem SQL
		String query = "SELECT p FROM Produto p";
		return this.em.createQuery(query, Produto.class).getResultList();
	}
	
	
	//Consulta filtrando por nome
	public List<Produto> consultValue(String value) {
		
		//Chamada da Named Query definida na entidade Produto
		return this.em.createNamedQuery("Produto.produtosCategoria", Produto.class)
				.setParameter("name", value)
				.getResultList();
		
//		String query = "SELECT p FROM Produto p WHERE p.nome = :name";
//		return this.em.createQuery(query, Produto.class).setParameter("name", value).getResultList();
		
	}
	
	//Consulta filtrando por nome da entidade (consulta pelo relacionamento chave estrangeira)
	public List<Produto> consultEntity(String value) {
		
		String query = "SELECT p FROM Produto p WHERE p.categoria.nome = :name";
		return this.em.createQuery(query, Produto.class).setParameter("name", value).getResultList();
		
	}
	
	//Consulta que retorna apenas um registro
	public BigDecimal consultPreco(String value) {
		
		String query = "SELECT p.preco FROM Produto p WHERE p.nome = :nome";
		return this.em.createQuery(query, BigDecimal.class).setParameter("nome", value).getSingleResult();
		
	}
	
	//Busca Dinâmica Padrão JPQL
	public List<Produto> searchParameters(String name, BigDecimal price, LocalDate date) {
		
		String sql = "SELECT p FROM Produto p WHERE 1=1 ";
		
		//Concatena a query com os parâmetros opicionais
		if (name != null && !name.trim().isEmpty()) {
			sql += " AND p.nome = :nome ";
		}
		
		if (price != null) {
			sql += " AND p.preco = :preco ";
		}
		
		if (date != null) {
			sql += " AND p.dataCadastro = :data ";
		}
		
		//Atribuindo a query criada a uma variável
		//Verifica quais parâmetros serão substituídos
		TypedQuery<Produto> query = em.createQuery(sql, Produto.class);
		if (name != null && !name.trim().isEmpty()) {
			query.setParameter("nome", name);
		}
		
		if (price != null) {
			query.setParameter("preco", price);
		}
		
		if (date != null) {
			query.setParameter("dataCadastro", date);
		}
		
		return query.getResultList();
	}
	
	//Busca Dinâmica usando o API Criteria
	public List<Produto> searchParametersCriteria(String name, BigDecimal price, LocalDate date) {
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
		
		//SELECT p FROM Produto p
		//Entende-se que a entidade de consulta é o Produto passado no 'FROM'
		Root<Produto> from = query.from(Produto.class);
		
		//Criação de um builder vazio com AND's
		Predicate filter = builder.and();
		
		if (name != null && !name.trim().isEmpty()) {
			//Constrói o and na query com o AND atual criado, passando qual o tipo de filtro (equal)
			//qual o campo (from - Produto)
			//qual o parâmetro de substituição (nome)
			builder.and(filter, builder.equal(from.get("nome") , name));
		}
		
		if (price != null) {
			builder.and(filter, builder.equal(from.get("preco") , price));
		}
		
		if (date != null) {
			builder.and(filter, builder.equal(from.get("dataCadastro") , date));
		}
		
		query.where(filter);
		
		return em.createQuery(query).getResultList();
	}
}
