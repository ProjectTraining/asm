<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
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
	<div class="am-g">
		<div class="am-u-sm-11">
			<table border="1" width="100%" align="center"
				class="am-table am-table-bd am-table-striped admin-content-table">
				<tr>
					<td colspan="6" align="center">
						<form name="form" method="post"
							action="assetSortAction_findByName.action">
							<button>
								<a style="text-decoration:none"
									href="assetSortAction_addPage.action">添加资产类型</a>
							</button>
							&nbsp;&nbsp;<input type="text" placeholder="请输入资产名"
								name="assetSortName" id="assetSortName" size="40" /> <input
								type="submit" tabindex="3" value="按资产名查找" />
						</form></td>
				</tr>
				<tr>
					<th>资产调出部门</th>
					<th>调出部门负责人</th>
					<th>资产调出时间</th>
					<th>资产接收部门</th>
					<th>接收部门负责人</th>
					<th>接收资产名</th>
					<th>资产接收时间</th>
					<th>资产调拨理由</th>
				</tr>
				<c:forEach items="${allocateList}" var="allocate" varStatus="vs">
					<tr>
						<td align="center">${allocate.deptOut}</td>
						<td align="center">${allocate.userOut}</td>
						<td align="center">${allocate.outDate}</td>
						<td align="center">${allocate.deptAccept}</td>
						<td align="center">${allocate.userAccept}</td>
						<td align="center">${allocate.asset}</td>
						<td align="center">${allocate.inConfirmDate}</td>
						<td align="center">${allocate.outReason}</td>
						
						<br>
					</tr>

				</c:forEach>

				<s:iterator value="pageBean">
					<tr>
						<td colspan="6" align="center">共<s:property value="allRow" />条记录
							共<s:property value="totalPage" />页 当前第<s:property
								value="currentPage" />页<br /> <s:if test="%{currentPage == 1}">    
           第一页  上一页    
         </s:if> <!-- currentPage为当前页 --> <s:else>
								<a href="assetSortAction_home.action?page=1">第一页</a>
								<a
									href="assetSortAction_home.action?page=<s:property value="%{currentPage-1}"/>">上一页</a>
							</s:else> <s:if test="%{currentPage != totalPage}">
								<a
									href="assetSortAction_home.action?page=<s:property value="%{currentPage+1}"/>">下一页</a>
								<a
									href="assetSortAction_home.action?page=<s:property value="totalPage"/>">最后一页</a>
							</s:if> <s:else>    
         下一页  最后一页    
         </s:else></td>
					</tr>
				</s:iterator>

			</table>
		</div>
	</div>

</body>
</html>
