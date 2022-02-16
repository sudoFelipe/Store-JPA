package br.com.practice.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "Pedidos")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Long id;
	@Column(name = "valor_total")
	@Getter @Setter private BigDecimal valorTotal = BigDecimal.ZERO;
	@Getter @Setter private LocalDate data = LocalDate.now();
	
	//Fetch indica que ao realizar uma consulta os dados não serão recuperados, a não ser que você solicite
	//na query de consulta (JOIN FETCH)
	@ManyToOne(fetch = FetchType.LAZY)
	@Getter @Setter private Cliente cliente;
	
//	@JoinTable(name = "nomedatabela") - é usado quando há um join tabelas compartilhadas com relacionamentos
	
	//Relacionamento bidirecional e definição de efeito cascata (tudo que eu fizer nessa classe faça para a classe de JOIN)
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	@Getter @Setter private List<ItemPedido> itens = new ArrayList<>();
	
	public void addItens(ItemPedido item) {
		item.setPedido(this);		//Setando o outro lado do relacionamento (NÃO ESQUEÇA)
		this.itens.add(item);		//Adicionando os itens na lista
		this.setValorTotal(this.valorTotal.add(item.getValor()));
	}
}
