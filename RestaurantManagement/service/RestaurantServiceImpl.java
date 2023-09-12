package com.example.RestaurantManagement.service;

import java.util.List;


import java.util.ArrayList;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.RestaurantManagement.RestservInterface.RestaurantService;
import com.example.RestaurantManagement.model.Restaurant;
import com.example.RestaurantManagement.repository.RestaurantRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

/*The RestaurantServiceImplementation class is a service class that provides the business logic to  with Restaurant 
 * items in the database. It implements the SoftwareServe interface to perform CRUD  Read, Update, Delete) operations 
 * on Restaurant.*/

@Service
public class RestaurantServiceImpl implements RestaurantService{
	
	

		RestaurantRepository restaurantRepository;
	
		public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
			this.restaurantRepository = restaurantRepository;
		}

		
		
		//Insert Restaurant Data to the Database
		public Restaurant saveRestaurant(Restaurant restaurant) {
			return restaurantRepository.save(restaurant);  
		}

		
		//readAll Restaurant Data to the Database
		@Override
		public List<Restaurant> getRestaurantsFromDb(String title) {
			List<Restaurant> restaurant = new ArrayList<Restaurant>();
			if (title == null) 
				restaurantRepository.findAll().forEach(restaurant::add);
		else
				restaurantRepository.findByRestaurantNameContainingIgnoreCase(title).forEach(restaurant::add);
			
			 return restaurant; 
		}
		
		
		
        //read any specific Restaurant by id Data to the Database
		@Override
		public Optional<Restaurant> getRestaurantById(int restaurantId) { 
		Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);  
		return restaurant;
		}
		
		

		//Update any Restaurant by id Data to the Database
		@Override
		public Restaurant updateRestaurantDetails( Optional<Restaurant> existingData,Restaurant newRestaurantData) {


			    Restaurant  restaurant=existingData.get();
			  
			    restaurant.setRestaurantName(newRestaurantData.getRestaurantName());
			    restaurant.setOwnerName(newRestaurantData.getOwnerName());
			    restaurant.setAvgCost(newRestaurantData.getAvgCost());
			    restaurant.setRatings(newRestaurantData.getRatings());
			    restaurant.setLocation(newRestaurantData.getLocation());
			    restaurant.setIsVegRestaurant(newRestaurantData.getIsVegRestaurant());
			    return restaurantRepository.save( restaurant);
		}

		//Delete Restaurant data by id to the Database
		@Override
		public void deleteRestaurantById(int restaurantId) {
				restaurantRepository.deleteById(restaurantId);
			}	


       //get Restaurant by name
		public Restaurant getByRestaurantName(int restaurantId) { 
			Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId); 
			System.out.println(restaurantId);
			System.out.println(restaurant.isPresent());
			if(restaurant.isPresent()) {
				Restaurant obj = restaurant.get();
				System.out.println(obj);
				return restaurant.get();
			}
			else {
				return null;
			}
		}
		
		

		   
		 //search NonVegRestaurants and VegRestaurant Restaurant Data to the Database   
		    public List<Restaurant> findByIsVegRestaurant(boolean status) {
			 return restaurantRepository.findByIsVegRestaurant(status);
				
		   }



		//Delete All Restaurant data by id to the Database
		@Override
		public void deleteAllRestaurants() {
			restaurantRepository.deleteAll();
			
		}

		  //search any Restaurant by it name
		   public List<Restaurant>getByRestaurantDetailsByRestaurantName(String name) {
			List<Restaurant> RestaurantList = new ArrayList<>();
			restaurantRepository.findByRestaurantNameContainingIgnoreCase(name).forEach(RestaurantList::add);
			
			return RestaurantList;
		}



		public List<Restaurant> getAllRestaurantsByLoc(String location) {
			List<Restaurant> restaurant = new ArrayList<Restaurant>();
			restaurantRepository.findByLocation(location).forEach(restaurant::add);	
			return restaurant;
		}



		public List<Restaurant> getAllRestaurantsByPriceDesc(String direction, String price) {
			List<Restaurant> restaurant = restaurantRepository.findAll(Sort.by( getSortDirection(direction), price));
			return restaurant;
		}

		public List<Restaurant> getAllRestaurantsByRatingsDesc(String direction, String ratings) {
			List<Restaurant> restaurant = restaurantRepository.findAll(Sort.by(getSortDirection(direction), ratings));
			return restaurant;
		}
		
		private Sort.Direction getSortDirection(String direction) {
		    if (direction.equals("asc")) {
		    	System.out.println(" came here");
		      return Sort.Direction.ASC;
		    } else if (direction.equals("desc")) {
		    	System.out.println(" came here desc");
		      return Sort.Direction.DESC;
		    }
		 
		    return Sort.Direction.ASC;
		  }
	

		
}


