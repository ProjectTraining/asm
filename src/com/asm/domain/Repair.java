package com.asm.domain;
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
 * Repair entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_repair", catalog = "asm")
public class Repair implements java.io.Serializable {

	// Fields

	private String repairId;
	private User user;
	private Asset asset;
	private String wrongDesc;
	private float price;
	private Integer state;
	private Integer useStateBeforeRepair;

	// Constructors

	/** default constructor */
	public Repair() {
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

	@ManyToOne(cascade=CascadeType.REFRESH,optional=true)  
    @JoinColumn(name = "repairUserId",referencedColumnName="userId") 
	 public User getUser() {
	  return user;
	 }
	
	public void setUser(User user) {
		this.user = user;

	}

	 @ManyToOne(cascade=CascadeType.REFRESH,optional=true)  
	    @JoinColumn(name = "assetId",referencedColumnName="assetId") 
		public Asset getAsset() {
			return asset;
		}
		public void setAsset(Asset asset) {
			this.asset = asset;
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