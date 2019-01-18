package com.qa.persistence.repository;

import com.qa.persistence.domain.Classroom;

public interface ClassroomRepository {
	String getClassrooms();
	
	String addClassroom(Classroom classroom);
	
	String deleteClassroom(Long id);
	
	String updateClassroom(Long id, Classroom classroom);
}
