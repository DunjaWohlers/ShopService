import db.OrderRepo;
import db.ProductRepo;
import model.Order;
import model.Product;
import service.ShopService;

import java.util.Map;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        int idCounter=0;
        welcomeMessage();
        ProductRepo repo = createProducts();
        OrderRepo orderRepo = createOrderRepo(repo);
        ShopService service = new ShopService(repo, orderRepo);

        String input1= scannerInput();

        switch (input1) {
            case "1" -> {
                System.out.println("Gib den Namen des Produktes ein:");
                String name = scannerInput();
                System.out.println("Gib die ID des Produktes ein:");
                String id = scannerInput();
                service.addProduct(name, id);
            }
            // System.out.println(service.getProductRepo());
            case "2" -> {
                System.out.println("============================================");
                repo.getProductList().values().forEach(System.out::println);
                System.out.println("============================================");
                System.out.println("Gib die Id des gewünschten Produktes ein:");
                String id2 = scannerInput();
                idCounter++;
                Product product = service.getProduct(id2);
                service.addOrder(new Order("" + idCounter, Map.of(product.getId(), product)));
            }
            case "3" ->{
                System.out.println("============================================");
                repo.getProductList().values().forEach(System.out::println);
                System.out.println("============================================");
            }
            case "4" ->{
                System.out.println("Bisherige Aufträge:");

                if(service.listorder().size()==0){
                    System.out.println("Keine Aufträge vorhanden");
                }else {
                    service.listorder().forEach((k, v) -> {
                        System.out.println(v);
                    });
                }
            }

        }
    }

    private static void welcomeMessage(){
        System.out.println("Bitte wähle eine der Optionen:");
        System.out.println("1 Produkt anlegen");
        System.out.println("2 Bestellung aufgeben");
        System.out.println("3 Alle Produkte anzeigen");
        System.out.println("4 Alle Aufträge anzeigen");
    }


    private static String scannerInput() {

        Scanner scan= new Scanner(System.in);
        return scan.nextLine();
    }

    private static OrderRepo createOrderRepo(ProductRepo repo) {
        Order orderNull=new Order();
        Order order1 = new Order("O1", repo.getProductList());
        Order order2 = new Order("O2", repo.getProductList());
        Order order3 = new Order("O3", repo.getProductList());

        System.out.println(order1);

        OrderRepo orderRepo = new OrderRepo();
       // orderRepo.add(orderNull);
        return orderRepo;
    }

    public static ProductRepo createProducts(){
        Product product1 = new Product("Samsung", "1");
        Product product2 = new Product("iPhone", "2");
        Product product3 = new Product("Nokia", "3");
        ProductRepo repo=new ProductRepo(
                //Map.of(product1.id,product1,product2.id,product2)
        );
        repo.getProductList().put(product1.getId(),product1);
        repo.getProductList().put(product2.getId(),product2);
        repo.getProductList().put(product3.getId(),product3);

        return repo;
    }


}
