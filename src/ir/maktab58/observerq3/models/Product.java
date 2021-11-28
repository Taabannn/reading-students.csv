package ir.maktab58.observerq3.models;

import java.util.*;

/**
 * @author Taban Soleymani
 */
public class Product {
    private String name;
    private int count;
    private long price;
    private ProductPublisher publisher;
    private List<Customer> interestedCustomers = new ArrayList<>();
    private double discountPercent = 0.0;
    private boolean isDiscountEnabled = false;
    private boolean hasCountIncreased = false;

    public Product(String name, int count, long price, ProductPublisher publisher) {
        this.name = name;
        this.count = count;
        this.price = price;
        this.publisher = publisher;
        activateProThread();
    }

    public void addNewCustomer(Customer customer) {
        interestedCustomers.add(customer);
    }

    private void activateProThread() {
        Thread proThread = new Thread(() -> {
            while (hasCountIncreased || (isDiscountEnabled && discountPercent != 0.0)) {
                interestedCustomers.forEach(customer -> customer.notifyMe(generateMessage()));
                interestedCustomers = new ArrayList<>();
                hasCountIncreased = false;
            }
        });
        proThread.start();
    }

    private String generateMessage() {
        String message = "";
        if (hasCountIncreased)
            message += "the count of product " + name + " has increased.";

        if (isDiscountEnabled && discountPercent!=0.0)
            message += "we enabled " + (discountPercent*100) + " discount for product " + name;

        if (message.length() == 0)
            message = "sorry! unable to process.";

        return message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if (this.count == 0)
            hasCountIncreased = true;
        this.count = count;
    }

    public long getPrice() {
        if (isDiscountEnabled)
            return (long) (price * (1 - discountPercent));
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public boolean isDiscountEnabled() {
        return isDiscountEnabled;
    }

    public void setDiscountEnabled(boolean discountEnabled) {
        isDiscountEnabled = discountEnabled;
    }

    public ProductPublisher getPublisher() {
        return publisher;
    }

    public void setPublisher(ProductPublisher publisher) {
        this.publisher = publisher;
    }

    public List<Customer> getInterestedCustomers() {
        return interestedCustomers;
    }

    public void setInterestedCustomers(List<Customer> interestedCustomers) {
        this.interestedCustomers = interestedCustomers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && name.equals(product.name) && publisher.equals(product.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, publisher);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", publisher=" + publisher +
                ", discountPercent=" + discountPercent +
                ", isDiscountEnabled=" + isDiscountEnabled +
                '}';
    }
}
