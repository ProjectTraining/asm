package com.asm.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;


/**
 * StockTakingItem entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_stockTakingItem")

public class StockTakingItem  implements java.io.Serializable {


    // Fields    

     private String stockTakingItemId;
     private Asset asset;
     private StockTaking stockTaking;
     private Integer stockTakingResult;
     private Date stockTakingDate;


     @Id
  	@GeneratedValue(generator="stockTakingItemUUID")
  	@GenericGenerator(name="stockTakingItemUUID", strategy="uuid")
    public String getStockTakingItemId() {
        return this.stockTakingItemId;
    }
    
    public void setStockTakingItemId(String stockTakingItemId) {
        this.stockTakingItemId = stockTakingItemId;
    }
    
   
    
    @Column(name="stockTakingResult")

    public Integer getStockTakingResult() {
        return this.stockTakingResult;
    }
    
    public void setStockTakingResult(Integer stockTakingResult) {
        this.stockTakingResult = stockTakingResult;
    }
    
    @Column(name="stockTakingDate", length=19)

    public Date getStockTakingDate() {
        return this.stockTakingDate;
    }
    
    public void setStockTakingDate(Date stockTakingDate) {
        this.stockTakingDate = stockTakingDate;
    }
   

    @ManyToOne(cascade=CascadeType.REFRESH,optional=true)  
    @JoinColumn(name = "assetId",referencedColumnName="assetId") 
	public Asset getAsset() {
		return asset;
	}
	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	
	
	@ManyToOne(cascade=CascadeType.REFRESH,optional=true)  
    @JoinColumn(name = "stockTakingId",referencedColumnName="stockTakingId") 
	public StockTaking getStockTaking() {
		return stockTaking;
	}

	public void setStockTaking(StockTaking stockTaking) {
		this.stockTaking = stockTaking;
	}







}