package net.sdm.appbackend.test;


import static org.junit.Assert.assertEquals;
import net.sdm.appbackend.dao.UserDAO;


import net.sdm.appbackend.dto.Address;
import net.sdm.appbackend.dto.Cart;
import net.sdm.appbackend.dto.User;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserTestCase {
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user ;
	private Cart cart;
	private Address address;
	
	@BeforeClass
	public static void init(){
		context=new AnnotationConfigApplicationContext();
	    context.scan("net.sdm.appbackend");
	    context.refresh();
	    userDAO=(UserDAO)context.getBean("userDAO");
	}
	@Test
	public void TestUser()
	{
		user =new User();
		user.setContactNumber("8438328888");
		user.setEmail("Sadam.mohamme@gmail.com");
		user.setFirstname("mohammed");
		user.setLastname("sadam");
		user.setPassword("12345");
		user.setRole("USER");
		assertEquals("Failed to add User",true,userDAO.addUser(user));
		
		address=new Address();
		address.setAddressLineOne("611,South Street");
		address.setAddressLineTwo("south Street,Kottaippatinam");
		address.setBilling(true);
		address.setCity("pudukottai");
		address.setCountry("India");
		address.setPostalCode("614619");
		address.setState("Tamilnadu");
		address.setUserId(user.getId());
		assertEquals("Failed to add address",true,userDAO.addAddress(address));
		
		
		if(user.getRole().equals("USER"))
		{
			
			cart=new Cart();
			cart.setUserId(user.getId());
			assertEquals("Failed to add Cart",true,userDAO.addCart(cart));
			
			address=new Address();
			address.setAddressLineOne("612,South Street");
			address.setAddressLineTwo("south Street,Kottaippatinam");
			address.setShipping(true);
			address.setCity("pudukottai");
			address.setCountry("India");
			address.setPostalCode("614619");
			address.setState("Tamilnadu");
			address.setUserId(user.getId());
			assertEquals("Failed to add address",true,userDAO.addAddress(address));
		}
		
	}
}
