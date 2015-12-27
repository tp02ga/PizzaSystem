package com.coderscampus.enums;

public enum PizzaCrustEnum
{
  THIN("thin", 0.0),
  REGULAR("regular", 0.0),
  THICK("thick", 0.0),
  GLUTEN_FREE("gluten free", 3.0);
  
  private String description;
  private Double price;
  
  PizzaCrustEnum (String description, Double price) {
    this.description = description;
    this.price = price;
  }

  public String getDescription()
  {
    return description;
  }

  public Double getPrice()
  {
    return price;
  }
}
