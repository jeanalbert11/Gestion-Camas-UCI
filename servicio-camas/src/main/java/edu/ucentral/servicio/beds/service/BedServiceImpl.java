package edu.ucentral.servicio.beds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ucentral.commons.service.services.CommonServiceImpl;
import edu.ucentral.servicio.beds.model.Bed;
import edu.ucentral.servicio.beds.repository.IBedRepository;
import edu.ucentral.servicio.nurses.model.Nurse;
import edu.ucentral.servicio.nurses.repository.INurseRepository;

@Service
public class BedServiceImpl /*extends CommonServiceImpl<Bed, IBedRepository>*/ implements BedService {


	@Autowired
	private IBedRepository bedRepository;
/*
	@Autowired
	private INurseRepository nurseRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Nurse> findAllNurses() {
		return nurseRepository.findAll();
	}
*/

	@Override
	@Transactional(readOnly = true)
	public Iterable<Bed> findAll() {
		return bedRepository.findAll();
	}
}
