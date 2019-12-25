package net.sdm.onlineshopping.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException()
	{
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errorTitle", "The page is not constructed");
		mv.addObject("errorDescription", "The page your looking for is not available now!");
		mv.addObject("title","404 Error Page ");
		return mv;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException()
	{
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errorTitle", "Product not available");
		mv.addObject("errorDescription", "The Product your looking for is not available now!");
		mv.addObject("title","Prodcut Unavailable ");
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView commonException()
	{
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errorTitle", "Please Contact Administrator");
		mv.addObject("errorDescription", "your looking for is not available now!");
		mv.addObject("title","Error ");
		return mv;
	}
}
