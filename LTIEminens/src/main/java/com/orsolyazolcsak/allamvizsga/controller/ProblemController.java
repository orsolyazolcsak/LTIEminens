package com.orsolyazolcsak.allamvizsga.controller;

import com.orsolyazolcsak.allamvizsga.model.Problem;
import com.orsolyazolcsak.allamvizsga.repository.ProblemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProblemController {

    private final ProblemRepository repository;

    ProblemController(ProblemRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/problem")
    List<Problem> all() {
        return repository.findAll();
    }

    @PostMapping("/problem")
    Problem newProblem(@RequestBody Problem newProblem) {
        return repository.save(newProblem);
    }

    @GetMapping("/problem/{id}")
    Problem one(@PathVariable Long id) {

        return repository.findById(id);
        //.orElseThrow(()-> new ProblemNotFoundException(id));
    }

    @DeleteMapping("/problem/{id}")
    void deleteProblem(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
