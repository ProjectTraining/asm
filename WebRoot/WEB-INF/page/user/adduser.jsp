<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script src="script/jquery.1.4.2-min.js" type="text/javascript"></script>
     <script src="script/list.js" type="text/javascript"></script> 
     <script src="jBox/jquery.jBox-2.3.min.js" type=text/javascript></script>
<script src="jBox/jquery.jBox-zh-CN.js" type=text/javascript></script>
<link type="text/css" rel="stylesheet" href="jBox/skins2/blue/jbox.css"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
 
<html>
<head>
  <title>添加</title>
  <meta name="viewport" content="width=device-width,initial-scale=1">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="keywords" content="HTML,CSS,XML,JavaScript">
  <meta charset="utf-8" />
  <style type="text/css">
		body{
			font:14px/28px "微软雅黑";
		}
		img{cursor:pointer;}
		h3{
			margin:0;padding:0;border:0; font-size:20px;color:#005eac; padding-bottom:10px; border-bottom:1px solid #ccc; width:100%; float:left; margin-bottom:20px;	
		}
		.contact *:focus{outline :none;}
		.contact{
			width: 700px;
			height: auto;
		
			margin: 40px auto;
			padding: 10px;
		}
		.contact ul {
			width: 650px;
			margin: 0 auto;
		}
		.contact ul li{
			border-bottom: 1px solid #dfdfdf;
			list-style: none;
			padding: 12px;
		}
		.contact ul li label {
			width: 120px;
			display: inline-block;
			float: left;
		}
		.contact ul li input[type=text],.contact ul li input[type=password]{
			width: 220px;
			height: 25px;
			border :1px solid #aaa;
			padding: 3px 8px;
			border-radius: 5px;
		}
		.contact ul li input:focus{
			border-color: #c00;
			
		}
		.contact ul li input[type=text]{
			transition: padding .25s;
			-o-transition: padding  .25s;
			-moz-transition: padding  .25s;
			-webkit-transition: padding  .25s;
		}
		.contact ul li input[type=password]{
			transition: padding  .25s;
			-o-transition: padding  .25s;
			-moz-transition: padding  .25s;
			-webkit-transition: padding  .25s;
		}
		.contact ul li input:focus{
			padding-right: 70px;
		}

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
 
  
  <script type="text/javascript">
   
  		//验证用户名
  		var booluserName = false;
  		var boolpassWord = false;
  		var boolpassWord2 = false;
	    function checkna(){
			na=form1.userName.value;
		  	if( na.length<6||na.length>20)  
	  		{  	
	  			divname.innerHTML='<font class="tips_false">长度是6~20个字符</font>';
	  		    booluserName = false; 
	  		}
	  else{  
	  		    divname.innerHTML='<font class="tips_true">输入正确</font>';
	  		   	booluserName = true;
	  		}  
	  // 是否被注册过
		$.ajax({
			cache: false,
			async: false,
			type: "POST",
		dataType: "json",
			data: {userName: na},
			url: "userAction_CheckUsername.action",
		success: function(flag) {
				if(flag) {
					divname.innerHTML='<font class="tips_false">该用户名已经存在！</font>';
					booluserName = false;			
				}
			}
      });
	  }
	  //验证密码 
//验证密码 
		function checkpsd1(){
			psd1=form1.password.value;
			var flagZM=false;
			var flagSZ=false;
			var flagQT=false;
			if(psd1.length<6 || psd1.length>20){
				divpassword1.innerHTML='<font class="tips_false">长度错误,长度必须在6-20位之间</font>';
				boolpassWord= false;
			}else
				{
				  for(i=0;i<psd1.length;i++)
{
						if((psd1.charAt(i)>='A'&&psd1.charAt(i)<='Z')||(psd1.charAt(i)>='a'&&psd1.charAt(i)<='z'))
{
							flagZM=true;
						}
						else if(psd1.charAt(i)>='0'&&psd1.charAt(i)<='9')
{
							flagSZ=true;
						}else
{
							flagQT=true;
						}
}
					if(!flagZM||!flagSZ||flagQT){
					divpassword1.innerHTML='<font class="tips_false">密码必须是字母数字的组合</font>';
					boolpassWord= false;

					}else{
						
					divpassword1.innerHTML='<font class="tips_true">输入正确</font>';
					boolpassWord=true;
}

				}	
		}
		//验证确认密码 
		function checkpsd2(){ 
				if(form1.password.value!=form1.password2.value){
 divpassword2.innerHTML='<font class="tips_false">您两次输入的密码不一样</font>';
boolpassWord2=false;
				}else{
   divpassword2.innerHTML='<font class="tips_true">输入正确</font>';
  boolpassWord2=true;
				}
		}

	var check = function(){
		var bool =booluserName&&boolpassWord&&boolpassWord2;
		var userName1 = $('#userName').val();
		var password1 = $('#password').val();
		var state1 = $('#state').val();
		var sex1 = $('#sex').val();
		var deptId = $('#deptId').val();
		if(bool==true){
			$.ajax({
			cache: false,
			async: false,
			type: "POST",
		dataType: "json",
			data: {userName:userName1,password:password1,state:state1,sex:sex1,deptId:deptId},
			url: "userAction_register.action",
		success: function(flag) {
				if(flag) {
				$.jBox.tip('添加成功！');
					setTimeout(SubmitCallback, 700);	
				}
			}
     	});
		}

   };
    var SubmitCallback = function(){     
       	   parent.MainGrid.loadData(true); 
        	parent.$.jBox.close('id-jbox-dialog');
	};
  </script>
</head>
<body>
	<div class="contact" >
		<form name="form1" method="post" action="userAction_register.action">
			<h3 >添加员工</h3>
					<ul>
				<li>
					<label>用户名：</label>
					<input type="text" name="userName" id="userName" placeholder="请输入用户名"  onblur="checkna()" required/><span class="tips" id="divname">长度6~20个字符</span>
				</li>
				<li>
					<label>密码：</label>
					<input type="password" name="password" id="password" placeholder="请输入你的密码" onBlur="checkpsd1()" required/><span class="tips" id="divpassword1">密码必须由字母和数字组成,6-20位</span>
				</li>
				<li>
					<label>确认密码：</label>
					<input type="password" name="password2" id="password2" placeholder="请再次输入你的密码" onBlur="checkpsd2()" required/><span class="tips" id="divpassword2">两次密码需要相同</span>
				</li>
				<li>
					<label>部门：</label>
					<div class="info">
						<select id="deptId" name="deptId" style="width:80px;height:25px">
									<s:iterator value="deptList" var="item">
									
									<option value="${item.deptId}">${item.deptName}</option>		
									</s:iterator>
									</select> 
					</div>
				</li>
				<li>
					<label>角色：</label>
					<div class="info">
					<select id="roleId" name="roleId" style="min-width:80px;height:25px">
						<option value ="1">管理员</option>
						 <option value ="2">技术员</option>
 						 
					</select>
					</div>
				</li>
				<li>
					<label>性别：</label>
					<div class="info">
					<select id="sex" name="sex"  style="min-width:80px;height:25px">
						<option value ="1">男</option>
						 <option value ="0">女</option>
 						 
					</select>
					</div>
				</li>
				<li>
					<label>员工状态：</label>
					<div class="info">
					<select id="state" name="state" style="min-width:80px;height:25px" >
						 <option value ="1">在职</option>
						 <option value ="0">离职</option>
 						
					</select>
					</div>
				</li>

				<li>
					<img src="images/save.gif" onClick="check()">
				</li>
			</ul>
		
		</form>
	</div>
	
</body>
</html>
