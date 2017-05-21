package co.com.itshirt.processor;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import javax.tools.FileObject;
import javax.tools.StandardLocation;

import co.com.itshirt.annotation.Feature;
import co.com.itshirt.processor.enums.OptionalFeatures;
import co.com.itshirt.processor.util.FeatureList;

@SupportedAnnotationTypes("co.com.itshirt.annotation.Feature")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class FeatureProcessor extends AbstractProcessor {
	
	@Override
	 public void init(ProcessingEnvironment processingEnv) {
		super.init(processingEnv);
		System.err.println("iT_Shirt Processor Init.");
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    	try {
    		for (final Element element : roundEnv.getElementsAnnotatedWith(Feature.class)) {
        		final List<String> features = FeatureList.getInstance().optionalFeatures();
//        		System.err.println("-------------- " + element + " ---------");
    			final FileObject fa = processingEnv.getFiler().createResource(StandardLocation.CLASS_OUTPUT, "", "config.properties");
                processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "Creating FILE " + fa.toUri());
                final Writer w = fa.openWriter();
        		try {
                    PrintWriter pw = new PrintWriter(w);
                    pw.println("# Archivo generado a partir de modelo FeatureIDE.");
                    pw.println();
                    for (final OptionalFeatures optionalFeature : OptionalFeatures.VALUES) {
                    	
                    	 pw.print("config."); //Arma una propiedad de tipo: config.AdvancedSearch = false
                    	 pw.print(optionalFeature.getName().substring(0, 1).toLowerCase() + optionalFeature.getName().substring(1));
                    	 pw.print(" = ");
                    	 pw.print(features.contains(optionalFeature.getName()));
                    	 pw.println();
                    }
                    pw.flush();
                } finally {
                    w.close();
                }
        	}
        	this.processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "iTShirt Processor  !!");
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
        return true;
    }
}