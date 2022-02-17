package br.com.practice.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor

//Esta anotação serve para indicar o mapeamento de uma classe objeto no banco de dados
//Comunicação informando que essa classe é uma tabela do nosso database que à representa
@Entity

//Renomeação de tabela de Produto (nome da classe) para -> Produtos
@Table(name = "Produtos")
@NamedQuery(name = "Produto.produtosCategoria", query = "SELECT p FROM Produto p WHERE p.nome = :name")

//Herança com tabela única (Single_table)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class Produto {

	@Column(name = "codigo") 	//Renomeação de coluna
	@Id		//Indicação do atributo que será o meu id na base
	@GeneratedValue(strategy = GenerationType.IDENTITY)		//Indicação de campo auto increment
	@Getter @Setter private Long id;
	@Getter @Setter private String nome;
	@Getter @Setter private String descricao;
	@Getter @Setter private BigDecimal preco;
	@Getter @Setter private LocalDate dataCadastro = LocalDate.now();
	
	//CATEGORIA É UMA NOVA ENTIDADE, E POR PADRÃO DEVE SER REPASSADO A CARDINALIDADE DO RELACIONAMENTO
	@ManyToOne(fetch = FetchType.LAZY)	//Cardinalidade muitos para um (n,1)
	@Getter @Setter private Categoria categoria;
	
	//
	/*
	 * INDICANDO PARA A JPA QUE ESSE ENUM SERÁ SALVO COMO UMA STRING
	 * O PADRÃO É SER ARMAZENADO COMO UM CÓGIDO ORDENADO SEQUENCIAL DOS ELEMENTOS DO ENUM
	 * 
	 * @Enumerated(EnumType.STRING) -> ENUM
	 * @Getter @Setter private Categoria categoria;
	 */
}
