package edu.ucentral.proyecto.uci.service;

import java.util.*;

import org.springframework.stereotype.Service;

import edu.ucentral.proyecto.models.Localidad;


@Service
public class LocalidadServiceImpl implements ILocalidadService {

	private List<Localidad> localidades;
	
	public LocalidadServiceImpl() {
		this.localidades = Arrays.asList(
				new Localidad((long) 1, "COL", "Colombia"),
				new Localidad((long) 2, "AR", "Argentina"),
				new Localidad((long) 3, "MX", "México"), 
				new Localidad((long) 4, "PE", "Perú"), 
				new Localidad((long) 5, "CL", "Chile"));	
		}

	@Override
	public List<Localidad> findAll() {
		// TODO Auto-generated method stub
		return localidades;
	}

	@Override
	public Localidad findById(Long id) {
		Localidad result = null;
		for (Localidad country : this.localidades) {
			if (id == country.getId()) {
				result = country;
				break;
			}
		}

		return result;
	}

}
