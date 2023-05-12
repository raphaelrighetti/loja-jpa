package br.com.alura.loja.model;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDAO{

    private final EntityManager entityManager;

    public CategoriaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Categoria categoria) {
        entityManager.persist(categoria);
    }

    public Categoria detalhar(Long id) {
        return entityManager.find(Categoria.class, id);
    }

    public List<Categoria> listar() {
        String jpql = "SELECT c FROM Categoria c";

        return entityManager.createQuery(jpql, Categoria.class).getResultList();
    }

    public Categoria atualizar(Categoria categoria) {
        return entityManager.merge(categoria);
    }

    public void deletar(Categoria categoria) {
        entityManager.remove(categoria);
    }
}
