package com.example.RestaurantManagement.repository;

import java.sql.Date;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.RestaurantManagement.model.User;

import jakarta.transaction.Transactional;


@Transactional 
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	

		@Query(value = "SELECT * FROM User_table p WHERE p.restaurant_id = ?1",nativeQuery = true  )
		public List<User> findUsersByRestId(long restaurantId);

		
	

			
		@Modifying
		@Query(value = "DELETE FROM User_table WHERE date BETWEEN ?1 AND ?2",nativeQuery = true  )
		void deleteByDateBetween(Date startDate, Date endDate);
		
		
			
			
			/*
			 * @QueryDELETE FROM MyTable WHERE DateField BETWEEN "?1" to "?2" 
			 * detequer
			 * 
			 */
		
}
