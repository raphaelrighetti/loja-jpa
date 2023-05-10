package br.com.alura.loja;

import br.com.alura.loja.model.Categoria;
import br.com.alura.loja.model.CategoriaDAO;
import br.com.alura.loja.model.Produto;
import br.com.alura.loja.model.ProdutoDAO;
import br.com.alura.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class LojaApplication {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);
        CategoriaDAO categoriaDAO = new CategoriaDAO(entityManager);

        try {
            Categoria talher = new Categoria("Talher");

            Produto colher = new Produto("Garfo", "Um pouco util.", talher, new BigDecimal("10"));

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
}