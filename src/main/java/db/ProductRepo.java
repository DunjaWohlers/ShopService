package db;

import model.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductRepo {
    Map<String, Product> productList = new HashMap<>();
    public ProductRepo(){
    }

    public ProductRepo(HashMap<String, Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "products:" + productList;
    }

    public Map<String, Product> getProductList() {
        return productList;
    }

    public void setProductList(Map<String, Product> productList) {
        this.productList = productList;
    }

    public void add(Product product) {
        this.productList.put( product.getId(),product);
    }
}
