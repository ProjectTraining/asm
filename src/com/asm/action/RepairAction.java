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
import com.asm.domain.Repair;
import com.asm.domain.User;
import com.asm.service.DeptService;
import com.asm.service.RepairService;
import com.asm.service.UserService;
import com.asm.util.ResponseUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
@Controller("repairAction")
@Scope("prototype")
public class RepairAction extends ActionSupport implements ModelDriven<Repair> {

	private Repair repair=new Repair();
	@Autowired
	private RepairService repairService;
	@Autowired
	private UserService userService;
	@Autowired
	private DeptService	deptService;
	private Map<String, Object> session;
	private List<Repair> repairList;
	private List<Dept> deptList;
	private List<User> userList;
	private List<AssetSort> assetSortList;
	private String userId;
private String state;
	
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

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

	public Repair getRepair() {
		return repair;
	}
	public void setRepair(Repair repair) {
		this.repair = repair;
	}
	
	public List<Dept> getDeptList() {
		return deptList;
	}

	@Override 
	public Repair getModel() {
		// TODO Auto-generated method stub
		return repair;
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
		assetSortList=repairService.findAssertSortList();
		userList=userService.listUser(null, null, null, null);
		return "addpage";
	}

	public String add() throws Exception{
		boolean flag = true;
		try {
			repairService.saveRepair(repair);
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
	public String listRepair() {
		
		repairList = repairService.listRepair(null,null);
		HashMap<String, Object> maps = new HashMap<String, Object>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		for (Repair  repair: repairList) {
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("repairId", repair.getRepairId());
			hashMap.put("price", repair.getPrice());
			hashMap.put("userName", repair.getUser().getUserName());
			hashMap.put("assetName",repair.getAsset().getAssetName() );
			hashMap.put("wrongDesc",repair.getWrongDesc() );
			hashMap.put("state",repair.getState() );
			list.add(hashMap);
		}
		maps.put("Rows", list);
		maps.put("total", list.size());
		System.out.println(maps.size());
		rows = JSONObject.parseObject(JSON.toJSONString(maps));
		System.out.println(rows.toJSONString());
		return "repairlist";
	}
	public String remove() throws Exception {
		boolean flag = false;
		if (repairService.remove(repair.getRepairId())) {
			flag = true;
			ResponseUtil.write1(flag);
		} else {
			ResponseUtil.write1(flag);
		}
		return null;
	}
	public String editPage(){
		assetSortList=repairService.findAssertSortList();
		userList=userService.listUser(null, null, null, null);
		repair=repairService.findRepair(repair.getRepairId());
		
		return "editPage";
	}
	public String edit() throws Exception {
		boolean flag = true;
		try {
			repairService.updateRepair(repair);
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
