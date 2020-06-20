package com.orsolyazolcsak.allamvizsga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orsolyazolcsak.allamvizsga.model.Difficulty;

@Repository
public interface DifficultyRepository extends JpaRepository<Difficulty, Long> {
	
	//Iterable<Difficulty> findAll();

}