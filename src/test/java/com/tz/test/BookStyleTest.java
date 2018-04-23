package com.tz.test;

import java.util.List;

import org.junit.Test;

import com.tz.entity.BookStyle;
import com.tz.entity.eum.Category;
import com.tz.service.BookStyleService;
import com.tz.util.BeansFactory;

public class BookStyleTest {
    BookStyleService bs = (BookStyleService) BeansFactory.getInstance("bookStyleService");
    @Test
    public void testfindid(){
        Long i = bs.findStyleIdByName(Category.精选图书.toString());
        System.out.println(i);
    }
    @Test
    public void testfindname(){
        System.out.println(bs.findStyleNameById(1));
    }
    @Test
    public void testfindall(){
        List<BookStyle> list = bs.findAllStyle();
        for (BookStyle c : list) {
           System.out.println(c); 
        }
    }
   /* @Test
    public void testinsert(){
        List<BookStyle> list = new ArrayList<BookStyle>();
        BookStyle b1 = new BookStyle(Category.精选图书.toString());
        BookStyle b2 = new BookStyle(Category.推荐图书.toString());
        BookStyle b3 = new BookStyle(Category.特价图书.toString());
        list.add(b1);list.add(b2);list.add(b3);
        for(BookStyle s:list){
            bs.insertStyle(s);
        }
    }*/
}
