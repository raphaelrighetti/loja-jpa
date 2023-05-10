package br.com.alura.loja;

import br.com.alura.loja.model.Produto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.math.BigDecimal;

public class LojaApplication {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("loja");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            Produto colher = new Produto(null, "Colher", "Muito util!", new BigDecimal("10"));

            entityManager.getTransaction().begin();
            entityManager.persist(colher);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            entityManagerFactory.close();
            entityManager.close();
        }
    }
}