package br.com.practice.loja.modelo;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString @EqualsAndHashCode

@Entity
@Table(name = "Clientes")
public class Cliente {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Getter @Setter private Long id;
	
	//Embutindo a classe dados pessoais na entidade Cliente
	@Embedded
	@Getter @Setter private DadosPessoais dadosPessoais;
	
	public Cliente(String nome, String cpf) {
		this.dadosPessoais = new DadosPessoais(nome, cpf);	
	}
	
//	public String getNome() {
//		return this.dadosPessoais.getNome();
//	}
//	
//	public String getCpf() {
//		return this.dadosPessoais.getCpf();
//	}
}
