package co.com.itshirt.admin.controller.exception;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionHandlerController {

    public static final String DEFAULT_ERROR_VIEW = "/pages/common/error";

    @ExceptionHandler(Throwable.class)
    public String handleAnyException(Throwable ex, HttpServletRequest request) {
    	System.err.println("ExceptionHandlerController 1. ::::::");
    	ex.printStackTrace();
        ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);
        mav.addObject("datetime", new Date());
        mav.addObject("exception", ex.getMessage());
        mav.addObject("url", request.getRequestURL());
        return DEFAULT_ERROR_VIEW;
    }
    
    @ExceptionHandler(value = {Exception.class, RuntimeException.class})
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) {
    	System.err.println("ExceptionHandlerController ::::::");
    	e.printStackTrace();
        ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);
        mav.addObject("datetime", new Date());
        mav.addObject("exception", e);
        mav.addObject("url", request.getRequestURL());
        return mav;
    }
    
    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handleError404(HttpServletRequest request, Exception e)   {
            ModelAndView mav = new ModelAndView("/404");
            mav.addObject("exception", e);  
            //mav.addObject("errorcode", "404");
            return mav;
    }
}