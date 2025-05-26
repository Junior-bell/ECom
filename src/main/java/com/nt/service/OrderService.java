package com.nt.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.model.Cart;
import com.model.CartItem;
import com.model.Order;
import com.model.OrderItem;
import com.repo.CartRepo;
import com.repo.OrderRepo;
@Service
public class OrderService {

	private final OrderRepo orderRepo;
	private final CartRepo CartRepo;
	
	public OrderService(OrderRepo OrderRepo,CartRepo CartRepo)
	{
		this.orderRepo=OrderRepo;
		this.CartRepo=CartRepo;
	}
	
	public Order PlaceOrder(Integer UserId)
	{
		Cart Cart=CartRepo.findById(UserId)
			.orElseThrow(()-> new RuntimeException("cart not found"));
		Order order=new Order();
		order.setUser(Cart.getUser());
		order.setOrderDate(LocalDateTime.now());
		order.setStatus("PENDING");
		double total=0;
		for(CartItem cartItem:Cart.getItems())
		{
			OrderItem orderItem = new OrderItem();
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setQuantity(cartItem.getQuantity());
			orderItem.setPrice(cartItem.getProduct().getPrice());
			order.getItems().add(orderItem);
			total+=cartItem.getQuantity() * cartItem.getProduct().getPrice();
		}
		order.setTotal(total);
		Order saveOrder=orderRepo.save(order);
		CartRepo.delete(Cart);	
		return saveOrder;
	}
}
