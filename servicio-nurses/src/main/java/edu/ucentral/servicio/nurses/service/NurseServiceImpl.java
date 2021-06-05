package edu.ucentral.servicio.nurses.service;

import org.springframework.stereotype.Service;
import edu.ucentral.commons.service.services.CommonServiceImpl;
import edu.ucentral.commons.nurses.model.Nurse;

import edu.ucentral.servicio.nurses.repository.INurseRepository;

@Service
public class NurseServiceImpl extends CommonServiceImpl<Nurse, INurseRepository> implements NurseService {


}
