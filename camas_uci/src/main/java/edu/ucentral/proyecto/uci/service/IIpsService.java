package edu.ucentral.proyecto.uci.service;

import java.util.List;

import edu.ucentral.proyecto.models.Ips;


public interface IIpsService {
	
	public List<Ips> findAll();

	public Ips findById(Long id);

	public void delete(Long id);

	public void save(Ips Ips);
}
