package com.asm.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="t_parameter")
public class Parameter implements java.io.Serializable {
	private String parameterId;
	private String parameterName;
	private String parameterValue;
	private int groupId;
	private String groupName;
	
	public Parameter(){
	}
	
	public Parameter(String parameterId, String parameterName, String parameterValue, int groupId, String groupName){
		this.parameterId = parameterId;
		this.parameterName = parameterName;
		this.parameterValue = parameterValue;
		this.groupId = groupId;
		this.groupName = groupName;
	}
	
	@Id
	@GeneratedValue(generator="parameterUUID")
	@GenericGenerator(name="parameterUUID", strategy="uuid")
	public String getParameterId() {
		return parameterId;
	}
	public void setParameterId(String parameterId) {
		this.parameterId = parameterId;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getParameterName() {
		return parameterName;
	}
	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}
	public String getParameterValue() {
		return parameterValue;
	}
	public void setParameterValue(String parameterValue) {
		this.parameterValue = parameterValue;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
}
