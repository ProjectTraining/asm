
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'list.jsp' starting page</title>
<script type="text/javascript">  
            function del(){  
                if(confirm("Are you sure?")){  
                    return true;  
                }  
                return false;  
            }  
        </script>
</head>

<body>
	<h1>
		<font color="red">Users List</font>
	</h1>
	<table border="1" width="80%" align="center">
		<tr>
			<th>部门编号</th>
			<th>部门名称</th>
			<th>删除</th>
			<th>更新</th>
		</tr>

		<s:iterator value="#request.list" id="dept">
			<tr>
				<td><s:property value="#dept.deptId" /></td>
				<td><s:property value="#us.deptName" /></td>
				<td align="center"><s:a
						href="deptAction_deleteUser.action?dept.deptId=%{#dept.deptId}"
						onclick="return del()">删除</s:a></td>
				<td align="center"><s:a
						href="deptAction_updateUser.action?dept.deptId=%{#dept.deptId}">更新</s:a></td>
			</tr>
		</s:iterator>
	</table>

</body>
</html>
