package com.example.RestaurantManagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.RestaurantManagement.model.Restaurant;
import com.example.RestaurantManagement.repository.RestaurantRepository;
import com.example.RestaurantManagement.service.RestaurantServiceImpl;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
//@RequestMapping("/Restaurant.com")
@RequestMapping("/api/v1/")  

/* RestaurantController class manages the operations and interactions within a restaurant's management system.
 * accept the Request from front-end and act as that action. */


public class RestaurantController {

	@Autowired	
	public RestaurantServiceImpl restaurantServiceImp;



	public RestaurantController(RestaurantServiceImpl restaurantServiceImp) {
		this.restaurantServiceImp = restaurantServiceImp;
	}
	
	
	

	//create Restaurant rest api
	@PostMapping("/restaurant")
	public ResponseEntity<Restaurant> saveRestaurant(@RequestBody Restaurant name){
		try {
			return new ResponseEntity<>(restaurantServiceImp.saveRestaurant(name), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	
	
	
	//readAll Restaurant rest api
	@GetMapping("/restaurant")
	public ResponseEntity<List<Restaurant>> getByAllRestaurant(@RequestParam(required = false) String name) {
		try {
			List restaurantList= restaurantServiceImp.getRestaurantsFromDb(name);
			
			if (restaurantList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

        return new ResponseEntity<>(restaurantList, HttpStatus.OK);
        
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	// get any specific Restaurant by id rest api
		@GetMapping("/restaurant/{id}")
		public ResponseEntity<Restaurant> getRestaurantById(@PathVariable("id") int restaurantId) {
			Optional<Restaurant> restaurant =restaurantServiceImp. getRestaurantById(restaurantId);

			if (restaurant.isPresent()) {
				return new ResponseEntity<>(restaurant.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
	
		
		
		
		// update any specific restaurant rest api
		@PutMapping("/restaurant/{id}")
		public ResponseEntity<Restaurant> updateRestaurantDetailsById(@PathVariable ("id")int restaurantId, @RequestBody Restaurant restaurantDetails){
			Optional<Restaurant> newRestaurantData = restaurantServiceImp.getRestaurantById(restaurantId);

				if(newRestaurantData.isPresent())
				{
					restaurantServiceImp.updateRestaurantDetails(newRestaurantData,restaurantDetails);
					return new ResponseEntity<>(restaurantServiceImp.updateRestaurantDetails(newRestaurantData, restaurantDetails),HttpStatus.OK);
				
				}
				else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
			}
			
		
		
		
		
		// delete  restaurant rest api
		@DeleteMapping("/restaurant/{restaurantId}")
		public ResponseEntity<String> deleteRestaurantById(@PathVariable("restaurantId") int restaurantId){

			Optional<Restaurant> restaurantData = restaurantServiceImp.getRestaurantById(restaurantId);
			try {
				if (restaurantData.isPresent()) {
					restaurantServiceImp. deleteRestaurantById(restaurantId);
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
			} catch (Exception e) 
			{
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

	
	
	
	//delete All Restaurant Data
	@DeleteMapping("/restaurant")
	public ResponseEntity<HttpStatus> deleteAllRestaurant(){
		try
		{
			restaurantServiceImp.deleteAllRestaurants();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch(Exception exception) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	


  //search VegRestaurant rest api
	@GetMapping("/restaurant/vegRestaurant")
	public ResponseEntity<List<Restaurant>> findByVegDomain() {
		try {
			List<Restaurant> restaurant = restaurantServiceImp.findByIsVegRestaurant(true);

			if (restaurant.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(restaurant, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	//search NonVegRestaurant rest api
	@GetMapping("/restaurant/nonVegRestaurant")
	public ResponseEntity<List<Restaurant>> findByNonVegDomain() {
		try {

			List<Restaurant> restaurant = restaurantServiceImp.findByIsVegRestaurant(false);

			if (restaurant.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(restaurant, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	
	//search rest api
	@GetMapping("restaurant/search")
	public ResponseEntity<List<Restaurant>> findByLocation(@RequestParam(required = false) String location) {
		try {
            System.out.println("rest location is =============="+location);
			List<Restaurant> restaurantList = restaurantServiceImp.getAllRestaurantsByLoc(location);

			if (restaurantList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(restaurantList, HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	@GetMapping("restaurant/filter/Ratings/{direction}")
	public ResponseEntity<List<Restaurant>> getAllRestaurantsByRatingseHighToLow(@PathVariable("direction") String direction, @RequestParam(required = true) String ratings){

		try {
			List<Restaurant> restaurantList = restaurantServiceImp.getAllRestaurantsByRatingsDesc(direction, ratings);
			if (restaurantList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(restaurantList, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
	@GetMapping("restaurant/filter/Price/{direction}")
	public ResponseEntity<List<Restaurant>> getAllRestaurantsByPriceHighToLow(@PathVariable("direction") String direction, @RequestParam(required = true) String price){

		try {
			List<Restaurant> restaurantList = restaurantServiceImp.getAllRestaurantsByPriceDesc(direction, price);
			System.out.println(direction);
			if (restaurantList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(restaurantList, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

		
	}