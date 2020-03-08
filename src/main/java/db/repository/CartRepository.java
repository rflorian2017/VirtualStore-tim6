package db.repository;

import model.Cart;

import java.util.List;
import java.util.Optional;

public class CartRepository implements CrudRepository<Cart, Integer> {
    @Override
    public List<Cart> findAll() {
        return null;
    }

    @Override
    public Cart save(Cart o) {
        return null;
    }

    @Override
    public Cart deleteById(Integer id) {
        return null;
    }

    @Override
    public Optional<Cart> findById(Integer id) {
        return Optional.empty();
    }
}
