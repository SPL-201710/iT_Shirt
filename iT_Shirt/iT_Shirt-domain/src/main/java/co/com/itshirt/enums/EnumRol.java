package co.com.itshirt.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * Roles del sistema.
 * @author ja.picon
 *
 */
public enum EnumRol {
	
	ADMINISTRADOR ("ADMIN", "Administrador", false),
	ARTISTA ("ARTIS", "Artista", true),
	COMPRADOR ("COMPR", "Comprador", true),
	;
	
	public final static EnumRol[] ENUM_VALUES = EnumRol.values();
	
	private String sigla;
	private String nombre;
	private boolean permiteRegistro; //Indica si se muestra o no en registro de usuarios desde la aplicación.
	
	private EnumRol(String sigla, String nombre, boolean permiteRegistro) {
		this.sigla = sigla;
		this.nombre = nombre;
		this.permiteRegistro = permiteRegistro;
	}
	
	/**
	 * Obtiene roles que permiten registro.
	 */
	public static List<EnumRol> obtenerRolesPermitenRegistro() {
		List<EnumRol> rolesPermitenRegistro = new ArrayList<EnumRol>();
		for (EnumRol rol : ENUM_VALUES) {
			if (rol.permiteRegistro) {
				rolesPermitenRegistro.add(rol);
			}
		}
		return rolesPermitenRegistro;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isPermiteRegistro() {
		return permiteRegistro;
	}

	public void setPermiteRegistro(boolean permiteRegistro) {
		this.permiteRegistro = permiteRegistro;
	}
	
}
