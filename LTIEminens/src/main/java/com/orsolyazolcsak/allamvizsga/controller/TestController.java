package com.orsolyazolcsak.allamvizsga.controller;

import com.orsolyazolcsak.allamvizsga.dao.ExamDAO;
import com.orsolyazolcsak.allamvizsga.dao.ProblemDAO;
import com.orsolyazolcsak.allamvizsga.model.Exam;
import com.orsolyazolcsak.allamvizsga.model.Problem;
import com.orsolyazolcsak.allamvizsga.model.Test;
import com.orsolyazolcsak.allamvizsga.service.ExamService;
import com.orsolyazolcsak.allamvizsga.service.ProblemService;
import com.orsolyazolcsak.allamvizsga.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;
    @Autowired
    private ExamService examService;
    @Autowired
    private ProblemService problemService;


    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<Set<Test>> getTests() {
        Set<Test> tests = testService.findAll();
        System.out.println("tests from testController = " + tests);
        return new ResponseEntity<>(tests, HttpStatus.ACCEPTED);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/new/{id}")
    public ResponseEntity<ExamDAO> newExam(@PathVariable Long id) {
        System.out.println("etteg vok");
        Optional<Exam> exam = examService.createNewExam(id, "vizsga");
        if (exam.isPresent()) {
            System.out.println("exam is present" + exam);
            Exam exam1 = exam.get();
            ExamDAO examDAO = new ExamDAO();
            examDAO.setId(exam1.getId());
            examDAO.setName(exam1.getName());

            examDAO.setProblems(exam1.getProblems().stream()
                    .map(problemService::toDao)
                    .sorted()
                    .collect(Collectors.toList()));
            return new ResponseEntity<>(examDAO, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Test> newTest(@RequestBody Test newTest) {
        testService.createNewTest(newTest);
        return new ResponseEntity<Test>(newTest, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Optional<Test> getTest(@PathVariable("id") Long id) {
        return testService.findById(id);
    }

}
