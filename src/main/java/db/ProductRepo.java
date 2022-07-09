package db;

import model.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductRepo {
    Map<String, Product> productList;


    public ProductRepo() {
        this.productList = new HashMap<>();

        String[] productNames={"iPhone","Nokia","BabypandaPhone", "iAlpakka", "iSteak"};
        int counter=0;
        for(String name:productNames){
            counter++;
            String id=""+counter;
            this.productList.put(id,new Product(id,name));
        }

    }

    public void addProduct(Product product){
        productList.put(product.getId(), product);
    }

    public Product getProductById(String id){
        return productList.get(id);
    }

    public  String getProductsAsString(){
        return this.productList.toString();
    }


}
