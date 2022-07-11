package service;

import db.OrderRepo;
import db.ProductRepo;
import model.Product;
import model.User;


public class ShopService {

    public OrderRepo orderDB;
    public ProductRepo productRepo;
    public User actualUser;

    public ShopService(ProductRepo productRepo, OrderRepo orderRepo){
        this.productRepo=productRepo;
        this.orderDB = orderRepo;
    }

    public void setUser(String userName){
        actualUser=new User(userName);
    }

    public String getUserName(){
        return this.actualUser.getName();
    }

    public User getActualUser(){
        return this.actualUser;
    }



}
