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

@Entity
@Table(name="t_transferItem")
public class TransferItem {
	private String transferItemId;
	private Asset asset;
	private Transfer transfer;
	private User receiverUser;
	private int reveiverResult;
	private Date receiverDate;
	
	@Id
	@GeneratedValue(generator="transferItemUUID")
	@GenericGenerator(name="transferItemUUID", strategy="uuid")
	public String getTransferItemId() {
		return transferItemId;
	}
	
	public void setTransferItemId(String transferItemId) {
		this.transferItemId = transferItemId;
	}
	
	@ManyToOne(cascade=CascadeType.REFRESH,optional=true)  
    @JoinColumn(name = "assetId",referencedColumnName="assetId")
	public Asset getAsset() {
		return asset;
	}
	
	public void setAsset(Asset asset) {
		this.asset = asset;
	}
	
	@OneToOne(cascade=CascadeType.REFRESH,optional=true)  
    @JoinColumn(name = "transferId",referencedColumnName="transferId")
	public Transfer getTransfer() {
		return transfer;
	}

	public void setTransfer(Transfer transfer) {
		this.transfer = transfer;
	}

	@ManyToOne(cascade=CascadeType.REFRESH,optional=true)  
    @JoinColumn(name = "receiverUserId",referencedColumnName="userId")
	public User getReceiverUser() {
		return receiverUser;
	}

	public void setReceiverUser(User receiverUser) {
		this.receiverUser = receiverUser;
	}

	public int getReveiverResult() {
		return reveiverResult;
	}

	public void setReveiverResult(int reveiverResult) {
		this.reveiverResult = reveiverResult;
	}
	
	@Column(name="receiverDate", length=19)
	public Date getReceiverDate() {
		return receiverDate;
	}

	public void setReceiverDate(Date receiverDate) {
		this.receiverDate = receiverDate;
	}
}
