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

@Entity
@Table(name="t_transfer")
public class Transfer {
	private String transferId;
	private User transferUser;
	private User receiverUser;
	private Date transferDate;
	private Date receiverDate;
	private int state;
	private int transferType;
	
	@Id
	@GeneratedValue(generator="transferUUID")
	@GenericGenerator(name="transferUUID", strategy="uuid")
	public String getTransferId() {
		return transferId;
	}
	
	public void setTransferId(String transferId) {
		this.transferId = transferId;
	}
	
	@ManyToOne(cascade=CascadeType.REFRESH,optional=true)  
    @JoinColumn(name = "transferUserId",referencedColumnName="userId")
	public User getTransferUser() {
		return transferUser;
	}
	
	public void setTransferUser(User transferUser) {
		this.transferUser = transferUser;
	}
	
	@ManyToOne(cascade=CascadeType.REFRESH,optional=true)  
    @JoinColumn(name = "receiverUserId",referencedColumnName="userId")
	public User getReceiverUser() {
		return receiverUser;
	}
	
	public void setReceiverUser(User receiverUser) {
		this.receiverUser = receiverUser;
	}
	
	@Column(name="transferDate", length=19)
	public Date getTransferDate() {
		return transferDate;
	}
	
	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}
	
	@Column(name="receiverDate", length=19)
	public Date getReceiverDate() {
		return receiverDate;
	}
	
	public void setReceiverDate(Date receiverDate) {
		this.receiverDate = receiverDate;
	}
	
	public int getState() {
		return state;
	}
	
	public void setState(int state) {
		this.state = state;
	}
	
	public int getTransferType() {
		return transferType;
	}
	
	public void setTransferType(int transferType) {
		this.transferType = transferType;
	}
}
