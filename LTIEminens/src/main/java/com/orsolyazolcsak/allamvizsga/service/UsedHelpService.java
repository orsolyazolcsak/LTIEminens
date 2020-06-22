package com.orsolyazolcsak.allamvizsga.service;

import com.orsolyazolcsak.allamvizsga.model.Exam;
import com.orsolyazolcsak.allamvizsga.model.Help;
import com.orsolyazolcsak.allamvizsga.model.UsedHelp;
import com.orsolyazolcsak.allamvizsga.model.User;

import java.util.Optional;

public interface UsedHelpService {
    Optional<UsedHelp> findByExamAndUserAndHelp(Exam exam, User user, Help help);
}
