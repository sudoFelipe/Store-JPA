package br.com.practice.loja.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	//Classe para manipulação da base de dados
	//Entity Factory recupera a entidade passada no pom da TAG persistence-unity do POM.XML
	
	//Criação da interface EntityManager
	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("loja");
	
	//Retorno da classe que implementa a interface
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}
}
