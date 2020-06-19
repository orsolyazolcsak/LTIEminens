package com.orsolyazolcsak.allamvizsga.service;

import com.orsolyazolcsak.allamvizsga.model.Problem;
import com.orsolyazolcsak.allamvizsga.model.Test;
import com.orsolyazolcsak.allamvizsga.repository.TestRepository;
import oracle.jdbc.OracleTypeMetaData;
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
    public Set<Problem> getThreeProblemsOfGivenTestAndDifficulty(Long testId, Long difficultyId) {
        Set<Problem> problems = problemService.findProblemsByDifficultyIdAndTestId(testId, difficultyId);
        if (problems.size() > 3) {
            return getThreeProblems(problems.size(), problems);
        } else if (problems.size() == 3) {
            return problems;
        } else {
            return new HashSet<>();
        }

    }

    public Set<Problem> getThreeProblems(int length, Set<Problem> problemsSet) {
        ArrayList<Integer> indexes = generateThreeRandomIndexesOf(problemsSet.size());
        ArrayList<Problem> problems = new ArrayList<>(problemsSet);
        ArrayList<Problem> chosenProblems = new ArrayList<>();
        chosenProblems.add(problems.get(indexes.get(0)));
        chosenProblems.add(problems.get(indexes.get(1)));
        chosenProblems.add(problems.get(indexes.get(2)));
        return new HashSet<>(chosenProblems);
    }

    public ArrayList<Integer> generateThreeRandomIndexesOf(int problemsLength) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
        for (int i = 1; i < problemsLength; ++i) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
        for (int i = 0; i < 3; i++) {
            randomNumbers.add(new Integer(i));
        }
        return randomNumbers;
    }

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
