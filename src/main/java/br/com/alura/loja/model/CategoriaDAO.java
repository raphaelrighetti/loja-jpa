package br.com.alura.loja.model;

import javax.persistence.EntityManager;

public class CategoriaDAO {

    private final EntityManager entityManager;

    public CategoriaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Categoria categoria) {
        entityManager.persist(categoria);
    }
}
