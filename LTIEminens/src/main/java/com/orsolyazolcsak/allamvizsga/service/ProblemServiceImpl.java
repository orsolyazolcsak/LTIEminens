package com.orsolyazolcsak.allamvizsga.service;

import java.util.*;

import com.orsolyazolcsak.allamvizsga.dao.ProblemDAO;
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
    public ProblemDAO toDao(Problem problem) {
        ProblemDAO p = new ProblemDAO();
        p.setId(problem.getId());
        p.setDifficulty(problem.getDifficulty());
        p.setQuestion(problem.getQuestion());
        // HashSet-be wrappeljuk hogy ne rendezetten kuldjuk a valaszokat(mindig az elso lenne a helyes a responseban)
        p.setAnswers(new HashSet<>(Arrays.asList(problem.getCorrectAnswer(), problem.getIncorrectAnswer1(), problem.getIncorrectAnswer2(), problem.getIncorrectAnswer3())));
        return p;
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
