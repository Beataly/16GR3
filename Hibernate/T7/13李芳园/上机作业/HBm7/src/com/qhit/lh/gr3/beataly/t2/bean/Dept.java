/**
 * 
 */
package com.qhit.lh.gr3.beataly.t2.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 李芳园
 *TODO
 * 2017年12月13日下午3:14:04
 */
public class Dept {
	private int deptId;
	private String deptName;
	private String address;
	
	private Set<Emp> emps = new HashSet<Emp>();
	
	public Dept(int deptId, String deptName, String address) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.address = address;
	}
	
	public Dept(String deptName) {
		super();
		this.deptName = deptName;
	}

	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Emp> getEmps() {
		return emps;
	}

	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}

	@Override
	public String toString() {
		return "Dept [deptId=" + deptId + ", deptName=" + deptName + ", address=" + address + "]";
	}
	
	
}
