package com.orsolyazolcsak.allamvizsga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Problem {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "problem_Sequence")
	@SequenceGenerator(name = "problem_Sequence", sequenceName = "PROBLEM_SEQ")
    private Long id;
	
	@Column(name = "question")
	private String question;
	
	@Column(name = "correctAnswer")
	private String correctAnswer;
	
	@Column(name = "incorrectAnswer1")
	private String incorrectAnswer1;
	
	@Column(name = "incorrectAnswer2")
	private String incorrectAnswer2;
	
	@Column(name = "incorrectAnswer3")
	private String incorrectAnswer3;
	
	@ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "difficulty_id", nullable = false)
	    private Difficulty difficulty;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id", nullable = false)
    private Test test;
	
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