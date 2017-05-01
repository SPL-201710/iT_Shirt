package co.com.itshirt.variability.injection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier()
public class ReporteVentasBasicoService  implements IReportService {

    @Override
    public String greet() {
        return "Reporte ventas básico";
    }
}