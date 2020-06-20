package com.orsolyazolcsak.allamvizsga.dao;

import java.time.ZonedDateTime;
import java.util.List;

public class ExamDAO {
    private Long id;
    private String name;
    private List<ProblemDAO> problems;
    private ZonedDateTime startTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProblemDAO> getProblems() {
        return problems;
    }

    public void setProblems(List<ProblemDAO> problems) {
        this.problems = problems;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
    }
}
