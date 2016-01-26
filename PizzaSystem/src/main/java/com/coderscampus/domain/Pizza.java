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
public class Pizza implements Comparable<Pizza>
{
  private Long id;
  private String size;
  private String crustType;
  private Order order;
  private Double price;
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
  
  public Double getPrice()
  {
    return price;
  }
  public void setPrice(Double price)
  {
    this.price = price;
  }
  
  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }
  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Pizza other = (Pizza) obj;
    if (id == null)
    {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
  @Override
  public int compareTo(Pizza otherPizza)
  {
    if (this.getId() == null)
      return 1;
    if (otherPizza.getId() == null)
      return -1;
    return this.getId().compareTo(otherPizza.getId());
  }
}
