package com.orsolyazolcsak.allamvizsga.service;

import com.orsolyazolcsak.allamvizsga.dao.ExamDAO;
import com.orsolyazolcsak.allamvizsga.model.Exam;

import java.util.Optional;
import java.util.Set;

public interface ExamService {
    Set<Exam> findAll();

    Optional<Exam> createNewExam(Long testId, String examName);

    Optional<Exam> findById(Long id);
    ExamDAO toDao(Exam exam);
}
