package edu.ucentral.proyecto.uci.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ucentral.proyecto.models.Ips;
import edu.ucentral.proyecto.uci.repository.IIPSRepository;

@Service //Equivale @Component: Denota un servicio
public class IpsServiceImpl implements IIpsService {

	@Autowired
	private IIPSRepository ipsRepository;

	@Override
	public List<Ips> findAll() {
		// TODO Auto-generated method stub
		return ipsRepository.findAll();
	}

	@Override
	public Ips findById(Long id) {
		// TODO Auto-generated method stub
		Optional<Ips> optional = ipsRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		ipsRepository.deleteById(id);

	}

	@Override
	public void save(Ips ips) {
		ipsRepository.save(ips);
	}
	
	

}
