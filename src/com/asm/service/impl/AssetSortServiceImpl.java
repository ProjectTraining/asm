package com.asm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asm.dao.AssetSortDao;
import com.asm.dao.deptDao;
import com.asm.domain.AssetSort;
import com.asm.domain.Dept;
import com.asm.service.AssetSortService;
import com.asm.util.PageBean;
//@Transactional(readOnly=true)
@Service("assetSortService")
public class AssetSortServiceImpl implements AssetSortService{
	@Autowired
	private AssetSortDao assetdao;
	@Override
	public List<AssetSort> findList() {
		// TODO Auto-generated method stub
		return this.assetdao.findList();
	}

	@Override
	public boolean addSort(AssetSort tasset) {
		// TODO Auto-generated method stub
		return assetdao.addSort(tasset);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public boolean delSort(AssetSort assetSort) {
		// TODO Auto-generated method stub
		return this.assetdao.delSort(assetSort);
	}

	@Override
	public boolean updateSort(AssetSort assetSort) {
		// TODO Auto-generated method stub
		return this.assetdao.updateSort(assetSort);
	}

	@Override
	public AssetSort findSort(String assetSortId) {
		// TODO Auto-generated method stub
		return this.assetdao.findSort(assetSortId);
	}
	/**   
	 * 分页查询     
	 * @param pageSize  每页显示多少记录   
	 * @param currentPage 当前页   
	 * @return 封装了分页信息的bean   
	 */  
	@Override
	public PageBean SplitPage(int pageSize, int page) {
		// TODO Auto-generated method stub
		final String hql = "from AssetSort a order by a.assetSortId asc"; // 查询语句
		int allRow = assetdao.getAllRowCount(hql); // 总记录数
		System.out.println("111111111");
		System.out.println(allRow);
		int totalPage = PageBean.countTatalPage(pageSize, allRow); // 总页数
		System.out.println("总共页数："+totalPage);
		final int offset = PageBean.countOffset(pageSize, page); // 当前页开始记录
		final int currentPage = PageBean.countCurrentPage(page); // 当前页
		int length = 0; // 每页记录数
		if(currentPage==totalPage){
			length=allRow-(currentPage-1)*pageSize;
		}else {
			length=pageSize;
		}
		List<AssetSort> list = assetdao.queryForPage(hql, offset, length); //得到在分页内的数据
		// 把分页信息保存到Bean当中
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setAssetSortList(list);
		pageBean.init();
		return pageBean;
	}

	@Override
	public List<AssetSort> findSortByName(String assetSortName) {
		// TODO Auto-generated method stub
		return this.assetdao.findSortByName(assetSortName);
	}

}
