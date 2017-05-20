package co.com.itshirt.processor;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

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
    	
    	this.processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "iTShirt Processor  !!");
        return true;
    }
}