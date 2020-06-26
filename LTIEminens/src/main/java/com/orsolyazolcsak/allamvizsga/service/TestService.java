package com.orsolyazolcsak.allamvizsga.service;

import com.orsolyazolcsak.allamvizsga.model.Problem;
import com.orsolyazolcsak.allamvizsga.model.Test;

import java.util.Optional;
import java.util.Set;

public interface TestService {
    Set<Test> findAll();

    void createNewTest(Test newTest);

    Optional<Test> findById(Long id);

    public Set<Problem> composeTestWithRandomizedProblems(Long testId);
}
