package edu.ucentral.proyecto.uci.service;

import java.util.List;

import edu.ucentral.proyecto.models.Cama;


public interface ICamaService {
	
	public List<Cama> findAll();

	public Cama findById(Long id);

	public void delete(Long id);

	public void save(Cama cama);
}
