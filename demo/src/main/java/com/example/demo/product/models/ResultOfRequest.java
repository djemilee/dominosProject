package com.example.demo.product.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultOfRequest {

    private String firstName;
    private String lastName;
    private String city;
    private String neighborhood;
    private String productName;
    private int quantity;
    private String date;

    public ResultOfRequest() {}
}
