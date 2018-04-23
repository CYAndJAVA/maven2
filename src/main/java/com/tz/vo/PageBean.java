package com.tz.vo;

import java.io.Serializable;
import java.util.List;

public class PageBean<T> implements Serializable{
    private static final long serialVersionUID = 1L;
    private final int MAX_PAGE_SIZE = 50; //最多每页显示50行
	public static final int DEFAULT_PAGE_SIZE = 4;
	//属性
	private int total; //总记录数
	private int pageSize; //每页显示的记录数，默认是4
	private int pageNum; //总页数
	
	private int first = 1; //第1页
	private int last; //最后1页
	private int previous; //上一页
	private int next; //下一页
	private int current = 1; //当前页,默认是1
	
	private List<T> datas; //存放分页的数据
	
	public PageBean(int total) {
		this(total, DEFAULT_PAGE_SIZE); //默认的每页行数是 4
	}
	
	public PageBean(int total, int pageSize) {
		//赋值
		this.total = total;
		if(pageSize > MAX_PAGE_SIZE) {
			this.pageSize = MAX_PAGE_SIZE;
		} else {
	        this.pageSize = pageSize;
		}
		//更新受 pageSize影响的属性
		update();
		
		this.current = 1; //默认当前页就是1
		
		this.next = this.pageNum == 1 ? 1 : this.current + 1;
		this.previous = this.current == 1 ? 1 : this.current - 1;
	}

	public int getTotal() {
		return total;
	}

	public int getPageSize() {
		return pageSize;
	}

	//注意，会影响其它的属性值
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		update();
	}

	private void update() { //更新所有依赖 pageSize的其它属性值
		//根据总记录数和每页记录数，计算出 总页数
		this.pageNum = this.total / this.pageSize;
		if(this.total % this.pageSize != 0) {
			this.pageNum ++;
		}
				
		//给另外的属性赋值
		this.last = this.pageNum; //最后一页，就是总页数
		//此时 this.current的值有可能会大于 this.last
		if(this.current > this.last) {
			//当每页的行数增大后，当前的页码超过最后1页时，则当前页变为最后1页
			this.current = this.last; 
		}else if(this.current <= 0 ){
		    this.current = 1;
		}
	}

	public int getPageNum() {
		return pageNum;
	}

	public int getFirst() {
		return first;
	}

	public int getLast() {
		return last;
	}

	public void setLast(int last) {
		this.last = last;
	}

	public int getPrevious() {
		return previous;
	}

	public void setPrevious(int previous) {
		this.previous = previous;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public int getCurrent() {
		return current;
	}

	//这个方法会影响一些属性
	public void setCurrent(int current) {
		this.current = current;
		update();
		//修改 previous和next
		this.previous = this.current == 1 ? 1 : this.current - 1;
		this.next = this.pageNum == 1 ? 1 : this.current + 1;
		if(this.next > this.pageNum) {
			this.next = this.pageNum; //如果超过最后1行，则等于最后1行
		}
		
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + MAX_PAGE_SIZE;
        result = prime * result + current;
        result = prime * result + ((datas == null) ? 0 : datas.hashCode());
        result = prime * result + first;
        result = prime * result + last;
        result = prime * result + next;
        result = prime * result + pageNum;
        result = prime * result + pageSize;
        result = prime * result + previous;
        result = prime * result + total;
        return result;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PageBean other = (PageBean) obj;
        if (MAX_PAGE_SIZE != other.MAX_PAGE_SIZE)
            return false;
        if (current != other.current)
            return false;
        if (datas == null) {
            if (other.datas != null)
                return false;
        } else if (!datas.equals(other.datas))
            return false;
        if (first != other.first)
            return false;
        if (last != other.last)
            return false;
        if (next != other.next)
            return false;
        if (pageNum != other.pageNum)
            return false;
        if (pageSize != other.pageSize)
            return false;
        if (previous != other.previous)
            return false;
        if (total != other.total)
            return false;
        return true;
    }

    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PageBean [total=").append(total).append(", pageSize=").append(pageSize).append(", pageNum=")
				.append(pageNum).append(", first=").append(first).append(", last=").append(last).append(", previous=")
				.append(previous).append(", next=").append(next).append(", current=").append(current).append("]");
		return builder.toString();
	}
}
