package com.asm.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.asm.dao.TransferDao;
import com.asm.domain.Parameter;
import com.asm.domain.Transfer;

@Repository("transferDao")
public class TransferDaoImpl extends CommonDaoImpl<Transfer> implements
		TransferDao{

	@Override
	public Transfer getTransferById(String transferId) {
		String hql = "from Transfer t where t.transferId=?";
		List<Transfer> list = (List<Transfer>) find(hql,
				new String[] { transferId });
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}

	@Override
	public boolean delTransfer(Transfer transfer) {
		List<Transfer> tlist = new ArrayList<Transfer>();
		tlist.add(transfer);
		this.deleteObjectByCollection(tlist);
		return true;
	}
	
	public List<Transfer> findAll() {
		String hql = "from Transfer t order by t.transferUser.userId asc";
		@SuppressWarnings("unchecked")
		List<Transfer> list = (List<Transfer>) this.getHibernateTemplate().find(hql);
		return list;
	}

	@Override
	public List<Transfer> queryForPage(String hql, int offset, int length) {
		List<Transfer> list = findAll();
		if(list.size() <= 0){
			return null;
		}
		List<Transfer> list1=new ArrayList<Transfer>();
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
