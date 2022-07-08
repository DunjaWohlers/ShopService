package db;

import model.Order;

import java.util.*;

public class OrderRepo {
    Map<String,Order> orders = new HashMap<>();

    public OrderRepo() {
    }

    public OrderRepo(HashMap<String, Order> orders) {
        this.orders = orders;
    }

    public void add(Order order){
        this.orders.put(order.getOrderId(),order);
    }


    public Map<String, Order> getOrders() {
        return orders;
    }

    public void setOrders(Map<String, Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "OrderRepo:" + orders +
                ' ';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderRepo orderRepo = (OrderRepo) o;
        return Objects.equals(orders, orderRepo.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orders);
    }
}
