package co.com.itshirt.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

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

	public boolean isSchedulerEnabled() {
		return schedulerEnabled;
	}

	public void setSchedulerEnabled(boolean schedulerEnabled) {
		this.schedulerEnabled = schedulerEnabled;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
}