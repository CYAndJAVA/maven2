package com.tz.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.ibatis.session.SqlSession;

import com.tz.entity.User;
import com.tz.mapper.UserMapper;
import com.tz.service.UserService;
import com.tz.util.MybatisUtil;

public class UserServiceImpl implements UserService {

    @Override
    public User findByName(String name) {
        SqlSession session = MybatisUtil.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.findByName(name);
        session.close();
        return user;
    }

    @Override
    public void insertUser(User user) {
        SqlSession session = MybatisUtil.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.insertUser(user);
        session.commit();
        session.close();
    }

    @Override
    public void updateUser(User user) {
        SqlSession session = MybatisUtil.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.updateUser(user);
        session.commit();
        session.close();
    }

    @Override
    public void deleteUserByname(String name) {
        SqlSession session = MybatisUtil.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.deleteUserByname(name);
        session.commit();
        session.close();
    }
    
    //校验注册客户
  // mb=1名字 ，    2密码，     4邮箱。  5电话，   6公司，   7地址/邮政编码
    //对  11名字 ， 21密码， 41邮箱。51电话，61公司，71地址/邮政编码
    //错  12名字 ， 22密码， 42邮箱。52电话，62公司，72地址/邮政编码
    @Override
    public int checkNewUser(String m, String newData) {
        int ck = 0;
        String regEx = null;
        Pattern pattern = null;
        Matcher matcher = null;
        boolean rs = true;
        int mb = Integer.valueOf(m);
        String newdata = newData==null?"":newData;
        if(mb==1){
            regEx = "[A-Za-z][A-Za-z1-9_-]+";
            pattern = Pattern.compile(regEx);
            matcher = pattern.matcher(newdata);
            rs = matcher.matches();
            if(rs==true){
                User user = findByName(newdata);
                if(user==null){
                    ck=11;
                }else{
                    ck=12;
                }
            }else{
                ck=12;
            }
            
        }else if(mb==2){
            regEx = "[A-Za-z1-9_-]+";
            pattern = Pattern.compile(regEx);
            matcher = pattern.matcher(newdata);
            rs = matcher.matches();
            if(rs==true){
               ck = 21;
            }else{
               ck = 22;
            }
            
        }else if(mb==4){
            regEx = "[A-Za-z1-9_-]+@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
            pattern = Pattern.compile(regEx);
            matcher = pattern.matcher(newdata);
            rs = matcher.matches();
            if(rs==true){
               ck = 41;
            }else{
               ck = 42;
            }
        }else if(mb==5){
            regEx = "1[3|4|5|8][0-9]\\d{8}";
            pattern = Pattern.compile(regEx);
            matcher = pattern.matcher(newdata);
            rs = matcher.matches();
            if(rs==true){
               ck = 51;
            }else{
               ck = 52;
            }
            
        }else if(mb==6){
            if(newdata.equals("")){
                ck = 62;
            }else{
                ck = 61;
            }
            
        }else if(mb==7){
            if(newdata.equals("")){
                ck = 72;
            }else{
                ck = 71;
            }
            
        }
        return ck;
    }
    //0账户不存在；1密码错误；2正确
    @Override
    public int checkLoginUser(String name, String passWord) {
        int i = 0;
        name = null==name?"":(name.trim().length()>0?name:"");
        passWord = null==passWord?"":(passWord.trim().length()>0?passWord:"");
        User user = findByName(name);
        if(null != user){
            if(user.getPassWord().equals(passWord)){
                i = 2;
            }else{
                i = 1;
            }
        }
        return i;
    }

}
