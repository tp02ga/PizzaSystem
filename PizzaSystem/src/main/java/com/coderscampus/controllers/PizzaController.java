package com.coderscampus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coderscampus.domain.Order;
import com.coderscampus.domain.Pizza;
import com.coderscampus.domain.Topping;
import com.coderscampus.enums.PizzaCrustEnum;
import com.coderscampus.enums.PizzaSizeEnum;
import com.coderscampus.repository.OrderRepository;
import com.coderscampus.repository.PizzaRepository;
import com.coderscampus.repository.ToppingRepository;

@Controller
@RequestMapping("/orders/{orderId}/pizzas")
public class PizzaController
{
  private ToppingRepository toppingRepo;
  private OrderRepository orderRepo;
  private PizzaRepository pizzaRepo;
  
  @RequestMapping(value="", method=RequestMethod.GET)
  public String pizzaGet (@PathVariable Long orderId, ModelMap model)
  {
    model.put("pizzaSizes", PizzaSizeEnum.values());
    model.put("pizzaCrusts", PizzaCrustEnum.values());
    model.put("toppings", toppingRepo.findAll());
    
    Pizza pizza = new Pizza();
    
    model.put("pizza", pizza);
    
    return "pizzas";
  }
  
  @RequestMapping(value="/{pizzaId}/delete", method=RequestMethod.GET)
  public String pizzaGet (@PathVariable Long orderId, @PathVariable Long pizzaId, ModelMap model)
  {
    Order order = orderRepo.findOne(orderId);

    Pizza pizzaToDelete = null;
    
    for (Pizza pizza : order.getPizzas())
    {
      if (pizza.getId().equals(pizzaId))
      {
        pizzaToDelete = pizza;
        break;
      }
    }

    pizzaToDelete.getToppings().clear();
    
    order.getPizzas().remove(pizzaToDelete);
    if (pizzaToDelete != null)
    {
      pizzaToDelete.setOrder(null);
    }
    
    orderRepo.save(order);
    
    return "redirect:/orders/" + orderId;
  }
  
  @RequestMapping(value="", method=RequestMethod.POST)
  public String pizzaPost (@ModelAttribute Pizza pizza, @PathVariable Long orderId, ModelMap model)
  {
    Order order = orderRepo.findOne(orderId);
    
    double pizzaPrice = 0.0;
    
    for (Topping topping : pizza.getToppings())
    {
      topping.getPizzas().add(pizza);
      pizzaPrice += topping.getPrice();
    }
    
    for (PizzaCrustEnum pizzaCrustEnum : PizzaCrustEnum.values())
    {
      if (pizzaCrustEnum.getDescription().equals(pizza.getCrustType()))
      {
        pizzaPrice += pizzaCrustEnum.getPrice();
      }
    }
    
    for (PizzaSizeEnum pizzaSizeEnum : PizzaSizeEnum.values())
    {
      if (pizzaSizeEnum.getDescription().equals(pizza.getSize()))
      {
        pizzaPrice += pizzaSizeEnum.getPrice();
      }
    }
    
    pizza.setPrice(pizzaPrice);
    pizza.setOrder(order);
    order.getPizzas().add(pizza);
    
    orderRepo.save(order);
    return "redirect:/orders/"+orderId;
  }
  
  @Autowired
  public void setToppingRepo(ToppingRepository toppingRepo)
  {
    this.toppingRepo = toppingRepo;
  }
  @Autowired
  public void setOrderRepo(OrderRepository orderRepo)
  {
    this.orderRepo = orderRepo;
  }
  @Autowired
  public void setPizzaRepo(PizzaRepository pizzaRepo)
  {
    this.pizzaRepo = pizzaRepo;
  }
}
