package com.tz.entity;

import java.io.Serializable;
import java.util.Date;

import com.tz.entity.eum.Suit;



public class Book implements Serializable {

	/**
	 * 图书信息
	 */
	private static final long serialVersionUID = 1L;

	private Long bookid;

	private String isbn;
	
	private String bookname;
	private double oldprice;
    private double newprice;
    private String publisher;
    private Date publish_date;
    private Suit suit;
	private String author;
	private String author_loc;// 作者地区
	private BookStyle bookstyle;
	private String info;
	private String imgurl;
    public Book() {
        super();
    }
    public Book(Long bookid, String isbn, String bookname, double oldprice, double newprice, String publisher,
            Date publish_date, Suit suit, String author, String author_loc, BookStyle bookstyle, String info,
            String imgurl) {
        super();
        this.bookid = bookid;
        this.isbn = isbn;
        this.bookname = bookname;
        this.oldprice = oldprice;
        this.newprice = newprice;
        this.publisher = publisher;
        this.publish_date = publish_date;
        this.suit = suit;
        this.author = author;
        this.author_loc = author_loc;
        this.bookstyle = bookstyle;
        this.info = info;
        this.imgurl = imgurl;
    }
    public Book(String isbn, String bookname, double oldprice, double newprice, String publisher, Date publish_date,
            Suit suit, String author, String author_loc, BookStyle bookstyle, String info, String imgurl) {
        super();
        this.isbn = isbn;
        this.bookname = bookname;
        this.oldprice = oldprice;
        this.newprice = newprice;
        this.publisher = publisher;
        this.publish_date = publish_date;
        this.suit = suit;
        this.author = author;
        this.author_loc = author_loc;
        this.bookstyle = bookstyle;
        this.info = info;
        this.imgurl = imgurl;
    }
    public Long getBookid() {
        return bookid;
    }
    public void setBookid(Long bookid) {
        this.bookid = bookid;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getBookname() {
        return bookname;
    }
    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
    public double getOldprice() {
        return oldprice;
    }
    public void setOldprice(double oldprice) {
        this.oldprice = oldprice;
    }
    public double getNewprice() {
        return newprice;
    }
    public void setNewprice(double newprice) {
        this.newprice = newprice;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public Date getPublish_date() {
        return publish_date;
    }
    public void setPublish_date(Date publish_date) {
        this.publish_date = publish_date;
    }
    public Suit getSuit() {
        return suit;
    }
    public void setSuit(Suit suit) {
        this.suit = suit;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getAuthor_loc() {
        return author_loc;
    }
    public void setAuthor_loc(String author_loc) {
        this.author_loc = author_loc;
    }
    public BookStyle getBookstyle() {
        return bookstyle;
    }
    public void setBookstyle(BookStyle bookstyle) {
        this.bookstyle = bookstyle;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    public String getImgurl() {
        return imgurl;
    }
    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bookid == null) ? 0 : bookid.hashCode());
        result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
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
        Book other = (Book) obj;
        if (bookid == null) {
            if (other.bookid != null)
                return false;
        } else if (!bookid.equals(other.bookid))
            return false;
        if (isbn == null) {
            if (other.isbn != null)
                return false;
        } else if (!isbn.equals(other.isbn))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Book [bookid=" + bookid + ", isbn=" + isbn + ", bookname=" + bookname + ", oldprice=" + oldprice
                + ", newprice=" + newprice + ", publisher=" + publisher + ", publish_date=" + publish_date + ", suit="
                + suit + ", author=" + author + ", author_loc=" + author_loc + ", bookstyle=" + bookstyle + ", info="
                + info + ", imgurl=" + imgurl + "]";
    }
}
