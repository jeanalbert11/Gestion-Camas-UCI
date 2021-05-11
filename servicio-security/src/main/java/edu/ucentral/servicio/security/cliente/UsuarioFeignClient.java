package edu.ucentral.servicio.security.cliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ucentral.commonusuarios.model.Usuario;


//Servicio con el que se va a comunicar
@FeignClient(name = "servicio-usuarios")
public interface UsuarioFeignClient {
	// Cualquier metodo que se cree aqui va a solicitar una peticion http al
	// servicio de @feignClient

	@GetMapping("/buscar-username")
	public Usuario findByUsername(@RequestParam String username);

}
