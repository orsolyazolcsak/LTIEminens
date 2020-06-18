package com.orsolyazolcsak.allamvizsga.model;

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
public class Problem {
	@Id
	@Column(name = "problem_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "problem_Sequence")
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
	            fetch = FetchType.LAZY,
	            mappedBy = "problem")
		private List<UsedHelp> usedHelp;
		
	@ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "difficulty_id", nullable = false)
	    private Difficulty difficulty;
	
	@OneToMany(cascade = CascadeType.ALL,
	            fetch = FetchType.LAZY,
	            mappedBy = "problem")
	    private List<Answer> answer;
		
	@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "test_id", nullable = false)
		private Test test;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(
			name="Test_ready_to_take_Problem",
			joinColumns = { @JoinColumn(name = "problem_id")},
			inverseJoinColumns = {@JoinColumn(name = "test_ready_to_take_id")}
	)
	Set<TestReadyToTake> testsReadyToTake = new HashSet<>();
	
	public Problem() {
		
	}
	//getters/setters

	public Long getId() {
		return id;
	}
	public String getQuestion() {
		return question;
	}
	
	
}