package com.example.RestaurantManagement.RestservInterface;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.RestaurantManagement.model.Menu;


public interface MenuService {
	
	public void addFoodMenu( Menu obj);
	public List< Menu> getMenuItemsByRestaurantId(long restaurantId);
	
	
public Menu saveImage(MultipartFile file, Integer foodID) throws IOException;
	
	public Menu getImageById(int foodID);

}
