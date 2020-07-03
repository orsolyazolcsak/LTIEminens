package com.orsolyazolcsak.allamvizsga.service;

import com.orsolyazolcsak.allamvizsga.dao.ExamDAO;
import com.orsolyazolcsak.allamvizsga.model.Exam;
import com.orsolyazolcsak.allamvizsga.model.Test;
import com.orsolyazolcsak.allamvizsga.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ExamServiceImpl implements ExamService {

    private final ExamRepository examRepository;
    private final TestService testService;
    private final ProblemService problemService;

    @Autowired
    public ExamServiceImpl(ExamRepository examRepository, TestService testService, ProblemService problemService) {
        this.examRepository = examRepository;
        this.testService = testService;
        this.problemService = problemService;
    }

    @Override
    public Optional<Exam> createNewExam(Long testId, String examName) {
        Exam exam = new Exam();
        exam.setProblems(testService.composeTestWithRandomizedProblems(testId));
        exam.setName(examName);
        Optional<Test> test = testService.findById(testId);
        if (test.isPresent()) {
            exam.setTest(test.get());
            return Optional.of(examRepository.save(exam));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Set<Exam> findAll() {
        return new HashSet<>(examRepository.findAll());
    }


    @Override
    public Optional<Exam> findById(Long id) {
        return examRepository.findById(id);
    }

    @Override
    public ExamDAO toDao(Exam exam) {
        ExamDAO dao = new ExamDAO();
        dao.setId(exam.getId());
        dao.setName(exam.getName());
        dao.setProblems(exam.getProblems().stream().map(problemService::toDao).collect(Collectors.toList()));
        return dao;
    }
}
