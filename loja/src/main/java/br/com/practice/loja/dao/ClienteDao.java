package br.com.practice.loja.dao;

import javax.persistence.EntityManager;

import br.com.practice.loja.modelo.Cliente;
import lombok.AllArgsConstructor;

@AllArgsConstructor

public class ClienteDao {

	private EntityManager em;
	
	public void salvar(Cliente cliente) {
		this.em.persist(cliente);
	}
	
	public Cliente idConsult(Long id) {
		return this.em.find(Cliente.class, id);
	}
	
}
