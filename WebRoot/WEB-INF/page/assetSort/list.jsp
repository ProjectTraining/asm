<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>list.jsp</title>
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
			<th>删除</th>
			<th>更新</th>
		</tr>
    	<c:forEach items="${assetList}" var="assetSort" varStatus="vs">  
        	<tr> 
             <td align = "center">${assetSort.assetCode}</td>  
             <td align = "center">${assetSort.assetName}</td>  
             <td align = "center">${assetSort.parentId}</td>  
             <td align = "center">${assetSort.parentName}</td>
             <td align="center">
             	<a href="assetSortAction_delSort.action?assetId=${assetSort.assetId}"
						onclick="return del()">删除</a></td>
			<td align="center"><a
						href="deptAction_updateUser.action?dept.deptId=%{#dept.deptId}">更新</a></td>
             <br>
         	</tr>  
		</c:forEach>   
	</table>
  </body>
</html>
