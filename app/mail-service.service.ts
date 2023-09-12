import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Restaurant } from './restaurant';
import { User } from './user';


@Injectable({
  providedIn: 'root'
})
export class MailServiceService {
  private baseURL = "http://localhost:8080/email/";

  constructor(private httpClient: HttpClient) { }


  checkEmail(mail:string, restaurant:Restaurant):Observable<Object>{
    return this.httpClient.post(`${this.baseURL}?userEmail=${mail}`,restaurant);
  }

}
