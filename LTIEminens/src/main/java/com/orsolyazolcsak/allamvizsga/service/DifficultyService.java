package com.orsolyazolcsak.allamvizsga.service;

import com.orsolyazolcsak.allamvizsga.model.Difficulty;

import java.util.List;
import java.util.Optional;

public interface DifficultyService {
	public List<String> getAllDifficulties();
	public Optional<Difficulty> findById(Long id);
}