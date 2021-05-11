package edu.ucentral.proyecto.uci.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ucentral.proyecto.models.Cama;
import edu.ucentral.proyecto.uci.repository.ICamaRepository;

@Service //Equivale @Component: Denota un servicio
public class CamaServiceImpl implements ICamaService {

	@Autowired
	private ICamaRepository camaRepository;

	@Override
	public List<Cama> findAll() {
		// TODO Auto-generated method stub
		return camaRepository.findAll();
	}

	@Override
	public Cama findById(Long id) {
		// TODO Auto-generated method stub
		Optional<Cama> optional = camaRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		camaRepository.deleteById(id);

	}

	@Override
	public void save(Cama Cama) {
		camaRepository.save(Cama);
	}
	
	

}
