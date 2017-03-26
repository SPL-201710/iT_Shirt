package co.com.itshirt.builder;

import java.util.ArrayList;
import java.util.List;

import co.com.itshirt.dto.MenuDTO;
import co.com.itshirt.enums.EnumRol;

/**
 * Clase que se encarga de construir los menus de los tipos de usuarios manualmente.
 * @author ja.picon
 *
 */
public class MenuBuilder {
	
	public static final List<MenuDTO> MENUS_ADMIN;
	public static final List<MenuDTO> MENUS_COMPRADOR;
	public static final List<MenuDTO> MENUS_ARTISTA;
	public static final List<MenuDTO> MENUS_OTRO; //No debería pasar (Pero por si acaso).
	
	static {
		//Configuración menus otro.
		MENUS_OTRO = new ArrayList<MenuDTO>();
		MENUS_OTRO.add(new MenuDTO("Inicio", null, "/welcome"));
		//Configuración menus administrador.
		MENUS_ADMIN = new ArrayList<MenuDTO>();
		MENUS_ADMIN.add(new MenuDTO("Inicio", null, "/welcome"));
		MENUS_ADMIN.add(new MenuDTO("Administrar Usuarios", null, "/admin/usuarios"));
		MENUS_ADMIN.add(new MenuDTO("Administrar Temas", null, "/admin/temas"));
		MENUS_ADMIN.add(new MenuDTO("Administrar Estampas", null, "/admin/estampas"));
		MENUS_ADMIN.add(new MenuDTO("Administrar Reportes", null, "/admin/reportes"));
		//Configuración menus comprador.
		MENUS_COMPRADOR = new ArrayList<MenuDTO>();
		MENUS_COMPRADOR.add(new MenuDTO("Inicio", null, "/welcome"));
		MENUS_COMPRADOR.add(new MenuDTO("Perfil de usuario", null, "/perfil"));
		MENUS_COMPRADOR.add(new MenuDTO("Catalogo", null, "/catalogo"));
		MENUS_COMPRADOR.add(new MenuDTO("Persinalizar camiseta", null, "/personalizar"));
		MENUS_COMPRADOR.add(new MenuDTO("Carrito de compras", null, "/carrito"));
		MENUS_COMPRADOR.add(new MenuDTO("Compras realizadas", null, "/historialCompras"));
		MENUS_COMPRADOR.add(new MenuDTO("Cambiar contraseña", null, "/cambiarCredenciales"));
		MENUS_COMPRADOR.add(new MenuDTO("Ayuda", null, "/ayuda"));
		//Configuración menus artista.
		MENUS_ARTISTA = new ArrayList<MenuDTO>();
		MENUS_ARTISTA.add(new MenuDTO("Inicio", null, "/welcome"));
		MENUS_ARTISTA.add(new MenuDTO("Perfil de usuario", null, "/perfil"));
		MENUS_ARTISTA.add(new MenuDTO("Catalogo", null, "/catalogo"));
		MENUS_ARTISTA.add(new MenuDTO("Crear estampa", null, "/crearEstampa"));
		MENUS_ARTISTA.add(new MenuDTO("Ver carrito", null, "/carrito"));
		MENUS_ARTISTA.add(new MenuDTO("Cambiar contraseña", null, "/cambiarCredenciales"));
		MENUS_ARTISTA.add(new MenuDTO("Ayuda", null, "/ayuda"));
	}
	
	/**
	 * Obtiene listado de menus seg{un rol.
	 * @param rol
	 * @return
	 */
	public static List<MenuDTO> obtenerMenusPorRol(final String rol) {
		if (EnumRol.ADMINISTRADOR.getNombre().equals(rol)) {
			return MENUS_ADMIN;
		} else if (EnumRol.COMPRADOR.getNombre().equals(rol)) {
			return MENUS_COMPRADOR;
		} else if (EnumRol.ARTISTA.getNombre().equals(rol)) {
			return MENUS_ARTISTA;
		}
		return MENUS_OTRO;
	}

}
