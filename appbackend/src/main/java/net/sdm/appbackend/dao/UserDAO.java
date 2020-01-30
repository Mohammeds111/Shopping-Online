package net.sdm.appbackend.dao;

import net.sdm.appbackend.dto.Address;
import net.sdm.appbackend.dto.Cart;
import net.sdm.appbackend.dto.User;

public interface UserDAO {
	
	boolean addUser(User user);
	boolean addAddress(Address address);
	boolean addCart(Cart cart);
	

}
