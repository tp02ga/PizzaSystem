package com.coderscampus.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coderscampus.domain.Customer;
import com.coderscampus.repository.CustomerRepository;

@Controller
public class CustomerController
{
  
  @Autowired
  private CustomerRepository customerRepo;
  
  @RequestMapping(value="/", method=RequestMethod.GET)
  public String rootRedirect ()
  {
    return "redirect:/customers";
  }
  
  @RequestMapping(value="/customers", method=RequestMethod.GET)
  public String customers (ModelMap model)
  {
    Customer customer = new Customer();
    
    model.put("customer", customer);
    
    return "customers";
  }
  
  @RequestMapping(value="/customers", method=RequestMethod.POST)
  public String customersPost (HttpServletRequest request, @ModelAttribute Customer customer, ModelMap model)
  {
    Customer savedCustomer = customerRepo.save(customer);
    request.getSession().setAttribute("customer", savedCustomer);
    return "redirect:/orders";
  }
}
