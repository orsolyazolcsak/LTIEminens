package com.orsolyazolcsak.allamvizsga.controller;

import com.orsolyazolcsak.allamvizsga.model.Test;
import com.orsolyazolcsak.allamvizsga.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<Set<Test>> getTests() {
        Set<Test> tests;
        tests = testService.findAll();
        return new ResponseEntity<>(tests, HttpStatus.ACCEPTED);
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
