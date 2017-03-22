package co.com.itshirt.api.util;

import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

public final class StringUtils {
	
	public static String getURLBase(HttpServletRequest request) throws MalformedURLException {
	    URL requestURL = new URL(request.getRequestURL().toString());
	    String port = requestURL.getPort() == -1 ? "" : ":" + requestURL.getPort();
	    return requestURL.getProtocol() + "://" + requestURL.getHost() + port;
	}

}