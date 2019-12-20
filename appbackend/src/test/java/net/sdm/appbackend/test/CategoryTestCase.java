package net.sdm.appbackend.test;



import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.sdm.appbackend.dao.CategoryDAO;
import net.sdm.appbackend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category ;
	
	@BeforeClass
	public static void init(){
		context=new AnnotationConfigApplicationContext();
	    context.scan("net.sdm.appbackend");
	    context.refresh();
	    categoryDAO=(CategoryDAO)context.getBean("CategoryDAO");
	}
	
	/*@Test
	public void testAddCategory(){
		 category=new Category();
		 category.setName("Mobile");
		 category.setDescription("Description for mobile");
		 category.setImageURL("CAT_2.png");
		 assertEquals("Succesfully added category inside table",true,categoryDAO.addCategory(category));
	}*/
	
	/*@Test
	public void testGetCategory(){
		 
		category=categoryDAO.getCategoryById(1);
		 
		 assertEquals("Succesfully feched category","Mobile",category.getName());
	}*/
	
	/*@Test
	public void testUpdateCategory(){
		 
		category=categoryDAO.getCategoryById(1);
		category.setName("Mobi");
		 
		 assertEquals("Succesfully updated category",true,categoryDAO.update(category));
	}*/
	
/*	@Test
	public void testSoftDeleteCategory(){
		 
		category=categoryDAO.getCategoryById(1);
		 
		 assertEquals("Succesfully updated category",true,categoryDAO.delete(category));
	}*/
	
	/*@Test
	public void testGetListOfCategory(){
		
		 
		 assertEquals("Succesfully fetched List of category",2,categoryDAO.list().size());
	}*/
	
	@Test
	public void testCRUDForCategory(){
		 
		category=categoryDAO.getCategoryById(2);
		 category.setName("TV");
		 assertEquals("Succesfully Comppled CRUD Test for category",true,categoryDAO.update(category));
		 assertEquals("Succesfully Comppled CRUD Test for category",true,categoryDAO.delete(category));
		 assertEquals("Succesfully Comppled CRUD Test for category",1,categoryDAO.list().size());
	}
	
}
