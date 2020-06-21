package com.orsolyazolcsak.allamvizsga.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

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

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "problem")
    private List<UsedHelp> usedHelp;

    @ManyToOne(fetch = FetchType.EAGER)
    private Difficulty difficulty;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "problem")
    private List<Answer> answer;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id", nullable = false)
    private Test test;


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

    public List<UsedHelp> getUsedHelp() {
        return usedHelp;
    }

    public void setUsedHelp(List<UsedHelp> usedHelp) {
        this.usedHelp = usedHelp;
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


	@ManyToMany(mappedBy = "problems")
	private Collection<Exam> exams;

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
				", usedHelp=" + usedHelp +
				", difficulty=" + difficulty +
				", answer=" + answer +
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