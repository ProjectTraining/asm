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
	private int groupId;
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
	
	public Parameter getParameter() {
		return parameter;
	}
	
	public void setParameter(Parameter parameter) {
		this.parameter = parameter;
	}
	
	public ParameterService getParameterService() {
		return parameterService;
	}
	
	public void setParameterService(ParameterService parameterService) {
		this.parameterService = parameterService;
	}
	
	public void setParameterList(List<Parameter> parameterList){
		this.parameterList = parameterList;
	}
	
	public String getParameterId(){
		System.out.println("DDDDD" + parameterId);
		return parameterId;
	}
	
	public void setParameterId(String parameterId) {
		System.out.println("CCCCCC" + parameterId);
		this.parameterId = parameterId;
	}
	
	public String getParameterName(){
		return parameterName;
	}
	
	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}
	
	public String getParameterValue(){
		return parameterValue;
	}
	
	public void setParameterValue(String parameterValue) {
		this.parameterValue = parameterValue;
	}
	
	public int getGroupId(){
		return groupId;
	}
	
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	
	public String getGroupName(){
		return groupName;
	}
	
	public void setGroupName(String groupName) {
		this.groupName = groupName;
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
		return "showList";
	}
	
	public String delParameter(){
		boolean flag = this.parameterService.delParameter(parameter);
		if(flag){
			parameterList = parameterService.scanTable();
			return "showList";
		}
		else{
			return "error";
		}

	}
	
	public String updateParameter(){
		parameterService.updateParamter(parameter);
		return "showList";
	}
}
