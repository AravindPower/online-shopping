package com.spring.online.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundExceotion() {
		
		ModelAndView mv = new  ModelAndView("error");
		
		mv.addObject("errorTitle", "The page is not constructed");
		mv.addObject("errorDescription", "The page you are looking for is not availble now!");
		mv.addObject("title", "404 Error page");
		
		
		return mv;
		
		
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundExceotion() {
		
		ModelAndView mv = new  ModelAndView("error");
		
		mv.addObject("errorTitle", "Product not availble");
		mv.addObject("errorDescription", "The product you are looking for is not availble now!");
		mv.addObject("title", "Product unavailable");
		
		
		return mv;
		
		
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView HandlerException(Exception ex) {
		
ModelAndView mv = new  ModelAndView("error");
		
		mv.addObject("errorTitle", "contact your admin");
		
		
		//only for debugging application
		
//		StringWriter sw = new StringWriter();
//		PrintWriter pw = new PrintWriter(sw);
//		ex.printStackTrace(pw);
//		
		
		mv.addObject("errorDescription", ex.toString());
		mv.addObject("title", "Error");
		
		return mv;
		
	}

}
