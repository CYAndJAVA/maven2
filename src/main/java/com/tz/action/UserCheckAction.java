package com.tz.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tz.entity.User;
import com.tz.service.UserService;
import com.tz.util.BeansFactory;
@WebServlet(urlPatterns="/user/check/*")
public class UserCheckAction extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private UserService us = (UserService) BeansFactory.getInstance("userService");
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String contextPath = req.getContextPath();
        String pathInfo = req.getPathInfo();
        switch(pathInfo){
        case "/checkLogin":
            //0账户不存在；1密码错误；2正确
            String userName = req.getParameter("userName");
            String userPassword = req.getParameter("userPassword");
            //是否记住密码
            String flag = req.getParameter("flag");
            flag = null == flag ?"":(flag.trim().length()>0?flag:"");
            if(flag.equals("yes")){
                Cookie c = new Cookie("login",userName+":"+userPassword);
                c.setPath("/");
                c.setMaxAge(1*24*60*60);
                resp.addCookie(c);
            }else{
               //只能覆盖原先的cookie
                Cookie c = new Cookie("login",":");
                c.setPath("/");
                c.setMaxAge(1);
                resp.addCookie(c);
            }
            Integer i = us.checkLoginUser(userName, userPassword);
            if(i == 2){
                User login_User = us.findByName(userName);
                req.getSession().setAttribute("LoginUser", login_User);
            }
            out.print(i);
            break;
        case "/checkRegister":
            String ndata = req.getParameter("newdata");
            String mbb = req.getParameter("mb");
            Integer mbi = us.checkNewUser(mbb, ndata);
            out.print(mbi);
            break;
        case "/registering":
            String cUserName = req.getParameter("cUserName");
            String cPassword = req.getParameter("cPassword");
            String cEmail = req.getParameter("cEmail");
            String cPhone = req.getParameter("cPhone");
            String cCompany = req.getParameter("cCompany");
            String cAddress = req.getParameter("cAddress");
            User user = new User(cUserName, cPassword, cEmail, cPhone, cCompany, cAddress);
            us.insertUser(user);
            resp.sendRedirect(contextPath);
            break;
        
        }
    
    
    
    }

}
