package co.com.itshirt.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.itshirt.annotation.OptionalFeature;
import co.com.itshirt.variability.injection.ReporteVentasAvanzadoService;
import co.com.itshirt.variability.injection.ReporteVentasBasicoService;
import co.com.itshirt.variability.injection.IReportService;

@OptionalFeature
@Configuration
public class ReportsConfig {

	@Bean("reporteVentas")
    @ConditionalOnProperty(name="config.reporteVentas", havingValue="basic", matchIfMissing = true)
    public IReportService reporteVentasBasico() {
        return new ReporteVentasAvanzadoService();
    }

    @Bean("reporteVentas")
    @ConditionalOnProperty(name="config.reporteVentas", havingValue="advanced")
    public IReportService reporteVentasAvanzado() {
        return new ReporteVentasAvanzadoService();
    }
}