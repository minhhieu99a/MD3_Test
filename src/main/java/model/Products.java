package model;

public class Products {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private String color;
    private String decribtion;
    private Category category;

    public Products() {
    }

    public Products(String name, double price, int quantity, String color, String decribtion, Category category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.decribtion = decribtion;
        this.category = category;
    }

    public Products(int id, String name, double price, int quantity, String color, String decribtion, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.decribtion = decribtion;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDecribtion() {
        return decribtion;
    }

    public void setDecribtion(String decribtion) {
        this.decribtion = decribtion;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}