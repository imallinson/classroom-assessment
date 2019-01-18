package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Classroom;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Alternative
public class ClassroomMapRepository implements ClassroomRepository {
	private Map<Long, Classroom> classrooms = new HashMap<>();
	Long id = (long) 1;

	@Inject
	private JSONUtil util;

	@Override
	public String getClassrooms() {
		return util.getJSONForObject(classrooms);
	}

	@Override
	@Transactional(REQUIRED)
	public String addClassroom(Classroom classroom) {
		classrooms.put(id, classroom);
		id++;
		return "{\"message\": \"classroom has been sucessfully added\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteClassroom(Long id) {
		if (classrooms.containsKey(id)) {
			classrooms.remove(id);
			return "{\"message\": \"classroom sucessfully deleted\"}";
		}
		return "{\"message\": \"classroom does not exist\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String updateClassroom(Long id, Classroom classroom) {
		if (classrooms.containsKey(id)) {
			classrooms.remove(id);
			classrooms.put(id, classroom);
			id++;
			return "{\"message\": \"classroom sucessfully updated\"}";
		}
		return "{\"message\": \"classroom does not exist\"}";
	}

}
