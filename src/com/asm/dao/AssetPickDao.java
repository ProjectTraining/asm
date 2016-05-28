package com.asm.dao;

import java.util.List;

import com.asm.domain.AssetPick;
import com.asm.domain.Dept;
/**
 * @description 资产领用归还
 * @Author: 赵楠（作者）
 * @Version: V1.00 （版本号）
 * @Create Date: 2016-5-12 （创建日期）
 */
public interface AssetPickDao extends CommonDao<AssetPick>{
	public abstract void save(AssetPick assetPick);
	/**   
	 * 分页查询   
	 * @param hql  查询条件   
	 * @param offset  开始记录   
	 * @param length  一次查询几条记录   
	 * @return 查询的记录集合   
	 */    
	public List<AssetPick> queryForPage(final String hql,final int offset,final int length);
	
	/**   
	 * 查询所有的记录数   
	 * @param hql 查询条件   
	 * @return 总记录数   
	 */    
	public int getAllRowCount(String hql);
	/**
	 * 根据AssetId得到每个资产被领用的数目
	 * @return 每一个资产领用的数目
	 */
	public List<Integer> getNumbyAssetId(String hql);
	/**
	 * 跟新AssetPick数据库操作
	 * @param assetPick
	 */
	public void updateAssetPick(AssetPick assetPick);
	/**
	 * 对数据库的操作
	 * @param hql
	 * @return
	 */
	public List<AssetPick> OperateAssetPick(String hql);
}
