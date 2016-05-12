package com.asm.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;
import com.asm.domain.Parameter;
import com.asm.service.ParameterService;
import com.asm.util.MD5;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @description:parameter table operator page action
 * @author:yjzheng
 * @version:0.01
 * @date:04/21/2016
 */
@SuppressWarnings("serial")
@Controller("parameterAction")
@Scope("prototype")
public class ParameterAction extends ActionSupport implements SessionAware, ModelDriven<Parameter> {
	private Parameter parameter = new Parameter();
	@Autowired
	private ParameterService parameterService;
	
	private Map<String, Object> session;
	private int pageNow = 1;
	private int pageSize = 10;
	private JSONObject rows;
	private String storeId;
	private int state;
	private String parameterId;
	private String Id;
	private JSONObject data;

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

	@Override
	public Parameter getModel() {
		// TODO Auto-generated method stub
		return parameter;
	}
	
	public String getParameterId(){
		return parameterId;
	}
	
	public JSONObject getData() {
		return data;
	}

	public void setData(JSONObject data) {
		this.data = data;
	}

	public void setParameterId(String parameterId) {
		this.parameterId = parameterId;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
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
	
	public String storeManagePage() {
		return "storemanagepage";
	}
	
	public String infoHome(){
		if(null != parameter.getGroupId() && null != parameter.getGroupName() &&
				null != parameter.getParameterName() && null != parameter.getParameterValue()){
			parameterService.updateParamter(parameter);
		}
		return "infoHome";
	}
	
	public void Show(){
		if(null == parameterService){
			return;
		}
		for(Parameter p : parameterService.scanTable()){
			System.out.println(p.getParameterName() + ":" + p.getParameterValue());
		}
	}
}
