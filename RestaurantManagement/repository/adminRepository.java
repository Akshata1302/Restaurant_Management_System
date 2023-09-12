package com.example.RestaurantManagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.RestaurantManagement.model.Admin;

public interface adminRepository extends JpaRepository<Admin, Long> {
	
	//JPQL - JAVA PERSISTENCE QUERY LANGUAGE
	
		@Query(value = "SELECT * FROM admin u WHERE u.user_email = ?1",nativeQuery = true  )
		public Optional<Admin> findByadminEmail(String email);
		
		
		@Query(value = "SELECT * FROM admin u WHERE u.admin_email = ?1 AND u.admin_password = ?2 ",nativeQuery = true  )
		public Optional<Admin> findByadminEmailAndPassword(String email, String Password);

}
