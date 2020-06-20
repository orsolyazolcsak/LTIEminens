package com.orsolyazolcsak.allamvizsga.dao;

import com.orsolyazolcsak.allamvizsga.model.Difficulty;

import java.util.Collection;

public class ProblemDAO implements Comparable<ProblemDAO> {
    private Long id;
    private String question;
    private Collection<String> answers;
    private Difficulty difficulty;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Collection<String> getAnswers() {
        return answers;
    }

    public void setAnswers(Collection<String> answers) {
        this.answers = answers;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public int compareTo(ProblemDAO o) {
        return difficulty.compareTo(o.difficulty);
    }
}
