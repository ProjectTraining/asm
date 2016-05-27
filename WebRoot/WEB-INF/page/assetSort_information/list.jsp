<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
	<tr><td colspan="6" align="center">
    <form name="form" method="post" action="assetSortAction_findByName.action">
	<button>
		<a style="text-decoration:none" href="assetSortAction_addPage.action">添加资产类型</a>
	</button> &nbsp;&nbsp;<input type="text" placeholder="请输入资产名" name="assetSortName" id="assetSortName"size="40"/>
	<input type="submit" tabindex="3"   value="按照资产名查找"/>
	</form>
	
	</td></tr>
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
					onclick="return del()">删除</a> <a
					href="assetSortAction_updatePage.action?assetSort.assetSortId=${assetSort.assetSortId}">修改</a>
				</td>
				<br>
			</tr>

		</c:forEach>

		<s:iterator value="pageBean">    
        <tr>    
         <td colspan="6" align="center" >    
         共<s:property value="allRow"/>条记录        
         共<s:property value="totalPage"/>页        
         当前第<s:property value="currentPage"/>页<br />    
         <s:if test="%{currentPage == 1}">    
           第一页  上一页    
         </s:if>    
         <!-- currentPage为当前页 -->    
         <s:else>    
           <a href="assetSortAction_home.action?page=1">第一页</a>    
           <a href="assetSortAction_home.action?page=<s:property value="%{currentPage-1}"/>">上一页</a>    
         </s:else>    
         <s:if test="%{currentPage != totalPage}">    
         <a href="assetSortAction_home.action?page=<s:property value="%{currentPage+1}"/>">下一页</a>    
         <a href="assetSortAction_home.action?page=<s:property value="totalPage"/>">最后一页</a>    
         </s:if>    
         <s:else>    
         下一页  最后一页    
         </s:else>    
         </td>    
        </tr>    
    </s:iterator>
    
	</table>
	

</body>
</html>
