package com.orsolyazolcsak.allamvizsga.service;

import com.orsolyazolcsak.allamvizsga.model.Answer;
import com.orsolyazolcsak.allamvizsga.model.Problem;
import com.orsolyazolcsak.allamvizsga.model.User;
import com.orsolyazolcsak.allamvizsga.repository.HelpRepository;
import com.orsolyazolcsak.allamvizsga.repository.UsedHelpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class HelpServiceImpl implements HelpService {

    private final HelpRepository helpRepository;

    @Autowired
    public HelpServiceImpl(HelpRepository helpRepository) {
        this.helpRepository = helpRepository;
    }

    @Override
    public Set<String> fiftyFifty(Problem problem){
        Set<String> wrongAnswers = new HashSet<>();
        wrongAnswers.add(problem.getIncorrectAnswer1());
        wrongAnswers.add(problem.getIncorrectAnswer2());
        return wrongAnswers;
    }


}
