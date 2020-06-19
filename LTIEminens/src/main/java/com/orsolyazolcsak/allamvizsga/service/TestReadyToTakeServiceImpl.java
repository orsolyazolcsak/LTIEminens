package com.orsolyazolcsak.allamvizsga.service;

import com.orsolyazolcsak.allamvizsga.model.TestReadyToTake;
import com.orsolyazolcsak.allamvizsga.repository.TestReadyToTakeRepository;
import com.orsolyazolcsak.allamvizsga.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class TestReadyToTakeServiceImpl implements TestReadyToTakeService {

    private final TestReadyToTakeRepository repository;
    private final TestService testService;

    @Autowired
    public TestReadyToTakeServiceImpl(TestReadyToTakeRepository repository, TestService testService) {
        this.repository = repository;
        this.testService = testService;
    }

    public void generateTestReadyToTake(Long testId, String testReadyToTakeName){

    }

    @Override
    public Set<TestReadyToTake> findAll() {
        return new HashSet<>(repository.findAll());
    }

    @Override
    public void createNewTestReadyToTake(TestReadyToTake testReadyToTake) {
        repository.save(testReadyToTake);
    }

    @Override
    public Optional<TestReadyToTake> findById(Long id) {
        return repository.findById(id);
    }
}
