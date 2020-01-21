package net.sdm.onlineshopping;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sdm.appbackend.dao.CategoryDAO;
import net.sdm.appbackend.dao.ProductDAO;
import net.sdm.appbackend.dto.Category;
import net.sdm.appbackend.dto.Product;
import net.sdm.onlineshopping.util.FileUploadUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value="/{id}/product" , method=RequestMethod.GET)
	public ModelAndView showEditProduct(@PathVariable("id") int id)
	{
		ModelAndView mv= new ModelAndView("page");
		mv.addObject("userClickManageProduct", true);
		mv.addObject("title", "Manage Products");
		Product nProduct=productDAO.get(id);
		
		mv.addObject("product",nProduct);	
		return mv;
	}
	
	@ModelAttribute("Categories")
	public List<Category> getCategoryList()
	{
		return categoryDAO.list() ;
	}
	
	
	@RequestMapping(value="/products" ,method=RequestMethod.POST)
	public String handleProductSubmission(@ModelAttribute("product") Product mproduct,HttpServletRequest request)
	{
	
		if(mproduct.getId()==0)
		{
		productDAO.add(mproduct);
		}
		else
		{
			productDAO.update(mproduct);
		}
		if(!mproduct.getFile().getOriginalFilename().equals(""))
		{
			FileUploadUtility.uploadFile(request,mproduct.getFile(),mproduct.getCode());
		}
		
		return "redirect:/manage/products?Operation=product"  ;
	}
	
	
	@RequestMapping(value="/product/{id}/activation" ,method=RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable("id") int id)
	{
		Product product=productDAO.get(id);
		boolean isActive=product.isActive();
		product.setActive(!product.isActive());
		productDAO.update(product);
		
		return (isActive)?
				"You have succesfully deactivated the Product" + product.getId()
		        : "You have succesfully activated the Product" + product.getId();
	}
	

}
