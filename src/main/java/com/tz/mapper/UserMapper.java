package com.tz.mapper;

import com.tz.entity.User;

public interface UserMapper {
    //通过姓名查询
    public User findByName(String name);
    //插入数据
    public void insertUser(User user);
    //更新数据
    public void updateUser(User user);
    //通过账户名删除数据
    public void deleteUserByname(String name);

}
