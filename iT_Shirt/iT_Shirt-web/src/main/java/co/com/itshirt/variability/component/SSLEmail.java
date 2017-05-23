package co.com.itshirt.variability.component;


import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class SSLEmail {
 
	/**
	   Outgoing Mail (SMTP) Server
	   requires TLS or SSL: smtp.gmail.com (use authentication)
	   Use Authentication: Yes
	   Port for SSL: 465
	 */
	
	List <String> correos;
	String temaEstamapa;
	String nombreUsuario;
	String urlEstampa;
	
	public SSLEmail(List <String> correos,String temaEstamapa){
		this.correos=correos;
		this.temaEstamapa=temaEstamapa;
		
		
	}
	
	public void enviar(){

		final String fromEmail = "itshirtcontact@gmail.com"; //requires valid gmail id
		final String password = "Fabricas2017"; // correct password for gmail id
		final String toEmail = "piconjulian03@gmail.com"; // can be any email id 
		
		System.out.println("SSLEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
		props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
		props.put("mail.smtp.port", "465"); //SMTP Port
		
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		  
		
		
		Session session = Session.getDefaultInstance(props, auth);
		System.out.println("Session created");
	        EmailUtil.sendEmail(session, toEmail,"Se ha creado una nueva estampa!!!", "Una nueva estampa se ha creado!!! entra a it_shirt y comprala!");

	      //  EmailUtil.sendAttachmentEmail(session, toEmail,"SSLEmail Testing Subject with Attachment", "SSLEmail Testing Body with Attachment");

	        //EmailUtil.sendImageEmail(session, toEmail,"SSLEmail Testing Subject with Image", "SSLEmail Testing Body with Image");

	
	}
	
	public void enviarTodosMejorado(){
		
		String temaEstampa=this.temaEstamapa;
		List <String> correosAll = this.correos;
		final String fromEmail = "itshirtcontact@gmail.com"; //requires valid gmail id
		final String password = "Fabricas2017"; // correct password for gmail id
		//final String toEmail = "piconjulian03@gmail.com"; // can be any email id 
		
		for(int i=0;i<correosAll.size();i++){
		
		System.out.println("SSLEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
		props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
		props.put("mail.smtp.port", "465"); //SMTP Port
		
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		  
		
		
		Session session = Session.getDefaultInstance(props, auth);
		System.out.println("Session created");
		System.out.println("Se enviara correo a: "+correosAll.get(i));
	        //EmailUtil.sendEmail(session, toEmail,"Se ha creado una nueva estampa!!!", "Una nueva estampa se ha creado!!! entra a it_shirt y comprala!");
	        EmailUtil.sendAttachmentEmail(session, correosAll.get(i),"Una estampa de tus temas favoritos ha sido creada!!!",
	        		"Hola "+correosAll.get(i)+"\nUna nueva estampa, de uno de tus temas favoritos: "+temaEstampa+""
	        				+ "\nHa sido creada!!!!\n"
	        				+ "\nEntra a iT_Shirt y obtenla con tus camisas que más te gusten!!!");
	      //  EmailUtil.sendAttachmentEmail(session, toEmail,"SSLEmail Testing Subject with Attachment", "SSLEmail Testing Body with Attachment");

	        //EmailUtil.sendImageEmail(session, toEmail,"SSLEmail Testing Subject with Image", "SSLEmail Testing Body with Image");

		}
	
	}
	
	public void enviarTodos(){
		List <String> correosAll = this.correos;
		final String fromEmail = "itshirtcontact@gmail.com"; //requires valid gmail id
		final String password = "Fabricas2017"; // correct password for gmail id
		//final String toEmail = "piconjulian03@gmail.com"; // can be any email id 
		
		for(int i=0;i<correosAll.size();i++){
		
		System.out.println("SSLEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
		props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
		props.put("mail.smtp.port", "465"); //SMTP Port
		
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		  
		
		
		Session session = Session.getDefaultInstance(props, auth);
		System.out.println("Session created");
		System.out.println("Se enviara correo a: "+correosAll.get(i));
	        //EmailUtil.sendEmail(session, toEmail,"Se ha creado una nueva estampa!!!", "Una nueva estampa se ha creado!!! entra a it_shirt y comprala!");
	        EmailUtil.sendEmail(session, correosAll.get(i),"Se ha creado una nueva estampa!!!", "Una nueva estampa se ha creado!!! entra a it_shirt y comprala!");
	      //  EmailUtil.sendAttachmentEmail(session, toEmail,"SSLEmail Testing Subject with Attachment", "SSLEmail Testing Body with Attachment");

	        //EmailUtil.sendImageEmail(session, toEmail,"SSLEmail Testing Subject with Image", "SSLEmail Testing Body with Image");

		}
	}
	
	public static void main() {
		final String fromEmail = "itshirtcontact@gmail.com"; //requires valid gmail id
		final String password = "Fabricas2017"; // correct password for gmail id
		final String toEmail = "piconjulian03@gmail.com"; // can be any email id 
		
		System.out.println("SSLEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
		props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
		props.put("mail.smtp.port", "465"); //SMTP Port
		
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		  
		Session session = Session.getDefaultInstance(props, auth);
		System.out.println("Session created");
	        EmailUtil.sendEmail(session, toEmail,"Se ha creado una nueva estampa!!!", "Una nueva estampa se ha creado!!! entra a it_shirt y comprala!");

	      //  EmailUtil.sendAttachmentEmail(session, toEmail,"SSLEmail Testing Subject with Attachment", "SSLEmail Testing Body with Attachment");

	        //EmailUtil.sendImageEmail(session, toEmail,"SSLEmail Testing Subject with Image", "SSLEmail Testing Body with Image");

	}
	

}