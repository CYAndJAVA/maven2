package com.tz.mapper;

import java.util.List;

import com.tz.entity.Address;
import com.tz.entity.Order;
import com.tz.entity.OrderItem;

public interface CartMapper {
    public void saveAddress(Address address);
    
    public List<Address> findByUId(Long userId);
    
    public void updateAddress(Address address);
    
    public Address findByAid(Long AId);
    
    //===========订单===========
    public void insertOrder(Order order);
    public List<Order> findOrderByUserId(Long userid);
    
    public void insertItem(OrderItem item);
    public List<OrderItem> findItemByOrderId(Long orderId);
    
}
