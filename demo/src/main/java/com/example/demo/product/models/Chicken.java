package com.example.demo.product.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Chicken extends Product{
    private long id;
    private String name;
    private String description;
    private double price;

    public Chicken() {
    }
}
