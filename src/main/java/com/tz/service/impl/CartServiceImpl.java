package com.tz.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.tz.entity.Address;
import com.tz.entity.Order;
import com.tz.entity.OrderItem;
import com.tz.entity.User;
import com.tz.entity.eum.OrderStatus;
import com.tz.mapper.CartMapper;
import com.tz.service.BookService;
import com.tz.service.CartService;
import com.tz.util.BeansFactory;
import com.tz.util.MybatisUtil;
import com.tz.vo.MyOrderItems;

public class CartServiceImpl implements CartService {
    private BookService bs = (BookService) BeansFactory.getInstance("bookService");

    @Override
    public HashSet<OrderItem> getCartSet(String ibsn, Integer number, HashSet<OrderItem> hashSet) {
        int i = 0;

        OrderItem item = new OrderItem(ibsn, number);
        for (OrderItem nt : hashSet) {
            if (nt.equals(item)) {
                int an = nt.getCounts() + number;
                if (an > 0) {
                    if (an == nt.getCounts()) {
                        hashSet.remove(nt);
                    } else {
                        nt.setCounts(an);
                        nt.setAllprice(bs.getByIbsn(ibsn).getNewprice() * an);
                    }
                } else {
                    hashSet.remove(nt);
                }
            } else {
                i++;
            }
        }
        if (i == hashSet.size()) {
            if (number > 0) {
                hashSet.add(item);
            }
        }
        return hashSet;
    }

    @Override
    public List<String> getByHashSet(HashSet<OrderItem> s) {
        List<String> arr = new ArrayList<String>();
        int a = 0;
        Double b = 0.00;
        if (null != s && s.size() > 0) {
            for (OrderItem f : s) {
                Integer n = f.getCounts();
                Double taot = f.getAllprice();
                a += n;
                b += taot;
            }
        }
        b = (int) (b * 100) * 0.01;
        arr.add(0, a + "");
        arr.add(1, b + "");
        return arr;
    }

    @Override
    public void saveAddress(Address address) {
        SqlSession session = MybatisUtil.getSqlSession();
        CartMapper mapper = session.getMapper(CartMapper.class);
        mapper.saveAddress(address);
        session.commit();
        session.close();
    }

    @Override
    public List<Address> findByUId(Long userId) {
        SqlSession session = MybatisUtil.getSqlSession();
        CartMapper mapper = session.getMapper(CartMapper.class);
        List<Address> list = mapper.findByUId(userId);
        session.close();
        return list;
    }

    @Override
    public void updateAddress(Address address) {
        SqlSession session = MybatisUtil.getSqlSession();
        CartMapper mapper = session.getMapper(CartMapper.class);
        mapper.updateAddress(address);
        session.commit();
        session.close();
    }

    @Override
    public Address findByAid(Long AId) {
        SqlSession session = MybatisUtil.getSqlSession();
        CartMapper mapper = session.getMapper(CartMapper.class);
        Address address = mapper.findByAid(AId);
        session.close();
        return address;
    }

    @Override
    public void updateFleg(Long uid, Long aid) {
        List<Address> list = findByUId(uid);
        for (Address a : list) {
            if(a.getaddressid() == aid){
                a.setisdefault("0");
            }else{
                a.setisdefault("1");
            }
        }
        for (Address b : list) {
           updateAddress(b);
        }
    }

    @Override
    public void insertOrder(Order order) {
        SqlSession session = MybatisUtil.getSqlSession();
        CartMapper mapper = session.getMapper(CartMapper.class);
        mapper.insertOrder(order);
        session.commit();
        session.close();
    }

    @Override
    public void insertItem(OrderItem item) {
        SqlSession session = MybatisUtil.getSqlSession();
        CartMapper mapper = session.getMapper(CartMapper.class);
        mapper.insertItem(item);
        session.commit();
        session.close();
    }

    @Override
    public List<Order> findOrderByUserId(Long userid) {
        SqlSession session = MybatisUtil.getSqlSession();
        CartMapper mapper = session.getMapper(CartMapper.class);
        List<Order> list = mapper.findOrderByUserId(userid);
        session.close();
        return list;
    }

    @Override
    public List<OrderItem> findItemByOrderId(Long orderId) {
        SqlSession session = MybatisUtil.getSqlSession();
        CartMapper mapper = session.getMapper(CartMapper.class);
        List<OrderItem> list = mapper.findItemByOrderId(orderId);
        session.close();
        return list;
    }

    @Override
    public List<MyOrderItems> lookMyOrderItems(User user, HashSet<OrderItem> hashSet,OrderStatus orderstatus) {
        List<MyOrderItems> list = new ArrayList<MyOrderItems>();
        if(null != hashSet & hashSet.size() > 0){
            Order order = new Order(user.getUserId(), findOneDress(user.getUserId()).getaddressid(), orderstatus);
            insertOrder(order);
            for (OrderItem hset : hashSet) {
                hset.setT_orderid(order.getOrderid());
                insertItem(hset);
            }
            //select
            List<Order> op = findOrderByUserId(user.getUserId());
            for (Order er : op) {
                MyOrderItems a = new MyOrderItems(user.getUserId(), er,
                        findOneDress(user.getUserId()), findItemByOrderId(er.getOrderid()));
                list.add(a);
            }
        }
        return list;
    }

    @Override
    public Address findOneDress(Long userid) {
        int i = 0;
        Address a = new Address();
        List<Address> list = findByUId(userid);
        for (Address address : list) {
            if("0".equals(address.getisdefault())){
               a =  address;
            }else{
                i++;
            }
        }
        if(i == list.size()){
            list.get(0).setisdefault("0");
            a = list.get(0);
            updateFleg(userid, list.get(0).getaddressid());
        }
        return a;
    }
    

}
