package com.escuela.api.controllers;

import com.escuela.api.db.models.*;
import com.escuela.api.jpa.repositories.*;
import com.escuela.api.service.interfaces.UserService;
import com.escuela.api.ui.models.UserWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/register")
public class UserController { final
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/finduser")
    public UserWrapper findRegisteredUsers(HttpServletRequest httpServletRequest){
        String email =httpServletRequest.getParameter("email");
        return userService.fetchUserProfile(email);
    }

    @PostMapping("/adduserprofile")
    public String addUserDetails(@RequestBody UserWrapper userWrapper){
        userService.createUserProfile(userWrapper);
        return "user profile updated";
    }
}


