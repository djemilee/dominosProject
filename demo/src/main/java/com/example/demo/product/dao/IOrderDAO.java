package com.example.demo.product.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.TreeSet;

import com.example.demo.product.exceptions.AddressException;
import com.example.demo.product.models.Order;
import com.example.demo.product.models.Product;
import com.example.demo.product.models.User;

public interface IOrderDAO {

	TreeSet<Order> getOrdersForUser(long user_id) throws ClassNotFoundException, SQLException;

	HashMap<Product, Integer> getProductsForOrder(long orderId) throws SQLException;

	void insertOrderForUser(Order order) throws SQLException;

	void insertProductsFromOrder(long orderId, HashMap<Product, Integer> cart) throws SQLException;

	Order getActiveOrderForUser(User user) throws SQLException;
	
	Order getOrderById(long id) throws SQLException, ClassNotFoundException, AddressException;
	
	void deleteOrderOnAddress(long address_id) throws SQLException;

}
