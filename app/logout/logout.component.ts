import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationServiceService} from '../authentication-service.service';
import { RestaurantService } from '../restaurant.service';
import { Restaurant } from '../restaurant'

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

restaurants: Restaurant[] = [];

  constructor(
    private restaurantService:RestaurantService,
    private authentocationService: AuthenticationServiceService,
    private router: Router) {

  }
  private getRestaurants(){
    this.restaurantService.getRestaurantsList().subscribe( data =>{
      this.restaurants=data;
    });
  }


  ngOnInit() {
    var status = confirm("Are you sure to Logout");
    if(status==true){
    this.authentocationService.logOut();
    this.router.navigate(['login']);
    }
    else{
      // this.getRestaurants();
      // this.router.navigate(['softwares']);
this.router.navigate(['restaurants']);
    }
  }

}
