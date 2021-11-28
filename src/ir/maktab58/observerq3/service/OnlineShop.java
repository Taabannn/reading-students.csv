package ir.maktab58.observerq3.service;

import ir.maktab58.observerq3.models.Customer;
import ir.maktab58.observerq3.models.Product;
import ir.maktab58.observerq3.models.ProductPublisher;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Taban Soleymani
 */
public class OnlineShop {
    List<ProductPublisher> productPublishers = new ArrayList<>();
    List<Customer> customers = new ArrayList<>();

    public void addNewElectronicStore() {
        ProductPublisher electronicStore = new ProductPublisher("Electronic Store", "Enghelab St. Tehran");
        electronicStore.addNewProduct(new Product("acer laptop: AspireE15", 12, 35000000, electronicStore));
        electronicStore.addNewProduct(new Product("asus laptop: ZenBook 14", 5, 320000000, electronicStore));
        productPublishers.add(electronicStore);
    }

    public void addNewBookShop() {
        ProductPublisher bookShop = new ProductPublisher("Book Shop", "Mirdamad St. Tehran");
        bookShop.addNewProduct(new Product("fiction book: prestige", 0, 25000, bookShop));
        bookShop.addNewProduct(new Product("fiction book: harry potter series", 0, 300000, bookShop));
        bookShop.addNewProduct(new Product("non-fiction book: becoming", 4, 25000, bookShop));
        bookShop.addNewProduct(new Product("non-fiction book: the art of thinking clearly", 4, 25000, bookShop));
        productPublishers.add(bookShop);
    }

    public void registerNewCustomerInfo() {
        addNewElectronicStore();
        addNewBookShop();
        Customer customer1 = new Customer("Taban", "61378");
        Customer customer2 = new Customer("Ali", "96752");
        Customer customer3 = new Customer("Fatemeh", "45675");
        customers.add(customer1);
        customer1.addFavoriteProduct(productPublishers.get(0).getPublishedProducts().get(0));
        productPublishers.get(0).getPublishedProducts().get(0).addNewCustomer(customer1);
        customers.add(customer2);
        customer2.addFavoriteProduct(productPublishers.get(1).getPublishedProducts().get(1));
        productPublishers.get(1).getPublishedProducts().get(1).addNewCustomer(customer2);
        customers.add(customer3);
        customer3.addFavoriteProduct(productPublishers.get(1).getPublishedProducts().get(0));
        productPublishers.get(1).getPublishedProducts().get(0).addNewCustomer(customer3);
    }

    public void onlineShopSimulation() {
        registerNewCustomerInfo();
        productPublishers.get(0).getPublishedProducts().get(0).setDiscountEnabled(true);
        productPublishers.get(0).getPublishedProducts().get(0).setDiscountPercent(0.2);
        productPublishers.get(1).getPublishedProducts().get(0).setCount(5);
        productPublishers.get(1).getPublishedProducts().get(1).setCount(9);
    }
}
