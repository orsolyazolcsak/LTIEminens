package com.orsolyazolcsak.allamvizsga.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orsolyazolcsak.allamvizsga.model.Problem;
import com.orsolyazolcsak.allamvizsga.repository.ProblemRepository;

@Service
public class ProblemServiceImpl implements ProblemService {

    private final ProblemRepository repository;

    @Autowired
    public ProblemServiceImpl(ProblemRepository repository) {
        this.repository = repository;
    }

    @Override
    public Set<Problem> findProblemsByDifficultyIdAndTestId(Long difficultyId, Long testId) {
        return repository.findProblemsByDifficultyIdAndTestId(difficultyId, testId);
    }

    @Override
    public Set<Problem> findAll() {
        return new HashSet<>(repository.findAll());
    }

    @Override
    public Problem createNewProblem(Problem newProblem) {
        repository.save(newProblem);
        return newProblem;
    }

    @Override
    public Optional<Problem> findById(Long id) {
        return repository.findById(id);
    }


    public List<String> getAllProblemsByTest(long testId) {
        List<String> result = new ArrayList<String>();
        List<Problem> problems = repository.findByTestId(testId);
        for (Problem problem : problems) {
            result.add(problem.getQuestion());
        }
        return result;
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    public List<String> getAllProblemsByDifficulty(long difficultyId) {
        List<String> result = new ArrayList<String>();
        List<Problem> problems = repository.findByDifficultyId(difficultyId);
        for (Problem problem : problems) {
            result.add(problem.getQuestion());
        }
        return result;
    }
}
