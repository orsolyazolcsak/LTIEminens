package com.orsolyazolcsak.allamvizsga.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "test_ready_to_take")
public class TestReadyToTake {
    @Id
    @Column(name = "test_ready_to_take_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "testReadyToTake_Sequence")
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
            fetch = FetchType.LAZY,
            mappedBy = "testReadyToTake")
    private List<Answer> answer;

    @ManyToMany(mappedBy = "testsReadyToTake")
    private Set<Problem> problems = new HashSet<Problem>();

    public TestReadyToTake() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public List<UsedHelp> getUsedHelp() {
        return usedHelp;
    }

    public void setUsedHelp(List<UsedHelp> usedHelp) {
        this.usedHelp = usedHelp;
    }

    public List<Answer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Answer> answer) {
        this.answer = answer;
    }

    public Set<Problem> getProblems() {
        return problems;
    }

    public void setProblems(Set<Problem> problems) {
        this.problems = problems;
    }
}