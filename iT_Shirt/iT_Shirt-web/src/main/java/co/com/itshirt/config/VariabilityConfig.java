package co.com.itshirt.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("config.properties")
@ConfigurationProperties(prefix="config")
public class VariabilityConfig {

	private boolean notifications;
    private boolean authFacebook;
    private boolean advancedSearch;
    
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
	
}