import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FoodOrderServiceService } from '../food-order-service.service';
import { User } from '../user';

@Component({
  selector: 'app-food-order',
  templateUrl: './food-order.component.html',
  styleUrls: ['./food-order.component.css']
})
export class FoodOrderComponent implements OnInit {
 
 //orderDetails: OrderDetails = {
  //   orderId: 0,
  //   user: {
  //     userID: 0,
  //     userName: '',
  //     userEmail: '',
  //     date: '',
  //     // Initialize other user properties as needed
  //   },
  //   menu: {
  //     foodId: 0,
  //   foodName: '',
  //   foodPrice:0,
  //   foodQuantity: 0,
  //   imageData: null,
  //   }
  // };

  orderDetails: any = {}; 

 userIdFromQueryParam: number | null = null;
  foodIdFromQueryParam: number | null = null;
  

  constructor(private foodOrderService: FoodOrderServiceService,
     private route: ActivatedRoute,private router: Router) { }

    
   
    
   
    ngOnInit() {
       this.route.queryParams.subscribe(params => {
         this.userIdFromQueryParam = +params['userId'] || null;
         this.foodIdFromQueryParam = +params['foodID'] || null;

         this.orderDetails.user = { userID: this.userIdFromQueryParam };
         this.orderDetails.menu = { foodID: this.foodIdFromQueryParam };
      
       });
     }




     createOrder(): void {
      console.log(this.orderDetails.user.userID);
      console.log(this.orderDetails.menu.foodID);
  
      this.foodOrderService.createOrder(this.orderDetails,this.orderDetails.user.userID,this.orderDetails.menu.foodID)
        .subscribe(
          (response) => {
            console.log('Order created:', response);
            this.goToRestaurantList();
            // Handle success, display a message, or navigate to another page
          },
          (error) => {
            console.error('Error creating order:', error);
            // Handle error, display an error message, etc.
           
          }
        );
    }



    goToRestaurantList(){
      this.router.navigate(['restaurants']);
    }


    
    //  createOrder(): void {
    //   console.log(this.orderDetails.user.userID);
    //   console.log(this.orderDetails.menu.foodId);
  
    //   this.foodOrderService.createOrder(this.orderDetails)
    //     .subscribe(
    //       (response) => {
    //         console.log('Order created:', response);
    //         // Handle success, display a message, or navigate to another page
    //       },
    //       (error) => {
    //         console.error('Error creating order:', error);
    //         // Handle error, display an error message, etc.
    //       }
    //     );
    // }

     


}
