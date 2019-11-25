package com.orsolyazolcsak.allamvizsga.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.orsolyazolcsak.allamvizsga.model.Difficulty;

@Repository
public interface DifficultyRepository extends CrudRepository<Difficulty, Long>{
	
	Difficulty findByProblem(long problemId);

}