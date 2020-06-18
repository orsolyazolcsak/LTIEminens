package com.orsolyazolcsak.allamvizsga.service;

import com.orsolyazolcsak.allamvizsga.model.Test;
import com.orsolyazolcsak.allamvizsga.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class TestServiceImpl implements TestService{

    @Autowired
    private TestRepository repository;

    @Override
    public Set<Test> findAll() {
        return new HashSet<>(repository.findAll());
    }

    @Override
    public void createNewTest(Test newTest) {
        repository.save(newTest);
    }

    @Override
    public Optional<Test> findById(Long id) {
        return repository.findById(id);
    }
}
