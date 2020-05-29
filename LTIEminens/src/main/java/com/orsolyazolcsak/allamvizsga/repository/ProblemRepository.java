package com.orsolyazolcsak.allamvizsga.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.orsolyazolcsak.allamvizsga.model.Problem;

@Repository
public interface ProblemRepository extends CrudRepository<Problem, Long> {

	List<Problem> findAll();
	Problem findById(long id);
	void deleteById(long id);
	List<Problem> findByDifficultyId(long difficultyId);
	List<Problem> findByTestId(long testId);
	
}
