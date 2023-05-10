package br.com.alura.loja.model;

import javax.persistence.EntityManager;

public class ProdutoDAO {

    private final EntityManager entityManager;

    public ProdutoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Produto produto) {
        entityManager.persist(produto);
    }
}
