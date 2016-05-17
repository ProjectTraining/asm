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
@Table(name="t_stockTaking")

public class StockTaking  implements java.io.Serializable {




     private String stockTakingId;
     private User user;
     private Date stockTakingDate;
     private Integer state;


   

    @Id
 	@GeneratedValue(generator="stockTakingUUID")
 	@GenericGenerator(name="stockTakingUUID", strategy="uuid")

    public String getStockTakingId() {
        return this.stockTakingId;
    }
    
    public void setStockTakingId(String stockTakingId) {
        this.stockTakingId = stockTakingId;
    }
    

    @Column(name="stockTakingDate", length=19)

    public Date getStockTakingDate() {
        return this.stockTakingDate;
    }
    
    public void setStockTakingDate(Date stockTakingDate) {
        this.stockTakingDate = stockTakingDate;
    }
    
    @Column(name="state")

    public Integer getState() {
        return this.state;
    }
    
    public void setState(Integer state) {
        this.state = state;
    }

    
    @ManyToOne(cascade=CascadeType.REFRESH,optional=true)  
    @JoinColumn(name = "stockTakingUserId",referencedColumnName="userId") 
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}