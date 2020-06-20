package com.orsolyazolcsak.allamvizsga.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "exam")
public class Exam {
    @Id
    @Column(name = "exam_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exam_Sequence")
    @SequenceGenerator(name = "exam_Sequence", sequenceName = "EXAM_SEQ")
    private Long id;

    @Column(name = "name")
    private String name;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "test_id", nullable = false)
    private Test test;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "exam")
    private List<UsedHelp> usedHelp;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "exam")
    private List<Answer> answer;

    @ManyToMany
    private Set<Problem> problems = new HashSet<Problem>();

    public Exam() {
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

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", test=" + test +
                ", usedHelp=" + usedHelp +
                ", answer=" + answer +
                ", problems=" + problems +
                '}';
    }
}