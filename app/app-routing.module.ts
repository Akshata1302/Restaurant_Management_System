import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RestaurantListComponent } from './restaurant-list/restaurant-list.component';
import { CreateRestaurantComponent } from './create-restaurant/create-restaurant.component';
import { UpdateRestaurantComponent } from './update-restaurant/update-restaurant.component';
import { RestaurantDetailsComponent } from './restaurant-details/restaurant-details.component';
import { HomeComponent } from './home/home.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import {MenuComponent }from'./menu/menu.component';
import {LoginComponent}from'./login/login.component';
import {LogoutComponent} from'./logout/logout.component';
import { AuthGaurdServiceService } from './auth-gaurd-service.service';
import { SearchLocationComponent } from './search-location/search-location.component';
import{FeedbackComponent}from'./feedback/feedback.component';
import { ViewCustomerComponent } from './view-customer/view-customer.component';
import { BookTableComponent } from './book-table/book-table.component';
import { ViewMenuComponent } from './view-menu/view-menu.component';
 import { AddFoodmenuComponent } from './add-foodmenu/add-foodmenu.component';
 import { SignupComponent } from './signup/signup.component';
 import { FoodOrderComponent } from './food-order/food-order.component';
 import { ViewOrdersComponent } from './view-orders/view-orders.component';





const routes: Routes = [
  {path: 'restaurants', component: RestaurantListComponent,canActivate:[AuthGaurdServiceService]},
  {path: 'create-restaurant', component: CreateRestaurantComponent,canActivate:[AuthGaurdServiceService]},
    {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'update-restaurant/:restaurantId', component: UpdateRestaurantComponent,canActivate:[AuthGaurdServiceService]},
  {path: 'restaurant-details/:restaurantId', component: RestaurantDetailsComponent,canActivate:[AuthGaurdServiceService]},
  {path:'home',component:HomeComponent},
  {path:'about-us',component:AboutUsComponent},
  {path:'contact-us',component:ContactUsComponent},
  {path:'menu',component:MenuComponent,canActivate:[AuthGaurdServiceService]},
  {path: 'login', component: LoginComponent},
  { path: 'logout', component: LogoutComponent,canActivate:[AuthGaurdServiceService]},
  {path: 'search-location',component:SearchLocationComponent},
  {path:'feedback',component:FeedbackComponent},
  {path:'view-user/:restaurantId',component:ViewCustomerComponent},
 {path:'book-table/:restaurantId',component:BookTableComponent},
 {path:'view-menu/:restaurantId',component:ViewMenuComponent},
 {path:'add-menu/:restaurantId',component:AddFoodmenuComponent},
 {path:'signup',component:SignupComponent},
 {path:'food-order',component:FoodOrderComponent},
 {path:'view-orders/:userID',component:ViewOrdersComponent}
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
