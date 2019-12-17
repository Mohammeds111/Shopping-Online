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
	
	@Test
	public void testAddCategory(){
		 category=new Category();
		 category.setName("Mobile");
		 category.setDescription("Description for mobile");
		 category.setImageURL("CAT_2.png");
		 assertEquals("Succesfully added category inside table",true,categoryDAO.addCategory(category));
	}
}
