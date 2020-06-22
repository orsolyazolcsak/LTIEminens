package com.orsolyazolcsak.allamvizsga.service;

import com.orsolyazolcsak.allamvizsga.repository.HelpRepository;
import com.orsolyazolcsak.allamvizsga.repository.UsedHelpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelpServiceImpl implements HelpService {

    private final HelpRepository helpRepository;

    @Autowired
    public HelpServiceImpl(HelpRepository helpRepository) {
        this.helpRepository = helpRepository;
    }
}
