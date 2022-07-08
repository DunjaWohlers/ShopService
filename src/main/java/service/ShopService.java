package service;

import db.OrderRepo;
import db.ProductRepo;
import model.Order;
import model.Product;

import java.util.Map;

public class ShopService {
   ProductRepo productRepo;
   OrderRepo orderRepo;

   public ShopService(){}
    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    public Product getProduct( String id){
     //   System.out.println(productRepo.getProductList().stream().filter(e->(e.getId()==id)).findAny());
      //  System.out.println(productRepo.getProductList().stream().filter(e->e.getId()==id));
        return productRepo.getProductList().get(id);
    }

    public void addOrder(Order order){
     this.orderRepo.add(order);
    }

    public Order getOrder(String auftragsNummer){
            return orderRepo.getOrders().get(auftragsNummer);
    }

    public Map<String,Product> listProducts(){
       return productRepo.getProductList();
    }

    public Map<String,Order> listorder(){
       return orderRepo.getOrders();
    }


    public ProductRepo getProductRepo() {
        return productRepo;
    }

    public void setProductRepo(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public OrderRepo getOrderRepo() {
        return orderRepo;
    }

    public void setOrderRepo(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public String toString() {
        return "ShopService{" +
                "productRepo=" + productRepo +
                ", orderRepo=" + orderRepo +
                '}';
    }
}
