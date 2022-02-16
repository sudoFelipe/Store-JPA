package br.com.practice.loja.modelo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor @NoArgsConstructor
@ToString

public class Relatorio {

	@Getter @Setter private String nomeProduto;
	@Getter @Setter private Long quantVendida;
	@Getter @Setter private LocalDate ultimaVenda;
}
