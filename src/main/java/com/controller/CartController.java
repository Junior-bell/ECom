package com.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Cart;
import com.nt.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {

	private final CartService CartService;
	
	public CartController(CartService CartService)
	{
		this.CartService=CartService;
	}

	@PostMapping("/add")
	public Cart addToCart( @RequestParam Integer UserId, @RequestParam Integer Quantity)
	{
		return CartService.addToCart(UserId, UserId, Quantity);
	}
	
}
