package com.orsolyazolcsak.allamvizsga.service;

import java.util.List;

public interface ProblemService {
	public List<String> getAllProblemsByDifficulty(long difficultyId);
	public List<String> getAllProblemsByTest(long testId);
}
