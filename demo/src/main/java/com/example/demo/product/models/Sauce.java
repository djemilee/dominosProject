package com.example.demo.product.models;

import com.example.demo.product.exceptions.URLException;

public class Sauce extends Product {
	private int id;

	public Sauce() {

	}
	
	public Sauce(long id,float price, String pictureUrl, String name) throws URLException {
		super(id, price, pictureUrl, name);
	}
	
	public long getId() {
		return this.id;
	}
}
