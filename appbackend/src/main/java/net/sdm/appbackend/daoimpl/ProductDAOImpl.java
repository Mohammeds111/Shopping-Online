package net.sdm.appbackend.daoimpl;

import java.util.List;

import net.sdm.appbackend.dao.ProductDAO;
import net.sdm.appbackend.dto.Product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository("ProductDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
@Autowired
SessionFactory sessionfactory;
	@Override
	public Product get(int productID) {
		return sessionfactory.getCurrentSession().get(Product.class,Integer.valueOf(productID));
		 
	}

	@Override
	public List<Product> list() {
		return sessionfactory.getCurrentSession().createQuery("from Product",Product.class).getResultList();
		
	}

	@Override
	public boolean add(Product product) {
		try{
		sessionfactory.getCurrentSession().persist(product);
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean update(Product product) {
		try{
		sessionfactory.getCurrentSession().update(product);
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Product product) {
		product.setActive(false);
		return this.update(product);
	}

	@Override
	public List<Product> listActiveProducts() {
		Session session=sessionfactory.getCurrentSession();
		Query query=session.createQuery("from Product where active=:active",Product.class);
		query.setParameter("active", true);
		return query.getResultList();
	}
 
	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		
		return sessionfactory.getCurrentSession()
				                  .createQuery("from Product where active=:active and categoryId=:categoryID",Product.class)
				                  .setParameter("active", true)
				                  .setParameter("categoryID", categoryId)
				                    .getResultList();
	}

	@Override
	public List<Product> getLatestActivePrducts(int count) {
		
		 return sessionfactory.getCurrentSession()
                .createQuery("from Product where active=:active order by id",Product.class)
                .setParameter("active", true)
                .setFirstResult(0)
                .setMaxResults(count)
                   .getResultList();
        
	}

}
