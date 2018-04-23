package com.tz.entity;

import java.io.Serializable;
public class Address implements Serializable {
	/**
	 * 地址实体类
	 */
	private static final long serialVersionUID = 1L;

	private Long addressid;
	private String area;// 区域
	private String detailaddress;//详细地址
	private String emailcode;//邮政编码
	private String reciver;//收件人
	private String tel;//手机号
	private String isdefault;// 是否默认收货地址 默认值 是 0；  1 否
	private Long t_userid;
    public Address(String area, String detailaddress, String emailcode, String reciver, String tel, String isdefault,
            Long t_userid) {
        super();
        this.area = area;
        this.detailaddress = detailaddress;
        this.emailcode = emailcode;
        this.reciver = reciver;
        this.tel = tel;
        this.isdefault = isdefault;
        this.t_userid = t_userid;
    }
    
    public Address(Long addressid, String area, String detailaddress, String emailcode, String reciver, String tel,
            String isdefault, Long t_userid) {
        super();
        this.addressid = addressid;
        this.area = area;
        this.detailaddress = detailaddress;
        this.emailcode = emailcode;
        this.reciver = reciver;
        this.tel = tel;
        this.isdefault = isdefault;
        this.t_userid = t_userid;
    }

    public Address() {
        super();
    }
    public Long getaddressid() {
        return addressid;
    }
    public void setaddressid(Long addressid) {
        this.addressid = addressid;
    }
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public String getdetailaddress() {
        return detailaddress;
    }
    public void setdetailaddress(String detailaddress) {
        this.detailaddress = detailaddress;
    }
    public String getemailcode() {
        return emailcode;
    }
    public void setemailcode(String emailcode) {
        this.emailcode = emailcode;
    }
    public String getReciver() {
        return reciver;
    }
    public void setReciver(String reciver) {
        this.reciver = reciver;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getisdefault() {
        return isdefault;
    }
    public void setisdefault(String isdefault) {
        this.isdefault = isdefault;
    }
    public Long gett_userid() {
        return t_userid;
    }
    public void sett_userid(Long t_userid) {
        this.t_userid = t_userid;
    }
    @Override
    public String toString() {
        return "Address [addressid=" + addressid + ", area=" + area + ", detailaddress=" + detailaddress
                + ", emailcode=" + emailcode + ", reciver=" + reciver + ", tel=" + tel + ", isdefault=" + isdefault
                + ", t_userid=" + t_userid + "]";
    }

}
