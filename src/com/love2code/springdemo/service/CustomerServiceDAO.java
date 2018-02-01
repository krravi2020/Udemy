package com.love2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Customers;

public interface CustomerServiceDAO {

	public List<Customers> listCustomers();

	public void saveCustomer(Customers theCustomer);

	public Customers getCustomer(int id);

	public Object deleteCustomer(int id);
	
	
}
