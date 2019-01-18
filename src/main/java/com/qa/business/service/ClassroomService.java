package com.qa.business.service;

public interface ClassroomService {

	public String getClassrooms();

	public String addClassroom(String classroomJSON);

	public String deleteClassroom(Long id);
	
	public String updateClassroom(Long id, String classroomJSON);

}
