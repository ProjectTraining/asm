package com.asm.service;

import java.util.Date;
import java.util.List;

import com.asm.domain.StockTaking;


public interface StockTakingService {

	public abstract List<StockTaking> listStockTaking(String deptId,Date dateBegin,Date dateEnd);

	public abstract void saveStockTaking(StockTaking stockTaking);

	public abstract boolean remove(String stockTakingId);

	public abstract StockTaking findStockTaking(String stockTakingId);

	public abstract boolean updateStockTaking(StockTaking stockTaking);

}