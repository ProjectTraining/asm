<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加商品入库</title>
    
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
     <form name="form1" method="post" action="assertAction_addSort.action" >
     	<ul class="name_items">
			<li><label for="user">资产名：</label> 
			<input type="text" placeholder="请输入资产名" 
			name="assetName"  id="assetName" size="40"
				class="admin_input_style"  /></li>
			<li><label for="pwd">资产编号：</label> 
			<input type="text" placeholder="请输入资产编号"
				name="assetCode"  id="assetCode"  size="40"
				class="admin_input_style"  /></li>
			<li><label for="user">上级资产名：</label> 
			<input type="text" placeholder="请输入上级资产名" 
			name="parentName"  id="parentName" size="40"
				class="admin_input_style"  /></li>
			<li><label for="pwd">上级资产编号：</label> 
			<input type="text" placeholder="请输入上级资产编号"
				name="parentId"  id="parentId"  size="40"
				class="admin_input_style"  /></li>
				<li><input type="submit" tabindex="3"  value="添加资产"
			class="btn btn-primary" /></li>
		</ul>

     </form>
  </body>
</html>
