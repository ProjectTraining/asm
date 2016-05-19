package com.asm.service;

import java.util.Date;
import java.util.List;

import com.asm.domain.PurchaseOrder;
import com.asm.domain.User;

public interface PurchaseOrderService {

	public abstract List<PurchaseOrder> listPurchaseOrder(String deptId,Date dateBegin,Date dateEnd);

	public abstract void savePurchaseOrder(PurchaseOrder purchaseOrder);

	public abstract boolean remove(String purchaseOrderId);

	public abstract PurchaseOrder findPurchaseOrder(String purchaseOrderId);

	public abstract boolean updatePurchaseOrder(PurchaseOrder purchaseOrder);

}