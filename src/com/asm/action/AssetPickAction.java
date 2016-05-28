package com.asm.action;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.asm.domain.Asset;
import com.asm.domain.AssetPick;
import com.asm.domain.User;
import com.asm.service.AssetPickService;
import com.asm.service.AssetService;
import com.asm.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @description 资产领用和归还action
 * @Author: 赵楠（作者）
 * @Version: V1.00 （版本号）
 * @Create Date: 2016-5-12 （创建日期）
 */

@SuppressWarnings("serial")
@Controller("AssetPickAction")
@Scope("prototype")  // 来保证每一个请求有一个单独的Action来处理，避免struts中Action的线程安全问题
public class AssetPickAction  extends ActionSupport implements SessionAware, ModelDriven<AssetPick>{
	private AssetPick assetPick=new AssetPick();
	@Autowired
	private AssetPickService assetPickService;
	@Autowired
	private AssetService assetService;
	private Map<String, Object> session;
	private PageBean pageBean; //封装了分页信息和数据内容的pageBean    
	private PageBean pageBeanAsset;//封装了分页信息和数据内容的pageBean  
	private List<Object> request;//用于储存pageBean当中被封装的User信息   
	private int Assetpage = 1; //表示从网页中返回的当前页的值  默认为1 表示默认显示第一页内容  
	private int page = 1;      //表示从网页中返回的当前页的值  默认为1 表示默认显示第一页内容 
	private String assetId;    // 资产ID ，是用来根据ID来查询用的。
	private String assetname;
	/**
	 * home方法，调用两个list方法
	 * @return
	 */
	public String Home() {
		try {
			System.out.println("资产领用归还");
			String asset=ListforAssetandPage();
			String assetpick=ListforAssetPickandPage();
			if(asset=="success"&&assetpick=="success"){
			    return "OK";
			}else {
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	/**
	 * 通过关键词来找资产记录
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@SuppressWarnings("unchecked")
	public String FindAssetByName() throws UnsupportedEncodingException{
		if(assetname==null){
			return SUCCESS;
		}
		String title= new String(assetname.getBytes("iso-8859-1"),"UTF-8") ; 
	    System.out.println(title);
		System.out.println("搜索的关键词---"+title);
		final String hql = "from Asset a where a.assetName like '%"+title+"%' order by a.stocktime desc"; // 查询语句  select  a.assetName,a.stocktime,a.num
		System.out.println("hql语句--"+hql);
		System.out.println("当前页是--"+Assetpage);
		this.pageBeanAsset = assetPickService.queryForAsset(hql,5,Assetpage);//获取封装了分页信息和数据的pageBean    
		this.request = this.pageBeanAsset.getList();       //获取数据   
		System.out.println("此处没有问题");
		Map<String, List<Object>> request = (Map<String, List<Object>>) ActionContext.getContext().get("request");  // 获取项目中的HttpServletRequest对象
		request.put("list",this.request);                               //  对list标签赋值，传值过去。
		ListforAssetPickandPage();
		return SUCCESS; 
	}
	/**
	 * 对当前用户已经领用的资产进行查询
	 * @return
	 */
	public String FindAssetPickByName(){
		   String title;
		   User user=(User) session.get("user");
			if(assetname==null){
				return SUCCESS;
			}
		try {
			title = new String(assetname.getBytes("iso-8859-1"), "UTF-8");  //  将传进来的assetname转义一下，防止乱码
			System.out.println(title);
			System.out.println("搜索的关键词---" + title);
			final String hql = "from AssetPick a where a.pickUserId="+user.getUserId()+" and a.asset.assetName like '%" + title + "%' order by a.pickDate desc"; // 查询语句
			System.out.println("hql语句--" + hql);
			System.out.println("当前页是--" + page);
			this.pageBean = assetPickService.queryForPage(hql,5,page);//获取封装了分页信息和数据的pageBean    
			this.request = this.pageBean.getList(); //获取数据   
			Map request = (Map) ActionContext.getContext().get("request");
			request.put("listAssetPick",this.request);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		ListforAssetandPage();                   //  对list标签赋值，传值过去。
		return SUCCESS;
	}
	/**
	 * 申请领用
	 * @return 
	 * @throws ParseException 
	 */
	public String  AssetApply() throws ParseException {
		//System.out.println("这条记录的id"+assetPick.getAssetPickId());
		User user=(User) session.get("user");   // 得到了当前的用户，就知道了是谁要领用资产
		assetPick.setPickUserId(user.getUserId());
		assetPick.setState(1);
		//  当前时间存进PickDate中，后台设置领用时间
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		Date currentTime_2 = formatter.parse(dateString);
		assetPick.setPickDate(currentTime_2);
		// 打印一些情况
		System.out.println("这个是当前时间--"+currentTime_2.toString());// new Date()为获取当前系统时间
		System.out.println("资产ID---"+assetId);
		Asset asset=assetService.findAsset(assetId);   //这一步成功了
		assetPick.setAsset(asset);     
		System.out.println("资产名称---"+asset.getAssetName());
		System.out.println("当前用户--"+assetPick.getPickUserId());
		System.out.println("当前时间--"+assetPick.getPickDate());
		System.out.println("当前状态--"+assetPick.getState());
		System.out.println("当前主键id--"+assetPick.getAssetPickId());
		assetPickService.regAssetPick(assetPick);
		Home();
		return SUCCESS;
	}
	/**
	 * 分页的操作，这里主要是针对分页的一些处理,对资产分页
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String ListforAssetandPage(){    
		final String hql = "from Asset a order by a.stocktime desc"; // 查询语句  select  a.assetName,a.stocktime,a.num
		System.out.println("资产当前页是--"+Assetpage);
		this.pageBeanAsset = assetPickService.queryForAsset(hql,5,Assetpage);//获取封装了分页信息和数据的pageBean    
		this.request = this.pageBeanAsset.getList(); //获取数据   
		Map<String, List<Object>> request = (Map<String, List<Object>>) ActionContext.getContext().get("request");  // 获取项目中的HttpServletRequest对象
		request.put("list",this.request);                               //  对list标签赋值，传值过去。
		return SUCCESS;    
	} 
	/**
	 * 将当前用户的所有领用记录显示到页面
	 * @return
	 */
	public String ListforAssetPickandPage(){
		User user=(User) session.get("user");   // 得到了当前的用户，就知道了是谁要领用资产select assetPickId,assettId,pickDate 
		final String hql = "from AssetPick a where a.state=1 and a.pickUserId="+user.getUserId()+" order by a.pickDate desc"; // 查询语句  select  a.assetName,a.stocktime,a.num
		System.out.println("领用资产当前hql语句是--"+hql);
		System.out.println("领用资产当前页是--"+page);
		this.pageBean = assetPickService.queryForPage(hql,5,page);//获取封装了分页信息和数据的pageBean    
		this.request = this.pageBean.getList(); //获取数据   
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("listAssetPick",this.request);
		//final String hql1="select count(*) as getnum from AssetPick a,Asset aa where a.assetId=aa.assetId GROUP BY aa.assetId order by aa.stocktime asc";
		// List<Integer> list=assetPickService.queryForNum(hql1);
		return SUCCESS;
	}
	/**
	 * 归还资产
	 * @return
	 * @throws ParseException 
	 */
	public String PageforAssetReturn() throws ParseException{
		System.out.println(" AssetPick 的id---"+assetPick.getAssetPickId());
		String hql="update AssetPick a set a.state=0 where a.assetPickId="+assetPick.getAssetPickId();
		//assetPickService.OperateAssetPick(hql);
		//assetPickService.updateAssetPick(assetPick);
		assetPick=assetPickService.findById(assetPick.getAssetPickId());
		User user=(User) session.get("user");   // 得到了当前的用户，就知道了是谁要归还资产
		assetPick.setReturnUserId(user.getUserId());
		assetPick.setState(0);                 //  将状态设置为0
		// 设置归还资产时间
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		Date currentTime_2 = formatter.parse(dateString);
		assetPick.setReturnDate(currentTime_2);    //  设置归还时间
		assetPickService.updateAssetPick(assetPick);
		Home();
		return SUCCESS;
	}
	public AssetPick getAssetPick() {
		return assetPick;
	}
	public void setAssetPick(AssetPick assetPick) {
		this.assetPick = assetPick;
	}
	public AssetPickService getAssetPickService() {
		return assetPickService;
	}
	public void setAssetPickService(AssetPickService assetPickService) {
		this.assetPickService = assetPickService;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public PageBean getPageBeanAsset() {
		return pageBeanAsset;
	}
	public void setPageBeanAsset(PageBean pageBeanAsset) {
		this.pageBeanAsset = pageBeanAsset;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public PageBean getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	public int getAssetpage() {
		return Assetpage;
	}
	public void setAssetpage(int assetpage) {
		Assetpage = assetpage;
	}
	public AssetService getAssetService() {
		return assetService;
	}
	public void setAssetService(AssetService assetService) {
		this.assetService = assetService;
	}
	public String getAssetId() {
		return assetId;
	}
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}
	@Override
	public AssetPick getModel() {
		return assetPick;
	}
	public String getAssetname() {
		return assetname;
	}
	public void setAssetname(String assetname) {
		this.assetname = assetname;
	}
}
