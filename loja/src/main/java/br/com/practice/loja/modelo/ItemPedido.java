package br.com.practice.loja.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString @EqualsAndHashCode

@Entity
@Table(name = "Itens_Pedidos")
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Long id;
	
	@Column(name = "preco_unitario")
	@Getter @Setter private BigDecimal precoUnitario;
	@Getter @Setter private int quantidade;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@Getter @Setter private Pedido pedido;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@Getter @Setter private Produto produto;

	
	public ItemPedido(int quantidade, Pedido pedido, Produto produto) {
		super();
		this.precoUnitario = produto.getPreco();
		this.quantidade = quantidade;
		this.pedido = pedido;
		this.produto = produto;
	}


	public BigDecimal getValor() {
		
		return precoUnitario.multiply(new BigDecimal(quantidade));
	}
	
}
