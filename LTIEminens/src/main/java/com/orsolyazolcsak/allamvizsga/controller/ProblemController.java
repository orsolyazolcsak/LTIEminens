package com.orsolyazolcsak.allamvizsga.controller;

import com.orsolyazolcsak.allamvizsga.model.Problem;
import com.orsolyazolcsak.allamvizsga.repository.ProblemRepository;
import com.orsolyazolcsak.allamvizsga.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/problem")
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    @GetMapping
    public Set<Problem> getTests() {
        return problemService.findAll();
    }

    @PostMapping
    Problem newProblem(@RequestBody Problem newProblem) {
        return problemService.createNewProblem(newProblem);
    }

    @GetMapping("/{id}")
    Optional<Problem> one(@PathVariable Long id) {

        return problemService.findById(id);
        //.orElseThrow(()-> new ProblemNotFoundException(id));
    }

    @DeleteMapping("/{id}")
    void deleteProblem(@PathVariable Long id) {
        problemService.deleteById(id);
    }
}
