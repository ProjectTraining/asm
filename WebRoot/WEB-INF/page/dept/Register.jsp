    <%@ page language="java" contentType="text/html; charset=UTF-8"  
        pageEncoding="UTF-8"%>  
    <%@ taglib prefix="s" uri="/struts-tags"%>  
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
    <html>  
    <head>  
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
    <title>User Register Page</title>  
    </head>  
    <body>  
      
        <s:form action="deptAction_Register"  namespace="/" >  
           <%-- 密码的状态栏  <s:password name="dept.deptId" label="部门号："></s:password> --%>  
            <s:textfield name="dept.deptName" label="部门名称：" ></s:textfield>  
            <s:submit value="增加部门"></s:submit> 
        </s:form>  
        
        <s:a href="deptAction_ListData.action">查看所有的数据库数据</s:a> 
         <s:a href="deptAction_Test.action">测试按钮</s:a> 
    </body>  
    </html>  