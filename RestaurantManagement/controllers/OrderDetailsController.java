package com.example.RestaurantManagement.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestaurantManagement.model.Menu;
import com.example.RestaurantManagement.model.OrderDetails;
import com.example.RestaurantManagement.model.User;
import com.example.RestaurantManagement.repository.MenuRepository;
import com.example.RestaurantManagement.repository.UserRepository;
import com.example.RestaurantManagement.service.OrderDetailsServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/order")
public class OrderDetailsController {
	
	@Autowired
	private MenuRepository menuRepo;

	@Autowired
	private UserRepository userRepo;

	private  OrderDetailsServiceImpl orderDetailsService;

	 @Autowired
	    public OrderDetailsController(OrderDetailsServiceImpl orderDetailsService) {
	        this.orderDetailsService = orderDetailsService;
	    }

   @PostMapping("/orderFood")
   public ResponseEntity<OrderDetails> createOrder(@RequestBody OrderDetails orderDetails) {
       OrderDetails createdOrder = orderDetailsService.createOrder(orderDetails);
       return ResponseEntity.ok(createdOrder);
       
   }
   
   
   
   
   @PostMapping("/orderFood/{userID}/{foodId}")
	 public ResponseEntity<OrderDetails> createOrder(
	     @RequestBody OrderDetails orderDetails,
	     @PathVariable("userID") int userID,
	     @PathVariable("foodId") int foodId) {
	     
	     Optional<User> user = userRepo.findById(userID);
	     Optional<Menu> menu = menuRepo.findById(foodId);
	     
	    
	     
	     orderDetails.setUser(user.get());
	     orderDetails.setMenu(menu.get());
	     
	     OrderDetails createdOrder = orderDetailsService.createOrder(orderDetails);
	     return ResponseEntity.ok(createdOrder);
	 }
   
   @GetMapping("/{orderId}")
   public ResponseEntity<OrderDetails> getOrderDetails(@PathVariable Integer orderId) {
       OrderDetails orderDetails = orderDetailsService.getOrderDetails(orderId);
       
       if (orderDetails != null) {
           return ResponseEntity.ok(orderDetails);
       } else {
           return ResponseEntity.notFound().build();
       }
   }

   
   @GetMapping("/user/details/{userID}")
   public List<OrderDetails> getOrderDetailfromUser(@PathVariable Integer userID) {
   	System.out.println("User ID: " + userID); 
   	
   	 List<OrderDetails> orderDetailsList = orderDetailsService.getOrderDetailsfromuser(userID);
   	    
       
       if (orderDetailsList != null) {
       	 System.out.println("Retrieved Order Details: " + orderDetailsList);
       	 return orderDetailsList; 
       } else {
       	 return null; 
       }
   }
   
   

   @DeleteMapping("/{orderId}")
   public void deleteOrder(@PathVariable Integer orderId) {
   orderDetailsService.deleteOrder(orderId);
  }
   
   


   @DeleteMapping("/deleteAllUsers")
   public ResponseEntity<HttpStatus> deleteAllUsers() {
       try {
    	   orderDetailsService.deleteAllUsers();
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       } catch (Exception exception) {
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
   }
  
  
   

}
