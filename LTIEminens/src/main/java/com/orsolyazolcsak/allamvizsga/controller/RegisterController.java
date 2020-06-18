package com.orsolyazolcsak.allamvizsga.controller;

import com.orsolyazolcsak.allamvizsga.model.Role;
import com.orsolyazolcsak.allamvizsga.model.User;
import com.orsolyazolcsak.allamvizsga.service.RoleService;
import com.orsolyazolcsak.allamvizsga.service.UserDao;
import com.orsolyazolcsak.allamvizsga.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/register")
public class RegisterController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public RegisterController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<User> newUser(UserDao newUserDao) {
        User newUser = new User();
        newUser.setRole(roleService.findById(newUserDao.getRoleId()).orElseThrow(() -> new IllegalStateException("Role with specified id doesn't exist")));
        newUser.setUsername(newUserDao.getUsername());
        newUser.setPassword(newUserDao.getPassword());
        newUser.setFullName(newUserDao.getFullName());
        userService.createNewUser(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
