package com.orsolyazolcsak.allamvizsga.service;

import com.orsolyazolcsak.allamvizsga.model.TestReadyToTake;

import java.util.Optional;
import java.util.Set;

public interface TestReadyToTakeService {
    Set<TestReadyToTake> findAll();

    void createNewTestReadyToTake(TestReadyToTake testReadyToTake);

    Optional<TestReadyToTake> findById(Long id);
}
