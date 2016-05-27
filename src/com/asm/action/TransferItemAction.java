package com.asm.action;

import java.util.Date;
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
@Controller("transferItemAction")
@Scope("prototype")
public class TransferItemAction extends ActionSupport implements SessionAware,
		ModelDriven<TransferItem> {

	private TransferItem transferItem = new TransferItem();
	private List<Asset> assetList;
	private List<Transfer> transferList;
	private List<User> receiverUserList;
	private List<TransferItem> transferItemList;
	private int reveriverResult;
	private Date receiverDate;
	
	@Autowired
	private UserService userService;
	@Autowired
	private AssetService assetService;
	@Autowired
	private TransferService transferService;
	@Autowired
	private TransferItemService transferItemService;
	
	private PageBean pageBean;
	private int page = 1;
	
	private String transferItemId;
	private String transferId;
	private String receiverUserId;
	private String assetId;
	
	private JSONObject rows;
	
	@Override
	public TransferItem getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

	public TransferItem getTransferItem() {
		return transferItem;
	}

	public void setTransferItem(TransferItem transferItem) {
		this.transferItem = transferItem;
	}
	
	public List<User> getReceiverUserList() {
		return receiverUserList;
	}

	public void setReceiverUserList(List<User> receiverUserList) {
		this.receiverUserList = receiverUserList;
	}

	public List<Asset> getAssetList() {
		return assetList;
	}

	public void setAssetList(List<Asset> assetList) {
		this.assetList = assetList;
	}

	public List<Transfer> getTransferList() {
		return transferList;
	}

	public void setTransferList(List<Transfer> transferList) {
		this.transferList = transferList;
	}
	
	public List<TransferItem> getTransferItemList() {
		return transferItemList;
	}

	public void setTransferItemList(List<TransferItem> transferItemList) {
		this.transferItemList = transferItemList;
	}


	public int getReceriverResult() {
		return reveriverResult;
	}

	public void setReceriverResult(int reveriverResult) {
		this.reveriverResult = reveriverResult;
	}

	public Date getReceiverDate() {
		return receiverDate;
	}

	public void setReceiverDate(Date receiverDate) {
		this.receiverDate = receiverDate;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getTransferId() {
		return transferId;
	}

	public void setTransferId(String transferId) {
		this.transferId = transferId;
	}

	public String getReceiverUserId() {
		return receiverUserId;
	}

	public void setReceiverUserId(String receiverUserId) {
		this.receiverUserId = receiverUserId;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public JSONObject getRows() {
		return rows;
	}

	public void setRows(JSONObject rows) {
		this.rows = rows;
	}

	public String getTransferItemId() {
		return transferItemId;
	}

	public void setTransferItemId(String transferItemId) {
		this.transferItemId = transferItemId;
	}
	
	public String infoHome() {
		return "infoHome";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public AssetService getAssetService() {
		return assetService;
	}

	public void setAssetService(AssetService assetService) {
		this.assetService = assetService;
	}

	public TransferService getTransferService() {
		return transferService;
	}

	public void setTransferService(TransferService transferService) {
		this.transferService = transferService;
	}
	
	public String selectInfo(){
		setReceiverUserList(userService.listUser(null, null, null, null));
		setAssetList(assetService.listAsset(null, null));
		setTransferList(transferService.listTransfer(null, null, null, null));
		return "selectInfo";
	}
	
	public String addTransferItem() throws Exception{
		boolean flag = true;
		try {
			User receiverUser=userService.findUser(receiverUserId);
			Asset asset = assetService.findAsset(assetId);
			Transfer transfer = transferService.getTransferById(transferId);
			transferItem.setReceiverUser(receiverUser);
			transferItem.setAsset(asset);
			transferItem.setTransfer(transfer);
			transferService.saveTransfer(transfer);
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
	
	public String transferConfirm(){
		TransferItem t = transferItemService.getTransferItemById(transferItem.getTransferItemId());
		t.setReveiverResult(1);
		transferItemService.updateTransferItem(t);
		return "infoHome";
	}
	
	public String Pageforweb() {
		this.pageBean = transferItemService.queryForPage(5, page);// 获取封装了分页信息和数据的pageBean
		this.setTransferItemList(this.pageBean.getList()); // 获取数据
		Map transferItemList = (Map) ActionContext.getContext().get("request");
		transferItemList.put("list", this.transferItemList);
		return "showList";
	}
	
}
