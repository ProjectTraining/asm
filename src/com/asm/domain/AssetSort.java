package com.asm.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="t_assetSort")
public class AssetSort implements java.io.Serializable{
	
	private String assetSortId;
	private String assetSortCode;
	private String assetSortName;
	private String parentId;
	private String parentName;
	
	/** default constructor */
	public AssetSort() {
	}

	/** full constructor */
	public AssetSort(String assetSortCode, String assetSortName, String parentId,
			String parentName) {
		this.assetSortCode=assetSortCode;
		this.assetSortName=assetSortName;
		this.parentId = parentId;
		this.parentName = parentName;
	}
	
	@Id
	@GeneratedValue(generator="userUUID")
	@GenericGenerator(name="userUUID", strategy="uuid")
	public String getAssetSortId() {
		return assetSortId;
	}

	public void setAssetSortId(String assetSortId) {
		this.assetSortId = assetSortId;
	}
	public String getParentId() {
		return parentId;
	}
	public String getAssetSortCode() {
		return assetSortCode;
	}

	public void setAssetSortCode(String assetSortCode) {
		this.assetSortCode = assetSortCode;
	}

	public String getAssetSortName() {
		return assetSortName;
	}

	public void setAssetSortName(String assetSortName) {
		this.assetSortName = assetSortName;
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
