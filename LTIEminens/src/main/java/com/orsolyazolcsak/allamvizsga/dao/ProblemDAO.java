package com.orsolyazolcsak.allamvizsga.dao;

import com.orsolyazolcsak.allamvizsga.model.Difficulty;

import java.util.Collection;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProblemDAO that = (ProblemDAO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(question, that.question) &&
                Objects.equals(answers, that.answers) &&
                Objects.equals(difficulty, that.difficulty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, answers, difficulty);
    }

    @Override
    public String toString() {
        return "ProblemDAO{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answers=" + answers +
                ", difficulty=" + difficulty +
                '}';
    }
}
