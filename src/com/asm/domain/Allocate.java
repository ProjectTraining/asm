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
 * Allocate entity. 
 * @author 郑成斌
 * @time 2016-5-15
 */
@Entity
@Table(name = "t_allocate", catalog = "asm")
public class Allocate implements java.io.Serializable {

	// Fields

	private String allocateId;
//	private String outUserId;
//	private String outDeptId;
//	private String inConfirmUserId;
//	private String inDeptId;
//	private String assetId;
	private User userOut;// outUserId;
	private Dept deptOut;// outDeptId;
	private User userAccept;// inConfirmUserId;
	private Dept deptAccept;// inDeptId;
	private Asset asset;// assetId;
	private Date outDate;
	private String outReason;
	private Integer state;
	private Date inConfirmDate;

	// Constructors

	/** default constructor */
	public Allocate() {
	}

	
	@Id
	@GeneratedValue(generator="allocateUUID")
	@GenericGenerator(name="allocateUUID", strategy="uuid")
	public String getAllocateId() {
		return this.allocateId;
	}

	public void setAllocateId(String allocateId) {
		this.allocateId = allocateId;
	}

    @ManyToOne(cascade=CascadeType.REFRESH,optional=true)  
    @JoinColumn(name = "outUserId",referencedColumnName="userId") 
	public User getUserOut() {
		return userOut;
	}


	public void setUserOut(User userOut) {
		this.userOut = userOut;
	}

	@ManyToOne(cascade=CascadeType.REFRESH,optional=true)  
    @JoinColumn(name = "outDeptId",referencedColumnName="deptId") 
	public Dept getDeptOut() {
		return deptOut;
	}


	public void setDeptOut(Dept deptOut) {
		this.deptOut = deptOut;
	}

	@ManyToOne(cascade=CascadeType.REFRESH,optional=true)  
    @JoinColumn(name = "inConfirmUserId",referencedColumnName="userId") 
	public User getUserAccept() {
		return userAccept;
	}


	public void setUserAccept(User userAccept) {
		this.userAccept = userAccept;
	}

	@ManyToOne(cascade=CascadeType.REFRESH,optional=true)  
    @JoinColumn(name = "inDeptId",referencedColumnName="deptId") 
	public Dept getDeptAccept() {
		return deptAccept;
	}


	public void setDeptAccept(Dept deptAccept) {
		this.deptAccept = deptAccept;
	}

	@ManyToOne(cascade=CascadeType.REFRESH,optional=true)  
    @JoinColumn(name = "assetId",referencedColumnName="assetId") 
	public Asset getAsset() {
		return asset;
	}


	public void setAsset(Asset asset) {
		this.asset = asset;
	}


	@Column(name = "outDate", length = 19)
	public Date getOutDate() {
		return this.outDate;
	}

	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}

	@Column(name = "outReason", length = 200)
	public String getOutReason() {
		return this.outReason;
	}

	public void setOutReason(String outReason) {
		this.outReason = outReason;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name = "inConfirmDate", length = 19)
	public Date getInConfirmDate() {
		return this.inConfirmDate;
	}

	public void setInConfirmDate(Date inConfirmDate) {
		this.inConfirmDate = inConfirmDate;
	}

}