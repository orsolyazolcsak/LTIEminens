package com.orsolyazolcsak.allamvizsga.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Test implements Comparable<Test> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_Sequence")
    @SequenceGenerator(name = "test_Sequence", sequenceName = "TEST_SEQ")
    private Long id;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "test")
    private List<Problem> problems;

    public Test() {

    }

    public Test(String name) {
        this.name = name;
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

    public List<Problem> getProblems() {
        return problems;
    }

    public void setProblems(List<Problem> problems) {
        this.problems = problems;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Test o) {
        return id.compareTo(o.id);
    }
}
