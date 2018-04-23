package com.tz.entity;

import java.io.Serializable;

import com.tz.service.BookService;
import com.tz.util.BeansFactory;


public class OrderItem implements Serializable {
    private BookService bs = (BookService) BeansFactory.getInstance("bookService");
	private static final long serialVersionUID = 1L;
	private Long itemid;

	private String book_isbn;
	private String book_name;
	private String book_author;
	private int counts; // 购买数量
	private double newprive;//单价
	private double allprice; // 此明细的总价
	private String cimgurl;//图片url
	private Long t_orderid; // 此明细所属的订单
	
    public OrderItem(String book_isbn, String book_name, String book_author, int counts, double newprive,
            double allprice, String cimgurl, Long t_orderid) {
        super();
        this.book_isbn = book_isbn;
        this.book_name = book_name;
        this.book_author = book_author;
        this.counts = counts;
        this.newprive = newprive;
        this.allprice = allprice;
        this.cimgurl = cimgurl;
        this.t_orderid = t_orderid;
    }
    public OrderItem(Long itemid, String book_isbn, String book_name, String book_author, int counts, double newprive,
            double allprice, String cimgurl, Long t_orderid) {
        super();
        this.itemid = itemid;
        this.book_isbn = book_isbn;
        this.book_name = book_name;
        this.book_author = book_author;
        this.counts = counts;
        this.newprive = newprive;
        this.allprice = allprice;
        this.cimgurl = cimgurl;
        this.t_orderid = t_orderid;
    }
    public OrderItem() {
        super();
    }
    public String getcimgurl() {
        return cimgurl;
    }
    public void setcimgurl(String cimgurl) {
        this.cimgurl = cimgurl;
    }
   
    public OrderItem(String book_isbn, int counts) {
        super();
        Book b = bs.getByIbsn(book_isbn);
        this.book_isbn = book_isbn;
        this.counts = counts;
        this.cimgurl = b.getImgurl();
        this.book_name = b.getBookname();
        this.book_author = b.getAuthor();
        this.newprive = b.getNewprice();
        this.allprice = ((int)(b.getNewprice() * counts * 100)) * 0.01;
    }
    public Long getItemid() {
        return itemid;
    }
    public void setItemid(Long itemid) {
        this.itemid = itemid;
    }
    public String getBook_isbn() {
        return book_isbn;
    }
    public void setBook_isbn(String book_isbn) {
        this.book_isbn = book_isbn;
    }
    public String getBook_name() {
        return book_name;
    }
    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }
    public String getBook_author() {
        return book_author;
    }
    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }
    public int getCounts() {
        return counts;
    }
    public void setCounts(int counts) {
        this.counts = counts;
    }
    public double getNewprive() {
        return newprive;
    }
    public void setNewprive(double newprive) {
        this.newprive = newprive;
    }
    public double getAllprice() {
        return allprice;
    }
    public void setAllprice(double allprice) {
        this.allprice = allprice;
    }
    public Long getT_orderid() {
        return t_orderid;
    }
    public void setT_orderid(Long t_orderid) {
        this.t_orderid = t_orderid;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((book_isbn == null) ? 0 : book_isbn.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrderItem other = (OrderItem) obj;
        if (book_isbn == null) {
            if (other.book_isbn != null)
                return false;
        } else if (!book_isbn.equals(other.book_isbn))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "OrderItem [itemid=" + itemid + ", book_isbn=" + book_isbn + ", book_name=" + book_name
                + ", book_author=" + book_author + ", counts=" + counts + ", newprive=" + newprive + ", allprice="
                + allprice + ", t_orderid=" + t_orderid + "]";
    }
}
