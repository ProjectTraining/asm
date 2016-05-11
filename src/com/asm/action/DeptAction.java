package com.asm.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.asm.domain.Dept;
import com.asm.service.DeptService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import javassist.compiler.ast.StringL;

@Controller("deptAction")
@Scope("prototype")
public class DeptAction extends ActionSupport implements SessionAware, ModelDriven<Dept> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Dept dept = new Dept();
	@Autowired
	private DeptService deptService;
	private Map<String, Object> session;

	@Override
	public Dept getModel() {
		return null;
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
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("list",this.deptService.findAllUsers());
		return "list";
	}

	public DeptService getDeptService() {
		return deptService;
	}

	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
}
