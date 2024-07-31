package com.example.app_product_manager.model;

public class Product {
    private int id;
    private String name;
    private String company;
    private String description;
    private double price;

    public Product() {}

    public Product(int id, String name, String company, String description, double price) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.description = description;
        this.price = price;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
