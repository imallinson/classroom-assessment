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
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class ClassroomDBRepository implements ClassroomRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	public String getClassrooms() {
		Query query = manager.createQuery("Select c FROM Classroom c JOIN c.trainees t WHERE t.traineeID = :traineeID");
		Collection<Classroom> classrooms = (Collection<Classroom>) query.getResultList();
		return util.getJSONForObject(classrooms);
	}
	
	@Transactional(REQUIRED)
	public String addClassroom(Classroom classroom) {
		manager.persist(classroom);
		return "{\"message\": \"classroom has been sucessfully added\"}";
	}
	
	@Transactional(REQUIRED)
	public String deleteClassroom(Long id) {
		Classroom classroomInDB = findAccount(id);
		if (classroomInDB != null) {
			manager.remove(classroomInDB);
			return "{\"message\": \"classroom sucessfully deleted\"}";
		}
		return "{\"message\": \"classroom does not exist\"}";
	}
	
	@Transactional(REQUIRED)
	public String updateClassroom(Long id, Classroom classroom) {
		Classroom classroomInDB = findAccount(id);
		if (classroomInDB != null) {
			manager.remove(classroomInDB);
			manager.persist(classroom);
			return "{\"message\": \"classroom sucessfully updated\"}";
		}
		return "{\"message\": \"classroom does not exist\"}";
	}
	
	private Classroom findAccount(Long id) {
		return manager.find(Classroom.class, id);
	}

}
