package db;

import model.Order;
import model.Product;
import model.User;

import java.util.*;

public class OrderRepo {
    Map<String,Map<String,Order>> ordersUsers;


    public OrderRepo(){
        this.ordersUsers = new HashMap<>() {
        };
    }

    int idCounter=0;
    public void addOrder(Order order, User user){
        //idCounter++;
        // id="OrderNr."+idCounter;
        boolean exists=false;
        if(!this.ordersUsers.containsKey(user.getName().toLowerCase(Locale.ROOT))){
            this.ordersUsers.put(user.getName().toLowerCase(Locale.ROOT),new HashMap<>());
        }
        this.ordersUsers.get(user.getName().toLowerCase(Locale.ROOT)).put(order.getOrderID(), order);
    }



    public void addProductToExistingOrder(User user, Product product, String orderID){

        ordersUsers.get(user.getName()).get(orderID).addProduct(product);
    }


    public  String getOrdersAsString(){
        return this.ordersUsers.toString();
    }

}
