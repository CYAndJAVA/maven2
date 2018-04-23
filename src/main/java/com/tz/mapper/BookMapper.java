package com.tz.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tz.entity.Book;


public interface BookMapper {
    //插入图书
    public void insertBook(Book book);
    //多条件分页查询
    public List<Book> findAll(@Param("bookName")String bookname,@Param("styleId")Long styleId,@Param("pageNow")Integer pageNow,@Param("pageSize")Integer pageSize);
    //条件查询个数
    public Integer getRows(@Param("bookName")String bookName,@Param("styleId")Long styleId);
     //查询一条对象
    public Book getById(Integer id);
    
    public Book getByIbsn(String ibsn);
    
    
}