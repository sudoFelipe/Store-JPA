package br.com.practice.loja.modelo;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor @NoArgsConstructor
@ToString

//Classe incorporável 
@Embeddable

public class CategoriaId {

	@Getter @Setter private String nome;
	@Getter @Setter private String tipo;
}
