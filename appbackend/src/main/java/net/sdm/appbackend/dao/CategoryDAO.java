package net.sdm.appbackend.dao;

import java.util.List;

import net.sdm.appbackend.dto.Category;

public interface CategoryDAO {
	
	List<Category> list();

	Category getCategoryById(int id);

	boolean addCategory(Category category);
}
