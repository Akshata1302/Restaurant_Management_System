package com.example.RestaurantManagement.model;

import org.hibernate.annotations.DynamicUpdate;

import java.util.Arrays;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Menu_table")
@DynamicUpdate
public class Menu {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer foodID;
	private String  foodName;
	private int foodPrice;
	private int foodQuantity;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="restaurantId")
	private Restaurant restDetails;

	public Integer getFoodID() {
		return foodID;
	}

	public void setFoodID(Integer foodID) {
		this.foodID = foodID;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
	}

	public int getFoodQuantity() {
		return foodQuantity;
	}

	public void setFoodQuantity(int foodQuantity) {
		this.foodQuantity = foodQuantity;
	}

	public Restaurant getRestDetails() {
		return restDetails;
	}

	public void setRestDetails(Restaurant restDetails) {
		this.restDetails = restDetails;
	}
	
	@Lob
    private byte[] imageData;
	
	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	@Override
	public String toString() {
		return "Menu [foodID=" + foodID + ", foodName=" + foodName + ", foodPrice=" + foodPrice + ", foodQuantity="
				+ foodQuantity + ", restDetails=" + restDetails + ", imageData=" + Arrays.toString(imageData) + "]";
	}
	
	
	
	
	

}
