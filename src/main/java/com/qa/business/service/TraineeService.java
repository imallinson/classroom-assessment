package com.qa.business.service;

public interface TraineeService {
	
	public String getTrainees();

	public String addTrainee(Long id, String traineeJSON);

	public String deleteTrainee(Long id);
	
	public String updateTrainee(Long id, String traineeJSON);
	
}
