package models.dto;

public class UpdateProduct {
    private String name;
    private float price;
    private int stock;

    public UpdateProduct() {}

    public UpdateProduct(int stock){
        this.stock = stock;
    }
    public UpdateProduct(float price){
        this.price = price;
    }
    public UpdateProduct(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
