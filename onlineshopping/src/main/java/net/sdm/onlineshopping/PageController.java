package net.sdm.onlineshopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.sdm.appbackend.dao.CategoryDAO;

@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value={"/","index","page"})
	public ModelAndView firstPage()
	{
		ModelAndView mvc=new ModelAndView("page");
		mvc.addObject("userClickHome", true);
		mvc.addObject("title", "Home");
		mvc.addObject("categories", categoryDAO.list());
		
		return mvc;
	}
	@RequestMapping(value="/contact")
	public ModelAndView about()
	{
		ModelAndView mvc=new ModelAndView("page");
		mvc.addObject("userClickContact", true);
		mvc.addObject("title", "Contact");
		return mvc;
	}
	@RequestMapping(value="/about")
	public ModelAndView contact()
	{
		ModelAndView mvc=new ModelAndView("page");
		mvc.addObject("userClickAbout", true);
		mvc.addObject("title", "About");
		return mvc;
	}
	
	

}
