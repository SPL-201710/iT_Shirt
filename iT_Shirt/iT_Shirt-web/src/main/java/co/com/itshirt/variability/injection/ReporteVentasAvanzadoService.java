package co.com.itshirt.variability.injection;

import org.springframework.stereotype.Service;

@Service
public class ReporteVentasAvanzadoService implements IReportService {

    @Override
    public String greet() {
        return "Reporte ventas avanzado";
    }
    
}