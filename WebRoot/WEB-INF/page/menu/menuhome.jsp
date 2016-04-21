<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<TITLE>管理员中心</TITLE>



<SCRIPT type="text/javascript">
</SCRIPT>
</HEAD>

<FRAMESET border=1 frameSpacing=0 rows=50,* frameBorder=1 id="mainparent" >
<FRAME name=topFrame src="menuAction_menuHead.action" noResize scrolling=no/>
<FRAMESET name="main" border=1  frameSpacing=0 frameBorder=1 cols=259,*>
<FRAME name="leftFrame" src="menuAction_menuLeft.action" noResize scrolling=no  border=1/>
<FRAME name="mainFrame" src="menuAction_menuInfo.action" />
</FRAMESET>
</FRAMESET>


</HTML>
