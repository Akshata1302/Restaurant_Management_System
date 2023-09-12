import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Admin } from './admin';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationServiceService {


constructor (private httpClient : HttpClient){}
 private baseURL = "http://localhost:8080/admins";

  // authenticate(username : any, password : any)  {
  //   if (username === "janani" && password === "password") { //pass
  //     sessionStorage.setItem('username', username)
  //     return true;
  //   } else {
  //     return false;
  //   }
  // }

  isUserLoggedIn() {
    // let user = sessionStorage.getItem('username') 
    // console.log(!(user === null)) //!false
    // return !(user === null)
    let isUserActive = localStorage.getItem("loginStatus");
     return !(isUserActive === null)
  }

  logOut() {
   // sessionStorage.removeItem('username')
    localStorage.removeItem('loginStatus');
  }

   signup(admin:Admin):Observable<any>
  {
     const headers={'content-type':'application/json'};
     const body=JSON.stringify(admin);
     return this.httpClient.post(`${this.baseURL}/signup`,body,{'headers':headers});
  }
 
  signin(email:any, password:any):Observable<any>
  {
    
     const params=new HttpParams().set('email',email).set('password',password);
     console.log(params);
    //?password = ${}&email
  //  return this.httpClient.get(`${this.baseURL}/login?${email}&${password}`);
  return this.httpClient.get(`${this.baseURL}/login`,{params});
  }
}
