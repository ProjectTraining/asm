package com.asm.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
/**
 * @description 资产领用归还
 * @Author: 赵楠（作者）
 * @Version: V1.00 （版本号）
 * @Create Date: 2016-5-12 （创建日期）
 */
@Entity
@Table(name="t_assetPick")
public class AssetPick implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String assetPickId;
	private String pickUserId;
	private String returnUserId;
	private Date pickDate;
	private Date returnDate;
	private int state;
	private Asset asset;   //  不需要定义外键，只需要定义外键所在的数据库类
	@Id
	@GeneratedValue(generator="assetPickUUID")
	@GenericGenerator(name="assetPickUUID", strategy="uuid")
	public String getAssetPickId() {
		return assetPickId;
	}
	public void setAssetPickId(String assetPickId) {
		this.assetPickId = assetPickId;
	}
	public String getPickUserId() {
		return pickUserId;
	}
	public void setPickUserId(String pickUserId) {
		this.pickUserId = pickUserId;
	}
	public String getReturnUserId() {
		return returnUserId;
	}
	public void setReturnUserId(String returnUserId) {
		this.returnUserId = returnUserId;
	}
	public Date getPickDate() {
		return pickDate;
	}
	public void setPickDate(Date pickDate) {
		this.pickDate = pickDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@ManyToOne(cascade=CascadeType.REFRESH,optional=true)  
    @JoinColumn(name = "assettId")    // 这里的name值是 many这个数据库的外键
	public Asset getAsset() {
		return asset;
	}
	public void setAsset(Asset asset) {
		this.asset = asset;
	}
}
