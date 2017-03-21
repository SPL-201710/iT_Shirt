package co.com.itshirt.api.dto.usuario;

import java.io.Serializable;

/**
 * DTO que encapsula la información del resultado autenticación.
 * @author julianpicon
 *
 */
public class ResultadoAutenticacionDTO implements Serializable {
	
	private static final long serialVersionUID = -4625755019571938318L;
	
	private String usuario;
	private boolean resultado;
	
	/**
	 * Constructor por defecto.
	 */
	public ResultadoAutenticacionDTO() {
		
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public boolean isResultado() {
		return resultado;
	}

	public void setResultado(boolean resultado) {
		this.resultado = resultado;
	}
	
	
}
