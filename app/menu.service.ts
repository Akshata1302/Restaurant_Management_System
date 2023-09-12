import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Menu } from './menu';
import { Observable } from 'rxjs';
import { User } from './user';
import { map } from 'rxjs/operators';
import { Restaurant } from './restaurant';


@Injectable({
  providedIn: 'root'
})
export class MenuService {
  private baseURL = "http://localhost:8080/menu";

  constructor(private httpClient: HttpClient) { }

  addFoodwithImage(restaurantId: number, menu: Menu,file: File): Observable<any> {

    const formData = new FormData();
    formData.append('file', file, file.name);
    formData.append('foodName', menu.foodName);
    formData.append('foodPrice', menu.foodPrice.toString());
    formData.append('foodQuantity', menu.foodQuantity.toString());
    return this.httpClient.post(`${this.baseURL}/addFood/${restaurantId}`,formData);


  }
  getMenuForRespectiveRestaurants(restaurantId: number): Observable<Menu[]>{
     return this.httpClient.get<Menu[]>(`${this.baseURL}/bookedMenus/${restaurantId}`);

  }


  deleteAllFoods(): Observable<any> {
  return this.httpClient.delete(`${this.baseURL}/deleteAll`);
}


deleteFoodById(foodID: number): Observable<Object>{  //2
  return this.httpClient.delete(`${this.baseURL}/deletemenu/${foodID}`);
}

getMenuwithimage(foodID: number): Observable<Menu[]> {
  return this.httpClient.get<Menu[]>(`${this.baseURL}/foodWithImage/${foodID}`);
}

}
