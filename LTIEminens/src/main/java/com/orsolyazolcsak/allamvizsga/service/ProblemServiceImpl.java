package com.orsolyazolcsak.allamvizsga.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orsolyazolcsak.allamvizsga.model.Problem;
import com.orsolyazolcsak.allamvizsga.repository.ProblemRepository;

@Service
public class ProblemServiceImpl implements ProblemService{

	@Autowired
	private ProblemRepository problemRepository;
	
	public List<String> getAllProblemsByTest(long testId ){
		List<String> result = new ArrayList<String>();
		List<Problem> problems = problemRepository.findByTestId(testId);
		for (Problem problem: problems) {
			result.add(problem.getQuestion());
		}
		return result;
	}
	
	public List<String> getAllProblemsByDifficulty(long difficultyId) {
		List<String> result = new ArrayList<String>();
        List<Problem> problems = problemRepository.findByDifficultyId(difficultyId);
        for (Problem problem : problems) {
            result.add(problem.getQuestion());
        }
        return result;
	}
}
