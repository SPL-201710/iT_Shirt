package co.com.itshirt.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.itshirt.api.dto.usuario.LoginDTO;
import co.com.itshirt.api.dto.usuario.ResultadoAutenticacionDTO;
import co.com.itshirt.repository.UsuarioDAO;

/**
 * Servicio funcionalidades de los usuarios.
 * @author ja.picon
 *
 */
@Service
public class UsuarioServicio implements Serializable {
	
	private static final long serialVersionUID = 1L;
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
		return this.usuarioDAO.consultaEjemplo();
	}

	public ResultadoAutenticacionDTO autenticar(LoginDTO login) throws Exception {
		return this.usuarioDAO.autenticar(login);
	}

}
