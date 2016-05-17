package com.asm.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
* @description:PO持久层对象，对应数据库表t_repair
* @Author: 邹嘉伟（作者）
* @Version: V1.00 （版本号）
* @Create Date: 2016-5-11 （创建日期）
*/

@Entity
@Table(name="t_repair")
public class AssetRepair implements java.io.Serializable{
	
  private String repairId;               //主键id
  private String repairUserId;           //送修人id
  private String assetId;                //资产id
  private String wrongDesc;              //损坏情况
  private float price;                   //维修费用
  private int state;                     //状态
  private int useStateBeforeRepair;      //送修前资产使用状态
  @Id
  @GeneratedValue(generator="userUUID")
  @GenericGenerator(name="userUUID", strategy="uuid")
  
  public String getRepairId() {
	  return repairId;
  }
  public void setRepairId(String repairId) {
	  this.repairId = repairId;
  }
  public String getRepairUserId() {
	  return repairUserId;
  }
  public void setRepairUserId(String repairUserId) {
	  this.repairUserId = repairUserId;
  }
  public String getAssetId() {
	  return assetId;
  }
  public void setAssetId(String assetId) {
	  this.assetId = assetId;
  }
  public String getWrongDesc() {
	  return wrongDesc;
  }
  public void setWrongDesc(String wrongDesc) {
	  this.wrongDesc = wrongDesc;
  }
  public float getPrice() {
	  return price;
  }
  public void setPrice(float price) {
	  this.price = price;
  }
  public int getState() {
	  return state;
  }
  public void setState(int state) {
	  this.state = state;
  }
  public int getUseStateBeforeRepair() {
	  return useStateBeforeRepair;
  }
  public void setUseStateBeforeRepair(int useStateBeforeRepair) {
	  this.useStateBeforeRepair = useStateBeforeRepair;
  }
  
   
}
