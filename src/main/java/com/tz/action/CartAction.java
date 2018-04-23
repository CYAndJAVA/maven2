package com.tz.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.tz.entity.Book;
import com.tz.entity.BookStyle;
import com.tz.entity.OrderItem;
import com.tz.service.BookService;
import com.tz.service.BookStyleService;
import com.tz.service.CartService;
import com.tz.util.BeansFactory;
@WebServlet(urlPatterns="/user/cart/*")
public class CartAction extends HttpServlet{

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
        
        switch(pathInfo){
        case "/getItem":
            String num = req.getParameter("number");
            HashSet<OrderItem> rightset = (HashSet<OrderItem>) req.getSession().getAttribute("myHashSet");
            if(null != num && num.trim().length() > 0){
                Integer number = Integer.parseInt(num);
                String bookIsbn = req.getParameter("bookIsbn");
                HashSet<OrderItem> hset = (HashSet<OrderItem>) req.getSession().getAttribute("myHashSet");
                if(null == hset){
                    hset = new HashSet<OrderItem>();
                }
                HashSet<OrderItem> newset = cs.getCartSet(bookIsbn, number, hset);
                req.getSession().setAttribute("myHashSet", newset);
                out.print("1"); 
            }else{
                out.print("0");
            }
            break;
        case "/getItems":
             String trs = "";
             String nums = req.getParameter("number");
             HashSet<OrderItem> rightsets = (HashSet<OrderItem>) req.getSession().getAttribute("myHashSet");
             if(null != nums && nums.trim().length() > 0){
                 Integer numbers = Integer.parseInt(nums);
                 String bookIsbns = req.getParameter("bookIsbn");
                 HashSet<OrderItem> hsets = (HashSet<OrderItem>) req.getSession().getAttribute("myHashSet");
                 if(null == hsets){
                     hsets = new HashSet<OrderItem>();
                 }
                 HashSet<OrderItem> newsets = cs.getCartSet(bookIsbns, numbers, hsets);
                 req.getSession().setAttribute("myHashSet", newsets);
                 trs = "1"; 
             }else{
                 trs = "0";
             }
             HashSet<OrderItem> newrightsets = (HashSet<OrderItem>) req.getSession().getAttribute("myHashSet");
             List<String> sls = cs.getByHashSet(newrightsets);
             sls.add(2, trs);
             JSONArray arr = (JSONArray) JSONArray.toJSON(sls);
             out.print(arr.toString());
             break;
             //0个数 1总价 2（1收藏成功，0失败）
        case "/MyCart":
            String numberNow = "0";
            String allPriceNow = "0";
            HashSet<OrderItem> riset = (HashSet<OrderItem>) req.getSession().getAttribute("myHashSet");
            if(null != riset && riset.size() > 0){
                List<String> sd = cs.getByHashSet(riset);
                numberNow = sd.get(0);
                allPriceNow = sd.get(1);
            }
            
            req.setAttribute("numberNow", numberNow);
            req.setAttribute("allPriceNow", allPriceNow);
            req.getRequestDispatcher("/WEB-INF/pages/userCart/cart.jsp").forward(req, resp);
            break;
        case "/delItems":
            String dstrc = req.getParameter("dstrc");
            dstrc = dstrc.substring(0, dstrc.length()-1);
            if(null != dstrc && dstrc.trim().length() > 0){
                HashSet<OrderItem> hsets = (HashSet<OrderItem>) req.getSession().getAttribute("myHashSet");
                HashSet<OrderItem> hset = new HashSet<OrderItem>();
                String[] dstrcarr = dstrc.split(";");
                for(int i = 0;i < dstrcarr.length;i++){
                    if(dstrcarr[i].trim().length() > 0){
                        hset = cs.getCartSet(dstrcarr[i], 1, hset);
                    }
                }
                hsets.removeAll(hset);
                out.print("1");
            } else {
                out.print("0");
            }
            break;
        case "/BuyView":
            String numberBuy = "0";
            String allPriceBuy = "0";
            HashSet<OrderItem> buyset = (HashSet<OrderItem>) req.getSession().getAttribute("myHashSet");
            if(null != buyset && buyset.size() > 0){
                List<String> sd = cs.getByHashSet(buyset);
                numberBuy = sd.get(0);
                allPriceBuy = sd.get(1);
            }
            req.setAttribute("numberNow", numberBuy);
            req.setAttribute("allPriceNow", allPriceBuy);
            req.getRequestDispatcher("/WEB-INF/pages/userCart/confirm_order.jsp").forward(req, resp);
            break;
        
        
        
        
        
        
        
        
        
        }
    }
}
