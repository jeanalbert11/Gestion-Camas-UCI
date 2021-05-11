package edu.ucentral.serviciousuarios.service;
import edu.ucentral.commons.service.services.*;

//import edu.ucentral.commonsservicio.service.CommonService;
import edu.ucentral.commonusuarios.model.Usuario;

public interface UsuarioService extends CommonService<Usuario> {
	public Usuario findByUsername(String username);
}
