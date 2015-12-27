package com.coderscampus.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer
{
  private Long id;
  private String firstName;
  private String lastName;
  private String emailAddress;
  private String password;
  private Set<Authorities> authorities = new HashSet<>();
  private Set<Order> orders = new HashSet<>();
  
  public Customer () {}
  
  public Customer(Customer customer)
  {
    this.id = customer.getId();
    this.firstName = customer.getFirstName();
    this.lastName = customer.getLastName();
    this.emailAddress = customer.getEmailAddress();
    this.password = customer.getPassword();
    this.authorities = customer.getAuthorities();
    this.orders = customer.getOrders();
  }
  
  @Id
  @GeneratedValue
  public Long getId()
  {
    return id;
  }
  public void setId(Long id)
  {
    this.id = id;
  }
  public String getFirstName()
  {
    return firstName;
  }
  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }
  public String getLastName()
  {
    return lastName;
  }
  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }
  public String getEmailAddress()
  {
    return emailAddress;
  }
  public void setEmailAddress(String emailAddress)
  {
    this.emailAddress = emailAddress;
  }
  
  @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="customer")
  public Set<Order> getOrders()
  {
    return orders;
  }
  public void setOrders(Set<Order> orders)
  {
    this.orders = orders;
  }
  
  public String getPassword()
  {
    return password;
  }
  public void setPassword(String password)
  {
    this.password = password;
  }
  
  @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="customer")
  public Set<Authorities> getAuthorities()
  {
    return authorities;
  }
  public void setAuthorities(Set<Authorities> authorities)
  {
    this.authorities = authorities;
  }
}
