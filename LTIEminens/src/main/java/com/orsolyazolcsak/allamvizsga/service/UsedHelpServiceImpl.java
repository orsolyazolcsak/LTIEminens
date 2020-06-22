package com.orsolyazolcsak.allamvizsga.service;

import com.orsolyazolcsak.allamvizsga.model.Exam;
import com.orsolyazolcsak.allamvizsga.model.Help;
import com.orsolyazolcsak.allamvizsga.model.UsedHelp;
import com.orsolyazolcsak.allamvizsga.model.User;
import com.orsolyazolcsak.allamvizsga.repository.UsedHelpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsedHelpServiceImpl implements UsedHelpService {

    private final UsedHelpRepository usedHelpRepository;

    @Autowired
    public UsedHelpServiceImpl(UsedHelpRepository usedHelpRepository) {
        this.usedHelpRepository = usedHelpRepository;
    }

    @Override
    public Optional<UsedHelp> findByExamAndUserAndHelp(Exam exam, User user, Help help) {
        return usedHelpRepository.findByExamAndUserAndHelp(exam, user, help);
    }
}
