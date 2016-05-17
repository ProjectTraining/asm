package com.asm.domain;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Asset entity. 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_asset")
public class Asset implements java.io.Serializable {

	// Fields

	private String assetId;
	private String assetSortId;
	private String deptId;
	private String userUserId;
	private String preserveUserId;
	private String assetInUserId;
	private String purchaseItemId;
	private String assetParentId;
	private String cardId;
	private Integer stockState;
	private Integer isInAccount;
	private String modeAndType;
	private Integer useState;
	private String assetName;
	private String purcharseDeptId;
	private Date stocktime;
	private String financeNum;
	private String assetNum;
	private String manufacturer;
	private String supplier;
	private Date inStockDate;
	private String unit;
	private Integer num;
	private String remarks;
	private float price;
	private Integer labelIsPrint;
	private String oneDimensionalCode;
	private String twoDimensionalCode;
	private String barCode;

	// Constructors

	/** default constructor */
	public Asset() {
	}

	/** full constructor */
	public Asset(String assetSortId, String deptId, String userUserId,
			String preserveUserId, String assetInUserId, String purchaseItemId,
			String assetParentId, String cardId, Integer stockState,
			Integer isInAccount, String modeAndType, Integer useState,
			String assetName, String purcharseDeptId, Date stocktime,
			String financeNum, String assetNum, String manufacturer,
			String supplier, Date inStockDate, String unit, Integer num,
			String remarks, float price, Integer labelIsPrint,
			String oneDimensionalCode, String twoDimensionalCode, String barCode) {
		this.assetSortId = assetSortId;
		this.deptId = deptId;
		this.userUserId = userUserId;
		this.preserveUserId = preserveUserId;
		this.assetInUserId = assetInUserId;
		this.purchaseItemId = purchaseItemId;
		this.assetParentId = assetParentId;
		this.cardId = cardId;
		this.stockState = stockState;
		this.isInAccount = isInAccount;
		this.modeAndType = modeAndType;
		this.useState = useState;
		this.assetName = assetName;
		this.purcharseDeptId = purcharseDeptId;
		this.stocktime = stocktime;
		this.financeNum = financeNum;
		this.assetNum = assetNum;
		this.manufacturer = manufacturer;
		this.supplier = supplier;
		this.inStockDate = inStockDate;
		this.unit = unit;
		this.num = num;
		this.remarks = remarks;
		this.price = price;
		this.labelIsPrint = labelIsPrint;
		this.oneDimensionalCode = oneDimensionalCode;
		this.twoDimensionalCode = twoDimensionalCode;
		this.barCode = barCode;
	}

	// Property accessors
	@Id
	@GeneratedValue(generator="assetUUID")
	@GenericGenerator(name="assetUUID", strategy="uuid")
	public String getAssetId() {
		return this.assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	@Column(name = "assetSortId", length = 50)
	public String getAssetSortId() {
		return this.assetSortId;
	}

	public void setAssetSortId(String assetSortId) {
		this.assetSortId = assetSortId;
	}

	@Column(name = "deptId", length = 50)
	public String getDeptId() {
		return this.deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	@Column(name = "userUserId", length = 50)
	public String getUserUserId() {
		return this.userUserId;
	}

	public void setUserUserId(String userUserId) {
		this.userUserId = userUserId;
	}

	@Column(name = "preserveUserId", length = 50)
	public String getPreserveUserId() {
		return this.preserveUserId;
	}

	public void setPreserveUserId(String preserveUserId) {
		this.preserveUserId = preserveUserId;
	}

	@Column(name = "assetInUserId", length = 50)
	public String getAssetInUserId() {
		return this.assetInUserId;
	}

	public void setAssetInUserId(String assetInUserId) {
		this.assetInUserId = assetInUserId;
	}

	@Column(name = "purchaseItemId", length = 50)
	public String getPurchaseItemId() {
		return this.purchaseItemId;
	}

	public void setPurchaseItemId(String purchaseItemId) {
		this.purchaseItemId = purchaseItemId;
	}

	@Column(name = "assetParentId", length = 50)
	public String getAssetParentId() {
		return this.assetParentId;
	}

	public void setAssetParentId(String assetParentId) {
		this.assetParentId = assetParentId;
	}

	@Column(name = "cardId", length = 50)
	public String getCardId() {
		return this.cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	@Column(name = "stockState")
	public Integer getStockState() {
		return this.stockState;
	}

	public void setStockState(Integer stockState) {
		this.stockState = stockState;
	}

	@Column(name = "isInAccount")
	public Integer getIsInAccount() {
		return this.isInAccount;
	}

	public void setIsInAccount(Integer isInAccount) {
		this.isInAccount = isInAccount;
	}

	@Column(name = "modeAndType", length = 100)
	public String getModeAndType() {
		return this.modeAndType;
	}

	public void setModeAndType(String modeAndType) {
		this.modeAndType = modeAndType;
	}

	@Column(name = "useState")
	public Integer getUseState() {
		return this.useState;
	}

	public void setUseState(Integer useState) {
		this.useState = useState;
	}

	@Column(name = "assetName", length = 500)
	public String getAssetName() {
		return this.assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	@Column(name = "purcharseDeptId", length = 50)
	public String getPurcharseDeptId() {
		return this.purcharseDeptId;
	}

	public void setPurcharseDeptId(String purcharseDeptId) {
		this.purcharseDeptId = purcharseDeptId;
	}

	@Column(name = "stocktime", length = 19)
	public Date getStocktime() {
		return this.stocktime;
	}

	public void setStocktime(Date stocktime) {
		this.stocktime = stocktime;
	}

	@Column(name = "financeNum", length = 100)
	public String getFinanceNum() {
		return this.financeNum;
	}

	public void setFinanceNum(String financeNum) {
		this.financeNum = financeNum;
	}

	@Column(name = "assetNum", length = 100)
	public String getAssetNum() {
		return this.assetNum;
	}

	public void setAssetNum(String assetNum) {
		this.assetNum = assetNum;
	}

	@Column(name = "manufacturer", length = 50)
	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Column(name = "supplier", length = 50)
	public String getSupplier() {
		return this.supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	@Column(name = "inStockDate", length = 19)
	public Date getInStockDate() {
		return this.inStockDate;
	}

	public void setInStockDate(Date inStockDate) {
		this.inStockDate = inStockDate;
	}

	@Column(name = "unit", length = 10)
	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Column(name = "num")
	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	@Column(name = "remarks", length = 500)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "price", precision = 12, scale = 0)
	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Column(name = "labelIsPrint")
	public Integer getLabelIsPrint() {
		return this.labelIsPrint;
	}

	public void setLabelIsPrint(Integer labelIsPrint) {
		this.labelIsPrint = labelIsPrint;
	}

	@Column(name = "oneDimensionalCode", length = 200)
	public String getOneDimensionalCode() {
		return this.oneDimensionalCode;
	}

	public void setOneDimensionalCode(String oneDimensionalCode) {
		this.oneDimensionalCode = oneDimensionalCode;
	}

	@Column(name = "twoDimensionalCode", length = 200)
	public String getTwoDimensionalCode() {
		return this.twoDimensionalCode;
	}

	public void setTwoDimensionalCode(String twoDimensionalCode) {
		this.twoDimensionalCode = twoDimensionalCode;
	}

	@Column(name = "barCode", length = 100)
	public String getBarCode() {
		return this.barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

}