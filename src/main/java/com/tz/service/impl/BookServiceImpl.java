package com.tz.service.impl;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import com.tz.entity.Book;
import com.tz.mapper.BookMapper;
import com.tz.service.BookService;
import com.tz.util.MybatisUtil;
import com.tz.vo.PageBean;

public class BookServiceImpl implements BookService{

    @Override
    public void insertBook(Book book) {
        SqlSession session = MybatisUtil.getSqlSession();
        BookMapper mapper = session.getMapper(BookMapper.class);
        mapper.insertBook(book);
        session.commit();
        session.close();
        
    }

    @Override
    public PageBean<Book> findAll(String bookname, Long styleId, Integer pageNow, Integer pageSize) {
        SqlSession session = MybatisUtil.getSqlSession();
        BookMapper mapper = session.getMapper(BookMapper.class);
        PageBean<Book> pages = new PageBean<Book>(getRows(bookname, styleId), pageSize);
        pages.setCurrent(pageNow);
        List<Book> datas = mapper.findAll(bookname, styleId, pages.getCurrent(), pages.getPageSize());
        pages.setDatas(datas);
        session.close();
        return pages;
    }

    @Override
    public Integer getRows(String bookName, Long styleId) {
        SqlSession session = MybatisUtil.getSqlSession();
        BookMapper mapper = session.getMapper(BookMapper.class);
        Integer i = mapper.getRows(bookName, styleId);
        session.close();
        return i;
    }

    @Override
    public Book getById(Integer id) {
        SqlSession session = MybatisUtil.getSqlSession();
        BookMapper mapper = session.getMapper(BookMapper.class);
        Book b = mapper.getById(id);
        session.close();
        return b;
    }

    @Override
    public Book getByIbsn(String ibsn) {
        SqlSession session = MybatisUtil.getSqlSession();
        BookMapper mapper = session.getMapper(BookMapper.class);
        Book book = mapper.getByIbsn(ibsn);
        session.close();
        return book;
    }
   

}
