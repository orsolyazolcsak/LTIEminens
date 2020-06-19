package com.orsolyazolcsak.allamvizsga;

import com.orsolyazolcsak.allamvizsga.model.Problem;
import com.orsolyazolcsak.allamvizsga.service.DifficultyService;
import com.orsolyazolcsak.allamvizsga.service.ProblemService;
import com.orsolyazolcsak.allamvizsga.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Set;


@SpringBootApplication
public class Application implements CommandLineRunner {


    private final ProblemService problemService;
    private final DifficultyService difficultyService;
    private final TestService testService;

    @Autowired
    public Application(ProblemService problemService, DifficultyService difficultyService, TestService testService) {
        this.problemService = problemService;
        this.difficultyService = difficultyService;
        this.testService = testService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... arg0) throws Exception {

        List<String> problems = problemService.getAllProblemsByTest(1);
        for (String problem : problems) {
            System.out.println("Easy questions => " + problem);
        }
        List<String> difficulties = difficultyService.getAllDifficulties();
        for (String difficulty : difficulties) {
            System.out.println("Difficulty: " + difficulty);
        }
        //Set<Problem> problemSet =
    }
}
