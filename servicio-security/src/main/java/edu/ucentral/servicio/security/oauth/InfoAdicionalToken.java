package edu.ucentral.servicio.security.oauth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import edu.ucentral.commonusuarios.model.Usuario;
import edu.ucentral.servicio.security.service.IUserService;

@Component
public class InfoAdicionalToken implements TokenEnhancer {

	@Autowired
	private IUserService userService;

//Se encarga de construir la informacion adicional al user, ya que este metodo es personalizado
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String, Object> infor = new HashMap<String, Object>();
		Usuario usuario = userService.findByUsername(authentication.getName());
		infor.put("email", usuario.getEmail());

		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(infor);
		return accessToken;
	}

}
