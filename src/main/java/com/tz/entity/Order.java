package com.tz.entity;

import java.io.Serializable;
import java.util.Date;

import com.tz.entity.eum.OrderStatus;
import com.tz.util.TimeTool;


public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long orderid;
	private String ordernum;// 订单编号
	private Date createdate;
	private Long t_userid;
	private Long t_addressid; // 发货地址
	private OrderStatus orderstatus;//订单状态
	
    public Order(Long orderid, String ordernum, Date createdate, Long t_userid, Long t_addressid,
            OrderStatus orderstatus) {
        super();
        this.orderid = orderid;
        this.ordernum = ordernum;
        this.createdate = createdate;
        this.t_userid = t_userid;
        this.t_addressid = t_addressid;
        this.orderstatus = orderstatus;
    }
    public Order() {
        super();
    }
    public Order(String ordernum, Date createdate, Long t_userid, Long t_addressid, OrderStatus orderstatus) {
        super();
        this.ordernum = ordernum;
        this.createdate = createdate;
        this.t_userid = t_userid;
        this.t_addressid = t_addressid;
        this.orderstatus = orderstatus;
    }
    public Long getOrderid() {
        return orderid;
    }
    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }
    public String getOrdernum() {
        return ordernum;
    }
    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }
    public Date getCreatedate() {
        return createdate;
    }
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
    public Long getT_userid() {
        return t_userid;
    }
    public void setT_userid(Long t_userid) {
        this.t_userid = t_userid;
    }
    public Long getT_addressid() {
        return t_addressid;
    }
    public void setT_addressid(Long t_addressid) {
        this.t_addressid = t_addressid;
    }
    public OrderStatus getOrderstatus() {
        return orderstatus;
    }
    public void setOrderstatus(OrderStatus orderstatus) {
        this.orderstatus = orderstatus;
    }
    @Override
    public String toString() {
        return "Order [orderid=" + orderid + ", ordernum=" + ordernum + ", createdate=" + createdate + ", t_userid="
                + t_userid + ", t_addressid=" + t_addressid + ", orderstatus=" + orderstatus + "]";
    }
    public Order(Long t_userid, Long t_addressid, OrderStatus orderstatus) {
        super();
        this.t_userid = t_userid;
        this.t_addressid = t_addressid;
        this.orderstatus = orderstatus;
        
        this.ordernum = TimeTool.format(new Date(), "yyyyMMddHHMMSSLL");
        this.createdate = new Date();
    }
}
