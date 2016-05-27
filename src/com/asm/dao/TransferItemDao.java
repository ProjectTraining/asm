package com.asm.dao;

import java.util.List;

import com.asm.domain.TransferItem;

public interface TransferItemDao {
	public abstract TransferItem getTransferItemById(String transferItemId);
	public abstract void save(TransferItem transferItem);
	public abstract void update(TransferItem transferItem);
	public abstract boolean delTransferItem(TransferItem transferItem);
	public abstract List<TransferItem> queryForPage(final String hql,final int offset,final int length);
	public abstract int getAllRowCount(String hql);
}
