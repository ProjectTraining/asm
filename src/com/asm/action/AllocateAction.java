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
import com.asm.service.AssetService;
import com.asm.service.DeptService;
import com.asm.service.UserService;
import com.asm.util.ResponseUtil;
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

	private String userOutId;
	private String userAcceptId;
	private String deptAcceptId;
	private String deptOutId;
	private String assetId;
	@Autowired
	private AllocateService allocateService;
	@Autowired
	private UserService userService;
	@Autowired
	private DeptService deptService;
	@Autowired
	private AssetService assetService;

	public String home() {
		allocateList = this.allocateService.findList();
		return "list";
	}

	public String assetOut(){
		AssetList = this.assetService.list();
		userList = this.userService.listUser(null, null, null, null);
		deptList = this.deptService.findAllUsers();
		return "assetOut";
	}
	
	public void add(){
		allocate.setDeptAccept(this.deptService.findDeptById(deptAcceptId));
		allocate.setDeptOut(this.deptService.findDeptById(deptOutId));
		allocate.setUserAccept(this.userService.findUser(userAcceptId));
		allocate.setUserOut(this.userService.findUser(userOutId));
		allocate.setAsset(this.assetService.findAsset(assetId));
		
		this.allocateService.add(allocate);
		try {
			ResponseUtil.write1(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public AssetService getAssetService() {
		return assetService;
	}


	public void setAssetService(AssetService assetService) {
		this.assetService = assetService;
	}


	public String getUserOutId() {
		return userOutId;
	}

	public void setUserOutId(String userOutId) {
		this.userOutId = userOutId;
	}

	public String getUserAcceptId() {
		return userAcceptId;
	}

	public void setUserAcceptId(String userAcceptId) {
		this.userAcceptId = userAcceptId;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getDeptAcceptId() {
		return deptAcceptId;
	}

	public void setDeptAcceptId(String deptAcceptId) {
		this.deptAcceptId = deptAcceptId;
	}

	public String getDeptOutId() {
		return deptOutId;
	}

	public void setDeptOutId(String deptOutId) {
		this.deptOutId = deptOutId;
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
