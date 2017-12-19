/**
 * 
 */
package com.qhit.lh.gr3.beataly.t2.bean;



/**
 * @author 李芳园
 *TODO
 * 2017年12月13日上午9:50:08
 */
public class Emp {
 private int eid;
 private String empName;
 private String  empSex;
 private String birthday;
 private int deptId;
 //一对一关系映射
 private User user;
//多对一的关联
 private Dept dept;
 
public Emp(int eid, String empName, String empSex, String birthday, int deptId, User user) {
	super();
	this.eid = eid;
	this.empName = empName;
	this.empSex = empSex;
	this.birthday = birthday;
	this.deptId = deptId;
	this.user = user;
}
public Emp(int eid, String empName, String empSex, String birthday, int deptId) {
	super();
	this.eid = eid;
	this.empName = empName;
	this.empSex = empSex;
	this.birthday = birthday;
	this.deptId = deptId;
}

public Emp(String empName, String empSex, String birthday, int deptId) {
	super();
	this.empName = empName;
	this.empSex = empSex;
	this.birthday = birthday;
	this.deptId = deptId;
}
public Emp(String empName, String empSex, String birthday, int deptId, User user) {
	super();
	this.empName = empName;
	this.empSex = empSex;
	this.birthday = birthday;
	this.deptId = deptId;
	this.user = user;
}
public Emp() {
	super();
	// TODO Auto-generated constructor stub
}
public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public String getEmpSex() {
	return empSex;
}
public void setEmpSex(String empSex) {
	this.empSex = empSex;
}
public String getBirthday() {
	return birthday;
}
public void setBirthday(String birthday) {
	this.birthday = birthday;
}
public int getDeptId() {
	return deptId;
}
public void setDeptId(int deptId) {
	this.deptId = deptId;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}

public Dept getDept() {
	return dept;
}
public void setDept(Dept dept) {
	this.dept = dept;
}
@Override
public String toString() {
	return "Emp [eid=" + eid + ", empName=" + empName + ", empSex=" + empSex + ", birthday=" + birthday + ", deptId="
			+ deptId + ", user=" + user + ", dept=" + dept + "]";
}


 
}
