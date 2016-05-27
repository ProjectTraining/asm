package com.asm.service;

import java.util.List;

import com.asm.domain.Transfer;
import com.asm.util.PageBean;

public interface TransferService {
	public abstract Transfer getTransferById(String transferId);
	public abstract void saveTransfer(Transfer transfer);
	public abstract void updateTransfer(Transfer transfer);
	public abstract boolean delTransfer(Transfer transfer);
	public abstract PageBean queryForPage(int pageSize,int page);
	public abstract List<Transfer> listTransfer(String transferId,String transferUserId,String receiverUserId,String state);
}
