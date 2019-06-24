package com.example.demo.product.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.demo.product.exceptions.ProductException;
import com.example.demo.product.exceptions.URLException;
import com.example.demo.product.models.*;

public interface IProductDAO {

	Product getProductById(long id) throws ProductException, URLException, SQLException;

	List<Drink> getAllDrinks() throws URLException, ProductException, SQLException;

	List<Sauce> getAllSauces() throws URLException, ProductException, SQLException;

	List<Pizza> getAllPizzas() throws URLException, ProductException, SQLException;
}
