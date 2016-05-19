package com.asm.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.asm.domain.Dept;
import com.asm.service.DeptService;
import com.asm.util.PageBean;
import com.asm.util.ResponseUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.net.httpserver.Authenticator.Success;

import javassist.compiler.ast.StringL;

@SuppressWarnings("serial")
@Controller("deptAction")
@Scope("prototype")  // 来保证每一个请求有一个单独的Action来处理，避免struts中Action的线程安全问题
public class DeptAction extends ActionSupport implements SessionAware, ModelDriven<Dept> {
	/**
	 * @description 部门action
     * @Author: 赵楠（作者）
     * @Version: V1.00 （版本号）
     * @Create Date: 2016-4-12 （创建日期）
	 */
	private static final long serialVersionUID = 1L;
	private Dept dept = new Dept();
	@Autowired
	private DeptService deptService;
	private Map<String, Object> session;

	private PageBean pageBean; //封装了分页信息和数据内容的pageBean    
	private List<Dept> request;//用于储存pageBean当中被封装的User信息    
	private int page = 1; //表示从网页中返回的当前页的值  默认为1 表示默认显示第一页内容  
	
	
	@Override
	public Dept getModel() {
		return dept;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String home() {
		try {
			System.out.println("部门按钮正确");
			System.out.println("dept:"+dept.getDeptName());
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	/**
	 * 点击增加的按钮的时候，跳转到其他页面。
	 * @return
	 */
	public String AddDept() {
		try {
			System.out.println("跳转到增加部门页面");
			return "add";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	/**
	 * 添加一个部门
	 * @return
	 * @throws Exception 
	 */
	public String RegisterDept() throws Exception {
		boolean flag = true;
		try {
			System.out.println("---" + dept.getDeptId() + "---" + dept.getDeptName());
			deptService.regDept(dept);
			ResponseUtil.write1(flag);
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
			ResponseUtil.write1(flag);
			return ERROR;
		}
		return SUCCESS;
	}

	public String ListData() {
		System.out.println("读取数据库中的数据反映到列表中");
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("list",this.deptService.findAllUsers());
		return "list";
	}
	/**
	 * 分页的操作，这里主要是针对分页的一些处理
	 * @return
	 * @throws Exception
	 */
	public String Pageforweb()throws Exception{    
		this.pageBean = deptService.queryForPage(5, page);//获取封装了分页信息和数据的pageBean    
		this.request = this.pageBean.getList(); //获取数据   
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("list",this.request);
		return SUCCESS;    
		} 
	public String Remove() throws Exception {
		System.out.println("删除ID是--"+dept.getDeptId());
		System.out.println("删除部门是--"+dept.getDeptName());
		//boolean flag = false;
		String flag=null;
		if (deptService.delete(dept)) {
			flag = Pageforweb();    //  调用ListData()函数来使得数据库的数据显示到页面中
			//ResponseUtil.write1(flag);// 输出标识符到页面上
		} else {
			//ResponseUtil.write1(flag);
		}
		return flag;
	}
	public String DeptInfo(){
		System.out.println("部门ID是："+dept.getDeptId());
		dept=deptService.findDeptById(dept.getDeptId());
		return "edit";
	}
	/**
	 * 修改的部门并保存
	 * @return
	 * @throws Exception
	 */
	public String editDept() throws Exception {
		boolean flag = true;
		try {
			System.out.println("编辑ID是--"+dept.getDeptId());
			System.out.println("编辑name是--"+dept.getDeptName());
			deptService.update(dept);
			ResponseUtil.write1(flag);
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
			ResponseUtil.write1(flag);
		}
		return SUCCESS;
	}
	public String CheckDeptname() throws Exception {
		boolean flag = false;
		if (deptService.checkDeptExistByName(dept.getDeptName())) {
			flag = true;
			ResponseUtil.write1(flag);
		} else {
			ResponseUtil.write1(flag);
		}
		return null;
	}
	
	public DeptService getDeptService() {
		return deptService;
	}

	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public List<Dept> getRequest() {
		return request;
	}

	public void setRequest(List<Dept> request) {
		this.request = request;
	}
}
