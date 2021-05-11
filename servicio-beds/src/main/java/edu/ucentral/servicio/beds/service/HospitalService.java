package edu.ucentral.servicio.beds.service;



import edu.ucentral.commons.service.services.CommonService;
import edu.ucentral.servicio.beds.model.Hospital;

public interface HospitalService  extends CommonService<Hospital>{

	public Iterable<Hospital> findHospitalByIdByBedEstado(Long hospitalId, Boolean estado);
	

	// public Iterable<Nurse> findAllNurses();
}
