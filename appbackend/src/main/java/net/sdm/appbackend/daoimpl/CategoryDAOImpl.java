package net.sdm.appbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import net.sdm.appbackend.dao.CategoryDAO;
import net.sdm.appbackend.dto.Category;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository("CategoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionfactory;
	
	private static List<Category> categories=new ArrayList<>();
	

	
	@Override
	public List<Category> list() {
		String selectActiveCategory="from Category where active=:active";
		Query query=sessionfactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		return query.getResultList();
	}

	@Override
	public Category getCategoryById(int id) {
		Category category=sessionfactory.getCurrentSession().get(Category.class,Integer.valueOf(id) );
		return category;	
	}

	@Override
	
	public boolean addCategory(Category category) {
		try{
			
			sessionfactory.getCurrentSession().persist(category);
			return true;
		}
		catch(Exception E)
		{
			E.printStackTrace();
			return false;
		}
	
	}

	@Override
	public boolean update(Category category) {
try{
			
			sessionfactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception E)
		{
			E.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
try{
	        category.setActive(false);
			sessionfactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception E)
		{
			E.printStackTrace();
			return false;
		}
	}

}
