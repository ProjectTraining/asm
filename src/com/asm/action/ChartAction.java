package com.asm.action;

import java.text.DecimalFormat;
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
import com.asm.domain.AssetSort;
import com.asm.domain.Dept;
import com.asm.domain.User;
import com.asm.service.ChartService;
import com.asm.service.DeptService;
import com.asm.service.PurchaseItemService;
import com.asm.service.UserService;
import com.asm.util.MD5;
import com.asm.util.ResponseUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


/**  
* @description:用户action
* @Author: 张毓峰（作者）
* @Version: V1.00 （版本号）
* @Create Date: 2016-4-8 （创建日期）
*/
@SuppressWarnings("serial")
@Controller("chartAction")
@Scope("prototype")
public class ChartAction extends ActionSupport  {

	private User user=new User();
	@Autowired
	private ChartService chartService;
	@Autowired
	private PurchaseItemService purchaseItemService;
	private JSONObject rows;
	private List<AssetSort> assetSortList;
	private String assetSortId;
	
	public String getAssetSortId() {
		return assetSortId;
	}

	public void setAssetSortId(String assetSortId) {
		this.assetSortId = assetSortId;
	}

	public List<AssetSort> getAssetSortList() {
		return assetSortList;
	}

	public void setAssetSortList(List<AssetSort> assetSortList) {
		this.assetSortList = assetSortList;
	}

	public JSONObject getRows() {
		return rows;
	}

	public void setRows(JSONObject rows) {
		this.rows = rows;
	}
	public String homePage(){
		assetSortList=purchaseItemService.findAssertSortList();
		System.out.println(assetSortList.size()+" adsf");
		return "homepage";
	}

	public String chartData(){
		HashMap<String, Object> maps = new HashMap<String, Object>();
		List<Object[]> assetNameAndNumObj=null;
		System.out.println("assetSortId"+assetSortId);
		if(null!=assetSortId&&!"".equals(assetSortId)){
			assetNameAndNumObj=chartService.findNameAndNumByAssetSortLv2(assetSortId);
		}else{
			assetNameAndNumObj=chartService.findNameAndNumByAssetSortLv1();
		}
		
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		for(int i=0;null!=assetNameAndNumObj && i<assetNameAndNumObj.size();i++){
			Object[] object = assetNameAndNumObj.get(i);		
			System.out.println(object[0].toString()+"  "+object[1].toString());
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("name", object[0].toString());
			hashMap.put("age", Double.valueOf(object[1].toString()).intValue());
			list.add(hashMap);
		}
		maps.put("list", list);
		rows = JSONObject.parseObject(JSON.toJSONString(maps));
		
		return "chartdata";
	}
}
