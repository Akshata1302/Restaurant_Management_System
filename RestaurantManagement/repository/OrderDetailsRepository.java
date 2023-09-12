package com.example.RestaurantManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.RestaurantManagement.model.OrderDetails;

import jakarta.transaction.Transactional;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer>{
	
	@Query(value="SELECT * FROM order_Details od WHERE od.userID = ?1",nativeQuery = true)
	List<OrderDetails> getOrderDetailsByUserId(Integer userId);
	

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM order_Details od WHERE od.order_id = ?1", nativeQuery = true)
	void deleteOrderByFoodId(Integer foodID);


}
