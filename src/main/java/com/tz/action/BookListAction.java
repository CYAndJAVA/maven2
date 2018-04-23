package com.tz.action;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tz.entity.Book;
import com.tz.entity.BookStyle;
import com.tz.entity.OrderItem;
import com.tz.service.BookService;
import com.tz.service.BookStyleService;
import com.tz.service.CartService;
import com.tz.util.BeansFactory;
import com.tz.vo.PageBean;

@WebServlet(urlPatterns = "/book/*")
public class BookListAction extends HttpServlet {

    /**
     * 获取书本信息
     */
    private static final long serialVersionUID = 1L;
    private BookStyleService bss = (BookStyleService) BeansFactory.getInstance("bookStyleService");
    private BookService bs = (BookService) BeansFactory.getInstance("bookService");
    private CartService cs = (CartService) BeansFactory.getInstance("cartService");
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String path = req.getPathInfo();
        // 页面上那个唯一图标
        String imgSigel = bs.findAll("tubiao", null, 1, 1).getDatas().get(0).getImgurl();
        // 图书类型集合
        List<BookStyle> StyleList = bss.findAllStyle();
        // 录播图片
        List<Book> lunlist = bs.findAll("gun", null, 1, 3).getDatas();

        req.setAttribute("StyleList", StyleList);
        req.setAttribute("imgSigel", imgSigel);
        req.setAttribute("lunlist", lunlist);
        switch (path) {
        case "/booksview":
            String searchName = "";
            searchName = req.getParameter("searchName");
            searchName = null == searchName ? "" : (searchName.trim().length() > 0 ? searchName : "");
            req.setAttribute("searchName", searchName);
            req.getRequestDispatcher("/WEB-INF/pages/book/index.jsp").forward(req, resp);
            break;
        case "/bookseek1":
            // 精选图书id
            
            String a = req.getParameter("searchName1");
            String bname1 = null == a ? "" :(a.trim().length()>0?a:"");
            
            Long styleId = 1L;
            int pageSize = 4;
            // 接收pageNow
            String pageNow = req.getParameter("pageNow");
            if (pageNow == null) {
                pageNow = "1";
            }
            // 获取图书类型
            BookStyle bookStyle = new BookStyle(styleId, bss.findStyleNameById(styleId.intValue()));
            PageBean<Book> pageBean = bs.findAll(bname1, styleId, Integer.parseInt(pageNow), pageSize);

            req.setAttribute("pageBean", pageBean);
            req.setAttribute("bookStyle", bookStyle);
            // 转发到bookStyle1.jsp页面
            req.getRequestDispatcher("/WEB-INF/pages/bookview/bookstyle.jsp").forward(req, resp);
            break;
        case "/bookseek2":
            // 精选图书id
            String a2 = req.getParameter("searchName2");
            String bname2 = null == a2 ? "" :(a2.trim().length()>0?a2:"");
            Long styleId2 = 2L;
            int pageSize2 = 4;
            // 接收pageNow
            String pageNow2 = req.getParameter("pageNow2");
            if (pageNow2 == null) {
                pageNow2 = "1";
            }
            // 获取图书类型
            BookStyle bookStyle2 = new BookStyle(styleId2, bss.findStyleNameById(styleId2.intValue()));
            PageBean<Book> pageBean2 = bs.findAll(bname2, styleId2, Integer.parseInt(pageNow2), pageSize2);

            req.setAttribute("pageBean2", pageBean2);
            req.setAttribute("bookStyle2", bookStyle2);
            // 转发到bookStyle1.jsp页面
            req.getRequestDispatcher("/WEB-INF/pages/bookview/bookstyle2.jsp").forward(req, resp);
            break;
        case "/bookseek3":
            // 精选图书id
            String a3 = req.getParameter("searchName3");
            String bname3 = null == a3 ? "" :(a3.trim().length()>0?a3:"");
            Long styleId3 = 3L;
            int pageSize3 = 4;
            // 接收pageNow
            String pageNow3 = req.getParameter("pageNow3");
            if (pageNow3 == null) {
                pageNow3 = "1";
            }
            // 获取图书类型
            BookStyle bookStyle3 = new BookStyle(styleId3, bss.findStyleNameById(styleId3.intValue()));
            PageBean<Book> pageBean3 = bs.findAll(bname3, styleId3, Integer.parseInt(pageNow3), pageSize3);

            req.setAttribute("pageBean3", pageBean3);
            req.setAttribute("bookStyle3", bookStyle3);
            // 转发到bookStyle1.jsp页面
            req.getRequestDispatcher("/WEB-INF/pages/bookview/bookstyle3.jsp").forward(req, resp);
            break;
        case "/bookStyleView":
            String StyleId = req.getParameter("styleId");
            // 封装第二页面的图书类型
            BookStyle stle = new BookStyle(Long.parseLong(StyleId), bss.findStyleNameById(Integer.parseInt(StyleId)));
            PageBean<Book> pgx = bs.findAll("", Long.parseLong(StyleId), 1, 8);
            req.setAttribute("pgBean", pgx);
            req.setAttribute("stle", stle);
            req.getRequestDispatcher("/WEB-INF/pages/book/index2.jsp").forward(req, resp);
            break;
        case "/pageContorl":
            // 初始化默认值
            String bookname_c = "";
            Long styleId_c = 1L;
            Integer pageNow_c = 1;
            Integer pageSize_c = 8;
            // 接受参数
            String sName = req.getParameter("sName");
            String pgNow = req.getParameter("pgNow");
            String pgSize = req.getParameter("pgSize");
            String sty_id = req.getParameter("sty_id");

            if (null != sty_id && sty_id.trim().length() > 0) {
                styleId_c = Long.parseLong(sty_id);
            }
            if (null != sName && sName.trim().length() > 0) {
                bookname_c = sName;
            }
            if (null != pgNow && pgNow.trim().length() > 0) {
                pageNow_c = Integer.parseInt(pgNow);
            }
            if (null != pgSize && pgSize.trim().length() > 0) {
                pageSize_c = Integer.parseInt(pgSize);
            }

            PageBean<Book> pg = bs.findAll(bookname_c, styleId_c, pageNow_c, pageSize_c);
            BookStyle stle1 = new BookStyle(styleId_c, bss.findStyleNameById(styleId_c.intValue()));
            req.setAttribute("stle", stle1);
            req.setAttribute("pgBean", pg);
            req.getRequestDispatcher("/WEB-INF/pages/book/index2.jsp").forward(req, resp);
            break;
        case "/detail":
            String seeBId = req.getParameter("seeBId");
            String numberNow = "0";
            String allPriceNow = "0";
            Book book = bs.getById(Integer.parseInt(seeBId));
            
            @SuppressWarnings("unchecked")
            HashSet<OrderItem> rightset = (HashSet<OrderItem>) req.getSession().getAttribute("myHashSet");
            if(null != rightset && rightset.size() > 0){
                List<String> sls = cs.getByHashSet(rightset);
                numberNow = sls.get(0);
                allPriceNow = sls.get(1);
            }
            req.setAttribute("numberNow", numberNow);
            req.setAttribute("allPriceNow", allPriceNow);
            req.setAttribute("book", book);
            
            req.getRequestDispatcher("/WEB-INF/pages/book/details.jsp").forward(req, resp);
            break;
        }

    }
}
