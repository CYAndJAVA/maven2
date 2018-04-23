package com.tz.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.tz.entity.BookStyle;
import com.tz.mapper.BookStyleMapper;
import com.tz.service.BookStyleService;
import com.tz.util.MybatisUtil;

public class BookStyleServiceImpl implements BookStyleService{

    @Override
    public void insertStyle(BookStyle style) {
        SqlSession session = MybatisUtil.getSqlSession();
        BookStyleMapper mapper = session.getMapper(BookStyleMapper.class);
        mapper.insertStyle(style);
        session.commit();
        session.close();
    }

    @Override
    public Long findStyleIdByName(String name) {
        SqlSession session = MybatisUtil.getSqlSession();
        BookStyleMapper mapper = session.getMapper(BookStyleMapper.class);
        Long id = mapper.findStyleIdByName(name);
        session.close();
        return id;
    }

    @Override
    public String findStyleNameById(Integer id) {
        SqlSession session = MybatisUtil.getSqlSession();
        BookStyleMapper mapper = session.getMapper(BookStyleMapper.class);
        String name = mapper.findStyleNameById(id);
        session.close();
        return name;
    }

    @Override
    public List<BookStyle> findAllStyle() {
        SqlSession session = MybatisUtil.getSqlSession();
        BookStyleMapper mapper = session.getMapper(BookStyleMapper.class);
        List<BookStyle> list = mapper.findAllStyle();
        session.close();
        return list;
    }

}
