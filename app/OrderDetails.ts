import { Menu } from "./menu";
import { User } from "./user";

export interface OrderDetails {
  orderId: number;
  user: User;
  menu: Menu; 
    
  
}