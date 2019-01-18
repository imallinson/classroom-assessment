package com.qa.persistence.domain;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Classroom {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long classroomID;
	private String trainer;
	@OneToMany(mappedBy="classroomID", cascade=CascadeType.ALL)
	private List<Trainee> trainees = new ArrayList<>();
	
	public Classroom() {
		
	}
	
	public Classroom(String trainer) {
		this.trainer = trainer;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public Long getClassroomID() {
		return classroomID;
	}

	public List<Trainee> getTrainees() {
		return trainees;
	}
	
}
