package br.com.alura.loja;

import br.com.alura.loja.model.cliente.Cliente;
import br.com.alura.loja.model.cliente.ClienteDAO;
import br.com.alura.loja.model.pedido.Pedido;
import br.com.alura.loja.model.pedido.PedidoDAO;
import br.com.alura.loja.model.produto.Categoria;
import br.com.alura.loja.model.produto.CategoriaDAO;
import br.com.alura.loja.model.produto.Produto;
import br.com.alura.loja.model.produto.ProdutoDAO;
import br.com.alura.loja.model.relationship.ItemPedido;
import br.com.alura.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class LojaApplication {
    public static void main(String[] args) {
        popularBancoDeDados();
//        listarProdutos();
        cadastrarPedido();
    }

    private static void popularBancoDeDados() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);
        CategoriaDAO categoriaDAO = new CategoriaDAO(entityManager);
        ClienteDAO clienteDAO = new ClienteDAO(entityManager);

        Categoria talher = new Categoria("Talher");
        Produto colher = new Produto("Faca", "Ela corta.", talher, new BigDecimal("10"));
        Cliente cliente = new Cliente("Raphael", "123");

        try {

            entityManager.getTransaction().begin();

            categoriaDAO.cadastrar(talher);
            produtoDAO.cadastrar(colher);
            clienteDAO.cadastrar(cliente);

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

    private static void cadastrarPedido() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        ClienteDAO clienteDAO = new ClienteDAO(entityManager);
        ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);
        PedidoDAO pedidoDAO = new PedidoDAO(entityManager);

        try {
         Cliente cliente = clienteDAO.detalhar(1L);
         Produto produto = produtoDAO.detalhar(1L);
         Pedido pedido = new Pedido(cliente);

         ItemPedido itemPedido = new ItemPedido(4, produto, pedido);

         entityManager.getTransaction().begin();

         pedido.adicionarItem(itemPedido);
         pedidoDAO.cadastrar(pedido);

         entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
        }
    }
}