package com.orsolyazolcsak.allamvizsga.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Help {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "difficulty_Sequence")
    @SequenceGenerator(name = "difficulty_Sequence", sequenceName = "DIFFICULTY_SEQ")
    private Long id;
	
	@Column(name = "name")
	private String name;
	
	 @OneToMany(cascade = CascadeType.ALL,
	            fetch = FetchType.EAGER,
	            mappedBy = "help")
	    private List<UsedHelp> usedHelp;
	 
	public Help() {
		 
	}
	 
	public String getName() {
		return name;
	}
}