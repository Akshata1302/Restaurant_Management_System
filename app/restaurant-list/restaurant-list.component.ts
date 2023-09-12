import { Component, OnInit  } from '@angular/core';
import { Restaurant } from '../restaurant'
import { RestaurantService } from '../restaurant.service'
import { Router } from '@angular/router';
import { Location } from '@angular/common';
import { User } from '../user';
import {UserService} from '../user.service';

@Component({
  selector: 'app-restaurant-list',
  templateUrl: './restaurant-list.component.html',
  styleUrls: ['./restaurant-list.component.css']
})
export class RestaurantListComponent implements OnInit {

restaurants: Restaurant[] = [];
restaurantName: string = "";
pageNo: number = 1;
count: number = 5;
location : string = "";
selectedSearchType: string = 'name';
user: User[]=[];

  constructor(private restaurantService: RestaurantService,
    private userService:UserService,
    private router: Router) { }

  ngOnInit(): void {
    this.getRestaurants();
  }

search(selectedSearchType:string) {
    if (this.selectedSearchType === 'name') {
      this.searchByRestaurantName();
    } else if (this.selectedSearchType === 'location') {
      this.searchRestaurantByLocation();
    }
  }


  addFoodMenu(restaurantId:number){
    this.router.navigate(["view-menu",restaurantId]);
  }


 viewAllFoodItemsOfCurrentRestaurant(restaurantId:number){
  this.router.navigate(["view-menu",restaurantId]);
}
  

  searchByRestaurantName() : any{
    this.restaurantService.findByRestaurantName(this.restaurantName).subscribe(details => {
      this.restaurants= details;
      console.log(details);
    },
      error => {
        console.log(error);
      });
  }

  searchRestaurantByLocation() {
    console.log('Location to search:', this.location);
    
    this.restaurantService.findByLocation(this.location).subscribe(
      details => {
        console.log('Response from service:', details);
        this.restaurants = details;
      },
      error => {
        console.log('Error:', error);
      }
    );
  }
  removeAllRestaurants() : void{
    var status = confirm("Are you sure to delete all the Restaurant?");
    if (status == true) {
      this.restaurantService.deleteAllRestaurant().subscribe(details => {
        console.log(details);
        this.getRestaurants();
      },
        error => {
          console.log(error);
        })
    }
    else{
    this.getRestaurants();
  }
  }

 getVegRestaurants() {
    this.restaurantService.findByVegDomain().subscribe({
      next: (res) => {
      console.log(res);
      this.restaurants = res;
    },
    error: (e) => console.error(e)
  });
  }

  getNonVegRestaurants(){
    this.restaurantService. findByNonVegDomain().subscribe({
      next: (res) => {
      console.log(res);
      this.restaurants = res;
    },
    error: (e) => console.error(e)
  });
  }

   private getRestaurants(){
    this.restaurantService.getRestaurantsList().subscribe(data => {
      this.restaurants = data;
    });
  }


  restaurantDetails(restaurantId: number){
       var status = confirm("Are you sure to read the Restaurant?");
    this.router.navigate(['restaurant-details', restaurantId]);
  }

  updateRestaurant(restaurantId: number){
     var status = confirm("Are you sure to  update the Restaurant?");
    this.router.navigate(['update-restaurant', restaurantId]);
  }

 deleteRestaurant(restaurantId: number){
    var status = confirm("Are you sure to delete this record?");
    if (status == true) {
    this.restaurantService.deleteRestaurantById(restaurantId).subscribe( data => {
      console.log(data);
      this.getRestaurants();
    })
  }
    else{
      this.getRestaurants();
    }
  }


 sortBy(sort: string): void {
    switch (sort) {
      case 'costHigh':
        this.restaurantService.sortByCost("desc","avgCost").subscribe(details => {
    
          console.log('Response from service:',details);
          this.restaurants= details;
    
        },
          error => {
            console.log(error);
          });
        break;
      case 'costLow':
        this.restaurantService.sortByCost("asc","avgCost").subscribe(details => {
    
          console.log('Response from service:',details);
          this.restaurants= details;
    
        },
          error => {
            console.log(error);
          });
        break;

      case 'ratingLow':
        this.restaurantService.sortByRatings("asc","ratings").subscribe(details => {
    
          console.log('Response from service:',details);
          this.restaurants= details;
    
        },
          error => {
            console.log(error);
          });
          break;
        break;

      case 'ratingHigh':
       this.restaurantService.sortByRatings("desc","ratings").subscribe(details => {
    
        console.log('Response from service:',details);
        this.restaurants= details;
  
      },
        error => {
          console.log(error);
        });
        break;
      default:
        break;
    }
  }


  getUsersByRestaurantId(restaurantId?: number)
  {
  
    // this.userService.getUsersByRestaurantId(restaurantId).subscribe( data => {
    //   console.log(data);
    //   this.getRestaurants();
    // }
    // )

    var status = confirm("Are you sure to read this record?");
    if (status == true) {
    this.router.navigate(['view-user', restaurantId]);
    }
    else{
      this.getRestaurants();
    }
 
  }

}

  
