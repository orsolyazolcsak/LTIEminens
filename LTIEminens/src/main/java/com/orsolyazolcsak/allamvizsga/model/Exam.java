package com.orsolyazolcsak.allamvizsga.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

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

    @ManyToMany
    private Set<Problem> problems = new TreeSet<>();

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

    public Set<Problem> getProblems() {
        return problems;
    }

    public void setProblems(Set<Problem> problems) {

        this.problems = new TreeSet<>(problems);
        System.out.println("set problems in exam " + id + " problems = " + problems);
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", test=" + test +
                ", problems=" + problems +
                '}';
    }

    // implementaljuk az equals metodust hogy az examcontroller startedExams hashMap mezojeben megatalajuk
    // az examService.findById altal visszateritett examot
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exam exam = (Exam) o;
        return id.equals(exam.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}