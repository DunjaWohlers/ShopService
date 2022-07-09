package model;

import java.util.Objects;



public class Product {
    String name ;
    String id ;

public Product (String id, String name){
    this.name=name;
    this.id=id;
}

    public String getId() {
        return id;
    }

    public String getName(){
    return this.name;
    }

    @Override
    public String toString() {
        return "" + id + ": "  + name;
    }
}

