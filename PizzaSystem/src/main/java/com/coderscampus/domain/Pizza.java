package com.coderscampus.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Pizza
{
  private Long id;
  private String size;
  private String crustType;
  private Order order;
  private Set<Topping> toppings = new HashSet<>();
  
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
  public String getSize()
  {
    return size;
  }
  public void setSize(String size)
  {
    this.size = size;
  }
  public String getCrustType()
  {
    return crustType;
  }
  public void setCrustType(String crustType)
  {
    this.crustType = crustType;
  }
  
  @ManyToOne
  public Order getOrder()
  {
    return order;
  }
  public void setOrder(Order order)
  {
    this.order = order;
  }
  
  @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="pizzas")
  public Set<Topping> getToppings()
  {
    return toppings;
  }
  public void setToppings(Set<Topping> toppings)
  {
    this.toppings = toppings;
  }
}
