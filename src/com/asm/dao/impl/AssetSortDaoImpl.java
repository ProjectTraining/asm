package com.asm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.asm.dao.AssetSortDao;

import com.asm.domain.AssetSort;
import com.asm.domain.Dept;
import com.asm.domain.User;

@Repository("assetSortDao")
public class AssetSortDaoImpl extends CommonDaoImpl<AssetSort> implements
		AssetSortDao {

	@Override
	public boolean addSort(AssetSort asset) {
		// TODO Auto-generated method stub
		save(asset);
		return true;
	}

	@Override
	public boolean delSort(AssetSort assetSort) {
		// TODO Auto-generated method stub
		this.deleteObjectByIds(assetSort.getAssetSortId());
		return true;

	}
	@Override
	public AssetSort findSort(String assetSortId){
		return findObjectByID(assetSortId);
	}

	@Override
	public List<AssetSort> findList() {
		// TODO Auto-generated method stub
		String hql = "from AssetSort t ";
		List<AssetSort> list = (List<AssetSort>) find(hql, null);
		return list;
	}

	@Override
	public boolean updateSort(AssetSort assetSort) {
		// TODO Auto-generated method stub
		this.update(assetSort);
		return true;
	}
	
	/**   
	 * 分页查询   
	 * @param hql  查询条件   
	 * @param offset  开始记录   
	 * @param length  一次查询几条记录   
	 * @return 查询的记录集合   
	 */    
	@SuppressWarnings("unchecked")
	public List<AssetSort> queryForPage(final String hql, final int offset, final int length) {
		List<AssetSort> list = findList();
		List<AssetSort> list1=new ArrayList<AssetSort>();
		for(int i=0;i<offset+length;i++){
			if(i>=offset){
				list1.add(list.get(i));
			}
		}
		System.out.println("这一页的记录是："+list1.size());
		return list1;
	}
	/**
	 * 查询所有的记录数
	 * 
	 * @param hql
	 *            查询条件
	 * @return 总记录数
	 */
	public int getAllRowCount(String hql) {
		return this.getHibernateTemplate().find(hql).size();
	}

	@Override
	public List<AssetSort> findSortByName(String assetSortName) {
		// TODO Auto-generated method stub
		final String hql = "from AssetSort a where a.assetSortName=?";
		List<AssetSort> list=(List<AssetSort>)find(hql, new String[]{assetSortName});
		if(list.size()>0){
			return list;
		}else{
			return null;
		}
	}

}
