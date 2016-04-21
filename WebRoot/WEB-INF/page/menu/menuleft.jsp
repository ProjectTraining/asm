<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>资产管理后台主页</title>
  <meta name="description" content="这是一个 index 页面">
  <meta name="keywords" content="index">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="assets/css/admin.css">
</head>
<body>
<div class="am-cf admin-main">
  <!-- sidebar start -->
  <div class="admin-sidebar">
    <ul class="am-list admin-sidebar-list">
      <li><a href="#" target="mainFrame"><span class="am-icon-home"></span> 首页</a></li>
      <li class="admin-parent">
        <a class="#" data-am-collapse="{target: '#collapse-nav'}" target="mainFrame"><span class="am-icon-file"></span> 资产管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
          <li><a href="#" class="am-cf" target="mainFrame"><span class="am-icon-check"></span> 验收登记<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
        </ul>
      </li>
      <li><a href="#" target="mainFrame"><span class="am-icon-table"></span>统计报表</a></li>
       <li class="admin-parent">
        <a class="am-cf" data-am-collapse="{target: '#collapse-sys'}"><span class="am-icon-file"></span> 页面模块 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-sys">
          <li><a href="roleAction_home.action" class="am-cf" target="mainFrame"><span class="am-icon-check"></span> 角色管理<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
          <li><a href="deptAction_home.action" target="mainFrame"><span class="am-icon-puzzle-piece"></span> 部门管理</a></li>
          <li><a href="assertAction_home.action" target="mainFrame"><span class="am-icon-th"></span> 资产类别管理<span class="am-badge am-badge-secondary am-margin-right am-fr">24</span></a></li>
          <li><a href="parameterAction_sortHome.action" target="mainFrame"><span class="am-icon-calendar"></span> 参数类型配置</a></li>
          <li><a href="parameterAction_infoHome.action" target="mainFrame"><span class="am-icon-bug"></span> 参数信息配置</a></li>
        </ul>
      </li>
      <li><a href="userAction_manageHomePage.action" target="mainFrame"><span class="am-icon-pencil-square-o"></span> 用户管理</a></li>
      <li><a href="#" target="mainFrame"><span class="am-icon-sign-out"></span> 注销</a></li>
    </ul>

    
  </div>
 </div>

<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/amazeui.min.js"></script>
<!--<![endif]-->
<script src="assets/js/app.js"></script>


</body>
</html>