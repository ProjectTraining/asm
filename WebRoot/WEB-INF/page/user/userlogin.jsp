<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>管理员登陆</title>
<link href="css/admin_login.css" rel="stylesheet" type="text/css" />
<script src="script/jquery-1.9.1.min.js" type="text/javascript"></script>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
.tips{
			color: rgba(0, 0, 0, 0.5);
			padding-left: 10px;
		}
		.tips_true,.tips_false{
			padding-left: 10px;
		}
		.tips_true{
			color: green;
		}
		.tips_false{
			color: red;
		}
</style>
</head>
<script type="text/javascript" language="javascript">
function loadImage(){
	  	document.getElementById("randImage").src = "<%=request.getContextPath()%>/image.jsp?"+Math.random(); //Math.random()方法非常重要，它使每次的请求都不同以便重新发送。如果每次的请求都一样，那么不会重新生成页面
     }
	 var booluserName=false;
 var boolpassWord=false;
 var boolnumber=false;
  function checkNumber(){
      var number=$("#number").val();
	  // 验证码是否正确
		$.ajax({
			cache: false,
			async: false,
			type: "POST",
		dataType: "json",
			data: {number: number},
			url: "userAction_CheckNumber.action",
		success: function(flag) {
				if(flag) {
					divnumber.innerHTML='';
					boolnumber = true;			
				}else{
					divnumber.innerHTML='<font class="tips_false">验证码错误</font>';
					boolnumber = false;	
				}
			}
      });
	  }
	  
	  
	   function checkna(){
			na=form1.userName.value;
	  // 是否存在
		$.ajax({
			cache: false,
			async: false,
			type: "POST",
		dataType: "json",
			data: {userName: na},
			url: "userAction_CheckUsername.action",
		success: function(flag) {
				if(!flag) {
					divname.innerHTML='<font class="tips_false">该用户名不存在！</font>';
					booluserName = false;			
				}else{
				divname.innerHTML='';
					booluserName = true;			
				}
			}
      });
	  }
 
function check(){
checkNumber();
if(booluserName==false){
		return;
	}
	
	if(boolnumber==false){
		return;
	}
	var un = $("#userName").val();
	var pwd = $("#password").val();
	 $.ajax({
			cache: false,
			async: false,
			type: "POST",
		dataType: "json",
			data: {"userName":un , "password": pwd},
			url: "userAction_checkUser.action",
		success: function(flag) {
				if(!flag) {
					divpassword.innerHTML='<font class="tips_false" style="text-align:left">用户名和密码不匹配！</font>';
					boolpassWord = false;	
				}else{
					divpassword.innerHTML='<font class="tips_true"></font>';
					boolpassWord = true;
					
				}
			}
      }); 
    if(boolpassWord==false){
    	return;
    }else{
    	document.form1.submit();
    }
	}
  </script>

<body>
	<div class="admin_login_wrap">
		<h1>管理员登陆</h1>
		<div class="adming_login_border">
			<div class="admin_input">
				<form name="form1" method="post" action="userAction_login.action">
					<ul class="admin_items">
						<li><label for="user">用户名：</label> <input type="text" placeholder="请输入登录名"
							name="userName"  id="userName"  onblur="checkna()" size="40"
							class="admin_input_style"  />
						</li>
						<span class="tips" id="divname"></span> 
						<li><label for="pwd">密码：</label> <input type="password" placeholder="请输入密码"
							name="password"  id="password"  size="40"
							class="admin_input_style"  /></li>
							<span class="tips" id="divpassword"></span>
							
						<li><label for="number">验证码：</label> <input type="text" placeholder="验证码"
							name="number"  id="number"  size="20"
							class="admin_input_style"  /><img onClick="javascript:loadImage();"  title="换一张试试" id="randImage" 
				  src="<%=request.getContextPath()%>/image.jsp" width="60" height="20" border="1" ></li>
							<span class="tips" id="divnumber"></span>
								
						<li><input type="button" tabindex="3" onClick="check()" value="登陆"
							class="btn btn-primary" /></li>
					</ul>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
