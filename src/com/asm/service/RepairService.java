package com.asm.service;

import java.util.Date;
import java.util.List;

import com.asm.domain.AssetSort;
import com.asm.domain.Repair;
import com.asm.domain.User;

public interface RepairService {

	public abstract List<Repair> listRepair(String assettName,String purchaseId);

	public abstract void saveRepair(Repair repair);

	public abstract boolean remove(String repairId);

	public abstract Repair findRepair(String repairId);

	public abstract boolean updateRepair(Repair repair);
	
	public abstract List<AssetSort> findAssertSortList();

}