package com.orsolyazolcsak.allamvizsga.service;

import com.orsolyazolcsak.allamvizsga.dao.AnswerDAO;
import com.orsolyazolcsak.allamvizsga.dao.ProblemDAO;
import com.orsolyazolcsak.allamvizsga.model.Answer;
import com.orsolyazolcsak.allamvizsga.model.Exam;
import com.orsolyazolcsak.allamvizsga.model.Problem;
import com.orsolyazolcsak.allamvizsga.model.User;

public interface AnswerService {
    Answer save(Answer answer);
    Answer toAnswer(AnswerDAO answerDAO);
    boolean existsByExamAndUserAndProblem(Exam exam, User user, Problem problem);
    boolean existsByAnswerDao(AnswerDAO answerDAO);
}
