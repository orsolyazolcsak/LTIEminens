package com.orsolyazolcsak.allamvizsga.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Answer {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "answer_Sequence")
    @SequenceGenerator(name = "answer_Sequence", sequenceName = "ANSWER_SEQ")
    private Long id;
	
	@Column(name = "answer_is_correct")
	private boolean answerIsCorrect;
	
	@OneToMany(cascade = CascadeType.ALL,
	            fetch = FetchType.EAGER,
	            mappedBy = "answer")
	    private List<UsedHelp> usedHelp;
	 
	@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "user_id", nullable = false)
		private User user;
		
	@ManyToOne(fetch = FetchType.LAZY)
    	@JoinColumn(name = "problem_id", nullable = false)
		private Problem problem;
		
	@ManyToOne(fetch = FetchType.LAZY)
    	@JoinColumn(name = "test_ready_to_take_id", nullable = false)
		private TestReadyToTake testReadyToTake;
		
		
	public Answer() {
		 
	}
	 
	public boolean getAnswerIsCorrect() {
		return answerIsCorrect;
	}
}