package com.coderscampus.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Authorities implements GrantedAuthority
{
  private static final long serialVersionUID = -4974442521182171726L;
  private Long id;
  private String authority;
  private Customer customer;
  
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
  public String getAuthority()
  {
    return authority;
  }
  public void setAuthority(String authority)
  {
    this.authority = authority;
  }
  
  @ManyToOne
  public Customer getCustomer()
  {
    return customer;
  }
  public void setCustomer(Customer customer)
  {
    this.customer = customer;
  }
  
  
}
