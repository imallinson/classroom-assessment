package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.qa.business.service.TraineeService;

@Path("/trainee")
public class TraineeEndpoint {
	@Inject
	private TraineeService service;
	
	@Path("/json")
	@GET
	public String getTrainee() {
		return service.getTrainees();
	}
	
	@Path("/json")
	@POST
	public String addClassroom(String account) {
		return service.addTrainee(account);
	}

	@Path("/json/{id}")
	@DELETE
	public String deleteClassroom(@PathParam("id") Long id) {
		return service.deleteTrainee(id);
	}

	@Path("/json/{id}")
	@PUT
	public String updateClassroom(@PathParam("id") Long id, String account) {
		return service.updateTrainee(id, account);
	}
}
