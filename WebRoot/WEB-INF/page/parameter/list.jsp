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

<title>parameter list page</title>
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
			<th>参数名称</th>
			<th>参数值</th>
			<th>参数组别编号</th>
			<th>参数组别名称</th>

		</tr>
		<c:forEach items="${parameterList}" var="parameter" varStatus="vs">
			<tr>
				<td align="center">${parameter.parameterName}</td>
				<td align="center">${parameter.parameterValue}</td>
				<td align="center">${parameter.groupId}</td>
				<td align="center">${parameter.groupName}</td>
				<td align="center"><a
					href="assetSortAction_delSort.action?assetSort.assetSortId=${assetSort.assetSortId}"
					onclick="return del()">删除</a> 
					<a href="assetSortAction_updatePage.action?assetSort.assetSortId=${assetSort.assetSortId}">修改</a>
				</td>
				<br>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>
