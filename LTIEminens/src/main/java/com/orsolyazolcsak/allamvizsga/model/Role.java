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
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "role_Sequence")
	@SequenceGenerator(name = "role_Sequence", sequenceName = "ROLE_SEQ")
	private Long id;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "role")
    private List<User> user;
	
	public Role() {
		
	}
	
	public String getDescription() {
		return description;
	}
}
