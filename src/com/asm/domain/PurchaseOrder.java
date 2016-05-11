package com.asm.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TPurchaseOrder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_purchaseOrder")
public class PurchaseOrder implements java.io.Serializable {

	// Fields

	private String purchaseId;
	private String purchaseUserId;
	private String purchaseDeptId;
	private Date purchaseDate;
	private String purchasePurpose;


	@Id
	@GeneratedValue(generator="purchaseOrderUUID")
	@GenericGenerator(name="purchaseOrderUUID", strategy="uuid")
	public String getPurchaseId() {
		return this.purchaseId;
	}

	public void setPurchaseId(String purchaseId) {
		this.purchaseId = purchaseId;
	}

	public String getPurchaseUserId() {
		return this.purchaseUserId;
	}

	public void setPurchaseUserId(String purchaseUserId) {
		this.purchaseUserId = purchaseUserId;
	}

	public String getPurchaseDeptId() {
		return this.purchaseDeptId;
	}

	public void setPurchaseDeptId(String purchaseDeptId) {
		this.purchaseDeptId = purchaseDeptId;
	}

	public Date getPurchaseDate() {
		return this.purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getPurchasePurpose() {
		return this.purchasePurpose;
	}

	public void setPurchasePurpose(String purchasePurpose) {
		this.purchasePurpose = purchasePurpose;
	}

}