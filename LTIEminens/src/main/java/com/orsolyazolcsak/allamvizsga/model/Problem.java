package com.orsolyazolcsak.allamvizsga.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Problem implements Comparable<Problem> {
    @Id
    @Column(name = "problem_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "problem_Sequence")
    @SequenceGenerator(name = "problem_Sequence", sequenceName = "PROBLEM_SEQ")
    private Long id;

    @Column(name = "question")
    private String question;

    @Column(name = "correct_answer")
    private String correctAnswer;

    @Column(name = "incorrect_answer1")
    private String incorrectAnswer1;

    @Column(name = "incorrect_answer2")
    private String incorrectAnswer2;

    @Column(name = "incorrect_answer3")
    private String incorrectAnswer3;

    @ManyToOne(fetch = FetchType.EAGER)
    private Difficulty difficulty;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "problem")
    private List<Answer> answer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id", nullable = false)
    private Test test;
    @ManyToMany(mappedBy = "problems")
    private Collection<Exam> exams;

    public Problem() {

    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getIncorrectAnswer1() {
        return incorrectAnswer1;
    }

    public void setIncorrectAnswer1(String incorrectAnswer1) {
        this.incorrectAnswer1 = incorrectAnswer1;
    }

    public String getIncorrectAnswer2() {
        return incorrectAnswer2;
    }

    public void setIncorrectAnswer2(String incorrectAnswer2) {
        this.incorrectAnswer2 = incorrectAnswer2;
    }

    public String getIncorrectAnswer3() {
        return incorrectAnswer3;
    }

    public void setIncorrectAnswer3(String incorrectAnswer3) {
        this.incorrectAnswer3 = incorrectAnswer3;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public List<Answer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Answer> answer) {
        this.answer = answer;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

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

    public Collection<Exam> getExams() {
        return exams;
    }

    public void setExams(Collection<Exam> exams) {
        this.exams = exams;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", incorrectAnswer1='" + incorrectAnswer1 + '\'' +
                ", incorrectAnswer2='" + incorrectAnswer2 + '\'' +
                ", incorrectAnswer3='" + incorrectAnswer3 + '\'' +

                ", difficulty=" + difficulty +
                ", test=" + test +
                '}';
    }

    @Override
    public int compareTo(Problem o) {
        int difficultyCompared = difficulty.compareTo(o.difficulty);
        if (difficultyCompared == 0) {
            return id.compareTo(o.id);
        }
        return difficultyCompared;
    }
}