package com.orsolyazolcsak.allamvizsga.service;

import com.orsolyazolcsak.allamvizsga.model.Role;
import com.orsolyazolcsak.allamvizsga.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {


    private final RoleRepository repository;

    @Autowired
    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Set<Role> findAll() {
        return (Set<Role>) repository.findAll();
    }

    @Override
    public void createNewRole(Role newRole) {
        repository.save(newRole);
    }

    @Override
    public Optional<Role> findById(Long id) {
        return repository.findById(id);
    }
}
