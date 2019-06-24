package com.example.demo.product.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dessert extends Product {
    private long id;
    private String name;
    private String description;
    private double price;
    private String pictureURL;

    public Dessert() {
    }
}
