package com.nt.service;


import org.springframework.stereotype.Service;

import com.model.Cart;
import com.model.CartItem;
import com.model.Product;
import com.model.User;
import com.repo.CartRepo;
import com.repo.ProductRepo;

@Service
public class CartService {

  private final CartRepo CartRepo;
  private final ProductRepo ProductRepo;
  
  public CartService(CartRepo CartRepo,ProductRepo ProductRepo)
  {
	  this.CartRepo = CartRepo;
	  this.ProductRepo=ProductRepo;
  }
  
  public Cart addToCart(Integer UserId,Integer ProductId, Integer quantity)
  {
	Cart cart=CartRepo.findByUserId(UserId)
			  .orElse(new Cart());
	  Product Product=ProductRepo.findById(ProductId)
			  .orElseThrow(()-> new RuntimeException("Product Not found"));
	  CartItem item=new CartItem();
	  item.setProduct(Product);
	  item.setQuantity(quantity);
      cart.getItems().add(item);
      if(cart.getUser()==null)
      {
    	  User user=new User();
    	  user.setId(UserId);
    	  cart.setUser(user);
      }
      return CartRepo.save(cart);
  }
}
