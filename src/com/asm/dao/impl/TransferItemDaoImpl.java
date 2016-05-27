package com.asm.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.asm.dao.TransferDao;
import com.asm.dao.TransferItemDao;
import com.asm.domain.Parameter;
import com.asm.domain.Transfer;
import com.asm.domain.TransferItem;

@Repository("transferItemDao")
public class TransferItemDaoImpl extends CommonDaoImpl<TransferItem> implements
		TransferItemDao{

	@Override
	public TransferItem getTransferItemById(String transferItemId) {
		String hql = "from TransferItem t where t.transferItemId=?";
		List<TransferItem> list = (List<TransferItem>) find(hql,
				new String[] { transferItemId });
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}

	@Override
	public boolean delTransferItem(TransferItem transferItem) {
		List<TransferItem> tlist = new ArrayList<TransferItem>();
		tlist.add(transferItem);
		this.deleteObjectByCollection(tlist);
		return true;
	}
	
	public List<TransferItem> findAll() {
		String hql = "from TransferItem t order by t.transfer.transferId asc";
		@SuppressWarnings("unchecked")
		List<TransferItem> list = (List<TransferItem>) this.getHibernateTemplate().find(hql);
		return list;
	}

	@Override
	public List<TransferItem> queryForPage(String hql, int offset, int length) {
		List<TransferItem> list = findAll();
		if(list.size() <= 0){
			return null;
		}
		List<TransferItem> list1=new ArrayList<TransferItem>();
		for(int i=0;i<offset+length;i++){
			if(i>=offset){
				list1.add(list.get(i));
			}
		}
		System.out.println("这一页的记录是："+list1.size());
		return list1;
	}

	@Override
	public int getAllRowCount(String hql) {
		return this.getHibernateTemplate().find(hql).size();
	}

}
