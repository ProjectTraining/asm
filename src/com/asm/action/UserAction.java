package com.asm.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.asm.domain.Dept;
import com.asm.domain.User;
import com.asm.service.DeptService;
import com.asm.service.UserService;
import com.asm.util.MD5;
import com.asm.util.ResponseUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


/**  
* @description:用户action
* @Author: 张毓峰（作者）
* @Version: V1.00 （版本号）
* @Create Date: 2016-4-8 （创建日期）
*/
@SuppressWarnings("serial")
@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements SessionAware,ModelDriven<User> {

	private User user=new User();
	@Autowired
	private UserService userService;
	@Autowired
	private DeptService	deptService;
	private Map<String, Object> session;
	private List<User> userList;
	private List<Dept> deptList;
	private String number;
	private JSONObject rows;
	private String stateStr;
	HashMap<String, String> deptMap = new HashMap<String, String>();
	

	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getStateStr() {
		return stateStr;
	}
	public void setStateStr(String stateStr) {
		this.stateStr = stateStr;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public List<Dept> getDeptList() {
		return deptList;
	}

	@Override 
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	public JSONObject getRows() {
		return rows;
	}

	public void setRows(JSONObject rows) {
		this.rows = rows;
	}
	
	public String loginPage() {
		User user=(User) session.get("user");
		if(null!=user){
			return "home";
		}
		return "login";
	}
	
	public String CheckNumber() throws Exception {
		boolean flag = false;
		String number=(String) session.get("CHECK_NUMBER_KEY");
		System.out.println(number);
		HttpServletRequest request = ServletActionContext.getRequest();
		String num=request.getParameter("number");
		System.out.println(num);
		if (number!=null&&number.equals(num)) {
			flag = true;
			ResponseUtil.write1(flag);
		} else {
			ResponseUtil.write1(flag);
		}
		return null;
	}
	
	
	
	public String login() {

		if(user.getUserName()==null||user.getPassword()==null){
			return "login";
		}
		user=userService.checkUserExist(user.getUserName(), MD5.getMD5(user.getPassword().getBytes()));
		if(user==null){
			return "login";
		}
		session.put("user", user);
		System.out.println(user.getUserName()+user.getPassword());
		return "home";
	}
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public String homePage(){
		deptList =deptService.findAllUsers();
		System.out.println("deptsize"+deptList.size());
		return "userlistpage";
	}
	public String addPage(){
		deptList=deptService.findAllUsers();
		System.out.println("deptsize"+deptList.size());
		return "addpage";
	}
	public String CheckUsername() throws Exception {
		boolean flag = false;
		if (userService.checkUserExistByName(user.getUserName())) {
			flag = true;
			ResponseUtil.write1(flag);
		} else {
			ResponseUtil.write1(flag);
		}
		return null;
	}
	public String register() throws Exception{
		System.out.println("sdaf"+user.getUserName());
		boolean flag = true;
		try {
			userService.saveUser(user);
			ResponseUtil.write1(flag);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			flag = false;
			e.printStackTrace();
			ResponseUtil.write1(flag);
		}
		return null;
	}
	private void getDataMap(){
		deptList=deptService.findAllUsers();
		for (Dept  dept: deptList) {
			deptMap.put(dept.getDeptId(), dept.getDeptName());
		}
	
	}
	public String listUser() {
		getDataMap();
		System.out.println(user.getUserName());
		System.out.println(user.getDeptId());
		System.out.println(user.getRoleId());
		System.out.println(stateStr);
		userList = userService.listUser(user.getUserName(),user.getDeptId(),user.getRoleId(),stateStr);
		HashMap<String, Object> maps = new HashMap<String, Object>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		for (User  user: userList) {
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("userId", user.getUserId());
			hashMap.put("userName", user.getUserName());
			hashMap.put("deptName", deptMap.get(user.getDeptId()));
			hashMap.put("roleName", user.getUserName());
			hashMap.put("state", user.getState());
			hashMap.put("sex", user.getSex());
			list.add(hashMap);
		}
		maps.put("Rows", list);
		maps.put("total", list.size());
		System.out.println(maps.size());
		rows = JSONObject.parseObject(JSON.toJSONString(maps));
		System.out.println(rows.toJSONString());
		return "userlist";
	}
	public String remove() throws Exception {

		System.out.println(user.getUserId());
		boolean flag = false;
		if (userService.remove(user.getUserId())) {
			flag = true;
			ResponseUtil.write1(flag);
		} else {
			ResponseUtil.write1(flag);
		}
		return null;
	}
	public String listInfo(){
		deptList =deptService.findAllUsers();
		user=userService.findUser(user.getUserId());
		
		return "listuserinfo";
	}
	public String editUser() throws Exception {
		boolean flag = true;
		try {
			System.out.println(user.getUserId());
			userService.updateUser(user);
			ResponseUtil.write1(flag);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			flag = false;
			e.printStackTrace();
			ResponseUtil.write1(flag);
		}
		return null;
	}
	
	public String checkUser() throws Exception {
		boolean flag = false;
		if (userService.checkUserExist(user.getUserName(), MD5.getMD5(user.getPassword().getBytes()))!=null){
			flag = true;
			ResponseUtil.write1(flag);
		} else {
			ResponseUtil.write1(flag);
		}
		return null;
	}
}
