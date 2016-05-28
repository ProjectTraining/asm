package com.asm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asm.dao.AssetDao;
import com.asm.dao.AssetPickDao;
import com.asm.domain.Asset;
import com.asm.domain.AssetPick;
import com.asm.domain.Dept;
import com.asm.service.AssetPickService;
import com.asm.util.PageBean;
/**
 * @description 资产领用归还
 * @Author: 赵楠（作者）
 * @Version: V1.00 （版本号）
 * @Create Date: 2016-5-12 （创建日期）
 */
@Transactional(readOnly=false)
@Service("AssetPickService")
public class AssetPickServiceImpl implements AssetPickService{
	@Autowired
	private AssetPickDao assetPickdao;
	@Autowired
	private AssetDao assetDao;
	@Override
	public void regAssetPick(AssetPick assetPick) {
		System.out.println("开始保存资产领用"+assetPick.getAssetPickId());
		assetPickdao.save(assetPick);
	}
	/**   
	 * 分页查询  ，查询assetpick数据库中的方法     
	 * @param pageSize  每页显示多少记录   
	 * @param currentPage 当前页   
	 * @return 封装了分页信息的bean   
	 */    
	public PageBean queryForPage(final String hql,int pageSize, int page) {
		//final String hql = "select aa.assetName,aa.stocktime,aa.num from AssetPick a,Asset aa order by aa.stocktime asc"; // 查询语句
		int allRow = assetPickdao.getAllRowCount(hql); // 总记录数
		int totalPage = PageBean.countTatalPage(pageSize, allRow); // 总页数
		System.out.println("总页数："+totalPage);
		// 有可能因为我们归还了资产，但是 当前页大于totalPage，这样就有问题了，
		while(page>totalPage){
			page--;
		}
		if(page<=0){
			page=1;
		}
		final int offset = PageBean.countOffset(pageSize, page); // 当前页开始记录
		final int currentPage = PageBean.countCurrentPage(page); // 当前页
		int length = 0; // 每页记录数
		if(currentPage==totalPage){
			length=allRow-(currentPage-1)*pageSize;
		}else {
			length=pageSize;
		}
		List<AssetPick> list = assetPickdao.queryForPage(hql, offset, length); //得到在分页内的数据
		// 把分页信息保存到Bean当中
		PageBean<AssetPick> pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}
	/**
	 * 查询资产类（asset）的方法
	 * hql：查询数据库
	 * pagesize:页面大小
	 * page：当前页
	 */
	public PageBean queryForAsset(final String hql,int pageSize, int page) {
		int allRow = assetDao.getAllRowCount(hql); // 总记录数
		int totalPage = PageBean.countTatalPage(pageSize, allRow); // 总页数
		System.out.println("总页数："+totalPage);
		// 有可能因为我们资产被删除了，但是 当前页大于totalPage，这样就有问题了，
		while(page>totalPage){
			page--;
		}
		if(page<=0){
			page=1;
		}
		final int offset = PageBean.countOffset(pageSize, page); // 当前页开始记录
		final int currentPage = PageBean.countCurrentPage(page); // 当前页
		int length = 0;              // 每页记录数
		if(currentPage==totalPage){
			length=allRow-(currentPage-1)*pageSize;
		}else {
			length=pageSize;
		}
		List<Asset> list = assetDao.findAll(hql);
		List<Asset> list1=new ArrayList<Asset>();
		if (list.size() != 0) {
			for (int i = 0; i < offset + length && i <= list.size(); i++) {
				if (i >= offset) {
					list1.add(list.get(i));
				}
			}
		}
		System.out.println("这一页的记录是："+list1.size());
		//List<Asset> list = assetPickdao.queryForPage(hql, offset, length); //得到在分页内的数据
		// 把分页信息保存到Bean当中
		PageBean<Asset> pageBeanAsset = new PageBean();
		pageBeanAsset.setPageSize(pageSize);
		pageBeanAsset.setCurrentPage(currentPage);
		pageBeanAsset.setAllRow(allRow);
		pageBeanAsset.setTotalPage(totalPage);
		pageBeanAsset.setList(list1);
		pageBeanAsset.init();
		return pageBeanAsset;
	}
	public List<Integer> queryForNum(String hql){
		List<Integer> list=assetPickdao.getNumbyAssetId(hql);
		return list;
	}
	public List<AssetPick> OperateAssetPick(String hql){
		
		return null;
	}
	/**
	 * 更新数据库
	 * @param assetPick
	 */
	public void updateAssetPick(AssetPick assetPick){
		assetPickdao.updateAssetPick(assetPick);
	}
	@Override
	public AssetPick findById(String id) {
		if(id==null){
			System.out.println("传进来的id为空");
			
		}
		return this.assetPickdao.findObjectByID(id);
	}
	public AssetPickDao getAssetPickdao() {
		return assetPickdao;
	}
	public void setAssetPickdao(AssetPickDao assetPickdao) {
		this.assetPickdao = assetPickdao;
	}
	public AssetDao getAssetDao() {
		return assetDao;
	}
	public void setAssetDao(AssetDao assetDao) {
		this.assetDao = assetDao;
	}

	

}
