package co.com.itshirt.repository.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.NativeWebRequest;

import co.com.itshirt.domain.Rol;
import co.com.itshirt.domain.Usuario;
import co.com.itshirt.security.CustomUserDetails;

@Service
public class FacebookSignInAdapter implements SignInAdapter {
	
    @Override
    public String signIn(String localUserId, Connection<?> connection, NativeWebRequest request) {
        System.out.println(" ====== Sign In adapter");
        final Usuario user = new Usuario(); //Temporal
        user.setUsername(localUserId);
        user.setNombres(localUserId);
        user.setApellidos("");
        user.setRol(new Rol());
		final UserDetails userDetails = new CustomUserDetails(user);
		final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
				new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(connection.getDisplayName(), null, Arrays.asList(new SimpleGrantedAuthority("FACEBOOK_USER"))));
        return null;
    }
}
