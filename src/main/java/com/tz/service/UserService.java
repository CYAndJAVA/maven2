package com.tz.service;

import com.tz.entity.User;

public interface UserService {
    //通过姓名查询
    public User findByName(String name);
    //插入数据
    public void insertUser(User user);
    //更新数据
    public void updateUser(User user);
    //通过账户名删除数据
    public void deleteUserByname(String name);
    //校验客户
    // mb=1名字 ， 2密码， 4邮箱。5电话，6公司，7地址
    //对  11名字 ， 21密码， 41邮箱。51电话，61公司，71地址
    //错  12名字 ， 22密码， 42邮箱。52电话，62公司，72地址
    public int checkNewUser(String mb,String newData);
    
    //0账户不存在；1密码错误；2正确
    public int checkLoginUser(String name, String passWord);
}
