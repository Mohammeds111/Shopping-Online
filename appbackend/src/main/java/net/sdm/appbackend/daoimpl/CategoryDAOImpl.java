package net.sdm.appbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.sdm.appbackend.dao.CategoryDAO;
import net.sdm.appbackend.dto.Category;
@Repository("CategoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories=new ArrayList<>();
	
	static{
		Category category=new Category();
		category.setId(1);
		category.setName("Television");
		category.setDescription("Description for TV");
		category.setImageURL("CAT_1.png");
		categories.add(category);
		
		category=new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("Description for mobile");
		category.setImageURL("CAT_2.png");
		categories.add(category);
		
		category=new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("Description for Laptop");
		category.setImageURL("CAT_3.png");
		categories.add(category);
	}
	
	@Override
	public List<Category> list() {
		
		return categories;
	}

}
