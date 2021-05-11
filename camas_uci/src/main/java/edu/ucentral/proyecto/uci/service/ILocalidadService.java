package edu.ucentral.proyecto.uci.service;

import java.util.List;
import edu.ucentral.proyecto.models.Localidad;

public interface ILocalidadService {
	
	public List<Localidad> findAll();
	public Localidad findById(Long id);
	//public Country Save();
	
	

}
