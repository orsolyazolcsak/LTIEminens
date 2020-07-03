package com.orsolyazolcsak.allamvizsga.util;

import com.orsolyazolcsak.allamvizsga.model.Difficulty;
import com.orsolyazolcsak.allamvizsga.model.Problem;
import com.orsolyazolcsak.allamvizsga.model.Test;
import com.orsolyazolcsak.allamvizsga.service.DifficultyService;
import com.orsolyazolcsak.allamvizsga.service.ProblemService;
import com.orsolyazolcsak.allamvizsga.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

@Service
public class ReadFile {

    private final DifficultyService difficultyService;
    private final TestService testService;
    private final ProblemService problemService;

    @Autowired
    public ReadFile(DifficultyService difficultyService, TestService testService, ProblemService problemService) {
        this.difficultyService = difficultyService;
        this.testService = testService;
        this.problemService = problemService;
        readTestsFromFile("c://eminens/tests.txt");
    }

    public static void main(String args[]) throws Exception {
//        readFile.readTestsFromFile("c://eminens/tests.txt");
      /*  Path test_data = Paths.get(ReadFile.class.getResource("tests.txt").toURI());
        Stream<Path> list = Files.list(test_data);
        System.out.println(Arrays.toString(list.toArray()));*/

    }

    void readTestsFromFile(String fileName) {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            String[] content = stream.toArray(String[]::new);
            Test test = createNewTest(content[0]);

            for (int i = 1; i < content.length; ++i) {
                convertALineToProblem(content[i], test);
            }
            System.out.println("A file kiolvasása sikeres volt.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Test createNewTest(String testName) {
        Test test = new Test();
        test.setName(testName);
        return testService.createNewTest(test);
    }

    Problem convertALineToProblem(String line, Test test) {
        String[] strings;
        strings = line.split("\t");
        Problem problem = new Problem();
        problem.setDifficulty(stringToDifficulty(strings[0]));
        problem.setQuestion(strings[1]);
        problem.setCorrectAnswer(strings[2]);
        problem.setIncorrectAnswer1(strings[3]);
        problem.setIncorrectAnswer2(strings[4]);
        problem.setIncorrectAnswer3(strings[5]);
        problem.setTest(test);
        return problemService.createNewProblem(problem);
    }

    // E = 1 = Easy; M = 2 = Medium; H = 3 = Hard
    Difficulty stringToDifficulty(String difficultyString) {
        Difficulty difficulty = new Difficulty();
        if (difficultyString.equals("E")) {
            difficulty = difficultyService.findById(1L).get();
        } else if (difficultyString.equals("M")) {
            difficulty = difficultyService.findById(2L).get();
        } else if (difficultyString.equals("H")) {
            difficulty = difficultyService.findById(3L).get();
        }
        return difficulty;
    }

}
