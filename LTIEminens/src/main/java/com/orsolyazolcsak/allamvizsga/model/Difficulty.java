package com.orsolyazolcsak.allamvizsga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Difficulty implements Comparable<Difficulty> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "difficulty_Sequence")
    @SequenceGenerator(name = "difficulty_Sequence", sequenceName = "DIFFICULTY_SEQ")
    private Long id;

    @Column(name = "name")
    private String name;

    public Difficulty() {

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

    @Override
    public String toString() {
        return "Difficulty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    @Override
    public int compareTo(Difficulty other) {
        return id.compareTo(other.id); // konnyutol nehez fele novekednek az ID-k
    }
}
