package com.asm.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Allocate entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_allocate", catalog = "asm")
public class Allocate implements java.io.Serializable {

	// Fields

	private String allocateId;
	private String outUserId;
	private String outDeptId;
	private String inConfirmUserId;
	private String inDeptId;
	private String assetId;
	private Date outDate;
	private String outReason;
	private Integer state;
	private Date inConfirmDate;

	// Constructors

	/** default constructor */
	public Allocate() {
	}

	/** full constructor */
	public Allocate(String outUserId, String outDeptId, String inConfirmUserId,
			String inDeptId, String assetId, Date outDate, String outReason,
			Integer state, Date inConfirmDate) {
		this.outUserId = outUserId;
		this.outDeptId = outDeptId;
		this.inConfirmUserId = inConfirmUserId;
		this.inDeptId = inDeptId;
		this.assetId = assetId;
		this.outDate = outDate;
		this.outReason = outReason;
		this.state = state;
		this.inConfirmDate = inConfirmDate;
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

	@Column(name = "outUserId", length = 32)
	public String getOutUserId() {
		return this.outUserId;
	}

	public void setOutUserId(String outUserId) {
		this.outUserId = outUserId;
	}

	@Column(name = "outDeptId", length = 32)
	public String getOutDeptId() {
		return this.outDeptId;
	}

	public void setOutDeptId(String outDeptId) {
		this.outDeptId = outDeptId;
	}

	@Column(name = "inConfirmUserId", length = 32)
	public String getInConfirmUserId() {
		return this.inConfirmUserId;
	}

	public void setInConfirmUserId(String inConfirmUserId) {
		this.inConfirmUserId = inConfirmUserId;
	}

	@Column(name = "inDeptId", length = 32)
	public String getInDeptId() {
		return this.inDeptId;
	}

	public void setInDeptId(String inDeptId) {
		this.inDeptId = inDeptId;
	}

	@Column(name = "assetId", length = 32)
	public String getAssetId() {
		return this.assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
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