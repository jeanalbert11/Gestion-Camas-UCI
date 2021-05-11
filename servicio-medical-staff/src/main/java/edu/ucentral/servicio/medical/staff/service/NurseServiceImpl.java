package edu.ucentral.servicio.medical.staff.service;

import org.springframework.stereotype.Service;
import edu.ucentral.commons.service.services.CommonServiceImpl;
import edu.ucentral.servicio.medical.staff.model.Nurse;
import edu.ucentral.servicio.medical.staff.repository.INurseRepository;

@Service
public class NurseServiceImpl extends CommonServiceImpl<Nurse, INurseRepository> implements NurseService {

	/*
	 * @Autowired
	 * 
	 * private IAsignaturaRepository asignaturaRepository;
	 * 
	 * @Override
	 * 
	 * @Transactional(readOnly = true) public Grupo findGrupoByEstudianteId(Long id)
	 * { return repository.findGrupoByEstudianteId(id); }
	 * 
	 * @Override
	 * 
	 * @Transactional(readOnly = true) public Iterable<Asignatura>
	 * findAllAsignaturas() { return asignaturaRepository.findAll(); }
	 */

}
