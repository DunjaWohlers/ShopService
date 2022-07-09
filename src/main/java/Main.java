import db.OrderRepo;
import db.ProductRepo;
import model.Order;
import model.Product;

import java.util.Scanner;

public class Main {


    public  static void main(String[] args) {
        ProductRepo repo = new ProductRepo();
        OrderRepo orders=new OrderRepo();
        abfrage(repo,orders);
    }

    private static void welcomeMessage(String user) {
        System.out.println("Willkommen, " + user);
        System.out.println("Bitte wähle eine der Optionen:");
        System.out.println("1 Neues Produkt anlegen");
        System.out.println("2 Bestellung aufgeben");
        System.out.println("3 Benutzer wechseln");
        System.out.println("e exit");
    }

    private  static void abfrage(ProductRepo repo, OrderRepo orders) {
        System.out.println("Bitte gib deinen Benutzernamen an:");
        String userName=scannerInput();

        welcomeMessage(userName);
       // ShopService service = new ShopService(repo, orderRepo);
        String wahlInput = scannerInput();

        switch (wahlInput) {
            case "1":
                createProduct(repo);
                abfrage(repo,orders);
                break;
            case "2":
                System.out.println("Möchtest du die Waren deiner aktuellen Bestellung hinzufügen? y/n");
                String input=scannerInput();
                if (input.equals("y")) {
                    if(orderIdCounter==0){
                        System.out.println("Du hast noch keine Bestellung ausgeführt, eine neue wird angelegt.");
                        addProductToNewOrder(orders, repo,userName);
                    }else {
                        addProdouctToExistingOrder(orders, repo);
                    }
                }else{
                    System.out.println("Die Waren werden einer neuen Bestellung hinzugefügt...");
                    addProductToNewOrder(orders, repo,userName);
                }
                abfrage(repo,orders);
                break;
            default:
                abfrage(repo,orders);
        }
    }

    private static String scannerInput() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }


    static void createProduct(ProductRepo repo) {
        System.out.println("Gib den Namen des Produktes ein:");
        String name = scannerInput();
        System.out.println("Gib die ID des Produktes ein:");
        String id = scannerInput();
        repo.addProduct(new Product(id, name));
    }

    static void addProdouctToExistingOrder( OrderRepo orderDb, ProductRepo repo) {
        System.out.println(repo.getProductsAsString());
        String orderID=""+orderIdCounter;
        System.out.println("Gib die ID des gewünschten Produktes ein:");
        String id = scannerInput();
        Product chosenProduct=repo.getProductById(id);
        orderDb.addProductToExistingOrder(chosenProduct, orderID);
    }

    static int orderIdCounter=0;
    static void addProductToNewOrder(OrderRepo orderDb, ProductRepo repo, String user) {
        orderIdCounter++;
        System.out.println(repo.getProductsAsString());
        String orderID=""+orderIdCounter;
        System.out.println("Gib die ID des gewünschten Produktes ein:");
        String id = scannerInput();
        System.out.println(repo.getProductById(id));
        Product chosenProduct=repo.getProductById(id);
        Order order=new Order(user,orderID, chosenProduct);
        System.out.println(order);
        orderDb.addOrder(order);//Neuen Order erstellen
        orderDb.addProductToExistingOrder(chosenProduct,orderID); //Product einfügen
        System.out.println(orderDb.getOrdersAsString());

    }

    }
