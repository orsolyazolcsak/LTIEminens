package com.orsolyazolcsak.allamvizsga.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.orsolyazolcsak.allamvizsga.model.Difficulty;
import com.orsolyazolcsak.allamvizsga.repository.DifficultyRepository;

@Service
public class DifficultyServiceImpl implements DifficultyService {
	
	@Autowired
	private DifficultyRepository difficultyRepository;
	
	public List<String> getAllDifficulties()
	{
		List<String> result = new ArrayList<String>();
		Iterable<Difficulty> difficulties = difficultyRepository.findAll();
		for (Difficulty difficulty : difficulties) {
            result.add(difficulty.getName());
        }
		return result;
	}
}
