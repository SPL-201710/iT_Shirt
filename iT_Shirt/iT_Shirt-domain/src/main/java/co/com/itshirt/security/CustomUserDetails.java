package co.com.itshirt.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import co.com.itshirt.domain.Usuario;
import co.com.itshirt.enums.EnumEstadoUsuario;

public class CustomUserDetails extends Usuario implements UserDetails {	
	
	private static final long serialVersionUID = 1L;
	private List<String> userRoles;
	
	public CustomUserDetails(Usuario user){
		super(user);
		this.userRoles =  Arrays.asList(user.getRol().getNombre());
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String roles=StringUtils.collectionToCommaDelimitedString(userRoles);			
		return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return EnumEstadoUsuario.ACTIVO.getSigla().equals(super.getEstado());
	}


	@Override
	public String getUsername() {
		return super.getUsername();
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}


}
