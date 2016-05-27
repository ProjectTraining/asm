package com.asm.dao;

import java.util.List;

import com.asm.domain.Transfer;

public interface TransferDao {
	public abstract Transfer getTransferById(String transferId);
	public abstract void save(Transfer transfer);
	public abstract void update(Transfer transfer);
	public abstract boolean delTransfer(Transfer transfer);
	public abstract List<Transfer> queryForPage(final String hql,final int offset,final int length);
	public abstract int getAllRowCount(String hql);
}
