package com.tz.service;
import com.tz.entity.Book;
import com.tz.vo.PageBean;
public interface BookService {
    //插入书
    public void insertBook(Book book);
    
    public PageBean<Book> findAll(String bookname,Long styleId,Integer pageNow,Integer pageSize);
    
    public Integer getRows(String bookName,Long styleId);
    
    public Book getById(Integer id);
    
    public Book getByIbsn(String ibsn);
}
