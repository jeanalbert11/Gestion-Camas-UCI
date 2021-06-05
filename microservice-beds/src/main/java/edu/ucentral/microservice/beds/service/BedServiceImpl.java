package edu.ucentral.microservice.beds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.ucentral.commons.beds.model.Bed;
import edu.ucentral.commons.nurses.model.Nurse;
import edu.ucentral.commons.service.services.CommonServiceImpl;
import edu.ucentral.microservice.beds.clients.NurseFeignClient;
import edu.ucentral.microservice.beds.repository.IBedRepository;

@Service
public class BedServiceImpl extends CommonServiceImpl<Bed, IBedRepository> implements BedService {

	@Autowired
	private NurseFeignClient nurseFeignClient;

	/*@Override
	@Transactional(readOnly = true)
	public Iterable<Long> findBedsIdsAssignedToPaciente(Long pacienteId) {
		return repository.findBedsIdsAssignedToPaciente(pacienteId);
	}
	*/

	@Override
	@Transactional(readOnly = true)
	public List<Bed> findByRoom(String room) {
		return repository.findByCode(room);
	}

	/*@Override
	@Transactional(readOnly = true)
	public List<Bed> findByEstate(boolean estado) {
		return repository.findByEstate(estado);
	}
	*/

	@Override
	@Transactional(readOnly = true)
	public List<Nurse> findAllNurses() {
		// TODO Auto-generated method stub
		return nurseFeignClient.findAllNurses();
	}

}
