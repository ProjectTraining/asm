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
	private String groupId;
	private String groupName;
	@Id
	@GeneratedValue(generator="parameterUUID")
	@GenericGenerator(name="parameterUUID", strategy="uuid")
	public String getParameterID() {
		return parameterId;
	}
	public void setParameterID(String parameterId) {
		this.parameterId = parameterId;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
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
