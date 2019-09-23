package net.sdm.onlineshopping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@RequestMapping(value={"/","index","page"})
	public ModelAndView firstPage()
	{
		ModelAndView mvc=new ModelAndView("Page");
		mvc.addObject("welcome", "Welcome To Shopping");
		return mvc;
	}
	
	

}
