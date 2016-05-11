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
           <%--  <s:textfield name="dept.deptId" label="部门号："></s:textfield> --%>  
            <s:password name="dept.deptName" label="部门名称："></s:password>  
            <s:submit value="增加部门"></s:submit> 
        </s:form>  
        
        <s:a href="deptAction_ListData.action">查看所有的数据库数据</s:a> 
        
    </body>  
    </html>  