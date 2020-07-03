package com.orsolyazolcsak.allamvizsga.repository;

import com.orsolyazolcsak.allamvizsga.model.Answer;
import com.orsolyazolcsak.allamvizsga.model.Exam;
import com.orsolyazolcsak.allamvizsga.model.Problem;
import com.orsolyazolcsak.allamvizsga.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    boolean existsByExamAndUserAndProblem(Exam exam, User user, Problem problem);

    Set<Answer> findByExamAndProblem(Exam exam, Problem problem);

    Optional<Answer> findByExamAndProblemAndUser(Exam exam, Problem problem, User user);
}
