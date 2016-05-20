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
import com.asm.domain.PurchaseOrder;
import com.asm.domain.User;
import com.asm.service.DeptService;
import com.asm.service.PurchaseOrderService;
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
@Controller("purchaseOrderAction")
@Scope("prototype")
public class PurchaseOrderAction extends ActionSupport implements ModelDriven<PurchaseOrder> {

	private PurchaseOrder purchaseOrder=new PurchaseOrder();
	@Autowired
	private PurchaseOrderService purchaseOrderService;
	@Autowired
	private UserService userService;
	@Autowired
	private DeptService	deptService;
	private Map<String, Object> session;
	private List<PurchaseOrder> purchaseOrderList;
	private List<Dept> deptList;
	private List<User> userList;
	private String userId;

	private JSONObject rows;
	private String storeId;

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

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}
	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}
	
	public List<Dept> getDeptList() {
		return deptList;
	}

	@Override 
	public PurchaseOrder getModel() {
		// TODO Auto-generated method stub
		return purchaseOrder;
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
		int state=purchaseOrder.getState();
		purchaseOrder=purchaseOrderService.findPurchaseOrder(purchaseOrder.getPurchaseId());
		purchaseOrder.setState(state);
		if (purchaseOrderService.updatePurchaseOrder(purchaseOrder)) {
			flag = true;
			ResponseUtil.write1(flag);
		} else {
			ResponseUtil.write1(flag);
		}
		return null;
	}
	
	public String loginPage() {
		PurchaseOrder employee=(PurchaseOrder) session.get("employee");
		if(employee!=null){
			return "home";
		}
		return "login";
	}


	
	public List<User> getUserList() {
		return userList;
	}
	public String home(){
		deptList =deptService.findAllUsers();
		return "purchaseOrderlistpage";
	}
	public String addPage(){
		deptList=deptService.findAllUsers();
		userList=userService.listUser(null, null, null, null);
		return "addpage";
	}

	public String add() throws Exception{
		boolean flag = true;
		try {
			System.out.println("userId"+userId);
			User user=userService.findUser(userId);
			purchaseOrder.setUser(user);
			//System.out.println(user.getUserId());
			purchaseOrderService.savePurchaseOrder(purchaseOrder);
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
	public String listPurchaseOrder() {
		
		getDataMap();
		purchaseOrderList = purchaseOrderService.listPurchaseOrder(purchaseOrder.getPurchaseDeptId(),startTime,endTime);
		HashMap<String, Object> maps = new HashMap<String, Object>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		for (PurchaseOrder  purchaseOrder: purchaseOrderList) {
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("purchaseId", purchaseOrder.getPurchaseId());
			hashMap.put("deptName", deptMap.get(purchaseOrder.getPurchaseDeptId()));
			hashMap.put("purchaseDate", StringHelper.dateTimetoString(purchaseOrder.getPurchaseDate()));
			hashMap.put("purchasePurpose", purchaseOrder.getPurchasePurpose());
			hashMap.put("purchaseUserId", purchaseOrder.getUser().getUserName());
			hashMap.put("state", purchaseOrder.getState());
			list.add(hashMap);
		}
		maps.put("Rows", list);
		maps.put("total", list.size());
		System.out.println(maps.size());
		rows = JSONObject.parseObject(JSON.toJSONString(maps));
		System.out.println(rows.toJSONString());
		return "purchaseOrderlist";
	}
	public String remove() throws Exception {
		boolean flag = false;
		if (purchaseOrderService.remove(purchaseOrder.getPurchaseId())) {
			flag = true;
			ResponseUtil.write1(flag);
		} else {
			ResponseUtil.write1(flag);
		}
		return null;
	}
	public String listInfo(){
		deptList=deptService.findAllUsers();
		userList=userService.listUser(null, null, null, null);
		purchaseOrder=purchaseOrderService.findPurchaseOrder(purchaseOrder.getPurchaseId());
		
		return "listpurchaseOrderinfo";
	}
	public String editPurchaseOrder() throws Exception {
		boolean flag = true;
		try {
			System.out.println("user"+userId);
			User user=userService.findUser(userId);
			System.out.println("purchaseOrder"+purchaseOrder.getPurchaseId());
			purchaseOrder.setUser(user);
			purchaseOrderService.updatePurchaseOrder(purchaseOrder);
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
