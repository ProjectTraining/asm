package com.asm.action;

import java.util.ArrayList;
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
import com.asm.domain.StockTakingItem;
import com.asm.domain.User;
import com.asm.service.DeptService;
import com.asm.service.StockTakingItemService;
import com.asm.service.UserService;
import com.asm.util.ResponseUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
@Controller("stockTakingItemAction")
@Scope("prototype")
public class StockTakingItemAction extends ActionSupport implements ModelDriven<StockTakingItem> {

	private StockTakingItem stockTakingItem=new StockTakingItem();
	@Autowired
	private StockTakingItemService stockTakingItemService;
	@Autowired
	private UserService userService;
	@Autowired
	private DeptService	deptService;
	private Map<String, Object> session;
	private List<StockTakingItem> stockTakingItemList;
	private List<Dept> deptList;
	private List<User> userList;
	private List<AssetSort> assetSortList;
	private String userId;
	private int pageNow = 1;
	private int pageSize = 10;
	private JSONObject rows;
	private String storeId;
	private JSONObject data;
	private String stateStr;

	
	
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
	public String getStateStr() {
		return stateStr;
	}
	public void setStateStr(String stateStr) {
		this.stateStr = stateStr;
	}
	public StockTakingItem getStockTakingItem() {
		return stockTakingItem;
	}
	public void setStockTakingItem(StockTakingItem stockTakingItem) {
		this.stockTakingItem = stockTakingItem;
	}
	
	public List<Dept> getDeptList() {
		return deptList;
	}

	@Override 
	public StockTakingItem getModel() {
		// TODO Auto-generated method stub
		return stockTakingItem;
	}
	


	

	
	
	public JSONObject getData() {
		return data;
	}
	public void setData(JSONObject data) {
		this.data = data;
	}
	

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}


	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public JSONObject getRows() {
		return rows;
	}

	public void setRows(JSONObject rows) {
		this.rows = rows;
	}
	
	
	public String loginPage() {
		StockTakingItem employee=(StockTakingItem) session.get("employee");
		if(employee!=null){
			return "home";
		}
		return "login";
	}


	
	public List<User> getUserList() {
		return userList;
	}
	public String home(){
		
		return "stockTakingItemlistpage";
	}
	public String addPage(){
		assetSortList=stockTakingItemService.findAssertSortList();
		userList=userService.listUser(null, null, null, null);
		return "addpage";
	}

	public String add() throws Exception{
		boolean flag = true;
		try {
			stockTakingItemService.saveStockTakingItem(stockTakingItem);
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
	public String listStockTakingItem() {
		stockTakingItemList = stockTakingItemService.listStockTakingItem(null,null);
		HashMap<String, Object> maps = new HashMap<String, Object>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		for (StockTakingItem  stockTakingItem: stockTakingItemList) {
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("stockTakingItemId", stockTakingItem.getStockTakingItemId());
			list.add(hashMap);
		}
		maps.put("Rows", list);
		rows = JSONObject.parseObject(JSON.toJSONString(maps));
		return "stockTakingItemlist";
	}
	public String remove() throws Exception {
		boolean flag = false;
		if (stockTakingItemService.remove(stockTakingItem.getStockTakingItemId())) {
			flag = true;
			ResponseUtil.write1(flag);
		} else {
			ResponseUtil.write1(flag);
		}
		return null;
	}
	public String editPage(){
		assetSortList=stockTakingItemService.findAssertSortList();
		userList=userService.listUser(null, null, null, null);
		stockTakingItem=stockTakingItemService.findStockTakingItem(stockTakingItem.getStockTakingItemId());
		
		return "editPage";
	}
	public String edit() throws Exception {
		boolean flag = true;
		try {
			stockTakingItemService.updateStockTakingItem(stockTakingItem);
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
