package br.com.alura.loja.model.cliente;

import javax.persistence.EntityManager;

public class ClienteDAO {

    private final EntityManager entityManager;

    public ClienteDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Cliente cliente) {
        entityManager.persist(cliente);
    }

    public Cliente detalhar(Long id) {
        return entityManager.find(Cliente.class, id);
    }
}
