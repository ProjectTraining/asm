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
	<script src="assets/js/jquery.min.js"></script>
	<div id="addparameter">
	<script type="text/javascript">
		function jumpAdd(){
			window.location = "asm/parameterAction_addParameter.action?timestamp="
						+ new Date().getTime();
		}
	</script>
	<button id="bAdd" onclick="jumpAdd()">添加新参数</button>
	</div>
	<div id="showList">
		<script type="text/javascript">
			$("#showList").load(
					"asm/parameterAction_showList.action?timestamp="
							+ new Date().getTime());
		</script>
	</div>
	<br>
</body>
</html>
