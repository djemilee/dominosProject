package com.example.demo.product.services;

import com.example.demo.product.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserService {

    public static boolean isLogged(HttpSession s){
        if(s.isNew()){
            return false;
        }
        if(s.getAttribute("id") == null){
            return false;
        }
        return true;
    }

    public Integer getLoggedUser(HttpServletRequest request) throws UserException {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("logged");

        if (userId != null) {
            return userId;
        }
        else {
            throw new UserException("The user is not logged");
        }
    }

}
