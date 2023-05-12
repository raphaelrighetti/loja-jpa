package br.com.alura.loja;

import br.com.alura.loja.model.Categoria;
import br.com.alura.loja.model.CategoriaDAO;
import br.com.alura.loja.model.Produto;
import br.com.alura.loja.model.ProdutoDAO;
import br.com.alura.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class LojaApplication {
    public static void main(String[] args) {
        cadastrarProduto();
        listarProdutos();
    }

    private static void cadastrarProduto() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);
        CategoriaDAO categoriaDAO = new CategoriaDAO(entityManager);

        try {
            Categoria talher = new Categoria("Talher");

            Produto colher = new Produto("Faca", "Ela corta.", talher, new BigDecimal("10"));

            entityManager.getTransaction().begin();

            categoriaDAO.cadastrar(talher);
            produtoDAO.cadastrar(colher);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    private static void listarProdutos() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);

        Produto produto = produtoDAO.detalhar(1L);

        System.out.println("\nProduto detalhado: " + produto.getNome() + "\n");

        List<Produto> produtos = produtoDAO.listar();

        System.out.println("\nLista de produtos:\n");

        produtos.forEach(p -> System.out.println(p.getNome()));

        List<Produto> produtosPorNome = produtoDAO.listarPorNome("Garfo");

        System.out.println("\nProdutos de nome \"Garfo\":\n");

        produtosPorNome.forEach(p -> System.out.println(p.getNome()));

        List<Produto> produtosPorNomeDaCategoria = produtoDAO.listarPorNomeDaCategoria("Talher");

        System.out.println("\nProdutos com nome da categoria \"Talher\":\n");

        produtosPorNome.forEach(p -> System.out.println(p.getNome()));

        BigDecimal precoDoProduto = produtoDAO.detalharPrecoPorNome("Faca");

        System.out.println("\nPreço do produto com nome \"Faca\": " + precoDoProduto.toString() + "\n");
    }
}