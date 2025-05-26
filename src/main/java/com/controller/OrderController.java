package com.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Order;
import com.nt.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	private final OrderService orderService;
	
	public OrderController(OrderService orderService)
	{
		this.orderService=orderService;
	}
	
	@PostMapping("/place")
	public Order placeOrder(@RequestParam Integer UserId)
	{
		return orderService.PlaceOrder(UserId);
	}
}
