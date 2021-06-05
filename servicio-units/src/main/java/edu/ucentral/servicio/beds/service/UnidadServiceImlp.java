package edu.ucentral.servicio.beds.service;

import org.springframework.stereotype.Service;
import edu.ucentral.commons.service.services.CommonServiceImpl;
import edu.ucentral.servicio.beds.model.Unit;
import edu.ucentral.servicio.beds.repository.IUnidadRepository;

@Service
public class UnidadServiceImlp extends CommonServiceImpl<Unit, IUnidadRepository> implements UnidadService {

}
