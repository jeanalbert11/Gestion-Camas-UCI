package edu.ucentral.microservice.units.service;

import org.springframework.stereotype.Service;
import edu.ucentral.commons.service.services.CommonServiceImpl;
import edu.ucentral.microservice.units.model.Hospital;
import edu.ucentral.microservice.units.repository.IHospitalRepository;

@Service
public class HospitalServiceImpl extends CommonServiceImpl<Hospital, IHospitalRepository> implements HospitalService {

/*	@Override
	@Transactional(readOnly = true)
	public Iterable<Hospital> findHospitalByIdByBedEstado(Long hospitalId, boolean estado) {
		return repository.findHospitalByIdByBedEstado(hospitalId, estado);
	}
*/
	
}
