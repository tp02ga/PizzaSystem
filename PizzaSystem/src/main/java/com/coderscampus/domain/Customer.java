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
  private Set<Order> orders = new HashSet<>();
  
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
}
