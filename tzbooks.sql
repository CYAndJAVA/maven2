=================book======================
drop table bsbook;
create table bsbook(
bookid number(10) primary key,
isbn varchar2(255) UNIQUE,
bookname varchar2(255),
oldPrice number(10,2),
newPrice number(10,2),
publisher varchar2(255),
publish_date DATE,
suit number(10),
author varchar2(255),
author_loc varchar2(255),
bookstyle number(10),
info varchar2(255),
imgurl varchar2(255)
);

drop sequence bs_bookId;
create sequence bs_bookId
		start with 1
		increment by 1
		nomaxvalue
		minvalue 1
		nocycle
		nocache;

===================user=====================
drop table bsuser;
create table bsuser(
userid number(10) primary key,
username varchar2(255) unique,
password varchar2(255),
email varchar2(255),
phone varchar2(255),
company varchar2(255),
address varchar2(255)
);
drop sequence bs_userId;
create sequence bs_userId
		start with 1
		increment by 1
		nomaxvalue
		minvalue 1
		nocycle
		nocache;
===================bookStyle=====================
drop table bsstyle;
create table bsstyle(
style_id number(10) primary key,
stylename varchar2(255) unique
);
drop sequence bs_StyleId;
create sequence bs_StyleId
		start with 1
		increment by 1
		nomaxvalue
		minvalue 1
		nocycle
		nocache;
======================order===========================

drop table bsorder;
create table bsorder(
orderid number(10) primary key,
ordernum varchar2(255) unique,
createdate DATE,
t_userid number(10),
t_addressid number(10),
orderstatus number(5)
);
drop sequence bs_orderId;
create sequence bs_orderId
		start with 1
		increment by 1
		nomaxvalue
		minvalue 1
		nocycle
		nocache;


drop table bsitem;
create table bsitem(
itemid number(10) primary key,
book_isbn varchar2(255),
book_name varchar2(255),
book_author varchar2(255),
counts number(10),
newprive number(10,2),
allprice number(10,2),
cimgurl varchar2(255),
t_orderid number(10)
);
drop sequence bs_itemId;
create sequence bs_itemId
		start with 1
		increment by 1
		nomaxvalue
		minvalue 1
		nocycle
		nocache;


drop table bsaddress;
create table bsaddress(
addressid number(10) primary key,
area varchar2(255),
detailaddress varchar2(255),
emailcode varchar2(255),
reciver varchar2(255),
tel varchar2(255),
isdefault varchar2(255),
t_userid number(10)
);
drop sequence bs_addressId;
create sequence bs_addressId
		start with 1
		increment by 1
		nomaxvalue
		minvalue 1
		nocycle
		nocache;






















