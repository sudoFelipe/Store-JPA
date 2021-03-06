package br.com.practice.loja.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor

@Entity
@Table(name = "Categorias")
public class Categoria {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Long id;
	@Getter @Setter private String nome;
	
	//EXEMPOLO DE CHAVE COMPOSTA
//	//Chave primária composta com 2 dados
//	@EmbeddedId
//	@Getter @Setter private CategoriaId id;
//	
//	public Categoria(String nome) {
//		this.id = new CategoriaId("Eletrodomésticos", "XPTO");
//	}
}
