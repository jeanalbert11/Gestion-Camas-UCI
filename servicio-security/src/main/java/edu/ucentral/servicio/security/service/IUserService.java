package edu.ucentral.servicio.security.service;

import edu.ucentral.commonusuarios.model.Usuario;

public interface IUserService {
	public  Usuario findByUsername(String username);
}
