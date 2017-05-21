package co.com.itshirt.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import co.com.itshirt.dto.MenuDTO;
import co.com.itshirt.enums.EnumRol;

/**
 * Clase que se encarga de construir los menus de los tipos de usuarios manualmente.
 * @author ja.picon
 *
 */
@Configuration
public class MenuBuilder {
	
	@Autowired
	protected VariabilityConfig variabilityConfig;
	
	public List<MenuDTO> MENUS_ADMIN;
	public List<MenuDTO> MENUS_COMPRADOR;
	public List<MenuDTO> MENUS_ARTISTA;
	public List<MenuDTO> MENUS_OTRO; //No debería pasar (Pero por si acaso).
	
	public MenuBuilder() {
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
//		MENUS_ADMIN.add(new MenuDTO("Suscripciones VIP", "glyphicon-star", "/admin/suscripcion"));
		//Configuración menus comprador.
		MENUS_COMPRADOR = new ArrayList<MenuDTO>();
		MENUS_COMPRADOR.add(new MenuDTO("Inicio", "glyphicon-home", "/welcome"));
		MENUS_COMPRADOR.add(new MenuDTO("Perfil de usuario", "glyphicon-user", "/perfil"));
		MENUS_COMPRADOR.add(new MenuDTO("Catalogo", "glyphicon-search", "/catalogo"));
		MENUS_COMPRADOR.add(new MenuDTO("Carrito de compras", "glyphicon-shopping-cart", "/carrito"));
		MENUS_COMPRADOR.add(new MenuDTO("Compras realizadas", "glyphicon-usd", "/compras/historial"));
//		MENUS_COMPRADOR.add(new MenuDTO("Cambiar contraseña", "glyphicon-wrench", "/perfil/cambiarCredenciales"));
		//Configuración menus artista.
		MENUS_ARTISTA = new ArrayList<MenuDTO>();
		MENUS_ARTISTA.add(new MenuDTO("Inicio", "glyphicon-home", "/welcome"));
		MENUS_ARTISTA.add(new MenuDTO("Perfil de usuario", "glyphicon-user", "/perfil"));
		MENUS_ARTISTA.add(new MenuDTO("Catalogo", "glyphicon-search", "/catalogo"));
		MENUS_ARTISTA.add(new MenuDTO("Crear estampa", "glyphicon-equalizer", "/crearEstampa"));
		MENUS_ARTISTA.add(new MenuDTO("Ver calificaciones", "glyphicon-thumbs-up", "/estampa/calificaciones"));
//		MENUS_ARTISTA.add(new MenuDTO("Cambiar contraseña", "glyphicon-wrench", "/perfil/cambiarCredenciales"));
		MENUS_ARTISTA.add(new MenuDTO("Reportes", "glyphicon-download-alt", "/artista/reportes"));
//		MENUS_ARTISTA.add(new MenuDTO("Comprar Paquete VIP", "glyphicon-star", "/suscripcion"));
//		MENUS_ARTISTA.add(new MenuDTO("Compras VIP realizadas", "glyphicon-usd", "/compras/historial/vip"));
	}
	
	/**
	 * Obtiene listado de menus seg{un rol.
	 * @param rol
	 * @return
	 */
	public List<MenuDTO> obtenerMenusPorRol(final String rol) {
		List<MenuDTO> menusRol = null;
		//Administrador
		if (EnumRol.ADMINISTRADOR.getNombre().equals(rol)) { 
			menusRol = new ArrayList<>(MENUS_ADMIN);
			if (this.variabilityConfig.isVip()) {
				menusRol.add(new MenuDTO("Suscripciones VIP", "glyphicon-star", "/admin/suscripcion"));
			}
		} 
		// Comprador
		else if (EnumRol.COMPRADOR.getNombre().equals(rol)) {
			menusRol = new ArrayList<>(MENUS_COMPRADOR);
			if (this.variabilityConfig.isChangeAddress()) {
				menusRol.add(new MenuDTO("Cambiar dirección", "glyphicon-info-sign", "/perfil/cambiarDireccion"));
			}
		} 
		// Artista
		else if (EnumRol.ARTISTA.getNombre().equals(rol)) {
			menusRol = new ArrayList<>(MENUS_ARTISTA);
			if (this.variabilityConfig.isVip()) {
				menusRol.add(new MenuDTO("Comprar Paquete VIP", "glyphicon-star", "/suscripcion"));
				menusRol.add(new MenuDTO("Compras VIP realizadas", "glyphicon-usd", "/compras/historial/vip"));
			}
		} 
		// Otro
		else {
			menusRol = new ArrayList<>(MENUS_OTRO);
		}
		
		//Menús características optionals que aplican a todos los roles.
		if (this.variabilityConfig.isChangePassword()) {
			menusRol.add(new MenuDTO("Cambiar contraseña", "glyphicon-wrench", "/perfil/cambiarCredenciales"));
		}
		
		return menusRol;
	}

}
