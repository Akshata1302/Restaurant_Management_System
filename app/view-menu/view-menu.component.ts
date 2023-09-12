import { Component,OnInit } from '@angular/core';
import { Restaurant } from '../restaurant';
import { RestaurantService } from '../restaurant.service';
import { ActivatedRoute, Router } from '@angular/router';
import { MenuService } from '../menu.service';
import { Menu } from '../menu';
import { User } from '../user';
import { UserService } from '../user.service';


@Component({
  selector: 'app-view-menu',
  templateUrl: './view-menu.component.html',
  styleUrls: ['./view-menu.component.css']
})
export class ViewMenuComponent implements OnInit{
  
 restaurantId: number=0;
  restaurant: Restaurant = new Restaurant();
  foodName = '';
  foodPrice = 0;
  foodQuantity = 0;
  imageData: File | null = null;
  menuList : Menu[] = [];
  restaurants: Restaurant[] = [];
  selectedUserIds: number[] = [];
  
  selectedUserId: number | null = null;
  
  users: User[] = []; 

  menu:Menu=new Menu();
 
  

  constructor(private restaurantService: RestaurantService,
    private menuService: MenuService,private route: ActivatedRoute,
    private userService: UserService,
    private router: Router) {}


    addMenu(restaurantId?:number){
      var status = confirm("Are you sure to Add the records?");
      if (status == true) {
        this.router.navigate(['add-menu',restaurantId]);
        }
      
      else{
      console.log("Error in booking")
    }
    }


    deleteFoodById(foodID: number){
      var status = confirm("Are you sure to delete this record?");
      if (status == true) {
      this.menuService.deleteFoodById(foodID).subscribe( data => {
        console.log(data);
        // this.getRestaurants();
      }
      )
    }
    else{
      // this.getRestaurants();
    }
    }

    removeAllFoods() : void{
      var status = confirm("Are you sure to delete all the records?");
      if (status == true) {
        this.menuService.deleteAllFoods().subscribe(details => {
          console.log(details);
          // this.getRestaurants();
        },
          error => {
            console.log(error);
          })
      }
      else{
      // this.getRestaurants();
    }
    }

    // private getRestaurants(){
    //   this.restaurantService.getRestaurantList().subscribe(data => {
    //     this.restaurants = data;
  
    //  });
    // }

    // orderFood(){
    //   var status = confirm("Are you sure to Add the records?");
    //   if (status == true) {
    //     this.router.navigate(['food-order']);
    //     }
      
    //   else{
    //   console.log("Error in booking")
    // }
    // }
  

  ngOnInit(): void {

    this.initSelectedUserIds();
  
    this.restaurantId = this.route.snapshot.params['restaurantId'];

    this.loadUsers(this.restaurantId); 

    this.menuService.getMenuForRespectiveRestaurants(this.restaurantId).subscribe(
      data => {
        
        console.log(data);  //all the attributes of menu class
        this.menuList = data;

      },
      error => console.log(error)
    );

  }


  loadUsers(restaurantId:number) {
    this.userService.getUsersByRestaurantId(restaurantId).subscribe(data => {
      this.users = data;
    });
  }

  initSelectedUserIds() {
    this.selectedUserIds = new Array(this.menuList.length).fill(null);
  }


  
  orderFood(index: number, selectedUserId: number | null,foodID:number) {
    if (selectedUserId !== null) {
      var status = confirm("Are you sure to add the records?");
      if (status === true) {
        this.router.navigate(['food-order'], {
          queryParams: { userId: selectedUserId, foodID: this.menuList[index].foodID }
        });
      } else {
        console.log("Error in booking");
      }
    } else {
      // Show an error or alert indicating that no user is selected for this item
    }
  }
}