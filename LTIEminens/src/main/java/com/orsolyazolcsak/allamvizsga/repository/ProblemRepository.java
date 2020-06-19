package com.orsolyazolcsak.allamvizsga.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.orsolyazolcsak.allamvizsga.model.Problem;

@Repository
public interface ProblemRepository extends JpaRepository<Problem, Long> {
	List<Problem> findByDifficultyId(long difficultyId);
	List<Problem> findByTestId(long testId);
	Set<Problem> findProblemsByDifficultyIdAndTestId(Long difficultyId, Long testId);
}
