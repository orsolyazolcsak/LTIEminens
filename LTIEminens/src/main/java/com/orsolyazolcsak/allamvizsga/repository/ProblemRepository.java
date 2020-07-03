package com.orsolyazolcsak.allamvizsga.repository;

import com.orsolyazolcsak.allamvizsga.model.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ProblemRepository extends JpaRepository<Problem, Long> {
    List<Problem> findByDifficultyId(long difficultyId);

    List<Problem> findByTestId(long testId);

    Set<Problem> findProblemsByDifficultyIdAndTestId(Long difficultyId, Long testId);
}
