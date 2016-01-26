package com.coderscampus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderscampus.domain.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Long>
{

}
