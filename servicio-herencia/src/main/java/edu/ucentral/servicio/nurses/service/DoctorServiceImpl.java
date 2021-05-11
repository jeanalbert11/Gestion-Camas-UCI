package edu.ucentral.servicio.nurses.service;

import org.springframework.stereotype.Service;
import edu.ucentral.commons.service.services.CommonServiceImpl;
import edu.ucentral.servicio.nurses.model.Doctor;
import edu.ucentral.servicio.nurses.repository.IDoctorRepository;

@Service
public class DoctorServiceImpl extends CommonServiceImpl<Doctor, IDoctorRepository> implements DoctorService {

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
