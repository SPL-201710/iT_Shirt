package co.com.itshirt.repository;

import org.springframework.stereotype.Repository;

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

}