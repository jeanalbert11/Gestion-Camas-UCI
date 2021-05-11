package edu.ucentral.servicio.beds.service;

import java.util.Optional;

import org.springframework.data.domain.Pageable;

import edu.ucentral.commons.service.services.CommonService;
import edu.ucentral.servicio.beds.model.Bed;
import edu.ucentral.servicio.nurses.model.Nurse;

public interface BedService  /*extends CommonService<Bed>*/ {

	public Iterable<Bed> findAll();
	

	// public Iterable<Nurse> findAllNurses();
}
