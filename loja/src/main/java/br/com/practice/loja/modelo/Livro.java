package br.com.practice.loja.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor @NoArgsConstructor
@ToString

//@Entity Indicando a classe que herdará a classe produto
public class Livro extends Produto{

	@Getter @Setter private String autor;
	@Getter @Setter private Integer numeroPaginas;
}
