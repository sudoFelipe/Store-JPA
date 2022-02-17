package br.com.practice.loja.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor @NoArgsConstructor
@ToString

//@Entity Indicando a alasse que herdará a classe produto
public class Informatica extends Produto{

	@Getter @Setter private String marca;
	@Getter @Setter private Integer modelo;
}
