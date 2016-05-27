package com.asm.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.asm.domain.Transfer;
import com.asm.domain.User;
import com.asm.service.TransferService;
import com.asm.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
@Controller("transferAction")
@Scope("prototype")
public class TransferAction extends ActionSupport implements SessionAware,
		ModelDriven<Transfer>{

	private Transfer transfer = new Transfer();
	@Autowired
	private TransferService transferService;
	@Autowired
	private UserService userService;
	
	private List<Transfer> transferList;
	private List<User> transferUserList, receiverUserList;
	private Date transferDate, receiverDate;
	private int state, transferType;
	
	private String transferId;
	
	@Override
	public Transfer getModel() {
		// TODO Auto-generated method stub
		return transfer;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

	public Transfer getTransfer() {
		return transfer;
	}

	public void setTransfer(Transfer transfer) {
		this.transfer = transfer;
	}

	public TransferService getTransferService() {
		return transferService;
	}

	public void setTransferService(TransferService transferService) {
		this.transferService = transferService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<Transfer> getTransferList() {
		return transferList;
	}

	public void setTransferList(List<Transfer> transferList) {
		this.transferList = transferList;
	}

	public List<User> getTransferUserList() {
		return transferUserList;
	}

	public void setTransferUserList(List<User> transferUserList) {
		this.transferUserList = transferUserList;
	}

	public List<User> getReceiverUserList() {
		return receiverUserList;
	}

	public void setReceiverUserList(List<User> receiverUserList) {
		this.receiverUserList = receiverUserList;
	}

	public Date getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}

	public Date getReceiverDate() {
		return receiverDate;
	}

	public void setReceiverDate(Date receiverDate) {
		this.receiverDate = receiverDate;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getTransferType() {
		return transferType;
	}

	public void setTransferType(int transferType) {
		this.transferType = transferType;
	}

	public String getTransferId() {
		return transferId;
	}

	public void setTransferId(String transferId) {
		this.transferId = transferId;
	}

	public String transferShow(){
		return "transferShow";
	}
}
