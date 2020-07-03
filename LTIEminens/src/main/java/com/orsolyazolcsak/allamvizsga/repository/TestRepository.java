package com.orsolyazolcsak.allamvizsga.repository;

import com.orsolyazolcsak.allamvizsga.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

    Optional<Test> findByName(String testName);
}
