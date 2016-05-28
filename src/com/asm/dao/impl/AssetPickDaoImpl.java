package com.asm.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.asm.dao.AssetPickDao;
import com.asm.domain.AssetPick;
/**
 * @description 资产领用归还
 * @Author: 赵楠（作者）
 * @Version: V1.00 （版本号）
 * @Create Date: 2016-5-12 （创建日期）
 */
@Repository("AssetPick")
public class AssetPickDaoImpl extends CommonDaoImpl<AssetPick> implements AssetPickDao{
	public void save(AssetPick assetPick) {
		System.out.println("资产领用--"+assetPick.getAssetPickId());
		this.getHibernateTemplate().save(assetPick);
	}
	/**   
	 * 分页查询   
	 * @param hql  查询条件   
	 * @param offset  开始记录   
	 * @param length  一次查询几条记录   
	 * @return 查询的记录集合   
	 */    
	@SuppressWarnings("unchecked")
	public List<AssetPick> queryForPage(final String hql, final int offset, final int length) {
		List<AssetPick> list = findAll(hql);
		List<AssetPick> list1=new ArrayList<AssetPick>();
		if(list.size()==0){
			return list;
		}
		for(int i=0;i<offset+length&&i<=list.size();i++){
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
	
	@SuppressWarnings("unchecked")
	public List<AssetPick> findAll(String hql) {
	//	String hql = "from AssetPick d order by d.assetPickId asc";
		List<AssetPick> list = (List<AssetPick>) this.getHibernateTemplate().find(hql);
		return list;
	}
	/**
	 * 根据AssetId得到每个资产被领用的数目
	 * @return 每一个资产领用的数目
	 */
	@Override
	public List<Integer> getNumbyAssetId(String hql){
		List<Integer> list=( List<Integer>)this.getHibernateTemplate().find(hql);
		return list;
	}
	/**
	 * 更新AssetPick数据库的操作
	 */
	public void updateAssetPick(AssetPick assetPick){
		this.getHibernateTemplate().update(assetPick);
	}
	/**
	 * 对数据库的操作
	 */
	public List<AssetPick> OperateAssetPick(String hql){
		if(hql.contains("update")){
		}
		return null;
	}

	
	
}
