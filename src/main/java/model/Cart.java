package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products;
    private Customer customer;

    public Cart(Customer customer) {
        this.customer = customer;
        products = new ArrayList<Product>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
