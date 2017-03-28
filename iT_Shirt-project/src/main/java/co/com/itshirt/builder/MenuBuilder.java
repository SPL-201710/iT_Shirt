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
		MENUS_ADMIN.add(new MenuDTO("Inicio", "glyphicon-home", "/welcome"));
		MENUS_ADMIN.add(new MenuDTO("Administrar Camisetas", "glyphicon-cog", "/camisetas/catalogo"));
		MENUS_ADMIN.add(new MenuDTO("Administrar Usuarios", "glyphicon-user", "/admin/usuarios"));
		MENUS_ADMIN.add(new MenuDTO("Administrar Temas", "glyphicon-thumbs-up", "/admin/temas"));
		MENUS_ADMIN.add(new MenuDTO("Administrar Estampas", "glyphicon-ok", "/admin/estampas"));
		MENUS_ADMIN.add(new MenuDTO("Administrar Reportes", "glyphicon-download-alt", "/admin/reportes"));
		//Configuración menus comprador.
		MENUS_COMPRADOR = new ArrayList<MenuDTO>();
		MENUS_COMPRADOR.add(new MenuDTO("Inicio", "glyphicon-home", "/welcome"));
		MENUS_COMPRADOR.add(new MenuDTO("Perfil de usuario", "glyphicon-user", "/perfil"));
		MENUS_COMPRADOR.add(new MenuDTO("Catalogo", "glyphicon-search", "/catalogo"));
//		MENUS_COMPRADOR.add(new MenuDTO("Persinalizar camiseta", "glyphicon-tag", "/personalizar"));
		MENUS_COMPRADOR.add(new MenuDTO("Carrito de compras", "glyphicon-shopping-cart", "/carrito"));
		MENUS_COMPRADOR.add(new MenuDTO("Compras realizadas", "glyphicon-usd", "/compras/historial"));
		MENUS_COMPRADOR.add(new MenuDTO("Cambiar contraseña", "glyphicon-wrench", "/perfil/cambiarCredenciales"));
//		MENUS_COMPRADOR.add(new MenuDTO("Ayuda", "glyphicon-flag", "/ayuda"));
		//Configuración menus artista.
		MENUS_ARTISTA = new ArrayList<MenuDTO>();
		MENUS_ARTISTA.add(new MenuDTO("Inicio", "glyphicon-home", "/welcome"));
		MENUS_ARTISTA.add(new MenuDTO("Perfil de usuario", "glyphicon-user", "/perfil"));
		MENUS_ARTISTA.add(new MenuDTO("Catalogo", "glyphicon-search", "/catalogo"));
		MENUS_ARTISTA.add(new MenuDTO("Crear estampa", "glyphicon-equalizer", "/crearEstampa"));
		MENUS_ARTISTA.add(new MenuDTO("Ver calificaciones", "glyphicon-thumbs-up", "/artista/calificaciones"));
		MENUS_ARTISTA.add(new MenuDTO("Cambiar contraseña", "glyphicon-wrench", "/perfil/cambiarCredenciales"));
		MENUS_ARTISTA.add(new MenuDTO("Reportes", "glyphicon-download-alt", "/artista/reportes"));
//		MENUS_ARTISTA.add(new MenuDTO("Ayuda", "glyphicon-flag", "/ayuda"));
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
