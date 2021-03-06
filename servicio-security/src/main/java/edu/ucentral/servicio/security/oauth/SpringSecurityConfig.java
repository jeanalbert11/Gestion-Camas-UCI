package edu.ucentral.servicio.security.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//Esta clase se encarga de la autenticación
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService usuarioService;

	// Se encarga de hacer el proceso de encriptacion
	// @Bean: Su funcion es similar que @Autowire
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// Registramos UserServiceImpl
	@Override
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Encriptamos la constraseña
		auth.userDetailsService(this.usuarioService).passwordEncoder(passwordEncoder());
	}

	// Permite hacer la autorizacion del usuario en el servidor de configuracion
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
}
