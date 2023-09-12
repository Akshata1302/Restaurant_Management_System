package com.example.RestaurantManagement.RestservInterface;

import java.util.List;
import java.util.Optional;

import com.example.RestaurantManagement.model.Restaurant;


/* this is interface and have abstract Methods only declaration. to save a new Restaurant , to retrieve Restaurant by its ID and
 *  all Restaurant update the details of an existing Restaurant item ,to delete a specific Restaurant item by its ID from the databases*/

public interface RestaurantService {

	Restaurant saveRestaurant(Restaurant restaurant);
	List<Restaurant>getRestaurantsFromDb(String str);
	Optional<Restaurant> getRestaurantById(int restaurantId);
	Restaurant updateRestaurantDetails(Optional<Restaurant> existingData , Restaurant newRestaurantData);
	void deleteRestaurantById(int restaurantId);
	void deleteAllRestaurants();
	
}
