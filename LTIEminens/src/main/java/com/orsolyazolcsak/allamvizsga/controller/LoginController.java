package com.orsolyazolcsak.allamvizsga.controller;

import com.orsolyazolcsak.allamvizsga.model.User;
import com.orsolyazolcsak.allamvizsga.service.LoginUserDao;
import com.orsolyazolcsak.allamvizsga.service.RoleService;
import com.orsolyazolcsak.allamvizsga.service.UserDao;
import com.orsolyazolcsak.allamvizsga.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public LoginController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    //@CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<User> loginUser(LoginUserDao loginUserDao) {
        System.out.println("post called");
        boolean userExists = userService.checkUser(loginUserDao.getUsername(), loginUserDao.getPassword());
        if(userExists){
            User user = userService.findByUsername(loginUserDao.getUsername()).get();
            System.out.println(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        else{
            System.out.println(loginUserDao);
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<User> neszeUser(){
        System.out.println("get called");
        User proba = new User();
        proba.setUsername("Jancsi");
        return new ResponseEntity<>(proba, HttpStatus.ACCEPTED);
    }

//    @CrossOrigin(origins = "http://localhost:3000")
//    @PostMapping
//    public ResponseEntity<User> loginUser2(LoginUserDao loginUserDao) {
//        System.out.println("post called2" + loginUserDao);
//        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//    }

}
