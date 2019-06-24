package com.example.demo.product.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Location {
	
	private int id;
	private String neighborhoodName;
	private City city;
	
}
