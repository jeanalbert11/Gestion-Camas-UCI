package edu.ucentral.servicio.medical.staff.service;

import org.springframework.stereotype.Service;
import edu.ucentral.commons.service.services.CommonServiceImpl;
import edu.ucentral.servicio.medical.staff.model.Person;
import edu.ucentral.servicio.medical.staff.repository.IPersonRepository;

@Service
public class PersonServiceImpl extends CommonServiceImpl<Person, IPersonRepository> implements PersonService {

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
