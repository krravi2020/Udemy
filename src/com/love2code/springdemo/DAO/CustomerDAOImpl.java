package com.love2code.springdemo.DAO;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.love2code.springdemo.DAO.CustomerDAO;
import com.luv2code.springdemo.entity.Customers;


@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	public List<Customers> listCustomers() {
		
		
				// 1. Get the Hibernate Session from SessionFactory
		
				Session session=sessionFactory.getCurrentSession();
				
				// 2. Create Query
				
				Query<Customers> query=session.createQuery("from Customers order by first_name",Customers.class);
				
				// 3. Execute the Query & get the result
				List<Customers>customersList=query.getResultList();			
								
				// 4. return the result
				
				return customersList;
		
	}



	@Override
	public void saveCustomer(Customers theCustomer) {
		
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(theCustomer);
	}

	@Override
	public Customers getCustomer(int id) {
		Session session=sessionFactory.getCurrentSession();
		Customers customer=session.get(Customers.class,id);
		System.out.println("============="+customer);
		return customer;
	}



	@Override
	public Object deleteCustomer(int id) {
		Session session=sessionFactory.getCurrentSession();
		Query theQuery=session.createQuery("delete from Customers where id=:theCustomerId");
		theQuery.setParameter("theCustomerId", id);
		/*Customers customer=session.get(Customers.class,id);
		session.delete(customer);*/
		theQuery.executeUpdate();
		return "";
	}
	
}
