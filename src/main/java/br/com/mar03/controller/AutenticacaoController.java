package br.com.mar03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mar03.dto.TokenDto;
import br.com.mar03.form.LoginForm;
import br.com.mar03.security.TokenService;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
	
	 @Autowired
	 private AuthenticationManager authManager;
	 
	 @Autowired
	 private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<TokenDto> autenticar(@RequestBody @Validated LoginForm form){
		
		UsernamePasswordAuthenticationToken dadosLogin = form.converter();
		try {
			Authentication authentication = authManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authentication);
			System.out.println(token);
			return ResponseEntity.ok(new TokenDto(token, "Bearer "));			
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
	}

}
