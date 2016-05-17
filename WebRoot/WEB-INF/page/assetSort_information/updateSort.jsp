<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateSort.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
     <form name="form1" method="post" action="assetSortAction_updateSort.action?assetSort.assetSortId=${assetSort.assetSortId}" >
     	<ul class="name_items">
     	<li><label for="pwd">资产编号：</label> 
			<input type="text" value="${assetSort.assetSortCode}"
				name="assetSortCode"  id="assetSortCode"  size="40"
				  /></li>
			<li><label for="user">资产名：</label> 
			<input type="text" value="${assetSort.assetSortName}" 
			name="assetSortName"  id="assetSortName" size="40"
				 /></li>
			<li><label for="pwd">上级资产编号：</label> 
			<input type="text" value="${assetSort.parentId}"
				name="parentId"  id="parentId"  size="40"
				  /></li>
			<li><label for="user">上级资产名：</label> 
			<input type="text" value="${assetSort.parentName}"
			name="parentName"  id="parentName" size="40"
				 /></li>
			
				<li><input type="submit" tabindex="3"  value="修改资产类型"
			 /></li>
		</ul>

     </form>
    
  </body>
</html>
