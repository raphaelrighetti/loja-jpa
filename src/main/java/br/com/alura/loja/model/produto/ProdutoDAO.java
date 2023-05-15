package br.com.alura.loja.model.produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProdutoDAO {

    private final EntityManager entityManager;

    public ProdutoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Produto produto) {
        entityManager.persist(produto);
    }

    public Produto detalhar(Long id) {
        return entityManager.find(Produto.class, id);
    }

    public BigDecimal detalharPrecoPorNome(String nome) {
        String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :nome";

        return entityManager.createQuery(jpql, BigDecimal.class)
                .setParameter("nome", nome)
                .getSingleResult();
    }

    public List<Produto> listar() {
        String jpql = "SELECT p FROM Produto p";

        return entityManager.createQuery(jpql, Produto.class).getResultList();
    }

    public List<Produto> listarPorNome(String nome) {
        String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";

        return entityManager.createQuery(jpql, Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    public List<Produto> listarPorNomeDaCategoria(String nome) {
        String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :nome";

        return entityManager.createQuery(jpql, Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    public Produto atualizar(Produto produto) {
        return entityManager.merge(produto);
    }

    public void deletar(Produto produto) {
        entityManager.remove(produto);
    }
}
