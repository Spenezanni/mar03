package br.com.mar03.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.mar03.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	@Value("${forum.jwt.expiration}")
	private String expiration;
	
	@Value("${forum.jwt.secret}")
	private String secret ;

	public String gerarToken(Authentication authentication) {
		User UserLogado = (User) authentication.getPrincipal();
		Date hoje = new Date();
		Date dateExpiration = new Date(hoje.getTime() + Long.parseLong(expiration)); 
		return Jwts.builder()
				.setIssuer("Token")
				.setSubject(UserLogado.getId().toString())
				.setIssuedAt(hoje)
				.setExpiration(dateExpiration)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}
	
	

}
