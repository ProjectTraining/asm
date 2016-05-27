package com.asm.dao.impl;


import org.springframework.stereotype.Repository;

import com.asm.dao.PurchaseItemDao;
import com.asm.dao.RepairDao;
import com.asm.dao.impl.RepairDaoImpl;
import com.asm.domain.PurchaseItem;
import com.asm.domain.Repair;




@Repository("repairDao")
public class RepairDaoImpl extends CommonDaoImpl<Repair> implements RepairDao {



	
}
