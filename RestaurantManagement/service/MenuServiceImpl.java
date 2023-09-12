package com.example.RestaurantManagement.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.RestaurantManagement.RestservInterface.MenuService;
import com.example.RestaurantManagement.model.Menu;
import com.example.RestaurantManagement.repository.MenuRepository;

@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuRepository menuRepo;

	public void addFoodMenu(Menu obj) {
		 this.menuRepo.save(obj);
		
		
	}

public List<Menu>getMenuItemsByRestaurantId(long restaurantId) {
		
		return this.menuRepo.getFoodByRestaurantId(restaurantId);

}


public Menu saveImage(MultipartFile file, Integer foodID) throws IOException {
	  Menu image = new Menu();
      	image.setFoodID(foodID);
        image.setImageData(file.getBytes());
        return menuRepo.save(image);
}

public Menu getImageById(int foodID) {
	 return menuRepo.findById(foodID).orElse(null);
	  
}






}
