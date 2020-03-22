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
public class UsedHelp {
	@Id
	@Column(name = "usedHelp_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "usedHelp_Sequence")
	@SequenceGenerator(name = "usedHelp_Sequence", sequenceName = "USEDHELP_SEQ")
    private Long id;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "help_id", nullable = false)
		private Help help;
	
	@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "testReadyToTake_id", nullable = false)
		private TestReadyToTake testReadyToTake;
		
	@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "user_id", nullable = false)
		private User user;
		
	@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "problem_id", nullable = false)
		private Problem problem;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "answer_id", nullable = false)
	private Problem answer;
		
		
	public UsedHelp() {
		
	}
	//getters/setters

	public Long getId() {
		return id;
	}
	
	
	
}