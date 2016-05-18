package com.asm.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;


/**
 * Scrap entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_scrap")

public class Scrap  implements java.io.Serializable {


    // Fields    

     private String scrapId;
     private User scrapUser;
     private User agreeUser;
     private Asset asset;
  
     private Date scrapDate;
     private Date agreeDate;
     private Integer state;



    @Id
	@GeneratedValue(generator="scrapUUID")
	@GenericGenerator(name="scrapUUID", strategy="uuid")
    public String getScrapId() {
        return this.scrapId;
    }
    
    public void setScrapId(String scrapId) {
        this.scrapId = scrapId;
    }
    

    



    public Date getScrapDate() {
        return this.scrapDate;
    }
    
    public void setScrapDate(Date scrapDate) {
        this.scrapDate = scrapDate;
    }
    

    public Date getAgreeDate() {
        return this.agreeDate;
    }
    
    public void setAgreeDate(Date agreeDate) {
        this.agreeDate = agreeDate;
    }
    
    public Integer getState() {
        return this.state;
    }
    
    public void setState(Integer state) {
        this.state = state;
    }


    
    @ManyToOne(cascade=CascadeType.REFRESH,optional=true)  
    @JoinColumn(name = "scrapUserId",referencedColumnName="userId") 
	public User getScrapUser() {
		return scrapUser;
	}


	public void setScrapUser(User scrapUser) {
		this.scrapUser = scrapUser;
	}

	@ManyToOne(cascade=CascadeType.REFRESH,optional=true)  
    @JoinColumn(name = "agreeUserId",referencedColumnName="userId") 
	public User getAgreeUser() {
		return agreeUser;
	}


	public void setAgreeUser(User agreeUser) {
		this.agreeUser = agreeUser;
	}

	@ManyToOne(cascade=CascadeType.REFRESH,optional=true)  
    @JoinColumn(name = "assetId",referencedColumnName="assetId") 
	public Asset getAsset() {
		return asset;
	}
	public void setAsset(Asset asset) {
		this.asset = asset;
	}
   
    
    
    








}