package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class TraineeDBRepository implements TraineeRepository {
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	
	public String getTrainees() {
		Query query = manager.createQuery("SELECT t FROM Trainee t");
		Collection<Trainee> trainees = (Collection<Trainee>) query.getResultList();
		return util.getJSONForObject(trainees);
	}
	
	@Transactional(REQUIRED)
	public String addTrainee(Trainee trainee) {
		manager.persist(trainee);
		return "{\"message\": \"trainee sucessfully added\"}";
	}
	
	@Transactional(REQUIRED)
	public String deleteTrainee(Long id) {
		Trainee traineeInDB = findTrainee(id);
		if (traineeInDB != null) {
			manager.remove(traineeInDB);
			return "{\"message\": \"trainee sucessfully deleted\"}";
		}
		return "{\"message\": \"trainee does not exist\"}";
	}
	
	@Transactional(REQUIRED)
	public String updateTrainee(Long id, Trainee trainee) {
		Trainee traineeInDB = findTrainee(id);
		if (traineeInDB != null) {
			manager.remove(traineeInDB);
			manager.persist(trainee);
			return "{\"message\": \"trainee sucessfully updated\"}";
		}
		return "{\"message\": \"trainee does not exist\"}";
	}
	
	private Trainee findTrainee(Long id) {
		return manager.find(Trainee.class, id);
	}

}
