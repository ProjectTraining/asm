<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>parameter list page</title>
	<script type="text/javascript">  
            function del(){  
                if(confirm("确定删除?")){
                	window.location.reload(); 
                    return true;  
                }  
                return false;  
            }  
    </script>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="description" content="这是一个 index 页面" />
<meta name="keywords" content="index" />
<meta name="viewport"
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" />
<meta name="renderer" content="webkit" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="assets/i/favicon.png" />
<link rel="apple-touch-icon-precomposed"
	href="assets/i/app-icon72x72@2x.png" />
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="assets/css/amazeui.min.css" />
<link rel="stylesheet" href="assets/css/admin.css" />
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<div id="addparameter">
	<script type="text/javascript">
		function jumpAdd(){
			window.location = "asm/parameterAction_addParameter.action?timestamp="
						+ new Date().getTime();
		}
	</script>
	<button id="bAdd" onclick="jumpAdd()">添加新参数</button>
	</div>
	<div class="am-g">
		<div class="am-u-sm-11">
			<table
				class="am-table am-table-bd am-table-striped admin-content-table">
				<tr>
					<th>参数名称</th>
					<th>参数值</th>
					<th>参数组别编号</th>
					<th>参数组别名称</th>
					<th>操作</th>
				</tr>

				<s:iterator value="%{parameterList}" id="parameter">
					<tr>
						<td><s:property value="#parameter.parameterName" />
						</td>
						<td><s:property value="#parameter.parameterValue" />
						</td>
						<td><s:property value="#parameter.groupId" />
						</td>
						<td><s:property value="#parameter.groupName" />
						</td>
						<td align="center"><s:a
								href="parameterAction_delParameter.action?parameter.parameterId=%{#parameter.parameterId}"
								onclick="return del()">删除</s:a> <s:a
								href="parameterAction_putPageParameter.action?parameter.parameterId=%{#parameter.parameterId}"
								onclick="update()">更新</s:a></td>
					</tr>
				</s:iterator>
			</table>
		</div>
	</div>
	<div class="am-u-sm-12">
		<s:iterator value="pageBean">
			<tr>
				<td colspan="6" align="center" bgcolor="#5BA8DE">共<s:property
						value="allRow" />条记录 共<s:property value="totalPage" />页 当前第<s:property
						value="currentPage" />页<br /> <s:if test="%{currentPage == 1}">    
						           第一页  上一页    
						         </s:if> <!-- currentPage为当前页 --> <s:else>
						<a href="parameterAction_Pageforweb.action?page=1">第一页</a>
						<a
							href="parameterAction_Pageforweb.action?page=<s:property value="%{currentPage-1}"/>">上一页</a>
					</s:else> <s:if test="%{currentPage != totalPage}">
						<a
							href="parameterAction_Pageforweb.action?page=<s:property value="%{currentPage+1}"/>">下一页</a>
						<a
							href="parameterAction_Pageforweb.action?page=<s:property value="totalPage"/>">最后一页</a>
					</s:if> <s:else>    
						         下一页  最后一页    
						         </s:else></td>
			</tr>
		</s:iterator>
	</div>
</body>
</html>
