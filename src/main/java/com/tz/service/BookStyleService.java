package com.tz.service;

import java.util.List;

import com.tz.entity.BookStyle;

public interface BookStyleService {
    
    public void insertStyle(BookStyle style);
    
    public Long findStyleIdByName(String name);
    
    public String findStyleNameById(Integer id);
    
    public List<BookStyle> findAllStyle();
}
