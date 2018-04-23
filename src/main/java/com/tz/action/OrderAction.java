package com.tz.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tz.entity.Address;
import com.tz.entity.Book;
import com.tz.entity.BookStyle;
import com.tz.entity.OrderItem;
import com.tz.entity.User;
import com.tz.entity.eum.OrderStatus;
import com.tz.service.BookService;
import com.tz.service.BookStyleService;
import com.tz.service.CartService;
import com.tz.util.BeansFactory;
import com.tz.vo.MyOrderItems;
@WebServlet(urlPatterns="/user/cart/order/*")
public class OrderAction extends HttpServlet{

    private static final long serialVersionUID = 1L;
    private BookStyleService bss = (BookStyleService) BeansFactory.getInstance("bookStyleService");
    private BookService bs = (BookService) BeansFactory.getInstance("bookService");
    private CartService cs = (CartService) BeansFactory.getInstance("cartService");
    @SuppressWarnings({ "unchecked", "unused" })
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        PrintWriter out = resp.getWriter();
        String imgSigel = bs.findAll("tubiao", null, 1, 1).getDatas().get(0).getImgurl();
        // 图书类型集合
        List<BookStyle> StyleList = bss.findAllStyle();
        // 录播图片
        List<Book> lunlist = bs.findAll("gun", null, 1, 3).getDatas();
        req.setAttribute("StyleList", StyleList);
        req.setAttribute("imgSigel", imgSigel);
        req.setAttribute("lunlist", lunlist);
        User user = (User) req.getSession().getAttribute("LoginUser");
        switch(pathInfo){
        case "/addressView":
            String aid = req.getParameter("addressId");
            if(null != aid && aid.trim().length() > 0){
                Long aId = Long.parseLong(aid);
                cs.updateFleg(user.getUserId(), aId);
            }
            List<Address> list = cs.findByUId(user.getUserId());
            req.setAttribute("addressList", list);
            req.getRequestDispatcher("/WEB-INF/pages/common/addressList.jsp").forward(req, resp);
            break;
        case "/checkAddress":
            int cn = 0;
            String fleg = req.getParameter("fleg");
            String locass = req.getParameter("locass");
            String addtail = req.getParameter("addtail");
            String youbian = req.getParameter("youbian");
            String reciver = req.getParameter("reciver");
            String recivtel = req.getParameter("recivtel");
            Address adrs = new Address(locass, addtail, youbian, reciver, recivtel, fleg, user.getUserId());
            if(null != adrs){
                cs.saveAddress(adrs);
                out.print("1");
            }else{
                out.print("0");
            }
            break;
        case "/orderListview":
            User users = (User) req.getSession().getAttribute("LoginUser");
            HashSet<OrderItem> hset = (HashSet<OrderItem>) req.getSession().getAttribute("myHashSet");
            List<MyOrderItems> liste = cs.lookMyOrderItems(users, hset, OrderStatus.交易成功);
            req.setAttribute("liste", liste);
            req.getRequestDispatcher("/WEB-INF/pages/userCart/order_list.jsp").forward(req, resp);
            break;
        
        
        
        
        
        
        }
    }
}
