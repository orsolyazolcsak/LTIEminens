package com.orsolyazolcsak.allamvizsga.service;

import com.orsolyazolcsak.allamvizsga.dao.AnswerDAO;
import com.orsolyazolcsak.allamvizsga.dao.AskTheAudienceDAO;
import com.orsolyazolcsak.allamvizsga.model.Answer;
import com.orsolyazolcsak.allamvizsga.model.Exam;
import com.orsolyazolcsak.allamvizsga.model.Problem;
import com.orsolyazolcsak.allamvizsga.model.User;

import java.util.Optional;
import java.util.Set;

public interface AnswerService {
    Answer save(Answer answer);

    Answer toAnswer(AnswerDAO answerDAO);

    boolean existsByExamAndUserAndProblem(Exam exam, User user, Problem problem);

    boolean existsByAnswerDao(AnswerDAO answerDAO);

    Set<Answer> findByExamAndProblem(Exam exam, Problem problem);

    Set<Answer> findByExamAndProblemAndWatcher(Exam exam, Problem problem);

    Set<String> findWatchersWhoAnswered(Exam exam, Problem problem);

    AskTheAudienceDAO askTheAudience(Exam exam, Problem problem);

    Optional<String> phoneAFriend(Exam exam, Problem problem, User user);
}
