package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Trainee;
import com.qa.persistence.repository.TraineeRepository;
import com.qa.util.JSONUtil;

public class TraineeServiceImplementation implements TraineeService {
	@Inject
	TraineeRepository repo;
	
	@Inject
	private JSONUtil util;

	public String getTrainees() {
		return repo.getTrainees();
	}

	public String addTrainee(Long id, String traineeJSON) {
		Trainee trainee = util.getObjectForJSON(traineeJSON, Trainee.class);
		return repo.addTrainee(id, trainee);
	}

	public String deleteTrainee(Long id) {
		return repo.deleteTrainee(id);
	}

	public String updateTrainee(Long id, String traineeJSON) {
		Trainee trainee = util.getObjectForJSON(traineeJSON, Trainee.class);
		return repo.updateTrainee(id, trainee);
	}

}
