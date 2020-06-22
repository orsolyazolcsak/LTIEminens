package com.orsolyazolcsak.allamvizsga.repository;

import com.orsolyazolcsak.allamvizsga.model.Exam;
import com.orsolyazolcsak.allamvizsga.model.Help;
import com.orsolyazolcsak.allamvizsga.model.UsedHelp;
import com.orsolyazolcsak.allamvizsga.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsedHelpRepository extends JpaRepository<UsedHelp, Long> {
    Optional<UsedHelp> findByExamAndUserAndHelp(Exam exam, User user, Help help);
}
