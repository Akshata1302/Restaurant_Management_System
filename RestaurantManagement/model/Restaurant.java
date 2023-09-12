package com.example.RestaurantManagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;



import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "Restaurant_table")
@DynamicUpdate


/* It is the blueprint of Restaurant class
 * In this class, we declare private attributes to represent Restaurant details and
 * provide getters and setters and To add toString method also privode parameterized and no-argument Constructor
 *  for accessing these attributes*/

public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer restaurantId;
	private String ownerName;
	private String restaurantName;
	private int ratings;
	private int avgCost;
	private String location;
	private Boolean isVegRestaurant;
	
	
	public Restaurant() {
		
	}

	public Restaurant(Integer restaurantId, String ownerName, String restaurantName, int ratings, int avgCost,
			String location, Boolean isVegRestaurant) {
		
		this.restaurantId = restaurantId;
		this.ownerName = ownerName;
		this.restaurantName = restaurantName;
		this.ratings = ratings;
		this.avgCost = avgCost;
		this.location = location;
		this.isVegRestaurant = isVegRestaurant;
	}


	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}


	public int getAvgCost() {
		return avgCost;
	}
	public void setAvgCost(int avgCost) {
		this.avgCost = avgCost;
	}
		
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public Boolean getIsVegRestaurant() {
		return isVegRestaurant;
	}

	public void setIsVegRestaurant(Boolean isVegRestaurant) {
		this.isVegRestaurant = isVegRestaurant;
	}



	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", ownerName=" + ownerName + ", restaurantName="
				+ restaurantName + ", ratings=" + ratings + ", avgCost=" + avgCost + ", location=" + location
				+ ", isVegRestaurant=" + isVegRestaurant + "]";
	}
	
	
}
