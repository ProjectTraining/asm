package com.asm.service;

import java.util.List;

import com.asm.domain.AssetPick;
import com.asm.util.PageBean;
import com.sun.org.apache.xpath.internal.operations.Bool;
/**
 * @description 资产领用归还
 * @Author: 赵楠（作者）
 * @Version: V1.00 （版本号）
 * @Create Date: 2016-5-12 （创建日期）
 */
public interface AssetPickService {
	public void regAssetPick(AssetPick assetPick);
	/**   
	 * 分页查询     
	 * @param pageSize  每页显示多少记录   
	 * @param currentPage 当前页   
	 * @return 封装了分页信息的bean   
	 */    
	public PageBean<AssetPick> queryForPage(String hql,int pageSize,int page); 
	/**   
	 * 分页查询     
	 * @param pageSize  每页显示多少记录   
	 * @param currentPage 当前页   
	 * @return 封装了分页信息的bean,主要是Asset   
	 */ 
	public PageBean queryForAsset(final String hql,int pageSize, int page);
	/**
	 * 根据hql语句来获取数据的数目
	 * @param hql
	 * @return 
	 * @return
	 */
	public List<Integer> queryForNum(String hql);
	/**
	 * 操作AssetPick数据库数据，因为有输入的hql语句，所以这个函数可以用来更新和查询
	 * @return
	 */
	public List<AssetPick> OperateAssetPick(String hql);
	/**
	 * 更新AssetPick数据库数据
	 * @param assetPick
	 */
	public void updateAssetPick(AssetPick assetPick);
	/**
	 * 通过id去寻找 
	 * @param id
	 * @return
	 */
	public AssetPick findById(String id);
}
