package com.tz.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

import com.tz.entity.Address;
import com.tz.entity.Order;
import com.tz.entity.OrderItem;
import com.tz.entity.eum.OrderStatus;
import com.tz.service.BookService;
import com.tz.service.CartService;
import com.tz.util.BeansFactory;

public class CartServiceTest {
    private CartService cs = (CartService) BeansFactory.getInstance("cartService");
    private BookService bs = (BookService) BeansFactory.getInstance("bookService");
    @Test
    public void testSet() {
        HashSet<OrderItem> s = new HashSet<OrderItem>();
        
       /* OrderItem i1 = new OrderItem("9787533946418", bs.getByIbsn("9787533946418").getBookname(), bs.getByIbsn("9787533946418").getAuthor(), 2, 1 * bs.getByIbsn("9787533946418").getNewprice());
        OrderItem i2 = new OrderItem("11", bs.getByIbsn("11").getBookname(), bs.getByIbsn("11").getAuthor(), 2, 2 * bs.getByIbsn("11").getNewprice());
        OrderItem i3 = new OrderItem("12", bs.getByIbsn("12").getBookname(), bs.getByIbsn("12").getAuthor(), 3, 3 * bs.getByIbsn("12").getNewprice());
        s.add(i1);s.add(i2);s.add(i3);*/
        HashSet<OrderItem> y = cs.getCartSet("9787533946418", 1, s);
        for (OrderItem yq : y) {
            System.out.println(yq);
        }
    }
    @Test
    public void testsaveaddress(){
        List<Address> list = new ArrayList<Address>();
        Address a = new Address("北京", "大厦", "726400", "woziji", "13098767743", "0", 1L);
        Address a1 = new Address("北京1", "大厦1", "726400", "woziji", "13098767743", "1", 1L);
        Address a2 = new Address("北京2", "大厦2", "726400", "woziji", "13098767743", "1", 1L);
        Address a3 = new Address("北京3", "大厦3", "726400", "woziji", "13098767743", "1", 1L);
        list.add(a); list.add(a1); list.add(a2); list.add(a3);
        for (Address d : list) {
            cs.saveAddress(d);
        }
    
    }
    @Test
    public void findaddressByuserid(){
        List<Address> a = cs.findByUId(1L);
        for (Address d : a) {
            System.out.println(d);
        }
    }
    
    @Test
    public void findaddressByAid(){
        Address a = cs.findByAid(1L);
        System.out.println(a);
    }
    @Test
    public void updateAddress(){
        Address a = new Address(1L,"北dsdsds京", "大fdsf厦", "72640sfs0", "wozifsfsji", "1309876fdsfsf7743", "0fsfs", 1L);
        cs.updateAddress(a);
    
    }
    
    @Test
    public void updatefleg(){
        cs.updateFleg(1L, 6L);
        
    }
    @Test
    public void insertOrder(){
        Order order = new Order(1L, 1L, OrderStatus.未付款);
        cs.insertOrder(order);
    }
    @Test
    public void insertItem(){
        OrderItem o = new OrderItem("9787533946418", 2);
        cs.insertItem(o);
    }
    @Test
    public void findOrderByuid(){
        List<Order> a = cs.findOrderByUserId(1L);
        for (Order r : a) {
            System.out.println(r);
        }
    }
    @Test
    public void finditemByoid(){
        List<OrderItem> a1 = cs.findItemByOrderId(1L);
        for (OrderItem r : a1) {
            System.out.println(r);
        }
    }
    
    @Test
    public void testFindAddress(){
        Address a = cs.findOneDress(1L);
        System.out.println(a);
    }
   
    
}
