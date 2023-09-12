import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { FormsModule} from '@angular/forms';
import { CreateRestaurantComponent } from './create-restaurant/create-restaurant.component';
import { RestaurantDetailsComponent } from './restaurant-details/restaurant-details.component';
import { RestaurantListComponent } from './restaurant-list/restaurant-list.component';
import { UpdateRestaurantComponent } from './update-restaurant/update-restaurant.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { HomeComponent } from './home/home.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { MenuComponent } from './menu/menu.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { SearchLocationComponent } from './search-location/search-location.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { ViewCustomerComponent } from './view-customer/view-customer.component';
import { BookTableComponent } from './book-table/book-table.component';
import { ViewMenuComponent } from './view-menu/view-menu.component';
import { AddFoodmenuComponent } from './add-foodmenu/add-foodmenu.component';
import { SignupComponent } from './signup/signup.component';
import { FoodOrderComponent } from './food-order/food-order.component';
import { ViewOrdersComponent } from './view-orders/view-orders.component';


@NgModule({
  declarations: [
    AppComponent,
    RestaurantListComponent,
    CreateRestaurantComponent,
    UpdateRestaurantComponent,
    RestaurantDetailsComponent,
    HomeComponent,
    AboutUsComponent,
    ContactUsComponent,
    MenuComponent,
    LoginComponent,
    LogoutComponent,
    SearchLocationComponent,
    FeedbackComponent,
    ViewCustomerComponent,
    BookTableComponent,
    ViewMenuComponent,
    AddFoodmenuComponent,
    SignupComponent,
    FoodOrderComponent,
    ViewOrdersComponent,
    

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }


