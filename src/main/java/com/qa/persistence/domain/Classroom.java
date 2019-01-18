package com.qa.persistence.domain;

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
	@OneToMany(mappedBy="traineeID", cascade=CascadeType.ALL)
	List<Trainee> trainees;
	
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

	public void setTrainees(List<Trainee> trainees) {
		this.trainees = trainees;
	}
	
}
