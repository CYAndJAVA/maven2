package com.tz.vo;

import java.io.Serializable;
import java.util.List;

import com.tz.entity.Address;
import com.tz.entity.Order;
import com.tz.entity.OrderItem;
import com.tz.service.CartService;
import com.tz.util.BeansFactory;

public class MyOrderItems implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private CartService cs = (CartService) BeansFactory.getInstance("cartService");
    private Long userId;
    private Order ord;
    private double allPrice;
    private Address address;
    private List<OrderItem> list;
    public MyOrderItems() {
        super();
    }
    public MyOrderItems(Long userId, Order order, double allPrice, Address address, List<OrderItem> list) {
        super();
        this.userId = userId;
        this.ord = order;
        this.allPrice = allPrice;
        this.address = address;
        this.list = list;
    }
    public MyOrderItems(Long userId, Order order, Address address, List<OrderItem> list) {
        super();
        this.userId = userId;
        this.ord = order;
        this.address = address;
        this.list = list;
        
        double all = 0;
        for (OrderItem olst : list) {
            all+=olst.getAllprice();
        }
       this.allPrice = all;
    }
    public CartService getCs() {
        return cs;
    }
    public void setCs(CartService cs) {
        this.cs = cs;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Order getOrder() {
        return ord;
    }
    public void setOrder(Order order) {
        this.ord = order;
    }
    public double getAllPrice() {
        return allPrice;
    }
    public void setAllPrice(double allPrice) {
        this.allPrice = allPrice;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public List<OrderItem> getList() {
        return list;
    }
    public void setList(List<OrderItem> list) {
        this.list = list;
    }
    @Override
    public String toString() {
        return "MyOrderItems [cs=" + cs + ", userId=" + userId + ", order=" + ord + ", allPrice=" + allPrice
                + ", address=" + address + ", list=" + list + "]";
    }
}
