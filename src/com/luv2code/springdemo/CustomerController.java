package com.luv2code.springdemo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.love2code.springdemo.DAO.CustomerDAO;
import com.love2code.springdemo.service.CustomerServiceDAO;
import com.luv2code.springdemo.entity.Customers;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//Inject the CustomerDAO bean
	@Autowired
	private CustomerServiceDAO customerServiceDAO;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel)
	{
		//Add the Customer list from DAO
		List<Customers> customersList=customerServiceDAO.listCustomers();
		System.out.println(customersList.toString()+"===============");
		theModel.addAttribute("customers",customersList);
		theModel.addAttribute("abd","Hello");
		return "customers-list";
	}	

	@GetMapping("/addForm")
	public String addCustomer(Model theModel)
	{
		Customers customer=new Customers();
		theModel.addAttribute("customers",customer);	
		
		return "add-customer";
	}
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customers") Customers theCustomer)
	{
			customerServiceDAO.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showUpdateForm")
	public String showUpdateForm(@RequestParam("customerId")int id,Model theModel)
	{
		Customers customers=customerServiceDAO.getCustomer(id);
		theModel.addAttribute("customers",customers);		
		return "add-customer";
	}
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int id,Model theModel)
	{
		customerServiceDAO.deleteCustomer(id);
		return "redirect:/customer/list";
	}	
}
