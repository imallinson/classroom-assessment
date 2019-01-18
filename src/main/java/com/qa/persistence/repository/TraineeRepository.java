package com.qa.persistence.repository;

import com.qa.persistence.domain.Trainee;

public interface TraineeRepository {
	String getTrainees();
	
	String addTrainee(Trainee trainee);
	
	String deleteTrainee(Long id);
	
	String updateTrainee(Long id, Trainee trainee);
}
