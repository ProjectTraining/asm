<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
  <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
  <title>资产管理后台主页</title>
  <meta name="description" content="这是一个 index 页面" />
  <meta name="keywords" content="index" />
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
  <meta name="renderer" content="webkit" />
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="assets/i/favicon.png" />
  <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png" />
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="assets/css/admin.css" />
</head>
<body>
	<div class="am-g">
		<div class="am-u-sm-12">
			<table
				class="am-table am-table-bd am-table-striped admin-content-table">
				<thead>
					<tr>
						<th>部门编号</th>
						<th>部门名称</th>
					</tr>
				</thead>
				<tbody>
				<s:iterator value="#request.list" id="dept">
					<tr>
						<td> <s:property value="#dept.deptId"/> </td>
						<td> <s:property value="#dept.deptName"/> </td>
						<td>
							<div class="am-dropdown" data-am-dropdown >
								<button
									class="am-btn am-btn-default am-btn-xs am-dropdown-toggle"
									data-am-dropdown-toggle >
									<span class="am-icon-cog"></span> <span
										class="am-icon-caret-down"></span>
								</button>
								<ul class="am-dropdown-content">
									<li><a href="#">1. 编辑</a></li>
									<li><a href="#">2. 保存</a></li>
									<li><a href="#">3. 删除</a></li>
								</ul>
							</div>
						</td>
					</tr>
				</s:iterator>
                </tbody>
			</table>
		</div>
	</div>
</body>
</html>