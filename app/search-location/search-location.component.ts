import { Component } from '@angular/core';
import { RestaurantService } from '../restaurant.service';
import { Restaurant } from '../restaurant';

@Component({
  selector: 'app-search-location',
  templateUrl: './search-location.component.html',
  styleUrls: ['./search-location.component.css']
})
export class SearchLocationComponent {
  // location : string="";
  // restaurants : Restaurant[]=[];
  // constructor(private restaurantService:RestaurantService){}

  //  searchRestaurantByLocation()
  // {
  //   this.restaurantService.findByLocation(this.location).subscribe(details => {
    
  //     console.log('Response from service:',details);
  //     this.restaurants= details;

  //   },
  //     error => {
  //       console.log(error);
  //     });
  // }
}
