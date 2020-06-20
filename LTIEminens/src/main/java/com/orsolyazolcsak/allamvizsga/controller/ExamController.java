package com.orsolyazolcsak.allamvizsga.controller;

import com.orsolyazolcsak.allamvizsga.dao.ExamDAO;
import com.orsolyazolcsak.allamvizsga.model.Exam;
import com.orsolyazolcsak.allamvizsga.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExamService examService;
    private Map<Exam, ZonedDateTime> startedExams;

    @Autowired
    public ExamController(ExamService examService) {
        this.examService = examService;
        startedExams = new HashMap<>();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/start/{id}")
    public ResponseEntity<ExamDAO> startExam(@PathVariable Long id) {
        Optional<Exam> examOptional = examService.findById(id);
        if (examOptional.isPresent()) {
            Exam exam = examOptional.get();
            if (exam.getProblems().size() == 9 && !startedExams.containsKey(exam)) {
                ZonedDateTime startTime = ZonedDateTime.now();
                startedExams.put(exam, startTime);
                ExamDAO examDao = examService.toDao(exam);
                examDao.setStartTime(startTime);
                return new ResponseEntity<>(examDao, HttpStatus.OK);
            } else {
                System.out.println(exam.getProblems().size() < 9 ? "Exam doesn't have questions " : "" + (startedExams.containsKey(exam) ? "Exam is already started" : ""));
            }
        } else {
            System.out.println("Exam not found by examService, can't be started");
        }
        return new ResponseEntity<>(new ExamDAO(), HttpStatus.OK);
    }


}
