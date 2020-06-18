package com.orsolyazolcsak.allamvizsga.service;

import com.orsolyazolcsak.allamvizsga.model.User;

import java.util.Optional;
import java.util.Set;

public interface UserService {
    Set<User> findAll();
    void createNewUser(User user);
    Optional<User> findById(Long id);
    Optional<User> findByUsername(String username);
    boolean checkUser(String username, char[] password);
    void deleteAll();
}
