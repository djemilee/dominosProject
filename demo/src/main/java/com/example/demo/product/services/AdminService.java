package com.example.demo.product.services;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

public class AdminService {

    @NotNull
    private static boolean isHeAnAdmin;

    public boolean isAddmin(HttpSession h) {
        if (h.isNew() || isHeAnAdmin) {
            return false;
        }
        if (h.getAttribute("id") == null || isHeAnAdmin) {
            return false;
        }
        isHeAnAdmin = true;
        return isHeAnAdmin;
    }

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
