package com.orsolyazolcsak.allamvizsga.dao;

import java.util.Map;

public class AskTheAudienceDAO {
    Map<String, Long> audienceAnswers;

    public AskTheAudienceDAO(Map<String, Long> audienceAnswers) {
        this.audienceAnswers = audienceAnswers;
    }

    public Map<String, Long> getAudienceAnswers() {
        return audienceAnswers;
    }

    public void setAudienceAnswers(Map<String, Long> audienceAnswers) {
        this.audienceAnswers = audienceAnswers;
    }
}
