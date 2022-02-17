package br.com.practice.loja.modelo;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor @NoArgsConstructor
@ToString @EqualsAndHashCode

/**
 * @Embeddable
 * @author luis
 *	Incorporar uma classe como sendo um tipo de dado usado pela entidade
 */
@Embeddable
public class DadosPessoais {

	@Getter @Setter private String nome;
	@Getter @Setter private String cpf;
}
