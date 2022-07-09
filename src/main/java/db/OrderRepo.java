package db;

import model.Order;
import model.Product;

import java.util.*;

public class OrderRepo {
    Map<String,Order> orders;

    public OrderRepo(){
        this.orders = new HashMap<>();
    }

    int idCounter=0;
    public void addOrder(Order order){
        //idCounter++;
        // id="OrderNr."+idCounter;
        this.orders.put(order.getOrderID(), order);
    }



    public void addProductToExistingOrder(Product product, String orderID){

        orders.get(orderID).addProduct(product);
    }


    public  String getOrdersAsString(){
        return this.orders.toString();
    }

}
