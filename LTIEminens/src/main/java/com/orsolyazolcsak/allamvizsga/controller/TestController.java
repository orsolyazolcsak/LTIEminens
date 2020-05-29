package com.orsolyazolcsak.allamvizsga.controller;

import com.orsolyazolcsak.allamvizsga.model.Test;
import com.orsolyazolcsak.allamvizsga.repository.TestRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {

    private final TestRepository repository;

    TestController(TestRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/test")
    List<Test> all() {
        return repository.findAll();
    }
/*
    @PostMapping("/test")
    Test newTest(@RequestBody Test newTest) {
        return repository.save(newTest);
    }
*/
    @PostMapping("/test")
    public ResponseEntity<Test> newTest(@RequestBody Test newTest) {
        repository.save(newTest);
        return new ResponseEntity<Test>(newTest, HttpStatus.CREATED);
    }
    @GetMapping("/test/{id}")
    Test one(@PathVariable Long id) {

        return repository.findById(id);
                //.orElseThrow(()-> new TestNotFoundException(id));
    }

    @DeleteMapping("/test/{id}")
    void deleteTest(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
