package net.sdm.onlineshopping;

import java.util.List;

import net.sdm.appbackend.dao.ProductDAO;
import net.sdm.appbackend.dto.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProduct()
	{
	return productDAO.listActiveProducts();
	
	}
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getProductByCategoryId(@PathVariable int id)
	{
	return productDAO.listActiveProductsByCategory(id);
	
	}
	
	@RequestMapping("/admin/all/products")
	@ResponseBody
	public List<Product> getAllProducts()
	{
	return productDAO.list();
	
	}
}
