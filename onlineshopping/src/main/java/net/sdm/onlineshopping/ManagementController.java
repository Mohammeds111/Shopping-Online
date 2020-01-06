package net.sdm.onlineshopping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.sdm.appbackend.dao.CategoryDAO;
import net.sdm.appbackend.dao.ProductDAO;
import net.sdm.appbackend.dto.Category;
import net.sdm.appbackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired 
	private ProductDAO productDAO;
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView showManageProduct(@RequestParam(name="Operation",required=false) String operation){
		ModelAndView mv= new ModelAndView("page");
		mv.addObject("userClickManageProduct", true);
		mv.addObject("title", "Manage Products");
		Product nProduct=new Product();
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		mv.addObject("product",nProduct);
		
		if(operation!=null)
		{
			mv.addObject("message", "Product Successfully Added");
		}
		
		return mv;
	}
	
	@ModelAttribute("Categories")
	public List<Category> getCategoryList()
	{
		return categoryDAO.list();
	}
	
	
	@RequestMapping(value="/products" ,method=RequestMethod.POST)
	public String handleProductSubmission(@ModelAttribute("product") Product mproduct)
	{
	
		productDAO.add(mproduct);
		return "redirect:/manage/products?Operation=product";
	}
	
	
	
	
	

}
