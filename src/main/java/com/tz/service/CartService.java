package com.tz.service;

import java.util.HashSet;
import java.util.List;

import com.tz.entity.Address;
import com.tz.entity.Order;
import com.tz.entity.OrderItem;
import com.tz.entity.User;
import com.tz.entity.eum.OrderStatus;
import com.tz.vo.MyOrderItems;

public interface CartService {
    //传入session里已存的集合，数量（0清除），书的编号，获取新的集合
   HashSet<OrderItem> getCartSet(String ibsn,Integer number,HashSet<OrderItem> hashSet);
   //获取商品个数和总价
   List<String> getByHashSet(HashSet<OrderItem> s);
   //===============地址==========================
   public void saveAddress(Address address);
   
   public List<Address> findByUId(Long userId);
   
   public void updateAddress(Address address);
   public Address findOneDress(Long userid);
   public Address findByAid(Long AId);
   //仅将该用户的这个地址作为默认地址
   public void updateFleg(Long uid,Long aid);
   //============订单类===========
   public void insertOrder(Order order);
   public List<Order> findOrderByUserId(Long userid);
   public void insertItem(OrderItem item);
   public List<OrderItem> findItemByOrderId(Long orderId);
   //=============整理并获取清单集合===================
   public List<MyOrderItems> lookMyOrderItems(User user, HashSet<OrderItem> hashSet,OrderStatus orderstatus);
   
}
