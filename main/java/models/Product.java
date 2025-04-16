package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Product {
    private int id;
    private String name;
    private float price;
    private int stock;

    private Product(int id, String name, float price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    public static Product getInstance(ResultSet res) throws SQLException{
        int id = res.getInt("id");
        String name = res.getString("name");
        float price = res.getFloat("price");
        int stock = res.getInt("stock");

        return new Product(id, name, price, stock);
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
}
