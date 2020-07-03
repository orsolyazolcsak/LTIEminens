package com.orsolyazolcsak.allamvizsga.repository;

import com.orsolyazolcsak.allamvizsga.model.Difficulty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DifficultyRepository extends JpaRepository<Difficulty, Long> {
    Optional<Difficulty> findById(Long id);
}