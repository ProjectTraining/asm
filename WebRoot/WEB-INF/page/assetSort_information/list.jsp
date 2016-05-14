<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>assetSort list page</title>
<script type="text/javascript">  
            function del(){  
                if(confirm("Are you sure?")){  
                    return true;  
                }  
                return false;  
            }  
    </script>
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
	<table border="1" width="80%" align="center">
		<tr>
			<th>资产类型编号</th>
			<th>资产类型名称</th>
			<th>上级资产类型编号</th>
			<th>上级资产类型名称</th>
			<th>可执行操作</th>

		</tr>
		<c:forEach items="${assetSortList}" var="assetSort" varStatus="vs">
			<tr>
				<td align="center">${assetSort.assetSortCode}</td>
				<td align="center">${assetSort.assetSortName}</td>
				<td align="center">${assetSort.parentId}</td>
				<td align="center">${assetSort.parentName}</td>
				<td align="center"><a
					href="assetSortAction_delSort.action?assetSort.assetSortId=${assetSort.assetSortId}"
					onclick="return del()">删除</a> 
					<a href="assetSortAction_updatePage.action?assetSort.assetSortId=${assetSort.assetSortId}">修改</a>
				</td>
				<br>
			</tr>

		</c:forEach>
	
	</table>
	<button >
		<a style="text-decoration:none" href="assetSortAction_addPage.action">添加资产种类</a>
	</button>
	
</body>
</html>
