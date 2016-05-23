<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>My JSP 'parameteroperate.jsp' starting page</title>

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
	<form name="form1" method="post" action="parameterAction_updateParameter.action">
		<input name="parameterId" id="parameterId" type="hidden" value="${parameter.parameterId}">
		<label style="font-size:15px">参数名:</label>
		<input name="parameterName" id="parameterName" value="${parameter.parameterName}"><br>
		<label style="font-size:15px">参数值:</label>
		<input name="parameterValue" id="parameterValue"  value="${parameter.parameterValue}"><br>
		<label style="font-size:15px">组编号:</label>
		<input name="groupId" id="groupId" value="${parameter.groupId}"><br>
		<label style="font-size:15px">组名称:</label>
		<input name="groupName" id="groupName" value="${parameter.groupName}"><br>
		<br> 
		<input type="submit" value="确认">
	</form>
</body>
</html>
