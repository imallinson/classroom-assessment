package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

public class TraineeMapRepository implements TraineeRepository {
	private Map<Long, Trainee> trainees = new HashMap<>();
	Long id = (long) 1;
	
	ClassroomMapRepository repo = new ClassroomMapRepository();

	@Inject
	private JSONUtil util;
	
	@Override
	public String getTrainees() {
		return util.getJSONForObject(trainees);
	}

	@Override
	public String addTrainee(Trainee trainee) {
		if (repo.getMap().containsKey(trainee.getClassroomID())) {
			trainees.put(id, trainee);
			repo.addTrainee(trainee.getClassroomID(), trainee);
			id++;
			return "{\"message\": \"trainee sucessfully added\"}";
		}
		return "{\"message\": \"classroom does not exist\"}";
	}

	@Override
	public String deleteTrainee(Long id) {
		if (trainees.containsKey(id)) {
			trainees.remove(id);
			repo.deleteTrainee(trainees.get(id).getTraineeID(), trainees.get(id));
			return "{\"message\": \"trainee sucessfully deleted\"}";
		}
		return "{\"message\": \"trainee does not exist\"}";
	}

	@Override
	public String updateTrainee(Long id, Trainee trainee) {
		if (repo.getMap().containsKey(trainee.getClassroomID())) {
			if (trainees.containsKey(id)) {
				deleteTrainee(id);
				addTrainee(trainee);
				return "{\"message\": \"trainee sucessfully updated\"}";
			}
			return "{\"message\": \"trainee does not exist\"}";
		}
		return "{\"message\": \"classroom does not exist\"}";
	}

}
