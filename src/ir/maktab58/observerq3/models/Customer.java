package ir.maktab58.observerq3.models;

import java.util.*;

/**
 * @author Taban Soleymani
 */
public class Customer {
    private String username;
    private String password;
    private Set<Product> favoriteProducts = new HashSet<>();

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void addFavoriteProduct(Product product) {
        favoriteProducts.add(product);
    }

    public void notifyMe(String message) {
        System.out.println(username + " " + message);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Product> getFavoriteProducts() {
        return favoriteProducts;
    }

    public void setFavoriteProducts(Set<Product> favoriteProducts) {
        this.favoriteProducts = favoriteProducts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return username.equals(customer.username) && password.equals(customer.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "username='" + username + '\'' +
                '}';
    }
}
