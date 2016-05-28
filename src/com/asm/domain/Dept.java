package com.asm.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
/**
 * @description 部门
 * @Author: 赵楠（作者）
 * @Version: V1.00 （版本号）
 * @Create Date: 2016-4-12 （创建日期）
 */
@Entity
@Table(name="t_dept")
public class Dept implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String deptId; 
	private String deptName;
	@Id
	@GeneratedValue(generator="userUUID")
	@GenericGenerator(name="userUUID", strategy="uuid")
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}  
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


}
