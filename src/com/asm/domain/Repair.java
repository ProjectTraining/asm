package com.asm.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Repair entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_repair", catalog = "asm")
public class Repair implements java.io.Serializable {

	// Fields

	private String repairId;
	private String repairUserId;
	private String assetId;
	private String wrongDesc;
	private float price;
	private Integer state;
	private Integer useStateBeforeRepair;

	// Constructors

	/** default constructor */
	public Repair() {
	}

	/** full constructor */
	public Repair(String repairUserId, String assetId, String wrongDesc,
			float price, Integer state, Integer useStateBeforeRepair) {
		this.repairUserId = repairUserId;
		this.assetId = assetId;
		this.wrongDesc = wrongDesc;
		this.price = price;
		this.state = state;
		this.useStateBeforeRepair = useStateBeforeRepair;
	}

	// Property accessors
	@Id
	@GeneratedValue(generator="repairUUID")
	@GenericGenerator(name="repairUUID", strategy="uuid")
	public String getRepairId() {
		return this.repairId;
	}

	public void setRepairId(String repairId) {
		this.repairId = repairId;
	}

	@Column(name = "repairUserId", length = 32)
	public String getRepairUserId() {
		return this.repairUserId;
	}

	public void setRepairUserId(String repairUserId) {
		this.repairUserId = repairUserId;
	}

	@Column(name = "assetId", length = 32)
	public String getAssetId() {
		return this.assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	@Column(name = "wrongDesc", length = 32)
	public String getWrongDesc() {
		return this.wrongDesc;
	}

	public void setWrongDesc(String wrongDesc) {
		this.wrongDesc = wrongDesc;
	}

	@Column(name = "price", precision = 10, scale = 0)
	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name = "useStateBeforeRepair")
	public Integer getUseStateBeforeRepair() {
		return this.useStateBeforeRepair;
	}

	public void setUseStateBeforeRepair(Integer useStateBeforeRepair) {
		this.useStateBeforeRepair = useStateBeforeRepair;
	}

}