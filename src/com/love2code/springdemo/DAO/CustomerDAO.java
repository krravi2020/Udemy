package com.love2code.springdemo.DAO;

import java.util.List;

import com.luv2code.springdemo.entity.Customers;

public interface CustomerDAO {

	public List<Customers> listCustomers();

	public void saveCustomer(Customers theCustomer);

	public Customers getCustomer(int id);

	public Object deleteCustomer(int id);
	
}
