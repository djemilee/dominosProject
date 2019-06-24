package com.example.demo.product.controllers;

import com.example.demo.product.dao.AdminDAO;
import com.example.demo.product.models.Admin;
import com.example.demo.product.services.AdminService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@RestController
public class AdminController {

    public static final String MESSAGE = "The administration is not logged";
    @NotNull
    private AdminDAO adminDAO;
    private AdminService adminService;
    private Admin admin;

    @PostMapping("/orders/deleteOld")
    public Boolean removeOldOrder(HttpSession session) {
        if (adminService.isLogged(session) && adminService.isAddmin(session)) {
            Thread thread = new Thread(this.admin);
            thread.setDaemon(true);
            thread.start();
            return true;
        }
        else {
            System.out.println(MESSAGE);
            return false;
        }
    }
}
