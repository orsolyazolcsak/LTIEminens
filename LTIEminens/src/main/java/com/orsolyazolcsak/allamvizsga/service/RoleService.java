package com.orsolyazolcsak.allamvizsga.service;

import com.orsolyazolcsak.allamvizsga.model.Role;

import java.util.Optional;
import java.util.Set;

public interface RoleService {

    Set<Role> findAll();

    void createNewRole(Role newRole);

    Optional<Role> findById(Long id);

}
