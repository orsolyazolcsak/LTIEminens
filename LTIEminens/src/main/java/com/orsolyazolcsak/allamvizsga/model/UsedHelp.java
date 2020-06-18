package com.orsolyazolcsak.allamvizsga.model;


import javax.persistence.*;

@Entity
@Table(name="used_help")
public class UsedHelp {
	@Id
	@Column(name = "used_help_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "usedHelp_Sequence")
	@SequenceGenerator(name = "usedHelp_Sequence", sequenceName = "USEDHELP_SEQ")
    private Long id;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "help_id", nullable = false)
		private Help help;
	
	@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "test_ready_to_take_id", nullable = false)
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Help getHelp() {
		return help;
	}

	public void setHelp(Help help) {
		this.help = help;
	}

	public TestReadyToTake getTestReadyToTake() {
		return testReadyToTake;
	}

	public void setTestReadyToTake(TestReadyToTake testReadyToTake) {
		this.testReadyToTake = testReadyToTake;
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

	public Problem getAnswer() {
		return answer;
	}

	public void setAnswer(Problem answer) {
		this.answer = answer;
	}
}