package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.repository.ClassroomRepository;
import com.qa.util.JSONUtil;

public class ClassroomServiceImplementation implements ClassroomService {
	@Inject
	ClassroomRepository repo;
	
	@Inject
	private JSONUtil util;

	public String getClassrooms() {
		return repo.getClassrooms();
	}

	public String addClassroom(String classroomJSON) {
		Classroom classroom = util.getObjectForJSON(classroomJSON, Classroom.class);
		return repo.addClassroom(classroom);
		
	}

	public String deleteClassroom(Long id) {
		return repo.deleteClassroom(id);
	}

	public String updateClassroom(Long id, String classroomJSON) {
		Classroom classroom = util.getObjectForJSON(classroomJSON, Classroom.class);
		return repo.updateClassroom(id, classroom);
	}

}
