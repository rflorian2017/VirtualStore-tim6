package db.repository;

import model.Product;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class ProductRepository implements CrudRepository<Product, Integer> {
    private EntityManager entityManager;

    public ProductRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Product> findAll() {
        return entityManager.createQuery("SELECT p from Product p").getResultList();
    }

    @Override
    public Product save(Product product) {
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
        return product;
    }

    @Override
    public Product deleteById(Integer id) {
        Product product = findById(id).get();
        entityManager.getTransaction().begin();
        entityManager.remove(product);
        entityManager.getTransaction().commit();
        return product;
    }

    @Override
    public Optional<Product> findById(Integer id) {
        Product product = entityManager.find(Product.class, id);
        if (product!=null) {
            return Optional.of(product);
        }

        return Optional.empty();
    }
}
