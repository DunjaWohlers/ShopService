package model;

import java.util.Map;
import java.util.Objects;

public class Order {
    String orderId;
    Map<String, Product> products;

    public Order() {
    }

    public Order(String orderId, Map<String,Product> products) {
        this.orderId = orderId;
        this.products = products;
    }



    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Map<String, Product> getProducts() {
        return products;
    }

    public void setProducts(Map<String, Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId) && Objects.equals(products, order.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, products);
    }

    @Override
    public String toString() {
        return  "" + products;
    }
}
