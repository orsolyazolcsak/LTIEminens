package com.orsolyazolcsak.allamvizsga.controller;

import com.orsolyazolcsak.allamvizsga.model.AuthenticationMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public AuthenticationMessage loginUser() {
        System.out.println("LoginController.loginUser");
        return new AuthenticationMessage("You are authenticated.");
    }
}
