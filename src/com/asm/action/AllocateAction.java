package com.asm.action;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.asm.domain.Allocate;
import com.asm.domain.Asset;
import com.asm.domain.Dept;
import com.asm.domain.User;
import com.asm.service.AllocateService;
import com.asm.service.DeptService;
import com.asm.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
@Controller("allocateAction")
@Scope("prototype")
public class AllocateAction extends ActionSupport implements
		ModelDriven<Allocate> {

	private String allocateId;
	private Date outDate;
	private String outReason;
	private int state;
	private Date inConfirmDate;
	private List<Allocate> allocateList;
	private List<User> userList;
	private List<Dept> deptList;
	private List<Asset> AssetList;
	private Allocate allocate = new Allocate();

	@Autowired
	private AllocateService allocateService;
	@Autowired
	private UserService userService;
	@Autowired
	private DeptService deptService;

	public String home() {
		allocateList = this.allocateService.findList();
		return "list";
	}

	public UserService getUserService() {
		return userService;
	}



	public void setUserService(UserService userService) {
		this.userService = userService;
	}



	public DeptService getDeptService() {
		return deptService;
	}



	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}



	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public List<Dept> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<Dept> deptList) {
		this.deptList = deptList;
	}

	public String getAllocateId() {
		return allocateId;
	}

	public void setAllocateId(String allocateId) {
		this.allocateId = allocateId;
	}



	public List<Asset> getAssetList() {
		return AssetList;
	}

	public void setAssetList(List<Asset> assetList) {
		AssetList = assetList;
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
