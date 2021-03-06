package com.asm.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.asm.domain.Dept;
import com.asm.domain.StockTaking;
import com.asm.domain.User;
import com.asm.service.DeptService;
import com.asm.service.StockTakingService;
import com.asm.service.UserService;
import com.asm.util.MD5;
import com.asm.util.ResponseUtil;
import com.asm.util.StringHelper;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;



/**  
* @description:用户action
* @Author: 张毓峰（作者）
* @Version: V1.00 （版本号）
* @Create Date: 2016-4-8 （创建日期）
*/
@SuppressWarnings("serial")
@Controller("stockTakingAction")
@Scope("prototype")
public class StockTakingAction extends ActionSupport implements ModelDriven<StockTaking> {

	private StockTaking stockTaking=new StockTaking();
	@Autowired
	private StockTakingService stockTakingService;
	@Autowired
	private UserService userService;
	@Autowired
	private DeptService	deptService;
	private List<StockTaking> stockTakingList;
	private List<Dept> deptList;
	private List<User> userList;
	private String userId;

	private JSONObject rows;
	private String storeId;
	private String stateStr;
	private Date startTime,endTime;
	
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	HashMap<String, String> deptMap = new HashMap<String, String>();
	public String getStateStr() {
		return stateStr;
	}
	public void setStateStr(String stateStr) {
		this.stateStr = stateStr;
	}
	public StockTaking getStockTaking() {
		return stockTaking;
	}
	public void setStockTaking(StockTaking stockTaking) {
		this.stockTaking = stockTaking;
	}
	
	public List<Dept> getDeptList() {
		return deptList;
	}

	@Override 
	public StockTaking getModel() {
		// TODO Auto-generated method stub
		return stockTaking;
	}
	


	

	

	

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}



	public JSONObject getRows() {
		return rows;
	}

	public void setRows(JSONObject rows) {
		this.rows = rows;
	}
	
	public String changeState() throws Exception {
		
		boolean flag = false;
		int state=stockTaking.getState();
		stockTaking=stockTakingService.findStockTaking(stockTaking.getStockTakingId());
		stockTaking.setState(state);
		if (stockTakingService.updateStockTaking(stockTaking)) {
			flag = true;
			ResponseUtil.write1(flag);
		} else {
			ResponseUtil.write1(flag);
		}
		return null;
	}
	



	
	public List<User> getUserList() {
		return userList;
	}
	public String listPage(){
		return "listpage";
	}
	public String addPage(){
		userList=userService.listUser(null, null, null, null);
		return "addpage";
	}

	public String add() throws Exception{
		boolean flag = true;
		try {
			
			User user=userService.findUser(userId);
			stockTaking.setUser(user);
			stockTakingService.saveStockTaking(stockTaking);
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
		System.out.println("time end:"+StringHelper.dateTimetoString(endTime));
		stockTakingList = stockTakingService.listStockTaking(null,startTime,endTime);
		System.out.println("size"+stockTakingList.size());
		HashMap<String, Object> maps = new HashMap<String, Object>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		for (StockTaking  stockTaking: stockTakingList) {
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("state", stockTaking.getState());
			hashMap.put("stockTakingDate", StringHelper.dateTimetoString(stockTaking.getStockTakingDate()));
			hashMap.put("stockTakingId", stockTaking.getStockTakingId());
			hashMap.put("userName", stockTaking.getUser().getUserName());
			
			list.add(hashMap);
		}
		maps.put("Rows", list);
		maps.put("total", list.size());
		System.out.println(maps.size());
		rows = JSONObject.parseObject(JSON.toJSONString(maps));
		System.out.println(rows.toJSONString());
		return "list";
	}
	public String remove() throws Exception {
		boolean flag = false;
		if (stockTakingService.remove(stockTaking.getStockTakingId())) {
			flag = true;
			ResponseUtil.write1(flag);
		} else {
			ResponseUtil.write1(flag);
		}
		return null;
	}
	public String editPage(){
		userList=userService.listUser(null, null, null, null);
		stockTaking=stockTakingService.findStockTaking(stockTaking.getStockTakingId());
		
		return "editpage";
	}
	public String edit() throws Exception {
		boolean flag = true;
		try {
			User user=userService.findUser(userId);
			stockTaking.setUser(user);
			stockTakingService.updateStockTaking(stockTaking);
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
