<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
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
  <title></title>
  <meta name="viewport" content="width=device-width,initial-scale=1">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="keywords" content="HTML,CSS,XML,JavaScript">

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
			width: 600px;
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
		
		
		.info select{ border:1px #993300 solid; background:#FFFFFF;}
.info{ margin:5px;}
.info #show{ color:#3399FF; }
  </style>
<script type="text/javascript">

	//验证用户名
  		var booluserName = true;
  		var boolpassWord = true;
  		var boolpassWord2 = true;
  		var boolemail = true;
  		
	    function checkna(){
	    	var orginalname=$('#orginalname').val();
			na=form1.userName.value;
			if(orginalname==na){
				booluserName = true;divname.innerHTML='';
			
				return;
			}
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
				}else{
					divname.innerHTML='';
					booluserName = true;
				}
				
				
				
					
      }
      	
      });
     
	  }
	 
	var check = function(){
		var bool =booluserName;
		var userName = $('#userName').val();
		var userId = $('#userId').val();
		var password= $('#password').val();
		var state = $('#state').val();
		var sex= $('#sex').val();
		var deptId= $('#deptId').val(); 
		if(bool==true){
			$.ajax({
			cache: false,
			async: false,
			type: "POST",
		dataType: "json",
			data: {userId:userId,userName:userName,password:password,state:state,sex:sex,deptId:deptId},
			url: "userAction_editUser.action",
		success: function(flag) {
				if(flag==true){
                
					$.jBox.tip('添加成功！');
					setTimeout(SubmitCallback, 700);
            }
                else{
                	 $.jBox.tip('添加失败！');
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
		<form id="form1" name="form1" method="post" action="userAction_editUser.action">
		<input type="hidden" id="userId" name="userId" value="${user.userId}">
		<input type="hidden" id="orginalname" name="orginalname" value="${user.userName}">
		<input type="hidden" id="password" name="password" value="${user.password}">
			<ul>
				<li>
					<label>用户名：</label>
					<input type="text" name="userName" id="userName" value="<s:property value="user.userName"/>"  placeholder="请输入用户名"  onblur="checkna()" required/><span class="tips" id="divname">长度6~20个字符</span>
				</li>
				
				<li>
					<label>部门：</label>
			
						<select id="deptId" name="deptId" style="width:80px;height:25px">
						<s:iterator value="deptList" var="item">
								<s:if test="%{#item.deptId==user.deptId}">
					<option value="${item.deptId}" selected="selected">${item.deptName}</option>
					 </s:if>
					 <s:else>
					 <option value="${item.deptId}">${item.deptName}</option>
					</s:else>	
						</s:iterator>
						
							
									</select> 
					
				</li>
				<li>
					<label>角色：</label>
					
					<select id="roleId" name="roleId" style="min-width:80px;height:25px">
						<option value ="1">管理员</option>
						 <option value ="2">技术员</option>
 						 
					</select>
		
				</li>
				
				<li>
					<label>状态：</label>
					
					<select id="state" name="state" >
					<s:if test="%{user.state==0}">
					 <option value ="0" selected="selected">离职</option>
 						 <option value ="1">在职</option>
					 </s:if>
					 <s:else>
					  <option value ="0">离职</option>
 						 <option value ="1" selected="selected">在职</option>
					</s:else>	
					</select>
				
				</li>
				<li>
					<label>性别：</label>
					
					<select id="sex" name="sex" >
					<s:if test="%{user.sex==0}">
					 <option value ="0" selected="selected">女</option>
 						 <option value ="1">男</option>
					 </s:if>
					 <s:else>
					  <option value ="0">女</option>
 						 <option value ="1" selected="selected">男</option>
					</s:else>	
					</select>
				
				</li>
				
				
				<li>
					<img src="images/save.gif" onClick="check()">
				</li>
			</ul>
		
		</form>
	</div>
</body>
</html>
