package net.sdm.appbackend.dao;

import java.util.List;

import net.sdm.appbackend.dto.Category;

public interface CategoryDAO {
	
	
	
	Category getCategoryById(int id);
	List<Category> list();
    boolean addCategory(Category category);
    boolean update(Category category);
    boolean delete(Category category);
}
