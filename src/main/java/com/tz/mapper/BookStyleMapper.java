package com.tz.mapper;

import java.util.List;

import com.tz.entity.BookStyle;

public interface BookStyleMapper {
    
    public void insertStyle(BookStyle b);
    
    public Long findStyleIdByName(String name);
    
    public String findStyleNameById(Integer id);
    
    public List<BookStyle> findAllStyle();
}
