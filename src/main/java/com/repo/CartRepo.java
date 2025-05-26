package com.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Cart;

public interface CartRepo extends JpaRepository<Cart, Integer>{

	Optional<Cart> findByUserId(Integer UserId);
}
