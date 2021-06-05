package edu.ucentral.servicio.beds.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.ucentral.commons.service.services.CommonServiceImpl;
import edu.ucentral.servicio.beds.model.Hospital;
import edu.ucentral.servicio.beds.repository.IHospitalRepository;

@Service
public class HospitalServiceImpl extends CommonServiceImpl<Hospital, IHospitalRepository> implements HospitalService {

/*	@Override
	@Transactional(readOnly = true)
	public Iterable<Hospital> findHospitalByIdByBedEstado(Long hospitalId, boolean estado) {
		return repository.findHospitalByIdByBedEstado(hospitalId, estado);
	}
*/
	
}
