package com.example.RestaurantManagement.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_Details")
public class OrderDetails {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;
	
	
	
	@ManyToOne
    @JoinColumn(name = "userID")
	@OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @ManyToOne
    @JoinColumn(name = "foodID")
    private Menu menu;
    
    

	public Integer getOrderId() {
		return orderId;
	}

	public User getUser() {
		return user;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", user=" + user + ", menu=" + menu + "]";
	}
    
    

	
	

//
//
//    @OneToOne
//    @JoinColumn(name = "userID")
//    private User user;
//
//    @OneToMany(mappedBy = "orderDet")
//    private List<Menu> menuList;
//
//
//	public void setMenuList(List<Menu> menuList) {
//		this.menuList = menuList;
//	}
//
//
//	public OrderDetails() {
//		
//	}
//
//
//	public User getUser() {
//		return user;
//	}
//
//
//
//	public Integer getOrderId() {
//		return orderId;
//	}
//
//
//	public void setOrderId(Integer orderId) {
//		this.orderId = orderId;
//	}
//
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//
//	
//	
//
//
//	@Override
//	public String toString() {
//		return "OrderDetails [orderId=" + orderId + ", user=" + user + ", menu=" +  "]";
//	}
//	

}
