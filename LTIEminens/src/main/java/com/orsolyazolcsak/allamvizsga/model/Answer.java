package com.orsolyazolcsak.allamvizsga.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "answer_Sequence")
    @SequenceGenerator(name = "answer_Sequence", sequenceName = "ANSWER_SEQ")
    private Long id;

    @Column(name = "answer_is_correct")
    private boolean answerIsCorrect;

    @Column(name = "answer")
    private String answer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "problem_id", nullable = false)
    private Problem problem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;


    public Answer() {

    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAnswerIsCorrect() {
        return answerIsCorrect;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public boolean getAnswerIsCorrect() {
        return answerIsCorrect;
    }

    public void setAnswerIsCorrect(boolean answerIsCorrect) {
        this.answerIsCorrect = answerIsCorrect;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", answerIsCorrect=" + answerIsCorrect +
                ", user=" + user +
                ", problem=" + problem +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer1 = (Answer) o;
        return answerIsCorrect == answer1.answerIsCorrect &&
                Objects.equals(id, answer1.id) &&
                Objects.equals(answer, answer1.answer) &&
                Objects.equals(user, answer1.user) &&
                Objects.equals(problem, answer1.problem) &&
                Objects.equals(exam, answer1.exam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, answerIsCorrect, answer, user, problem, exam);
    }
}