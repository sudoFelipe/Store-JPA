package br.com.practice.loja.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor @NoArgsConstructor
@ToString @EqualsAndHashCode

@Entity
@Table(name = "Clientes")
public class Cliente {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Getter @Setter private Long id;
	@Getter @Setter private String nome;
	@Getter @Setter private String cpf;
}
