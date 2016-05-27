package com.asm.action;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.asm.domain.Allocate;
import com.asm.domain.Dept;
import com.asm.domain.User;
import com.asm.service.AllocateService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
@Controller("allocateAction")
@Scope("prototype")
public class AllocateAction extends ActionSupport implements ModelDriven<Allocate>{

	private String allocateId;
	private User  userOut;//outUserId;
	private Dept deptOut;//outDeptId;
	private User userIn;//inConfirmUserId;
	private Dept deptIn;//inDeptId;
	private String assetId;//要修改
	private Date outDate;
	private String outReason;
	private int state;
	private Date inConfirmDate; 
	
	private Allocate allocate = new Allocate();
	@Autowired
	private AllocateService allocateService;
	private List<Allocate> allocateList;
	
	
	public String home(){
		return "list";
	}
	
	
	public String getAllocateId() {
		return allocateId;
	}



	public void setAllocateId(String allocateId) {
		this.allocateId = allocateId;
	}



	public User getUserOut() {
		return userOut;
	}



	public void setUserOut(User userOut) {
		this.userOut = userOut;
	}



	public Dept getDeptOut() {
		return deptOut;
	}



	public void setDeptOut(Dept deptOut) {
		this.deptOut = deptOut;
	}



	public User getUserIn() {
		return userIn;
	}



	public void setUserIn(User userIn) {
		this.userIn = userIn;
	}



	public Dept getDeptIn() {
		return deptIn;
	}



	public void setDeptIn(Dept deptIn) {
		this.deptIn = deptIn;
	}



	public String getAssetId() {
		return assetId;
	}



	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}



	public Date getOutDate() {
		return outDate;
	}



	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}



	public String getOutReason() {
		return outReason;
	}



	public void setOutReason(String outReason) {
		this.outReason = outReason;
	}



	public int getState() {
		return state;
	}



	public void setState(int state) {
		this.state = state;
	}



	public Date getInConfirmDate() {
		return inConfirmDate;
	}



	public void setInConfirmDate(Date inConfirmDate) {
		this.inConfirmDate = inConfirmDate;
	}



	public Allocate getAllocate() {
		return allocate;
	}



	public void setAllocate(Allocate allocate) {
		this.allocate = allocate;
	}



	public AllocateService getAllocateService() {
		return allocateService;
	}



	public void setAllocateService(AllocateService allocateService) {
		this.allocateService = allocateService;
	}



	public List<Allocate> getAllocateList() {
		return allocateList;
	}



	public void setAllocateList(List<Allocate> allocateList) {
		this.allocateList = allocateList;
	}



	@Override
	public Allocate getModel() {
		// TODO Auto-generated method stub
		return allocate;
	}
	
}
