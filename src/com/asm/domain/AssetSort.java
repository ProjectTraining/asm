package com.asm.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="t_assetSort")
public class AssetSort implements java.io.Serializable{
	
	private String assetId;
	private String assetCode;
	private String assetName;
	private String parentId;
	private String parentName;
	
	/** default constructor */
	public AssetSort() {
	}

	/** full constructor */
	public AssetSort(String assetCode, String assetName, String parentId,
			String parentName) {
		this.assetCode = assetCode;
		this.assetName = assetName;
		this.parentId = parentId;
		this.parentName = parentName;
	}
	
	@Id
	@GeneratedValue(generator="userUUID")
	@GenericGenerator(name="userUUID", strategy="uuid")
	public String getAssetId() {
		return assetId;
	}
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}
	public String getAssetCode() {
		return assetCode;
	}
	public void setAssetCode(String assetCode) {
		this.assetCode = assetCode;
	}
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	
}
