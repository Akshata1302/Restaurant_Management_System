package com.example.RestaurantManagement.service;

import java.sql.Date;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.RestaurantManagement.model.User;
import com.example.RestaurantManagement.repository.UserRepository;

@Service
public class UserServiceImpl {
	
	@Autowired
	private UserRepository userRepo;

	public void addUser(User obj) {
		
		this.userRepo.save(obj);
	}
	
	public List<User> findBookedUsersByRestId(long restaurantId) {
		
		return this.userRepo.findUsersByRestId(restaurantId);

}

	public void deleteUserByDateRange(Date fromDate1, Date toDate2){
				userRepo.deleteByDateBetween(fromDate1, toDate2);
		
	}

	
	
}
