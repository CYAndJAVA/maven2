package com.tz.entity;

import java.io.Serializable;

public class BookStyle implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long style_id;
    
    private String stylename;

    public BookStyle(Long style_id, String stylename) {
        super();
        this.style_id = style_id;
        this.stylename = stylename;
    }

    public BookStyle(String stylename) {
        super();
        this.stylename = stylename;
    }

    public BookStyle() {
        super();
    }

    public Long getStyle_id() {
        return style_id;
    }

    public void setStyle_id(Long style_id) {
        this.style_id = style_id;
    }

    public String getStylename() {
        return stylename;
    }

    public void setStylename(String stylename) {
        this.stylename = stylename;
    }

    @Override
    public String toString() {
        return "BookStyle [style_id=" + style_id + ", stylename=" + stylename + "]";
    }
    
    
}
