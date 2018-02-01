package com.love2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.love2code.springdemo.DAO.CustomerDAO;
import com.luv2code.springdemo.entity.Customers;

@Service
public class CustmoerServiceDAPImpl implements CustomerServiceDAO {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customers> listCustomers() {
		return customerDAO.listCustomers();
		
	}

	@Override
	@Transactional
	public void saveCustomer(Customers theCustomer) {
		customerDAO.saveCustomer(theCustomer);
		
	}

	@Override
	@Transactional
	public Customers getCustomer(int id) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomer(id);
	}

	@Override
	@Transactional
	public Object deleteCustomer(int id) {
		return customerDAO.deleteCustomer(id);
		
	}	

}
