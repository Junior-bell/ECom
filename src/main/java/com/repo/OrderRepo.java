package com.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Order;

public interface OrderRepo extends JpaRepository<Order, Integer>{

	List<Order> findByUserId(Integer Id);
}
