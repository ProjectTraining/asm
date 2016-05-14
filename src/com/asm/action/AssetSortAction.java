package com.asm.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.asm.domain.AssetSort;
import com.asm.service.AssetSortService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @description:资产类别action
 * @Author: 郑成斌（作者）
 * @Version: V1.02 （版本号）
 * @Create Date: 2016-5-12 （创建日期）
 */
@SuppressWarnings("serial")
@Controller("assetSortAction")
@Scope("prototype")
public class AssetSortAction extends ActionSupport implements ModelDriven<AssetSort> {
	@Autowired
	private AssetSortService assetService;

	private List<AssetSort> assetSortList;
	private AssetSort assetSort = new AssetSort();
	private String assetSortId;
	private String assetSortCode;
	private String assetSortName;
	private String parentId;
	private String parentName;
	
	public String home() {
		assetSortList = this.assetService.findList();
		return "list";
	}
	public String addPage(){
		return "add";
	}
	public String addSort() {
		boolean a = assetService.addSort(assetSort);
		if(a){
			assetSortList = this.assetService.findList();
			return "list";
		}else{
			return "error";
		}
	}
	public String delSort(){
		System.out.println(assetSort.getAssetSortId());
		boolean a=this.assetService.delSort(assetSort);
		System.out.println(a);
		if(a){
			assetSortList = this.assetService.findList();
			return "list";
		}else{
			return "error";
		}
	}
	public String updatePage() {
		assetSort = this.assetService.findSort(assetSort.getAssetSortId());
		return "update";
	}
	public String updateSort(){
		System.out.println(assetSort.getAssetSortId()+" "+assetSort.getAssetSortCode());
		boolean a=this.assetService.updateSort(assetSort);
		if(a){
			assetSortList = this.assetService.findList();
			return "list";
		}else{
			return "error";
		}
		
	}

	public String getAssetSortId() {
		return assetSortId;
	}

	public void setAssetSortId(String assetSortId) {
		this.assetSortId = assetSortId;
	}

	public String getAssetSortCode() {
		return assetSortCode;
	}

	public void setAssetSortCode(String assetSortCode) {
		this.assetSortCode = assetSortCode;
	}

	public String getAssetSortName() {
		return assetSortName;
	}

	public void setAssetSortName(String assetSortName) {
		this.assetSortName = assetSortName;
	}

	public AssetSortService getAssetService() {
		return assetService;
	}

	public void setAssetService(AssetSortService assetService) {
		this.assetService = assetService;
	}

	

	

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	@Override
	public AssetSort getModel() {
		// TODO Auto-generated method stub
		return assetSort;
	}

	public List<AssetSort> getAssetSortList() {
		return assetSortList;
	}

	public void setAssetSortList(List<AssetSort> assetSortList) {
		this.assetSortList = assetSortList;
	}

	public AssetSort getAssetSort() {
		return assetSort;
	}

	public void setAssetSort(AssetSort assetSort) {
		this.assetSort = assetSort;
	}
	
	
	
}
