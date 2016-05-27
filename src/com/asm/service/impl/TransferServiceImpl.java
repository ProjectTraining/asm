package com.asm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asm.dao.TransferDao;
import com.asm.domain.Transfer;
import com.asm.domain.User;
import com.asm.service.TransferService;
import com.asm.util.PageBean;

@Transactional(readOnly = false)
@Service("transferService")
public class TransferServiceImpl implements TransferService {
	
	@Autowired
	private TransferDao transferDao;
	
	@Override
	public Transfer getTransferById(String transferId) {
		return transferDao.getTransferById(transferId);
	}

	@Override
	public void saveTransfer(Transfer transfer) {
		transferDao.save(transfer);
	}

	@Override
	public void updateTransfer(Transfer transfer) {
		transferDao.update(transfer);
	}

	@Override
	public boolean delTransfer(Transfer transfer) {
		return transferDao.delTransfer(transfer);
	}

	@Override
	public PageBean queryForPage(int pageSize, int page) {
		final String hql = "from Transfer t order by t.transferUser.userId asc"; // 查询语句
		int allRow = transferDao.getAllRowCount(hql); // 总记录数
		int totalPage = PageBean.countTatalPage(pageSize, allRow); // 总页数
		System.out.println("总共记录数："+totalPage);
		final int offset = PageBean.countOffset(pageSize, page); // 当前页开始记录
		final int currentPage = PageBean.countCurrentPage(page); // 当前页
		int length = 0; // 每页记录数
		if(currentPage==totalPage){
			length=allRow-(currentPage-1)*pageSize;
		}else {
			length=pageSize;
		}
		List<Transfer> list = transferDao.queryForPage(hql, offset, length); //得到在分页内的数据
		// 把分页信息保存到Bean当中
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}

	@Override
	public List<Transfer> listTransfer(String transferId,String transferUserId,String receiverUserId,String state) {
		String hqlWhere = "";
		List<Object> paramsList = new ArrayList<Object>();
		if(null!=transferId && !"".equals(transferId)){
				hqlWhere += " and o.transferId = ? ";
				paramsList.add(transferId);
		}
		if(null!=transferUserId && !"".equals(transferUserId)){
			hqlWhere += " and o.transferUserId = ? ";
			paramsList.add(transferUserId);
		}
		if(null!=receiverUserId && !"".equals(receiverUserId)){
			hqlWhere += " and o.receiverUserId = ? ";
			paramsList.add(receiverUserId);
		}
		if(null!=state && !"".equals(state)){
			hqlWhere += " and o.state =?";

			System.out.println("ffff"+state);
			paramsList.add(Integer.parseInt(state));
		}
		Object [] params = paramsList.toArray();
		List<Transfer> list = transferDao.findCollectionByConditionNopage(
				hqlWhere, params, null);
		return list;
	}

}
