package com.asm.service;

import java.util.List;

import com.asm.domain.TransferItem;
import com.asm.util.PageBean;

public interface TransferItemService {
	public abstract TransferItem getTransferItemById(String transferItemId);
	public abstract void saveTransferItem(TransferItem transferItem);
	public abstract void updateTransferItem(TransferItem transferItem);
	public abstract boolean delTransferItem(TransferItem transferItem);
	public abstract PageBean queryForPage(int pageSize,int page);
}
