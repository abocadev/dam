package dev.boca.ejercicio3;

import java.util.ArrayList;

public class Product {

    public static ArrayList<Product> products = new ArrayList<>();

    private int title;
    private int img;
    private int quantity;

    public Product(){}

    public Product(int title, int img, int quantity){
        this.title = title;
        this.img = img;
        this.quantity = quantity;
    }

    public int getTitle() {
        return title;
    }

    public int getImg() {
        return img;
    }

    public int getQuantity() {
        return quantity;
    }


    public void addProduct(int title, int img){
        for(Product product : products){
            if(title == product.getTitle()){
                product.quantity++;
                return ;
            }
        }
        products.add(new Product(title, img, 1));
    }

    public void removeProduct(int position){
        if(products.get(position).quantity > 1){
            products.get(position).quantity--;
        }else{
            products.remove(position);
        }
    }

    public ArrayList<Product> getProducts(){
        return products;
    }
}
