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
import com.asm.domain.Asset;
import com.asm.domain.AssetSort;
import com.asm.domain.Dept;
import com.asm.domain.StockTaking;
import com.asm.domain.StockTakingItem;
import com.asm.domain.User;
import com.asm.service.AssetService;
import com.asm.service.DeptService;
import com.asm.service.StockTakingItemService;
import com.asm.service.StockTakingService;
import com.asm.service.UserService;
import com.asm.util.ResponseUtil;
import com.asm.util.StringHelper;
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
	private StockTakingService stockTakingService;
	@Autowired
	private AssetService assetService;
	@Autowired
	private DeptService	deptService;
	private Map<String, Object> session;
	private List<StockTakingItem> stockTakingItemList;
	private List<Dept> deptList;
	private List<User> userList;
	private List<Asset> assetList;
	private List<AssetSort> assetSortList;
	private String stockTakingId;
	private String assetId;

	private JSONObject rows;

	
	
	public List<Asset> getAssetList() {
		return assetList;
	}
	public void setAssetList(List<Asset> assetList) {
		this.assetList = assetList;
	}
	public List<AssetSort> getAssetSortList() {
		return assetSortList;
	}
	public void setAssetSortList(List<AssetSort> assetSortList) {
		this.assetSortList = assetSortList;
	}
	
	public String getStockTakingId() {
		return stockTakingId;
	}
	public void setStockTakingId(String stockTakingId) {
		this.stockTakingId = stockTakingId;
	}

	public String getAssetId() {
		return assetId;
	}
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	HashMap<String, String> deptMap = new HashMap<String, String>();

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
	public String listPage(){
		
		return "listpage";
	}
	public String addPage(){
		assetList=assetService.listAsset(null, null);
		return "addpage";
	}

	public String add() throws Exception{
		boolean flag = true;
		try {
			StockTaking stockTaking=stockTakingService.findStockTaking(stockTakingId);
			stockTakingItem.setStockTaking(stockTaking);
			Asset asset=assetService.findAsset(assetId);
			stockTakingItem.setAsset(asset);
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
	public String list() {
		System.out.println("资产盘点"+stockTakingId);
		stockTakingItemList = stockTakingItemService.listStockTakingItem(null,stockTakingId);
		HashMap<String, Object> maps = new HashMap<String, Object>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		for (StockTakingItem  stockTakingItem: stockTakingItemList) {
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("stockTakingItemId", stockTakingItem.getStockTakingItemId());
			hashMap.put("assetName", stockTakingItem.getAsset().getAssetName());
			hashMap.put("stockTakingResult", stockTakingItem.getStockTakingResult());
			hashMap.put("stockTakingDate", StringHelper.dateTimetoString(stockTakingItem.getStockTakingDate()));
			list.add(hashMap);
		}
		maps.put("Rows", list);
		maps.put("total", list.size());
		rows = JSONObject.parseObject(JSON.toJSONString(maps));
		return "list";
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
		assetList=assetService.listAsset(null, null);
		stockTakingItem=stockTakingItemService.findStockTakingItem(stockTakingItem.getStockTakingItemId());
		
		return "editpage";
	}
	public String edit() throws Exception {
		
		boolean flag = true;
		try {
			StockTaking stockTaking=stockTakingService.findStockTaking(stockTakingId);
			stockTakingItem.setStockTaking(stockTaking);
			Asset asset=assetService.findAsset(assetId);
			stockTakingItem.setAsset(asset);
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
