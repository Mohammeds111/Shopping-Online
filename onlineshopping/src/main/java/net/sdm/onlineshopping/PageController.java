package net.sdm.onlineshopping;

import net.sdm.appbackend.dao.CategoryDAO;
import net.sdm.appbackend.dao.ProductDAO;
import net.sdm.appbackend.dto.Category;
import net.sdm.appbackend.dto.Product;
import net.sdm.onlineshopping.exception.ProductNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value = {"/", "/home", "/index"})
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
		mvc.addObject("title", "Contact Us");
		return mvc;
	}
	@RequestMapping(value="/about")
	public ModelAndView contact()
	{
		ModelAndView mvc=new ModelAndView("page");
		mvc.addObject("userClickAbout", true);
		mvc.addObject("title", "About Us");
		return mvc;
	}
	
	@RequestMapping(value="/show/all/products")
	public ModelAndView showAllProduct()
	{
		ModelAndView mvc=new ModelAndView("page");
		mvc.addObject("userClickAllProducts", true);
		mvc.addObject("title", "All Products");
		mvc.addObject("categories", categoryDAO.list());
		return mvc;
	}
	
	@RequestMapping(value="/show/category/{id}/products")
	public ModelAndView showCategoryProduct(@PathVariable("id") int id)
	{
		ModelAndView mvc=new ModelAndView("page");
		
		Category category=null;
		category=categoryDAO.getCategoryById(id);
		mvc.addObject("userClickCategoryProducts", true);
		mvc.addObject("title", category.getName());
		mvc.addObject("categories", categoryDAO.list());
		mvc.addObject("category", category);
		return mvc;
	}
	@RequestMapping(value="/show/{id}/product")
	public ModelAndView showProductById(@PathVariable("id") int id) throws ProductNotFoundException
	{
		ModelAndView mvc=new ModelAndView("page");
		
		Product product=null;
		product=productDAO.get(id);
		
		if(product==null)
		{
			
			throw new ProductNotFoundException();
		}
		product.setViews(product.getViews()+1);
		productDAO.update(product);
		mvc.addObject("userClickShowProduct",true);
		mvc.addObject("title",product.getName());
		mvc.addObject("product",product);
		return mvc;
	}
	

}
