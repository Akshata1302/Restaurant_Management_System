import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { OrderDetails } from './OrderDetails';
import {Menu} from './menu';
import { Restaurant } from './restaurant';
import { map } from 'rxjs/operators';
import { User } from './user';


@Injectable({
  providedIn: 'root'
})
export class FoodOrderServiceService {

  private baseURL = "http://localhost:8080/order";

  constructor(private httpClient: HttpClient) { }

 createOrder(orderDetails: OrderDetails, userID: number, foodId: number): Observable<OrderDetails> {
    return this.httpClient.post<OrderDetails>(`${this.baseURL}/orderFood/${userID}/${foodId}`, orderDetails);
  }


  // getOrderDetails(orderId: number): Observable<OrderDetails> {
  //   return this.httpClient.get<OrderDetails>(`${this.baseURL}/${orderId}`);
  // }

   getOrderDetails(userID: number): Observable<OrderDetails[]> {
    return this.httpClient.get<OrderDetails[]>(`${this.baseURL}/user/details/${userID}`);
  }
  
}
