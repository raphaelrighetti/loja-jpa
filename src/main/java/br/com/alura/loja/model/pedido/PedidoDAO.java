package br.com.alura.loja.model.pedido;

import javax.persistence.EntityManager;

public class PedidoDAO {

    private final EntityManager entityManager;

    public PedidoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Pedido pedido) {
        entityManager.persist(pedido);
    }

    public Pedido detalhar(Long id) {
        return entityManager.find(Pedido.class, id);
    }
}
