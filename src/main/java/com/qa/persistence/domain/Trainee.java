package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.qa.persistence.domain.Classroom;

@Entity
public class Trainee {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long traineeID;
	private String traineeName;
	@ManyToOne
    @JoinColumn(name = "classroomID")
    private Classroom classroom;
	
	public Trainee() {
		
	}
	
	public Trainee(String traineeName) {
		this.traineeName = traineeName;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	public Long getTraineeID() {
		return traineeID;
	}
	
}
