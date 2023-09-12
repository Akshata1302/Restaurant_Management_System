package com.example.RestaurantManagement.RestservInterface;

import java.sql.Date;
import java.util.List;

import com.example.RestaurantManagement.model.User;

public interface UserService {
	
	public void addUser(User obj);
	public List<User> findBookedUsersByRestId(long restaurantId);
	void deleteUserByDateRange(Date fromDate1, Date toDate2);
	    

}
