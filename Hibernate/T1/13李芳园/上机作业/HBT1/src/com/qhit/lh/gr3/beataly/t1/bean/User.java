/**
 * 
 */
package com.qhit.lh.gr3.beataly.t1.bean;

/**
 * @author 李芳园
 *TODO
 * 2017年12月11日上午9:37:55
 */
public class User {
 private int id;
 private String uname;
 private String upwd;
 private String brithday;
 private String sex;
 private int enbale;
public User(int id, String uname, String upwd, String brithday, String sex, int enbale) {
	super();
	this.id = id;
	this.uname = uname;
	this.upwd = upwd;
	this.brithday = brithday;
	this.sex = sex;
	this.enbale = enbale;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getUpwd() {
	return upwd;
}
public void setUpwd(String upwd) {
	this.upwd = upwd;
}
public String getBrithday() {
	return brithday;
}
public void setBrithday(String brithday) {
	this.brithday = brithday;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public int getEnbale() {
	return enbale;
}
public void setEnbale(int enbale) {
	this.enbale = enbale;
}
@Override
public String toString() {
	return "User [id=" + id + ", uname=" + uname + ", upwd=" + upwd + ", brithday=" + brithday + ", sex=" + sex
			+ ", enbale=" + enbale + "]";
}
 
 
}
