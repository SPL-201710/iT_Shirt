package co.com.itshirt.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("config.properties")
@ConfigurationProperties(prefix="config")
public class VariabilityConfig {

	//Indica si es búsqueda simple o avanzada
	private boolean AdvancedSearch;
	private boolean schedulerEnabled;
	private String language;

	
	public boolean isBusquedaAvanzada() {
		return this.AdvancedSearch;
	}

	public void setBusquedaAvanzada(boolean busquedaAvanzada) {
		this.AdvancedSearch = busquedaAvanzada;
			
	}
	private boolean notifications;
    private boolean authFacebook;
    private boolean advancedSearch;
    private boolean changePassword;
    private boolean changeAddress;
    private boolean vip;
    
    /**
     * Constructor por defecto.
     */
    public VariabilityConfig() {
		super();
	}

	public boolean isNotifications() {
		return notifications;
	}

	public void setNotifications(boolean notifications) {
		this.notifications = notifications;
	}

	public boolean isAuthFacebook() {
		return authFacebook;
	}

	public void setAuthFacebook(boolean authFacebook) {
		this.authFacebook = authFacebook;
	}

	public boolean isAdvancedSearch() {
		return advancedSearch;
	}

	public void setAdvancedSearch(boolean advancedSearch) {
		this.advancedSearch = advancedSearch;
	}

	public boolean isChangePassword() {
		return changePassword;
	}

	public void setChangePassword(boolean changePassword) {
		this.changePassword = changePassword;
	}

	public boolean isChangeAddress() {
		return changeAddress;
	}

	public void setChangeAddress(boolean changeAddress) {
		this.changeAddress = changeAddress;
	}

	public boolean isVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}
	
}