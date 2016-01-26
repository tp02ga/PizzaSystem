package com.coderscampus.domain;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order
{
  private Long id;
  private Customer customer;
  private Set<Pizza> pizzas = new TreeSet<>();
  private Double finalPrice;
  private Boolean completed;
  
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
  
  @ManyToOne
  public Customer getCustomer()
  {
    return customer;
  }
  public void setCustomer(Customer customer)
  {
    this.customer = customer;
  }
  
  @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="order", orphanRemoval=true)
  public Set<Pizza> getPizzas()
  {
    return pizzas;
  }
  public void setPizzas(Set<Pizza> pizzas)
  {
    this.pizzas = pizzas;
  }
  public Double getFinalPrice()
  {
    return finalPrice;
  }
  public void setFinalPrice(Double finalPrice)
  {
    this.finalPrice = finalPrice;
  }
  public Boolean getCompleted()
  {
    return completed;
  }
  public void setCompleted(Boolean completed)
  {
    this.completed = completed;
  }
}
