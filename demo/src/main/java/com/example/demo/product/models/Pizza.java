package com.example.demo.product.models;

import com.example.demo.product.enums.Size;
import lombok.ToString;


@ToString
public class Pizza extends Product {

	private long id;
	private Size size;

	public Pizza() {
	}


	
	public long getId() {
		return this.id;
	}
}

