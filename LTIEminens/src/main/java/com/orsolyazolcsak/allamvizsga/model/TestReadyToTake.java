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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;


@Entity
public class TestReadyToTake {
	@Id
	@Column(name = "testReadyToTake_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "testReadyToTake_Sequence")
	@SequenceGenerator(name = "testReadyToTake_Sequence", sequenceName = "TESTREADYTOTAKE_SEQ")
    private Long id;
	
	@Column(name = "name")
	private String name;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id", nullable = false)
    private Test test;
	
	@OneToMany(cascade = CascadeType.ALL,
	            fetch = FetchType.EAGER,
	            mappedBy = "testReadyToTake")
		private List<UsedHelp> usedHelp;
	
	@OneToMany(cascade = CascadeType.ALL,
	            fetch = FetchType.EAGER,
	            mappedBy = "testReadyToTake")
	    private List<Answer> answer;
		
	@ManyToMany(mappedBy="testsReadyToTake")
	private Set<Problem> problems = new HashSet<Problem>();
	
	public TestReadyToTake() {
	}
	public String getName() {
		return name;
	}
	public Set<Problem> getProblems(){
		return problems;
	}
	public void setProblems(Set<Problem> problems){
		this.problems = problems;
	}
}