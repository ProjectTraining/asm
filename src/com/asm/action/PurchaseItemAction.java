package com.asm.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.asm.domain.AssetSort;
import com.asm.domain.Dept;
import com.asm.domain.PurchaseItem;
import com.asm.domain.User;
import com.asm.service.DeptService;
import com.asm.service.PurchaseItemService;
import com.asm.service.UserService;
import com.asm.util.ResponseUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
@Controller("purchaseItemAction")
@Scope("prototype")
public class PurchaseItemAction extends ActionSupport implements ModelDriven<PurchaseItem> {

	private PurchaseItem purchaseItem=new PurchaseItem();
	@Autowired
	private PurchaseItemService purchaseItemService;
	@Autowired
	private UserService userService;
	@Autowired
	private DeptService	deptService;
	private Map<String, Object> session;
	private List<PurchaseItem> purchaseItemList;
	private List<Dept> deptList;
	private List<User> userList;
	private List<AssetSort> assetSortList;
	private String userId;


	private JSONObject rows;

	
	
	public List<AssetSort> getAssetSortList() {
		return assetSortList;
	}
	public void setAssetSortList(List<AssetSort> assetSortList) {
		this.assetSortList = assetSortList;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	HashMap<String, String> deptMap = new HashMap<String, String>();

	public PurchaseItem getPurchaseItem() {
		return purchaseItem;
	}
	public void setPurchaseItem(PurchaseItem purchaseItem) {
		this.purchaseItem = purchaseItem;
	}
	
	public List<Dept> getDeptList() {
		return deptList;
	}

	@Override 
	public PurchaseItem getModel() {
		// TODO Auto-generated method stub
		return purchaseItem;
	}
	


	

	
	



	public JSONObject getRows() {
		return rows;
	}

	public void setRows(JSONObject rows) {
		this.rows = rows;
	}
	


	
	public List<User> getUserList() {
		return userList;
	}
	public String home(){
		
		return "listpage";
	}
	public String addPage(){
		assetSortList=purchaseItemService.findAssertSortList();
		userList=userService.listUser(null, null, null, null);
		return "addpage";
	}

	public String add() throws Exception{
		boolean flag = true;
		try {
			purchaseItemService.savePurchaseItem(purchaseItem);
			ResponseUtil.write1(flag);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			flag = false;
			e.printStackTrace();
			ResponseUtil.write1(flag);
		}
		return null;
	}
	private void getDataMap(){
		deptList=deptService.findAllUsers();
		for (Dept  dept: deptList) {
			deptMap.put(dept.getDeptId(), dept.getDeptName());
		}
	
	}
	public String listPurchaseItem() {
		System.out.println("par  "+purchaseItem.getAssettName()+purchaseItem.getPurchaseOrderId());
		purchaseItemList = purchaseItemService.listPurchaseItem(purchaseItem.getAssettName(),purchaseItem.getPurchaseOrderId());
		HashMap<String, Object> maps = new HashMap<String, Object>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		for (PurchaseItem  purchaseItem: purchaseItemList) {
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("purchaseItemId", purchaseItem.getPurchaseItemId());
			hashMap.put("assettName", purchaseItem.getAssettName());
			hashMap.put("assetSortId", purchaseItem.getAssetSortId());
			hashMap.put("purchaseOrderId", purchaseItem.getPurchaseOrderId());
			hashMap.put("preserveUserId", purchaseItem.getPreserveUserId());
			hashMap.put("parentAssertSortId", purchaseItem.getParentAssertSortId());
			hashMap.put("remarks", purchaseItem.getRemarks());
			hashMap.put("manufacturer", purchaseItem.getManufacturer());
			hashMap.put("supplier", purchaseItem.getSupplier());
			hashMap.put("assetType", purchaseItem.getAssetType());
			hashMap.put("unit", purchaseItem.getUnit());
			hashMap.put("price", purchaseItem.getPrice());
			hashMap.put("num", purchaseItem.getNum());
			list.add(hashMap);
		}
		maps.put("Rows", list);
		maps.put("total", list.size());
		System.out.println(maps.size());
		rows = JSONObject.parseObject(JSON.toJSONString(maps));
		System.out.println(rows.toJSONString());
		return "purchaseItemlist";
	}
	public String remove() throws Exception {
		boolean flag = false;
		if (purchaseItemService.remove(purchaseItem.getPurchaseItemId())) {
			flag = true;
			ResponseUtil.write1(flag);
		} else {
			ResponseUtil.write1(flag);
		}
		return null;
	}
	public String editPage(){
		assetSortList=purchaseItemService.findAssertSortList();
		userList=userService.listUser(null, null, null, null);
		purchaseItem=purchaseItemService.findPurchaseItem(purchaseItem.getPurchaseItemId());
		
		return "editPage";
	}
	public String edit() throws Exception {
		boolean flag = true;
		try {
			purchaseItemService.updatePurchaseItem(purchaseItem);
			ResponseUtil.write1(flag);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			flag = false;
			e.printStackTrace();
			ResponseUtil.write1(flag);
		}
		return null;
	}
	
	
}
