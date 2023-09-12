package com.example.RestaurantManagement.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.RestaurantManagement.model.Menu;



@Repository
	public interface MenuRepository extends JpaRepository<Menu, Integer>{
	
		
		
			@Query(value = "SELECT * FROM Menu_table p WHERE p.restaurant_id = ?1",nativeQuery = true  )
			public List<Menu> getFoodByRestaurantId(long restaurantId);

			
		}


