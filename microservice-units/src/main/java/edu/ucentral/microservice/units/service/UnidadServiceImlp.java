package edu.ucentral.microservice.units.service;

import org.springframework.stereotype.Service;
import edu.ucentral.commons.service.services.CommonServiceImpl;
import edu.ucentral.microservice.units.model.Unit;
import edu.ucentral.microservice.units.repository.IUnidadRepository;

@Service
public class UnidadServiceImlp extends CommonServiceImpl<Unit, IUnidadRepository> implements UnidadService {

}
