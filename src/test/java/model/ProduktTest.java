package model;

import db.OrderRepo;
import db.ProductRepo;
import org.junit.jupiter.api.Test;
import service.ShopService;

import java.util.List;
import java.util.Map;

class ProduktTest {

    @Test
    void productListIsEmpty(){
        Product product1 = new Product("Samsung", "1");
        Product product2 = new Product("iPhone", "2");
        Product product3 = new Product("Nokia", "3");
        ProductRepo repo=new ProductRepo(
                //Map.of(product1.id,product1,product2.id,product2)
        );
        repo.getProductList().put(product1.id,product1);
        repo.getProductList().put(product2.id,product2);
        repo.getProductList().put(product3.id,product3);

        System.out.println(repo);
        System.out.println(repo);
        Order order1 = new Order("O1", repo.getProductList());
        Order order2 = new Order("O2", repo.getProductList());
        Order order3 = new Order("O3", repo.getProductList());

        System.out.println(order1);
//
        OrderRepo orderRepo = new OrderRepo();
        orderRepo.add(order1);
        System.out.println(orderRepo);
        System.out.println("Shop Service");
        ShopService service = new ShopService(repo, orderRepo);
//
        System.out.println(service.getProduct("1"));

        service.addOrder(order2);
        System.out.println(service.getProduct("2"));

        System.out.println("Produkte:");
        System.out.println(service.listProducts());





    }

}