package com.asm.domain;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;


/**
 * PurchaseItem entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_purchaseItem")

public class PurchaseItem  implements java.io.Serializable {


    // Fields    

     private String purchaseItemId;
     private String assetSortId;
     private String purchaseOrderId;
     private String preserveUserId;
     private String parentAssertSortId;
     private String unit;
     private String assetType;
     private String assettName;
     private int num;
     private String remarks;
     private String manufacturer;
     private String supplier;
     private float price;


    // Constructors

    /** default constructor */
    public PurchaseItem() {
    }

    


   
	@Id
	@GeneratedValue(generator="purchaeItemUUID")
	@GenericGenerator(name="purchaeItemUUID", strategy="uuid")
    public String getPurchaseItemId() {
        return this.purchaseItemId;
    }
    
    public void setPurchaseItemId(String purchaseItemId) {
        this.purchaseItemId = purchaseItemId;
    }
    
    @Column(name="assetSortId", length=32)

    public String getAssetSortId() {
        return this.assetSortId;
    }
    
    public void setAssetSortId(String assetSortId) {
        this.assetSortId = assetSortId;
    }
    
    @Column(name="purchaseOrderId", length=32)

    public String getPurchaseOrderId() {
        return this.purchaseOrderId;
    }
    
    public void setPurchaseOrderId(String purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }
    
    @Column(name="preserveUserId", length=32)

    public String getPreserveUserId() {
        return this.preserveUserId;
    }
    
    public void setPreserveUserId(String preserveUserId) {
        this.preserveUserId = preserveUserId;
    }
    
    @Column(name="parentAssertSortId", length=32)

    public String getParentAssertSortId() {
        return this.parentAssertSortId;
    }
    
    public void setParentAssertSortId(String parentAssertSortId) {
        this.parentAssertSortId = parentAssertSortId;
    }
    
    @Column(name="unit", length=10)

    public String getUnit() {
        return this.unit;
    }
    
    public void setUnit(String unit) {
        this.unit = unit;
    }
    
    @Column(name="assetType", length=200)

    public String getAssetType() {
        return this.assetType;
    }
    
    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }
    
    @Column(name="assettName", length=200)

    public String getAssettName() {
        return this.assettName;
    }
    
    public void setAssettName(String assettName) {
        this.assettName = assettName;
    }
    
    @Column(name="num")

    public int getNum() {
        return this.num;
    }
    
    public void setNum(int num) {
        this.num = num;
    }
    
    @Column(name="remarks", length=200)

    public String getRemarks() {
        return this.remarks;
    }
    
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
    @Column(name="manufacturer", length=50)

    public String getManufacturer() {
        return this.manufacturer;
    }
    
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    
    @Column(name="supplier", length=50)

    public String getSupplier() {
        return this.supplier;
    }
    
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    
    @Column(name="price", precision=12, scale=0)

    public float getPrice() {
        return this.price;
    }
    
    public void setPrice(float price) {
        this.price = price;
    }
   








}