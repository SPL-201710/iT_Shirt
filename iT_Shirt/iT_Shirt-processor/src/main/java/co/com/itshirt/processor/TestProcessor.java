package co.com.itshirt.processor;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Properties;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import javax.tools.FileObject;
import javax.tools.JavaFileObject;
//import javax.tools.StandardLocation;
import javax.tools.StandardLocation;

import co.com.itshirt.annotation.Feature;

@SupportedAnnotationTypes("co.com.itshirt.annotation.Feature")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class TestProcessor extends AbstractProcessor {
	
	@Override
	 public void init(ProcessingEnvironment processingEnv) {
		super.init(processingEnv);
			System.out.println("INIT--------------------");
//		try {
//			FileObject fileObject = processingEnv.getFiler().getResource(StandardLocation.CLASS_OUTPUT, "com.olivierlafleur.guicetest", "Main.class");
////			FileObject fileObject = processingEnv.getFiler().getResource( StandardLocation.CLASS_OUTPUT , "", "config.properties" );
////	            BufferedWriter props = new BufferedWriter(fileObject.openWriter()); ;
//	            InputStream jsonStream = fileObject.openInputStream();
//	            OutputStream os = fileObject.openOutputStream();
//	            jsonStream.close();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
		
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    	System.err.println(roundEnv);
    	System.err.println(annotations);
        for(Element element : roundEnv.getElementsAnnotatedWith(Feature.class)) {
            for(Element element1 : element.getEnclosedElements()) {
            	try {
            		System.err.println("Truc : " + element1.getSimpleName());
            		System.err.println("replace++++ " + element.asType().toString().replace(".", "/") + ".java");
					FileObject in_file = processingEnv.getFiler().getResource(
					        StandardLocation.CLASS_OUTPUT, "",
					        element.asType().toString().replace(".", "/") + ".java");
//					FileObject out_file = processingEnv.getFiler().getResource(
//		                    StandardLocation.SOURCE_OUTPUT, "",
//		                    element.asType().toString().replace(".", "/") + ".java");
//
//		                //if (out_file.getLastModified() >= in_file.getLastModified()) continue;
//
//		                CharSequence data = in_file.getCharContent(false);
//
//		                JavaFileObject out_file2 = processingEnv.getFiler().createSourceFile(
//		                    element.asType().toString(), element);
//		                Writer w = out_file2.openWriter();
//		                w.append(data);
//		                w.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
            

            if (element.getKind() == ElementKind.CLASS) {
                TypeElement classElement = (TypeElement) element;
                System.err.println(classElement.getSimpleName());
                PackageElement packageElement = (PackageElement) element.getEnclosingElement();
                try {
                    JavaFileObject jfo = processingEnv.getFiler().createSourceFile("_"+classElement.getQualifiedName() + "GEN");
                    BufferedWriter bw = new BufferedWriter(jfo.openWriter());
                    bw.append("package ");
                    bw.append(packageElement.getQualifiedName());
                    bw.append(";");
                    bw.newLine();
                    bw.newLine();
                    bw.append("class _"+classElement.getSimpleName()+"GEN { private String nombre; }");
                    bw.close();
                    
                    JavaFileObject jf = processingEnv.getFiler().createSourceFile("DynamicTest");
                    bw = new BufferedWriter(jf.openWriter());
                    bw.append("package ");
                    bw.append(packageElement.getQualifiedName());
                    bw.append(";");
                    bw.newLine();
                    bw.append("class DynamicTest { private String nombre; }");
                    bw.close();
                    
//                    FileObject fileObject = processingEnv.getFiler()
//                        .getResource( StandardLocation.SOURCE_PATH , "", "config.properties" );
////                    BufferedWriter props = new BufferedWriter(fileObject.openWriter()); ;
//                    InputStream jsonStream = fileObject.openInputStream();
//                    OutputStream os = fileObject.openOutputStream();
//                    jsonStream.close();
                    
                    Properties prop = new Properties();  
                    try {  
                        // set the properties value  
                        prop.setProperty("Gujarat", "Gandhinagar");  
                        prop.setProperty("Maharashtra", "Mumbai");  
                        prop.setProperty("Madhya_Pradesh", "Indore");  
                        prop.setProperty("Rajasthan", "Jaipur");  
                        prop.setProperty("Punjab", "mkyong");  
                        prop.setProperty("Uttar_Pradesh", "Lucknow");  
                        // save properties to project root folder  
                        prop.store(new FileOutputStream("capitals.properties"), null);  
                    } catch (IOException ex) {  
                        ex.printStackTrace();  
                    }  
                    
                    try {
                    	
                    	FileObject fa = processingEnv.getFiler().
                                createResource(StandardLocation.CLASS_OUTPUT, "", "blabla.txt");
                        processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE,
                                "Creating FILE " + fa.toUri());
                        
                        JavaFileObject f = processingEnv.getFiler().
                                createSourceFile("in.test.ExtraClass");
                        processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE,
                                "Creating " + f.toUri());
                        Writer w = f.openWriter();
                        try {
                            PrintWriter pw = new PrintWriter(w);
                            pw.println("package in.test;");
                            pw.println("public class ExtraClass {");
                            pw.println("    public void print() {");
                            pw.println("        System.out.println(\"Hello boss!\");");
                            pw.println("    }");
                            pw.println("}");
                            pw.flush();
                        } finally {
                            w.close();
                        }
                        
                        Boolean result = Boolean.TRUE;
                        	    Messager consoleLogger = processingEnv.getMessager();
                        	    try{
                        	        Filer filer = processingEnv.getFiler();
                        	        //JavaFileObject o = filer.createSourceFile("org.example.generated."+
                        	        //element.getSimpleName()+".sql");
                        	        FileObject o = filer.createResource(StandardLocation.SOURCE_OUTPUT,
                        	        "org.example.generated",element.getSimpleName()+".sql");
                        	        Writer wr = o.openWriter();

                        	        //w.append("CREATE TABLE "+element.getAnnotation(Patate.class).name());
                        	        wr.append("CREATE TABLE "+element.getSimpleName());
                        	        wr.flush();
                        	        wr.close();
                        	        consoleLogger.printMessage(Diagnostic.Kind.NOTE,"File finished");
                        	      }
                        	     catch (IOException ex){
                        	      consoleLogger.printMessage(Diagnostic.Kind.NOTE,ex.getMessage());
                        	    }
                    
                    } catch (IOException x) {
                        processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
                                x.toString());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }

        processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "PATATE !!");

        return true;
    }
}