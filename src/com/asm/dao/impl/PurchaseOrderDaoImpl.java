package com.asm.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.asm.dao.PurchaseOrderDao;
import com.asm.dao.UserDao;
import com.asm.dao.impl.PurchaseOrderDaoImpl;
import com.asm.domain.PurchaseOrder;
import com.asm.domain.User;




@Repository("purchaseOrderDao")
public class PurchaseOrderDaoImpl extends CommonDaoImpl<PurchaseOrder> implements PurchaseOrderDao {



	
}
