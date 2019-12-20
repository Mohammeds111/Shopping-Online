package net.sdm.appbackend.dao;

import java.util.List;

import net.sdm.appbackend.dto.Product;

public interface ProductDAO {
	Product get(int productID);
	List<Product> list();
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
	//Business Methods
	List<Product> listActiveProducts();
	List<Product>  listActiveProductsByCategory(int categoryID);
	List<Product> getLatestActivePrducts(int count);
	
}
