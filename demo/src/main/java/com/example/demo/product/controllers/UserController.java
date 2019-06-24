package com.example.demo.product.controllers;

import com.example.demo.product.dto.LoginDTO;
import com.example.demo.product.exceptions.UserException;
import com.example.demo.product.dao.UserDAO;
import com.example.demo.product.models.Address;
import com.example.demo.product.models.User;
import com.example.demo.product.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@RestController
public class UserController {

    public static final String LOGIN_MESSAGE = "Login";
    public static final String SIGNOUT_MESSAGE = "Signout";
    public static final String MESSAGE_FOR_SAVED_ADDRESS = "The address was saved";
    public static final String MESSAGE_FOR_NOT_SAVED_ADDRESS = "The address was not saved";
    public static final String USER_REGISTERED_MESSAGE = "User registered";
    @Autowired
    private UserDAO userDAO;
    private UserService userService;


    @PostMapping("/users/login")
    public String login(@RequestBody LoginDTO user, HttpServletRequest request) throws SQLException {
        User u = this.userDAO.login(user);
        HttpSession session = request.getSession();
        session.setAttribute("id", u.getId());

        return LOGIN_MESSAGE;
    }

    @PostMapping("/users/signout")
    public String logout(HttpServletRequest request) throws UserException {
        HttpSession session = request.getSession();
        session.invalidate();

        return SIGNOUT_MESSAGE;
    }

    @PostMapping("/addaddresses")
    public int addAddress(@RequestBody Address address, HttpSession session) throws SQLException, ChangeSetPersister.NotFoundException {
        if(userService.isLogged(session)) {
            address.setUserId((long) (session.getAttribute("id")));
            System.out.println(MESSAGE_FOR_SAVED_ADDRESS);
            return this.userDAO.insertAddressForUser(address);
        }
        else{
            System.out.println(MESSAGE_FOR_NOT_SAVED_ADDRESS);
            return -1;
        }
    }

    @PostMapping("/users/delete/{id}")
    public boolean removeUser(@PathVariable int id) {
        return this.userDAO.removeUser(id);
    }


    @PostMapping("/users/register")
    public int registerUser(@RequestBody User user) throws SQLException, ClassNotFoundException {
        System.out.println(USER_REGISTERED_MESSAGE);
            return this.userDAO.register(user);
    }

     @GetMapping("/getUser/{id}")
     public User getUserById(@PathVariable long id) throws SQLException, ClassNotFoundException {
            return this.userDAO.getUserByID(id);
     }
}
