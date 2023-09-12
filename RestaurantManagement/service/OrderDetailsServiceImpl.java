package com.example.RestaurantManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RestaurantManagement.RestservInterface.OrderDetailsService;
import com.example.RestaurantManagement.model.OrderDetails;
import com.example.RestaurantManagement.repository.OrderDetailsRepository;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {
	
	 private final OrderDetailsRepository orderDetailsRepository;

	    @Autowired
	     public OrderDetailsServiceImpl(OrderDetailsRepository orderDetailsRepository) {
	        this.orderDetailsRepository = orderDetailsRepository;
	    }

		@Override
		public OrderDetails createOrder(OrderDetails orderDetails) {
			return orderDetailsRepository.save(orderDetails);
		}

		  public OrderDetails getOrderDetails(Integer orderId) {
		        return orderDetailsRepository.findById(orderId).orElse(null);
		    }

		  public List<OrderDetails> getOrderDetailsfromuser(Integer userID) {
			    return orderDetailsRepository.getOrderDetailsByUserId(userID);
			}
		  
		  

		  public void deleteOrder(Integer orderId) {
		            orderDetailsRepository.deleteOrderByFoodId(orderId);
		          
		    }
		  
		  
		  
		  public void deleteAllUsers() {
			  orderDetailsRepository.deleteAll();
		    }
		  
		  
		  
		  
		  
//		  public List<OrderDetails> getUserOrders(Integer userId) {
//		        // Simulate fetching user orders from a data source (replace with actual implementation)
//		        List<OrderDetails> userOrders = new ArrayList<>();
	
		        // You can create some dummy OrderDetails objects for testing
//		        OrderDetails order1 = new OrderDetails();
//		        order1.setOrderId(1);
//		        order1.setUserId(userId); // Set the userId as requested
//		        // Set other properties as needed
	//
//		        OrderDetails order2 = new OrderDetails();
//		        order2.setOrderId(2);
//		        order2.setUserId(userId);
//		        // Set other properties as needed
	//
//		        // Add the dummy orders to the list
//		        userOrders.add(order1);
//		        userOrders.add(order2);
	//
//		        return userOrders;
//		    }

}
