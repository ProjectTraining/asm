package com.asm.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.asm.domain.Dept;
import com.asm.service.DeptService;
import com.asm.util.ResponseUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
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
			return "register";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String Register() {
		try {
			System.out.println("---" + dept.getDeptId() + "---" + dept.getDeptName());
			deptService.regDept(dept);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String ListData() {
		System.out.println("LIST+++++");
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("list",this.deptService.findAllUsers());
		return "list";
	}
	public String Remove() throws Exception {
		System.out.println("删除ID是--"+dept.getDeptId());
		System.out.println("删除部门是--"+dept.getDeptName());
		//boolean flag = false;
		String flag=null;
		if (deptService.delete(dept)) {
			flag = ListData();    //  调用ListData()函数来使得数据库的数据显示到页面中
			//ResponseUtil.write1(flag);
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
			// TODO Auto-generated catch block
			flag = false;
			e.printStackTrace();
			ResponseUtil.write1(flag);
		}
		return null;
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

	public String Test() {
		return "ceshi";
	}
	
	
	public DeptService getDeptService() {
		return deptService;
	}

	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
}
