package com.movember.quizz.controller.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import org.apache.log4j.Logger;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.stereotype.Component;
import com.movember.quizz.model.bean.Usuario;
import com.movember.quizz.model.service.IUsuarioService;

/**
 * A custom authentication manager that allows access if the user details exist
 * in the database and if the username and password are not the same. Otherwise,
 * throw a {@link BadCredentialsException}
 */
@Component("customAuthenticationManager")
public class CustomAuthenticationManager implements AuthenticationProvider {

	@Inject
	private IUsuarioService usuarioService;
	protected static Logger logger = Logger.getLogger("service");

	// We need an Md5 encoder since our passwords in the database are Md5
	// encoded.
	private Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();

	public Authentication authenticate(Authentication auth) throws AuthenticationException {

		logger.debug("Performing custom authentication");

		// Init a database user object
		Usuario usuario = null;

		try {
			// Retrieve user details from database
			usuario = usuarioService.selectByUser(auth.getName());
		}
		catch (Exception e) {
			// logger.error("User does not exists!");
			throw new BadCredentialsException("El usuario no existe");
		}

		// Compare passwords
		// Make sure to encode the password first before comparing
		if (passwordEncoder.isPasswordValid(usuario.getPwd(), (String) auth.getCredentials(), null) == false) {
			logger.error("Wrong password!");
			throw new BadCredentialsException("Contraseņa incorrecta");
		}

		// Here's the main logic of this custom authentication manager
		// Username and password must be the same to authenticate
		if (auth.getName().equals(auth.getCredentials()) == true) {
			logger.debug("Entered username and password are the same!");
			throw new BadCredentialsException("El usuario y la contraseņa son iguales.");
		}
		else {
			logger.debug("User details are good and ready to go");
			return new UsernamePasswordAuthenticationToken(auth.getName(), auth.getCredentials(), getAuthorities(1));
		}
	}

	/**
	 * Retrieves the correct ROLE type depending on the access level, where
	 * access level is an Integer. Basically, this interprets the access value
	 * whether it's for a regular user or admin.
	 * 
	 * @param access
	 *            an integer value representing the access of the user
	 * @return collection of granted authorities
	 */
	public Collection<GrantedAuthority> getAuthorities(Integer access) {
		// Create a list of grants for this user
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);

		// All users are granted with ROLE_USER access
		// Therefore this user gets a ROLE_USER by default
		// logger.debug("Grant ROLE_USER to this user");
		authList.add(new GrantedAuthorityImpl("ROLE_USER"));

		// Check if this user has admin access
		// We interpret Integer(1) as an admin user
		if (access.compareTo(1) == 0) {
			// User has admin access
			logger.debug("Grant ROLE_ADMIN to this user");
			authList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
		}

		// Return list of granted authorities
		return authList;
	}

	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}
}
