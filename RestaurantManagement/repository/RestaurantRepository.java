package com.example.RestaurantManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.RestaurantManagement.model.Restaurant;


/*The RestaurantRepository interface is a Spring Data JPA repository that provides database access and 
 * CRUD operations for the Restaurant entity.*/


	@Repository
	public interface RestaurantRepository extends JpaRepository< Restaurant, Integer> {
	   List<Restaurant> findByIsVegRestaurant(boolean  status);
	    //List<Restaurant> findByIsVegRestaurant(boolean isVegRestaurant);

		Iterable<Restaurant> findByRestaurantNameContainingIgnoreCase(String restaurantName);

		Iterable<Restaurant> findByLocation(String location);

		

		

	




			

		
		
	
 	   
	}
	 
