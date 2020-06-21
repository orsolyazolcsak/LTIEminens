package com.orsolyazolcsak.allamvizsga.model;

import com.orsolyazolcsak.allamvizsga.controller.ExamController;

import java.time.ZonedDateTime;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class StartedExam {
    private Exam exam;
    private ZonedDateTime startTime;
    private Problem currentQuestion;
    private Iterator<Problem> problemIterator;

    public StartedExam(Exam exam, ZonedDateTime startTime) {
        this.exam = exam;
        this.startTime = startTime;
        this.problemIterator = new TreeSet<>(exam.getProblems()).iterator();
        scheduleQuestions();
    }

    private void scheduleQuestions() {
        try {
            ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
            scheduledExecutorService.scheduleAtFixedRate(() -> {
                if (problemIterator.hasNext()) {
                    setCurrentQuestion(problemIterator.next());
                } else {
                    setCurrentQuestion(null);
                    scheduledExecutorService.shutdown();
                }
            }, 0, ExamController.DURATION_OF_QUESTION, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("Exception during scheduled currentQuestionChange");
            e.printStackTrace();
            System.out.println(Arrays.toString(e.getSuppressed()));
        }
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
    }

    public Optional<Problem> getCurrentQuestion() {
        return Optional.ofNullable(currentQuestion);
    }

    public void setCurrentQuestion(Problem currentQuestion) {
        System.out.println("setting currentQuestion for exam " + exam.getId() + " = " + currentQuestion);
        this.currentQuestion = currentQuestion;
    }

    @Override
    public String toString() {
        return "StartedExam{" +
                "exam=" + exam +
                ", startTime=" + startTime +
                ", currentQuestion=" + currentQuestion +
                '}';
    }
}
