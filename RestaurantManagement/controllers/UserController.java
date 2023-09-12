package com.example.RestaurantManagement.controllers;

import java.sql.Date;
import java.util.ArrayList;


import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.RestaurantManagement.model.User;
import com.example.RestaurantManagement.repository.RestaurantRepository;
import com.example.RestaurantManagement.service.UserServiceImpl;

//many comments on one emp
//many user book one rest

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")

public class UserController {
	
	//open postm
		@Autowired
		private UserServiceImpl userServ;
		
		
		@Autowired
		private RestaurantRepository restRepo;
		
		
			@PostMapping("/bookTable/{restaurantId}")
			public ResponseEntity<Map<String,String>> addBooking(@PathVariable("restaurantId") int restId,@RequestBody User user)
			{
			
					User obj=new User();
					Random rand = new Random();
					obj.setUserEmail(user.getUserEmail());
					obj.setUserName(user.getUserName());
					obj.setDate(user.getDate());
					int userId=rand.nextInt(11111);
					obj.setUserID(userId);
					obj.setRestDetails(this.restRepo.findById( restId).get());
					this.userServ.addUser(obj);
					Map<String,String> response=new HashMap<String,String>();
					response.put("status", "success");
					response.put("message", "Comment added!!");
				
						return new ResponseEntity<Map<String,String>>(response, HttpStatus.CREATED);
				
			}
			
			@GetMapping("/bookedUsers/{restaurantId}")
			public List<User> getUsersByRestaurantId(@PathVariable long restaurantId)
			{
				List<User> userList = new ArrayList<User>();
				userList = this.userServ.findBookedUsersByRestId(restaurantId);
				
				return  userList;
				
			}
			
			
			@DeleteMapping("/delete")
		    public void deleteUserByDateRange(@RequestParam("fromdate1") Date fromDate1,
		                                      @RequestParam("todate2") Date toDate2){
			 System.out.println(fromDate1+" "+ toDate2);
			 userServ.deleteUserByDateRange(fromDate1, toDate2);
		    }

}
