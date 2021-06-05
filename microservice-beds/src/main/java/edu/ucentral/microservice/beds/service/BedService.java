package edu.ucentral.microservice.beds.service;

import java.util.List;

import edu.ucentral.commons.beds.model.Bed;
import edu.ucentral.commons.nurses.model.Nurse;
import edu.ucentral.commons.service.services.CommonService;

public interface BedService extends CommonService<Bed> {
	
	public List<Bed> findByRoom(String room);

	//public List<Bed> findByEstate(boolean estado);

	//public Iterable<Long> findBedsIdsAssignedToPaciente(Long pacienteId);

	public List<Nurse> findAllNurses();

}
