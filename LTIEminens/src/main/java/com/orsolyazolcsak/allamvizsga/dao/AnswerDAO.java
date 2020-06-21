package com.orsolyazolcsak.allamvizsga.dao;

public class AnswerDAO {
    private Long examId;
    private String user;
    private Long problemId;
    private String answer;
    private boolean correct;

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Long getProblemId() {
        return problemId;
    }

    public void setProblemId(Long problemId) {
        this.problemId = problemId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "AnswerDAO{" +
                "examId=" + examId +
                ", user='" + user + '\'' +
                ", problemId=" + problemId +
                ", answer='" + answer + '\'' +
                '}';
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public boolean getCorrect() {
        return correct;
    }
}
