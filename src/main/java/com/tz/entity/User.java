package com.tz.entity;

import java.io.Serializable;
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long userId;
	private String userName;
	private String passWord;
	private String email;
	private String phone;
	private String company;
	private String address;
	
    public User(Long userId, String userName, String passWord, String email, String phone, String company,
            String address) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.phone = phone;
        this.company = company;
        this.address = address;
    }
    public User(String userName, String passWord, String email, String phone, String company,
            String address) {
        super();
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.phone = phone;
        this.company = company;
        this.address = address;
    }
    public User() {
        super();
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassWord() {
        return passWord;
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getUserId() {
        return userId;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("User [userId=");
        builder.append(userId);
        builder.append(", userName=");
        builder.append(userName);
        builder.append(", passWord=");
        builder.append(passWord);
        builder.append(", email=");
        builder.append(email);
        builder.append(", phone=");
        builder.append(phone);
        builder.append(", company=");
        builder.append(company);
        builder.append(", address=");
        builder.append(address);
        builder.append("]");
        return builder.toString();
    }


}
