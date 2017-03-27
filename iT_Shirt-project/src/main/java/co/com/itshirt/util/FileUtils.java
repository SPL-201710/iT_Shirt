package co.com.itshirt.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

/**
 * Utilidades manejo de archivos.
 * @author ja.picon
 *
 */
public abstract class FileUtils {
	
	public final static String RUTA_ESTAMPAS = "/resources/estampas/";
	
	/**
	 * Guardado de la imagen de la estampa.
	 * @param file
	 * @param idUsuario
	 * @param idEstampa
	 * @param request
	 */
	public static final void guardarArchivoEstampa(final MultipartFile file, Long idUsuario, Long idEstampa, HttpServletRequest request){
		if (!file.isEmpty()) {
            try {
                String uploadsDir = RUTA_ESTAMPAS + idUsuario;
                String realPathtoUploads =  request.getServletContext().getRealPath(uploadsDir);
                if(! new File(realPathtoUploads).exists())
                {
                    new File(realPathtoUploads).mkdir();
                }
                System.err.println("realPathtoUploads = {}" + realPathtoUploads);
                String[] fileFrags = file.getOriginalFilename().split("\\.");
                String extension = fileFrags[fileFrags.length-1];
                String filePath = realPathtoUploads + "/"+ idEstampa + "." + extension;
                File dest = new File(filePath);
                file.transferTo(dest);
            } catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
