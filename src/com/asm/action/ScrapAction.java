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
import com.asm.domain.Asset;
import com.asm.domain.Dept;
import com.asm.domain.Scrap;
import com.asm.domain.User;
import com.asm.service.AssetService;
import com.asm.service.DeptService;
import com.asm.service.ScrapService;
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
@Controller("scrapAction")
@Scope("prototype")
public class ScrapAction extends ActionSupport implements SessionAware, ModelDriven<Scrap> {

	private Scrap scrap=new Scrap();
	@Autowired
	private ScrapService scrapService;
	@Autowired
	private UserService userService;
	@Autowired
	private AssetService assetService;
	@Autowired
	private DeptService	deptService;
	private Map<String, Object> session;
	private List<Scrap> scrapList;
	private List<Dept> deptList;
	private List<User> userList;
	private String userId;
	private int pageNow = 1;
	private int pageSize = 10;
	private JSONObject rows;
	private String storeId;
	private JSONObject data;
	private String stateStr;
	private Date startTime,endTime;
	
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}
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
	public Scrap getScrap() {
		return scrap;
	}
	public void setScrap(Scrap scrap) {
		this.scrap = scrap;
	}
	
	public List<Dept> getDeptList() {
		return deptList;
	}

	@Override 
	public Scrap getModel() {
		// TODO Auto-generated method stub
		return scrap;
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
	
	public String changeState() throws Exception {
		
		boolean flag = false;
		int state=scrap.getState();
		User user=(User) session.get("user");
		scrap=scrapService.findScrap(scrap.getScrapId());
		scrap.setState(state);
		scrap.setAgreeUser(user);
		scrap.setAgreeDate(new Date());
		if (scrapService.updateScrap(scrap)) {
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
		return "addpage";
	}

	public String add() throws Exception{
		boolean flag = true;
		try {
			scrapService.saveScrap(scrap);
			ResponseUtil.write1(flag);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			flag = false;
			e.printStackTrace();
			ResponseUtil.write1(flag);
		}
		return null;
	}
	
	public String list() {
		System.out.println("size:1111");
		scrapList = scrapService.listScrap(null, null);
		System.out.println("size:"+scrapList.size());
		HashMap<String, Object> maps = new HashMap<String, Object>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		for (Scrap  scrap: scrapList) {
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("scrapId", scrap.getScrapId());
			hashMap.put("assetName", scrap.getAsset().getAssetName());
			if(null!= scrap.getScrapUser()){
				hashMap.put("scrapUserName", scrap.getScrapUser().getUserName());
			}
			hashMap.put("scrapDate", StringHelper.dateTimetoString(scrap.getScrapDate()));
			if(null!= scrap.getAgreeUser()){
				hashMap.put("agreeUserName", scrap.getAgreeUser().getUserName());
			}
			hashMap.put("agreeDate", StringHelper.dateTimetoString(scrap.getAgreeDate()));
			hashMap.put("state", scrap.getState());
			list.add(hashMap);
		}
		maps.put("Rows", list);
		System.out.println(maps.size());
		rows = JSONObject.parseObject(JSON.toJSONString(maps));
		System.out.println(rows.toJSONString());
		return "list";
	}
	public String remove() throws Exception {
		boolean flag = false;
		if (scrapService.remove(scrap.getScrapId())) {
			flag = true;
			ResponseUtil.write1(flag);
		} else {
			ResponseUtil.write1(flag);
		}
		return null;
	}
	public String editScrap() throws Exception {
		boolean flag = true;
		try {
			scrapService.updateScrap(scrap);
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
