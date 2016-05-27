package com.asm.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;
import com.asm.domain.Asset;
import com.asm.domain.Transfer;
import com.asm.domain.TransferItem;
import com.asm.domain.User;
import com.asm.service.AssetService;
import com.asm.service.TransferItemService;
import com.asm.service.TransferService;
import com.asm.service.UserService;
import com.asm.util.PageBean;
import com.asm.util.ResponseUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
@Controller("transferAction")
@Scope("prototype")
public class TransferAction extends ActionSupport implements SessionAware,
		ModelDriven<Transfer>{

	private Transfer transfer = new Transfer();
	private TransferItem transferItem = new TransferItem();
	@Autowired
	private TransferService transferService;
	@Autowired
	private UserService userService;
	@Autowired
	private AssetService assetService;
	@Autowired
	private TransferItemService transferItemService;
	
	private List<Transfer> transferList;
	private List<User> transferUserList, receiverUserList;
	private List<Asset> assetList; 
	private Date transferDate, receiverDate;
	private int state, transferType;
	private int reveriverResult;
	
	HashMap<String, String> transferUserMap = new HashMap<String, String>();
	HashMap<String, String> recevierUserMap = new HashMap<String, String>();
	
	private PageBean pageBean;
	private int page = 1;
	
	private String transferId;
	private String transferUserId;
	private String receiverUserId;
	private String assetId;
	private JSONObject rows;
	
	@Override
	public Transfer getModel() {
		// TODO Auto-generated method stub
		return transfer;
	}

	public HashMap<String, String> getTransferUserMap() {
		return transferUserMap;
	}

	public void setTransferUserMap(HashMap<String, String> transferUserMap) {
		this.transferUserMap = transferUserMap;
	}

	public HashMap<String, String> getRecevierUserMap() {
		return recevierUserMap;
	}

	public void setRecevierUserMap(HashMap<String, String> recevierUserMap) {
		this.recevierUserMap = recevierUserMap;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
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
	
	public int getPage(){
		return page;
	}
	
	public void setPage(int page){
		this.page = page;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	
	public String infoHome() {
		return "infoHome";
	}
	
	public String showUser(){
		transferUserList = userService.listUser(null, null, null, null);
		receiverUserList = userService.listUser(null, null, null, null);
		assetList = assetService.listAsset(null, null);
		return "showUser";
	}
	
	public String addTransfer() throws Exception{
		boolean flag = true;
		try {
			User transferUser = userService.findUser(this.transferUserId);
			User receiverUser = userService.findUser(this.receiverUserId);
			Asset asset = assetService.findAsset(assetId);
			transfer.setTransferUser(transferUser);
			transfer.setReceiverUser(receiverUser);
			transfer.setState(0);
			transferService.saveTransfer(transfer);
			
			transferItem.setAsset(asset);
			transferItem.setReceiverDate(transfer.getReceiverDate());
			transferItem.setReceiverUser(receiverUser);
			transferItem.setTransfer(transfer);
			transferItem.setReveiverResult(0);
			transferItemService.saveTransferItem(transferItem);
			ResponseUtil.write1(flag);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			flag = false;
			e.printStackTrace();
			ResponseUtil.write1(flag);
		}
		return "infoHome";
	}
	
	public String Pageforweb() {
		this.pageBean = transferService.queryForPage(5, page);// 获取封装了分页信息和数据的pageBean
		this.transferList = this.pageBean.getList(); // 获取数据
		Map transferList = (Map) ActionContext.getContext().get("request");
		transferList.put("list", this.transferList);
		return "showList";
	}

	public String getTransferUserId() {
		return transferUserId;
	}

	public void setTransferUserId(String transferUserId) {
		this.transferUserId = transferUserId;
	}

	public String getReceiverUserId() {
		return receiverUserId;
	}

	public void setReceiverUserId(String receiverUserId) {
		this.receiverUserId = receiverUserId;
	}

	public JSONObject getRows() {
		return rows;
	}

	public void setRows(JSONObject rows) {
		this.rows = rows;
	}

	public List<Asset> getAssetList() {
		return assetList;
	}

	public void setAssetList(List<Asset> assetList) {
		this.assetList = assetList;
	}

	public AssetService getAssetService() {
		return assetService;
	}

	public void setAssetService(AssetService assetService) {
		this.assetService = assetService;
	}

	public TransferItemService getTransferItemService() {
		return transferItemService;
	}

	public void setTransferItemService(TransferItemService transferItemService) {
		this.transferItemService = transferItemService;
	}

	public int getReceriverResult() {
		return reveriverResult;
	}

	public void setReceriverResult(int reveriverResult) {
		this.reveriverResult = reveriverResult;
	}

	public TransferItem getTransferItem() {
		return transferItem;
	}

	public void setTransferItem(TransferItem transferItem) {
		this.transferItem = transferItem;
	}
}
