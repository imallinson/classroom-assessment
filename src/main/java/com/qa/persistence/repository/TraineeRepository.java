package com.qa.persistence.repository;

import com.qa.persistence.domain.Trainee;

public interface TraineeRepository {
	String getTrainees();
	
	String addTrainee(Long id, Trainee trainee);
	
	String deleteTrainee(Long id);
	
	String updateTrainee(Long id, Trainee trainee);
}
