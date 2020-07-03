package com.orsolyazolcsak.allamvizsga.service;

import com.orsolyazolcsak.allamvizsga.model.Difficulty;
import com.orsolyazolcsak.allamvizsga.repository.DifficultyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DifficultyServiceImpl implements DifficultyService {

    private final DifficultyRepository difficultyRepository;

    public DifficultyServiceImpl(DifficultyRepository difficultyRepository) {
        this.difficultyRepository = difficultyRepository;
    }


    public Optional<Difficulty> findById(Long id) {
        return difficultyRepository.findById(id);
    }

    public List<String> getAllDifficulties() {
        List<String> result = new ArrayList<String>();
        Iterable<Difficulty> difficulties = difficultyRepository.findAll();
        for (Difficulty difficulty : difficulties) {
            result.add(difficulty.getName());
        }
        return result;
    }
}
