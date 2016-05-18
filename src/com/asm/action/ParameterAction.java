package com.asm.action;

import java.util.List;
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
	private List<Parameter> parameterList;
	@Autowired
	private ParameterService parameterService;
	
	private Map<String, Object> session;
	private String parameterId;
	private String parameterName;
	private String parameterValue;
	private String groupId;
	private String groupName;

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
	
	public List<Parameter> getParameterList(){
		return parameterList;
	}
	
	public void setParameterList(List<Parameter> _parameterList){
		this.parameterList = _parameterList;
	}
	
	public String getParameterId(){
		return parameterId;
	}
	
	public void setParameterId(String _parameterId) {
		this.parameterId = _parameterId;
	}
	
	public String getParameterName(){
		return parameterName;
	}
	
	public void setParameterName(String _parameterName) {
		this.parameterName = _parameterName;
	}
	
	public String getParameterValue(){
		return parameterValue;
	}
	
	public void setParameterValue(String _parameterValue) {
		this.parameterValue = _parameterValue;
	}
	
	public String getGroupId(){
		return groupId;
	}
	
	public void setGroupId(String _groupId) {
		this.groupId = _groupId;
	}
	
	public String getGroupName(){
		return groupName;
	}
	
	public void setGroupName(String _groupName) {
		this.groupName = _groupName;
	}
	
	public String storeManagePage() {
		return "storemanagepage";
	}
	
	public String infoHome(){
		if(null != parameter.getGroupName() &&
				null != parameter.getParameterName() &&
				null != parameter.getParameterValue()){
			parameterService.updateParamter(parameter);
		}
		return "infoHome";
	}
	
	public String showList(){
		parameterList = parameterService.scanTable();
		System.out.println(parameterList.get(0).getParameterName());
		System.out.println("showList");
		return "showList";
	}
	
	public String delParameter{
		System.out.println("--------" + parameter.getParameterID());
	}
}
