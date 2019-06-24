package com.example.demo.product.services;

import javax.servlet.http.HttpSession;

public class OrderService {

    public static boolean isLogged(HttpSession s){
        if(s.isNew()){
            return false;
        }
        if(s.getAttribute("id") == null){
            return false;
        }
        return true;
    }
}
