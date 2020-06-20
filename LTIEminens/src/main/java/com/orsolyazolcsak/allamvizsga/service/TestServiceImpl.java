package com.orsolyazolcsak.allamvizsga.service;

import com.orsolyazolcsak.allamvizsga.model.Problem;
import com.orsolyazolcsak.allamvizsga.model.Test;
import com.orsolyazolcsak.allamvizsga.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TestServiceImpl implements TestService {

    private final TestRepository repository;
    private final ProblemService problemService;

    @Autowired
    public TestServiceImpl(TestRepository repository, ProblemService problemService) {
        this.repository = repository;
        this.problemService = problemService;
    }

    @Override
    public Set<Problem> getYourProblemsTogether(Long testId){
        Set<Problem> problems = new TreeSet<>();
        problems.addAll(getThreeProblemsOfGivenTestAndDifficulty(testId, (long) 1));
        problems.addAll(getThreeProblemsOfGivenTestAndDifficulty(testId, (long) 2));
        problems.addAll(getThreeProblemsOfGivenTestAndDifficulty(testId, (long) 3));
        if (problems.size() < 9) {
            problems.clear();
        }
        return problems;
    }

    public Set<Problem> getThreeProblemsOfGivenTestAndDifficulty(Long testId, Long difficultyId) {
        Set<Problem> problems = problemService.findProblemsByDifficultyIdAndTestId(difficultyId, testId);
        if (problems.size() > 3) {
            return getThreeProblems(problems.size(), problems);
        } else if (problems.size() == 3) {
            return problems;
        } else {
            return new HashSet<>();
        }

    }

    public Set<Problem> getThreeProblems(int length, Set<Problem> problemsSet) {
        Iterator<Integer> indexes = generateThreeInts(problemsSet.size()).iterator();
        ArrayList<Problem> problems = new ArrayList<>(problemsSet);
        ArrayList<Problem> chosenProblems = new ArrayList<>();
        chosenProblems.add(problems.get(indexes.next()));
        chosenProblems.add(problems.get(indexes.next()));
        chosenProblems.add(problems.get(indexes.next()));
        return new HashSet<>(chosenProblems);
    }

    public Set<Integer> generateThreeInts(int problemsLength) {
        Set<Integer> indexes = new HashSet<>();
        Random random = new Random();
        while (indexes.size() < 3)
            indexes.add(random.nextInt(problemsLength));
        return indexes;
    }

    @Override
    public Set<Test> findAll() {
        List<Test> allTests = repository.findAll();
        System.out.println("allTests = " + allTests);
        return new TreeSet<>(allTests);
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
