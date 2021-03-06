
package com.iobestgroup.donkeymoney.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iobestgroup.donkeymoney.user.DMUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPBinding;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static com.iobestgroup.donkeymoney.security.SecurityConstants.*;


public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private AuthenticationManager authenticationManager;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}


	@Override
	public Authentication attemptAuthentication(HttpServletRequest req,
												HttpServletResponse res) throws AuthenticationException {
		try {
			DMUser creds = new ObjectMapper()
					.readValue(req.getInputStream(), DMUser.class);

			return authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							creds.getEmail(),
							creds.getPassword(),
							new ArrayList<>())
			);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest req,
											HttpServletResponse res,
											FilterChain chain,
											Authentication auth) throws IOException, ServletException {

		String token = Jwts.builder()
				.setSubject(((User) auth.getPrincipal()).getUsername())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SECRET.getBytes())
				.compact();

		//res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
		res.getWriter().write('{' + HEADER_STRING + ':' + TOKEN_PREFIX  + token + '}');
		res.getWriter().flush();
		res.getWriter().close();

		res.addHeader("access-control-expose-headers", HEADER_STRING);
		res.setStatus(HttpStatus.NO_CONTENT.value());
	}
}
