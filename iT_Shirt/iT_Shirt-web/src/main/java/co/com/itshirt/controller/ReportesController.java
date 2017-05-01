package co.com.itshirt.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import co.com.itshirt.annotation.OptionalFeature;
import co.com.itshirt.repository.UserRepository;
//import net.sf.jasperreports.engine.JREmptyDataSource;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperExportManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//import net.sf.jasperreports.engine.util.JRLoader;

/**
 * Controlador generador de reportes.
 * @author ja.picon
 *
 */
@OptionalFeature
@Controller
public class ReportesController {
	
	@Autowired
    private ApplicationContext appContext;
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="/admin/reportes", method = RequestMethod.GET)
	public String reportesAdministrador(ModelMap model, HttpSession session) {
		return "reporte/reportes";
	}
	
	@RequestMapping(value="/artista/reportes", method = RequestMethod.GET)
	public String reportesArtista(ModelMap model, HttpSession session) {
		return "reporte/reportes";
	}
	
	@RequestMapping(value = "/pdf", method = RequestMethod.GET)
	public ModelAndView report() {
	    JasperReportsPdfView view = new JasperReportsPdfView();
	    view.setUrl("classpath:/reports/report1.jrxml");
	    view.setApplicationContext(appContext);

	    Map<String, Object> params = new HashMap<>();
	    params.put("datasource", userRepository.findAll());

	    return new ModelAndView(view, params);
	}
//	
//	@RequestMapping(value = "report2", method = RequestMethod.GET)
//	  @ResponseBody
//	  public void getRpt1(HttpServletResponse response) throws JRException, IOException {
//	    InputStream jasperStream = this.getClass().getResourceAsStream("src/main/resources/reports/report1.jasper");
//	    Map<String,Object> params = new HashMap<>();
//	    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
//	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());
//
//	    response.setContentType("application/x-pdf");
//	    response.setHeader("Content-disposition", "inline; filename=helloWorldReport.pdf");
//
//	    final OutputStream outStream = response.getOutputStream();
//	    JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
//	  }
//	
//	@RequestMapping(value = "report", method = RequestMethod.GET)
//	  @ResponseBody
//	  public void getRpt21(HttpServletResponse response) throws JRException, IOException {
//	    Map<String,Object> params = new HashMap<>();
//	    JasperReport jasperReport = JasperCompileManager
//	    		.compileReport("src/main/resources/reports/report1.jrxml");
//	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());
//
//	    response.setContentType("application/x-pdf");
//	    response.setHeader("Content-disposition", "inline; filename=helloWorldReport.pdf");
//
//	    final OutputStream outStream = response.getOutputStream();
//	    JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
//	  }
//	
//	@RequestMapping(value = "report3", method = RequestMethod.GET)
//	public ResponseEntity<byte[]> prueba() throws JRException {
//		String jasperAdi = "report1.jasper";
//		StringBuffer pathMain = new StringBuffer();
//		pathMain.append(this.getClass().getResource("/reports/").getPath());
//		System.err.println(pathMain.toString());
//		String jasperFileName = pathMain.toString() + File.separator + jasperAdi;
//		File jasperFile = new File(jasperFileName);
//		 Map<String,Object> params = new HashMap<>();
//		JasperReport report = (JasperReport) JRLoader.loadObject(jasperFile);
//		JasperPrint jasperPrint = JasperFillManager.fillReport(report, params, new JREmptyDataSource());
//		if (jasperPrint != null) {
//		    byte[] pdfReport = JasperExportManager.exportReportToPdf(jasperPrint);
//		    HttpHeaders headers = new HttpHeaders();
//		    headers.setContentType(MediaType.parseMediaType("application/pdf"));
//		    headers.setContentDispositionFormData("yillikPlan.pdf", "yillikPlan.pdf");
//		    ResponseEntity<byte[]> respon = new ResponseEntity<byte[]>(pdfReport, headers, HttpStatus.OK);
//		    return respon;
//
//		}
//		return null;
//	}
	
	
	
}
