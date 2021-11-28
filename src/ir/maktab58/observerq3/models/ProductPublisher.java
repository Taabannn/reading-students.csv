package ir.maktab58.observerq3.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Taban Soleymani
 */
public class ProductPublisher {
    private String name;
    private String address;
    private List<Product> publishedProducts = new ArrayList<>();

    public ProductPublisher(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void addNewProduct(Product product) {
        publishedProducts.add(product);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Product> getPublishedProducts() {
        return publishedProducts;
    }

    public void setPublishedProducts(List<Product> publishedProducts) {
        this.publishedProducts = publishedProducts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductPublisher that = (ProductPublisher) o;
        return name.equals(that.name) && address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }

    @Override
    public String toString() {
        return "ProductPublisher{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", publishedProducts=" + publishedProducts +
                '}';
    }
}
