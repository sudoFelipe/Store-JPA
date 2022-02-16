package br.com.practice.loja.dao;

import javax.persistence.EntityManager;

import br.com.practice.loja.modelo.Categoria;
import lombok.AllArgsConstructor;

@AllArgsConstructor

public class CategoriaDao {

	private EntityManager em;
	
	public void salvar(Categoria categoria) {
		this.em.persist(categoria);
	}
	
	public void update(Categoria categoria) {
		this.em.merge(categoria);
	}
	
	public void delete(Categoria categoria) {
		categoria = em.merge(categoria);
		this.em.remove(categoria);
	}
	
}
