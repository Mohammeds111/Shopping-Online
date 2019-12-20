package net.sdm.appbackend.test;



import static org.junit.Assert.*;
import net.sdm.appbackend.dao.ProductDAO;
import net.sdm.appbackend.dto.Product;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductTestCase {
	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product ;
	
	@BeforeClass
	public static void init(){
		context=new AnnotationConfigApplicationContext();
	    context.scan("net.sdm.appbackend");
	    context.refresh();
	    productDAO=(ProductDAO)context.getBean("ProductDAO");
	}
	
	/*@Test
	public void addProduct(){
		product=new Product();
		product.setActive(true);
		product.setBrand("Samsung");
		product.setCategoryId(3);
		product.setDescription("Latest Best mobile");
		product.setName("S8");
		product.setSupplierId(2);
		product.setUnitPrice(50000);
		product.setQuantity(5);
		
		assertEquals("Something went wrong while inserting ",true,productDAO.add(product));
		
		
		
		
		
	}*/
	
	@Test 
	public void CRUDForProduct(){
		product=productDAO.get(3);
		product.setName("Galaxy S8");
		assertEquals("Something went wrong while updating or fetching product ",true,productDAO.update(product));
		assertEquals("Something went wrong while updating or deleting product ",true,productDAO.delete(product));
		assertEquals("Something went wrong while fetching all product ",3,productDAO.list().size());
		assertEquals("Something went wrong while fetching active product ",2,productDAO.listActiveProducts().size());
		assertEquals("Something went wrong while fetching active product based on category id ",1,productDAO.listActiveProductsByCategory(3).size());
		assertEquals("Something went wrong while fetching latest active product ",2,productDAO.getLatestActivePrducts(2).size());
		
	}
	
	
}
