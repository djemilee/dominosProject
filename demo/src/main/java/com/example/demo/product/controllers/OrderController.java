package com.example.demo.product.controllers;


import com.example.demo.product.exceptions.ProductException;
import com.example.demo.product.exceptions.URLException;
import com.example.demo.product.exceptions.UserException;
import com.example.demo.product.dao.OrderDAO;
import com.example.demo.product.models.*;
import com.example.demo.product.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {

    public static final String MESSAGE_FOR_SAVED_ELEMENT = "The element was saved";
    public static final String MESSAGE_FOR_NOT_SAVED_ELEMENT = "The element was not saved";
    @Autowired
    private OrderDAO orderDAO;
    private OrderService orderService;

    @GetMapping("/orders/{addressId}")
    public Address deliveryOrder(@PathVariable long addressId) {

        return this.orderDAO.deliveryOrder(addressId);
    }

    @GetMapping("/orders/hours")
    public List<String> listAllHoursForDelivery() {
        return this.orderDAO.listAllHoursForDelivery();
    }

    @GetMapping("/orders/restaurants")
    public List<Restaurant> listAllRestaurants() throws ProductException, URLException, SQLException {
        return this.orderDAO.deliveryFromAPlace();
    }

    @PostMapping("/yourOrders/{id}")
    public List<ResultOfRequest>  listAllOrdersOnUser(@PathVariable long id, HttpSession session) throws SQLException, ClassNotFoundException, UserException {
        if (orderService.isLogged(session)) {
            return this.orderDAO.listAllOrdersForUser(id);
        }
        else {
            System.out.println("The user is not logged");
            return new ArrayList<>();
        }
    }

    @PostMapping("/product/insertOrder")
    public double insertOrderFromUser(@RequestBody ResultOfOrder resultOfOrder, HttpSession session) throws SQLException, ChangeSetPersister.NotFoundException {
        if(orderService.isLogged(session)) {
            System.out.println(MESSAGE_FOR_SAVED_ELEMENT);
            return this.orderDAO.insertOrderForUser(resultOfOrder);
        }
        else{
            System.out.println(MESSAGE_FOR_NOT_SAVED_ELEMENT);
            return -1;
        }
    }

    @PostMapping("/products/deleteByOrder/{id}")
    public boolean removeProductByOrder(@PathVariable int id, HttpSession session) {
        if (orderService.isLogged(session)) {
            return this.orderDAO.removeProductByOrder(id);
        }
        else {
            return false;
        }
    }
}
