package model;

import java.time.LocalDate;

public class Product {
    private String code;
    private String name;
    private Double price;
    private Integer quantity;
    private LocalDate date;

    public Product(String code, String name, Double price, Integer quantity, LocalDate date) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.date = date;
    }
    public Product() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
