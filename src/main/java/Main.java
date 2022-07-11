import db.OrderRepo;
import db.ProductRepo;
import model.Order;
import model.Product;
import model.User;
import service.ShopService;
import java.util.Scanner;
public class Main {
    public  static void main(String[] args) {
        ProductRepo repo = new ProductRepo();
        OrderRepo orders=new OrderRepo();
        ShopService shopService= new ShopService(repo, orders);
        registerUser(shopService);
        abfrage(shopService);
    }
    private static void welcomeMessage(String user) {
        System.out.println("Willkommen, " + user);
        System.out.println("Bitte wähle eine der Optionen:");
        System.out.println("1 Neues Produkt anlegen");
        System.out.println("2 Bestellung aufgeben");
        System.out.println("3 Benutzer wechseln");
        System.out.println("e exit");
    }
    private  static void abfrage(ShopService shopService) {
        welcomeMessage(shopService.getUserName());
        String wahlInput = scannerInput();
        switch (wahlInput) {
            case "1" -> {
                createProduct(shopService);
                abfrage(shopService);
            }
            case "2" -> {
                System.out.println("Möchtest du die Waren deiner aktuellen Bestellung hinzufügen? y/n");
                String input = scannerInput();
                if (input.equals("y")) {
                    if (orderIdCounter == 0) {
                        System.out.println("Du hast noch keine Bestellung ausgeführt, eine neue wird angelegt.");
                        addProductToNewOrder(shopService, shopService.getActualUser());
                    } else {
                        addProdouctToExistingOrder(shopService);
                    }
                } else {
                    System.out.println("Die Waren werden einer neuen Bestellung hinzugefügt...");
                    addProductToNewOrder(shopService, shopService.getActualUser());
                }
                abfrage(shopService);
            }
            default -> {
                registerUser(shopService);
                abfrage(shopService);
            }
        }
    }

    private static String scannerInput() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    static void createProduct(ShopService shopService) {
        System.out.println("Gib den Namen des Produktes ein:");
        String name = scannerInput();
        System.out.println("Gib die ID des Produktes ein:");
        String id = scannerInput();
        shopService.productRepo.addProduct(new Product(id, name));
    }

    static void addProdouctToExistingOrder( ShopService shopService) {
        System.out.println(shopService.productRepo.getProductsAsString());
        String orderID=""+orderIdCounter;
        System.out.println("Gib die ID des gewünschten Produktes ein:");
        String id = scannerInput();
        Product chosenProduct=shopService.productRepo.getProductById(id);
        shopService.orderDB.addProductToExistingOrder(shopService.getActualUser(),chosenProduct, orderID);
    }

    static int orderIdCounter=0;
    static void addProductToNewOrder(ShopService shopService, User user) {
        orderIdCounter++;
        System.out.println(shopService.productRepo.getProductsAsString());
        String orderID=""+orderIdCounter;
        System.out.println("Gib die ID des gewünschten Produktes ein:");
        String id = scannerInput();
        System.out.println(shopService.productRepo.getProductById(id));
        Product chosenProduct=shopService.productRepo.getProductById(id);
        Order order=new Order(user,orderID, chosenProduct);
        System.out.println(order);
        shopService.orderDB.addOrder(order, user);//Neuen Order erstellen
        shopService.orderDB.addProductToExistingOrder(user,chosenProduct,orderID); //Product einfügen
        System.out.println(shopService.orderDB.getOrdersAsString());

    }

    static void registerUser(ShopService shopService){
        System.out.println("Bitte gib deinen Benutzernamen an:");
        String userName=scannerInput();
        shopService.setUser(userName);
    }

    }
