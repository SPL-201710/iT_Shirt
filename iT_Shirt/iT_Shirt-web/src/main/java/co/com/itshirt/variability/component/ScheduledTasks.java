package co.com.itshirt.variability.component;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import co.com.itshirt.annotation.OptionalFeature;

/**
 * Tareas programadas (Usar en envío de correos).
 * @author ja.picon
 *
 */
@Component
@OptionalFeature
public class ScheduledTasks {

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");

	@Value("${config.notifications}")
    private boolean schedulerEnabled;
    
    @Scheduled(fixedRate = 1500000)
    public void enviarNotificaciones() {
//    	System.err.println("Envío de notificaciones activado: " + this.schedulerEnabled);
    	if (this.schedulerEnabled) {
    		System.err.println("Enviando correos: " + DATE_FORMAT.format(new Date()));
    		System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    		SSLEmail enviarCorreo = new SSLEmail();
    		enviarCorreo.enviar();
    	}
    }
}
