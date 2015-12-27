package com.coderscampus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderscampus.domain.Topping;

@Repository
public interface ToppingRepository extends JpaRepository<Topping, Long>
{

}
