package dev.boca.ejercicio3;

import java.util.ArrayList;

public class Product {

    private int title;
    private int description;
    private int img;

    public Product(int title, int description, int img) {
        this.title = title;
        this.description = description;
        this.img = img;
    }

    public int getTitle() {
        return title;
    }

    public int getDescription(){
        return description;
    }

    public int getImg() {
        return img;
    }

    public static ArrayList<Product> createBurgers(){
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Product(R.string.title_burger1_Products, R.string.info_burger1_Products, R.drawable.brutar_bacon_crispy));
        products.add(new Product(R.string.title_burger2_Products, R.string.info_burger2_Products, R.drawable.chicken_wrap));
        products.add(new Product(R.string.title_burger3_Products, R.string.info_burger3_Products, R.drawable.king_chicken));
        products.add(new Product(R.string.title_burger4_Products, R.string.info_burger4_Products, R.drawable.whopper));
        return products;
    }
}
