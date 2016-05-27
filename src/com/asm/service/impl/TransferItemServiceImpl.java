package com.asm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asm.dao.TransferItemDao;
import com.asm.domain.TransferItem;
import com.asm.service.TransferItemService;
import com.asm.util.PageBean;

@Transactional(readOnly = false)
@Service("transferItemService")
public class TransferItemServiceImpl implements TransferItemService {
	
	@Autowired
	private TransferItemDao transferItemDao;
	
	@Override
	public TransferItem getTransferItemById(String transferItemId) {
		return transferItemDao.getTransferItemById(transferItemId);
	}

	@Override
	public void saveTransferItem(TransferItem transferItem) {
		transferItemDao.save(transferItem);
	}

	@Override
	public void updateTransferItem(TransferItem transferItem) {
		transferItemDao.update(transferItem);
	}

	@Override
	public boolean delTransferItem(TransferItem transferItem) {
		return transferItemDao.delTransferItem(transferItem);
	}

	@Override
	public PageBean queryForPage(int pageSize, int page) {
		final String hql = "from TransferItem t order by t.transfer.transferId asc"; // 查询语句
		int allRow = transferItemDao.getAllRowCount(hql); // 总记录数
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
		List<TransferItem> list = transferItemDao.queryForPage(hql, offset, length); //得到在分页内的数据
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

}
