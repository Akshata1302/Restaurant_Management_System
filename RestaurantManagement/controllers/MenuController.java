package com.example.RestaurantManagement.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.RestaurantManagement.model.Menu;
import com.example.RestaurantManagement.repository.RestaurantRepository;
import com.example.RestaurantManagement.service.MenuServiceImpl;

import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuServiceImpl menuServ;
	@Autowired
	private RestaurantRepository restRepo;
	
	
	@PostMapping("/addFood/{restaurantId}")
	public ResponseEntity<Map<String,String>> addFoodMenu(@PathVariable("restaurantId") int restId,  @ModelAttribute Menu menu, @RequestParam("file") MultipartFile file)
	{
	
		  try {
			  
			  Random rand = new Random();
		  
	     	Menu obj=new Menu();
	     	int foodID=rand.nextInt(11111);
			obj.setFoodName(menu.getFoodName());
			obj.setFoodQuantity(menu.getFoodQuantity());
			obj.setFoodPrice(menu.getFoodPrice());
			obj.setRestDetails(this.restRepo.findById( restId).get());
			
			 
	        // Set image data to the same 'obj' instance
	        obj.setImageData(file.getBytes());
	        
			this.menuServ.addFoodMenu(obj);
			
			Map<String,String> response=new HashMap<>();
			response.put("status", "success");
			response.put("message", "Food item added successfully!!");
			
		
		return new ResponseEntity<>(response, HttpStatus.CREATED);
				
	 } catch (IOException e) {
	        // Handle IO exception
	        Map<String, String> errorResponse = new HashMap<>();
	        errorResponse.put("status", "error");
	        errorResponse.put("message", "Error uploading image or adding food item.");
	        
	        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@GetMapping("/bookedMenus/{restaurantId}")
	public ResponseEntity<List<Menu>> getMenuItemsByRestaurantId(@PathVariable int restaurantId){
	  List<Menu> menuItems = menuServ.getMenuItemsByRestaurantId(restaurantId);

	  if (menuItems.isEmpty()) {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }

      return new ResponseEntity<>(menuItems, HttpStatus.OK);
  }
	
	
	 
	 
	
	
	
	
	
	
	@PostMapping("/image/upload/{id}")
    public String uploadImage( @PathVariable("id") int foodID,@RequestParam("file") MultipartFile file) throws IOException {
		menuServ.saveImage(file,foodID);
        return "Image uploaded successfully!";
    }

    @GetMapping("/image/{id}")
    public void getImage(@PathVariable("id") int foodID, HttpServletResponse response) throws IOException {
        Menu image = menuServ.getImageById(foodID);

        if (image != null) {
            response.setContentType("image/jpeg"); // Adjust content type as needed
            response.getOutputStream().write(image.getImageData());
            response.getOutputStream().close();
        }
    }
}
