package co.com.itshirt.repository;

import org.springframework.stereotype.Repository;

import co.com.itshirt.api.dto.usuario.LoginDTO;
import co.com.itshirt.api.dto.usuario.ResultadoAutenticacionDTO;

/**
 * DAO funcionalidades usuario.
 * @author ja.picon
 *
 */
@Repository
public class UsuarioDAO {
	
	/**
	 * Consulta de ejemplo.
	 * @return Cadena con el resultado de la consulta.
	 */
	public String consultaEjemplo() {
		return "Ejemplo de consulta a capa de acceso de datos. UsuarioDAO. ";
	}

	public ResultadoAutenticacionDTO autenticar(final LoginDTO login) throws Exception {
		try {
			ResultadoAutenticacionDTO resultado = new ResultadoAutenticacionDTO();
			resultado.setUsuario(login.getUsuario());
			resultado.setResultado(true); //TODO Datos temporales.
			return resultado;
		} catch (Exception e) {
			throw new Exception("Error al autenticar el usuario.");
		}
	}

}