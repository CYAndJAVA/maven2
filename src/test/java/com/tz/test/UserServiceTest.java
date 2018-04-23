package com.tz.test;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.tz.entity.User;
import com.tz.service.UserService;
import com.tz.util.BeansFactory;

public class UserServiceTest {
    private UserService us = (UserService)BeansFactory.getInstance("userService");
    //通过姓名查询
    @Test
    public void checkNewUsertest(){
        int i = us.checkNewUser("5", "14345678909");
        System.out.println(i);
    }
    @Test
    public void checkLoginuser(){
        int i = us.checkLoginUser("a", "1");
        System.out.println(i);
    }
    @Test
    public void findByNametest(){
        User user = us.findByName("a");
        System.out.println(user);
    }
    //插入数据
    @Test
    public void insertUsertest(){
        List<User> list = new ArrayList<User>();
        User u1 = new User("a", "1", "13145@qq.com", "13190832224","公司1", "苏州");
        User u2 = new User("jks", "1234", "74323@qq.com", "14322234525","公司2", "上海");
        User u3 = new User("mik", "1234", "34245@qq.com", "18657456546","公司3", "南京");
        User u4 = new User("qwe", "1234", "64232@qq.com", "19767545545","公司4", "北京");
        User u5 = new User("aaa", "1234", "98775@qq.com", "13354647458","公司5", "山东");
        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);
        list.add(u5);
        for (User user : list) {
            us.insertUser(user);
        }
    }
    //更新数据
    @Test
    public void updateUsertest(){
        User u1 = new User(1L,"tom", "1234", "13145@qq.com", "13190832224","公司1", "杭州");
        us.updateUser(u1);
    }
    //通过账户名删除数据
    @Test
    public void deleteUserBynametest(){
       us.deleteUserByname(" "); 
    }
}
