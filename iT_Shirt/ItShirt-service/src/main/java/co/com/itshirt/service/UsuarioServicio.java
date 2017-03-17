package co.com.itshirt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.itshirt.repository.UsuarioDAO;

/**
 * Servicio funcionalidades de los usuarios.
 * @author ja.picon
 *
 */
@Service
public class UsuarioServicio {
	
	/**
	 * Inyección dependencia DAO usuario.
	 */
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	/**
	 * Consulta de ejemplo.
	 * @return Retorno consulta.
	 */
	public String consultaEjemplo() {
		return usuarioDAO.consultaEjemplo();
	}

}
