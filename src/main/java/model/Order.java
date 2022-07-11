package model;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class Order {
    String orderID;
    Map<String, Product> productMap;

    User user;

    public Order(User user, String id, Product product) {
        this.user = user;
        this.orderID = id;
        this.productMap = new HashMap<>();
        addProduct(product);
    }

    public void addProduct(Product product) {
        this.productMap.put(product.id, product);
    }

    public String getOrderID() {
        return orderID;
    }

    @Override
    public String toString() {
        return "" + orderID + ": " + productMap.values() +"("+ user + ')';
    }
}
