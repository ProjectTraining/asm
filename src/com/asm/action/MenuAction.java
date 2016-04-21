package com.asm.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**  
* @description:菜单action
* @Author: 张毓峰（作者）
* @Version: V1.00 （版本号）
* @Create Date: 2016-4-8 （创建日期）
*/
@Controller("menuAction")
@Scope("prototype")
public class MenuAction{
	
	public String menuHead() {
		return "menuhead";
	}
	public String menuLeft(){
		return "manageleft";
	}
	public String menuInfo(){
		return "manageinfo";
	}
	
	public String loginPage(){
		return "login";
	}
	
	
}
