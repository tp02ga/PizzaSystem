package com.coderscampus.security;

import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;

import com.coderscampus.domain.Authorities;
import com.coderscampus.domain.Customer;

public class CustomUserDetails extends Customer implements UserDetails
{
  
  private static final long serialVersionUID = 344094893169692400L;

  public CustomUserDetails() {}
  
  public CustomUserDetails(Customer customer)
  {
    super(customer);
  }

  @Override
  public Set<Authorities> getAuthorities()
  {
    return super.getAuthorities();
  }

  @Override
  public String getPassword()
  {
    return super.getPassword();
  }

  @Override
  public String getUsername()
  {
    return super.getEmailAddress();
  }

  @Override
  public boolean isAccountNonExpired()
  {
    return true;
  }

  @Override
  public boolean isAccountNonLocked()
  {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired()
  {
    return true;
  }

  @Override
  public boolean isEnabled()
  {
    return true;
  }

}
