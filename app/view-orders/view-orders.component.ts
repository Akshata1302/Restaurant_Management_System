import { Component, OnInit } from '@angular/core';
import { OrderDetails } from '../OrderDetails';
import { Menu } from '../menu';
import { ActivatedRoute } from '@angular/router';
import { FoodOrderServiceService } from '../food-order-service.service';

@Component({
  selector: 'app-view-orders',
  templateUrl: './view-orders.component.html',
  styleUrls: ['./view-orders.component.css']
})
export class ViewOrdersComponent {
 


  userID: number=0;
  //orderDetails: OrderDetails[] = [];
  orderDetails: OrderDetails[] = []; 
  foodOrderedByUser : Menu[] = [];
  

  constructor(private route: ActivatedRoute, private orderService: FoodOrderServiceService) { 
   
  }

  ngOnInit() {
    this.userID = this.route.snapshot.params['userID'];
      this.orderService.getOrderDetails(this.userID)
      .subscribe(
        (data) => {
         
            this.orderDetails = data; 
          console.log(data);
          
        },
        error => {
          console.error('Error fetching order details:', error);
          
        }
      );
   
  }

  // loadOrderDetails() {
  //   this.orderService.getOrderDetails(this.userID)
  //     .subscribe(
  //       (data: OrderDetails[]) => { 
  //         if (data.length > 0) {
  //           this.orderDetails = data[0]; 
  //         } else {
           
  //         }
  //       },
  //       error => {
  //         console.error('Error fetching order details:', error);
  //       }
  //     );
  // }



}
