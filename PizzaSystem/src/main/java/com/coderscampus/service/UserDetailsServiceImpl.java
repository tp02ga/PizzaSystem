package com.coderscampus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.coderscampus.domain.Customer;
import com.coderscampus.repository.CustomerRepository;
import com.coderscampus.security.CustomUserDetails;

@Service
public class UserDetailsServiceImpl implements UserDetailsService
{
  private CustomerRepository customerRepo;
  
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
  {
    Customer customer = customerRepo.findByEmailAddress(username);
    if (customer == null)
      throw new UsernameNotFoundException("Username " + username + " not found.");
    else
      return new CustomUserDetails(customer);
  }
  @Autowired
  public void setCustomerRepo(CustomerRepository customerRepo)
  {
    this.customerRepo = customerRepo;
  }
  
}
