package co.com.itshirt.variability.factory;

public class BusquedaFactory {

	public static BusquedaCatalogo getBusqueda(boolean esAvanzada) {
		if (esAvanzada) {			 
			return new BusquedaAvanzada();
		} else {			 
			return new BusquedaSencilla();
		}
	}
	
}