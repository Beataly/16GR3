package com.qhit.sbm.common.bean;

import java.util.ArrayList;
import java.util.List;

public class PageBean {
private int pagesize;//每页显示的条数
private int pagetotal;//总页数
private int p;//当前第p页
private int count;//记录总条数
private List data;//存放本页数据的集合
public PageBean(){
	pagesize = 5;//默认设置每页显示四条记录
	data = new ArrayList();
}

public int getPagesize() {
	return pagesize;
}
public void setPagesize(int pagesize) {
	this.pagesize = pagesize;
}
public int getPagetotal() {
	return pagetotal;
}
public void setPagetotal(int pagetotal) {
	this.pagetotal = pagetotal;
}
public int getP() {
	return p;
}
//检验p的取值范围
public void setP(int p) {
	if (p < 1) {
		this.p = 1;
	}else if (p > pagetotal) {
		this.p = pagetotal;
	}else {
		this.p = p ;
	}
}
public int getCount() {
	return count;
}
//根据记录总数和每页的条数，计算总页书
public void setCount(int count) {
	this.count = count;
	pagetotal = (int)Math.ceil(count*1.0/pagesize);
}
public List getData() {
	return data;
}
public void setData(List data) {
	this.data = data;
}
public void addData(Object obj){
	data.add(obj);
}

}
