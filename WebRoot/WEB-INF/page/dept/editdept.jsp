<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script src="script/jquery.1.4.2-min.js" type="text/javascript"></script>
<script src="script/list.js" type="text/javascript"></script>
<script src="jBox/jquery.jBox-2.3.min.js" type=text/javascript></script>
<script src="jBox/jquery.jBox-zh-CN.js" type=text/javascript></script>
<link type="text/css" rel="stylesheet" href="jBox/skins2/blue/jbox.css" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title></title>
<meta name="viewport" content="width=device-width,initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="keywords" content="HTML,CSS,XML,JavaScript">

<style type="text/css">
body {
	font: 14px/28px "微软雅黑";
}

img {
	cursor: pointer;
}

h3 {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 20px;
	color: #005eac;
	padding-bottom: 10px;
	border-bottom: 1px solid #ccc;
	width: 100%;
	float: left;
	margin-bottom: 20px;
}

.contact *:focus {
	outline: none;
}

.contact {
	width: 600px;
	height: auto;
	margin: 40px auto;
	padding: 10px;
}

.contact ul {
	width: 650px;
	margin: 0 auto;
}

.contact ul li {
	border-bottom: 1px solid #dfdfdf;
	list-style: none;
	padding: 12px;
}

.contact ul li label {
	width: 120px;
	display: inline-block;
	float: left;
}

.contact ul li input[type=text], .contact ul li input[type=password] {
	width: 220px;
	height: 25px;
	border: 1px solid #aaa;
	padding: 3px 8px;
	border-radius: 5px;
}

.contact ul li input:focus {
	border-color: #c00;
}

.contact ul li input[type=text] {
	transition: padding .25s;
	-o-transition: padding .25s;
	-moz-transition: padding .25s;
	-webkit-transition: padding .25s;
}

.contact ul li input[type=password] {
	transition: padding .25s;
	-o-transition: padding .25s;
	-moz-transition: padding .25s;
	-webkit-transition: padding .25s;
}

.contact ul li input:focus {
	padding-right: 70px;
}

.tips {
	color: rgba(0, 0, 0, 0.5);
	padding-left: 10px;
}

.tips_true, .tips_false {
	padding-left: 10px;
}

.tips_true {
	color: green;
}

.tips_false {
	color: red;
}

.info select {
	border: 1px #993300 solid;
	background: #FFFFFF;
}

.info {
	margin: 5px;
}

.info #show {
	color: #3399FF;
}
</style>
<script type="text/javascript">

	//验证用户名
  		var booldeptName = true;
  		var boolpassWord = true;
  		var boolpassWord2 = true;
  		var boolemail = true;
  		
	    function checkna(){
	    	var orginalname=$('#orginalname').val();
			na=form1.deptName.value;
			
			if(orginalname==na){
				booldeptName = true;
				return;
			}
		  	if( na.length<2||na.length>20)  
	  		{  	
	  			divname.innerHTML='<font class="tips_false">长度是2~20个字符</font>';
	  		    booldeptName = false; 
	  		}
	  		else{  
	  		    divname.innerHTML='<font class="tips_true">输入正确</font>';
	  		   	booldeptName = true;
	  		}  
	  // 是否被注册过
		$.ajax({
			cache: false,
			async: false,
			type: "POST",
		dataType: "json",
			data: {deptName: na},
			url: "deptAction_CheckDeptname.action",
		success: function(flag) {
				if(flag) {
					divname.innerHTML='<font class="tips_false">该部门名称已经存在！</font>';
					booldeptName = false;			
				}
			}
      });
	  }
	 
	var check = function(){
		var bool =booldeptName;
		var deptName = $('#deptName').val();  //  根据标签的ID 来获取相应的值，这里的deptName是指标签的ID
		var deptId = $('#deptId').val();
		if(bool==true){
			$.ajax({
			cache: false,
			async: false,
			type: "POST",
		dataType: "json",
			data: {deptId:deptId,deptName:deptName},
			url: "deptAction_editDept.action",
		success: function(flag) {
				if(flag==true){
					$.jBox.tip('修改成功！');
					setTimeout(SubmitCallback, 700);
            }
                else{
                	 $.jBox.tip('修改失败！');
                }
                    
			}
		
     	});
     	
		}
   };
    var SubmitCallback = function(){     
   /*     	parent.MainGrid.loadData(true); 
        parent.$.jBox.close('id-jbox-dialog'); */
        window.location.href = "deptAction_Pageforweb.action";
	};
     
</script>
</head>
<body>
	<div class="contact">
		<form id="form1" name="form1" method="post" action="deptAction_editDept.action">
		<input type="hidden" id="deptId" name="deptId"
				value="${dept.deptId}">
		 <input type="hidden" id="orginalname" name="orginalname"
				value="${dept.deptName}">
			<ul>
				<li><label>部门名称：</label> <input type="text" name="deptName"
					id="deptName" value="<s:property value="dept.deptName"/>"
					placeholder="请输入部门名称" onblur="checkna()" required /><span
					class="tips" id="divname">长度4~20个字符</span></li>
				<li><img src="images/save.gif" onClick="check()"></li>
			</ul>

		</form>
	</div>
</body>
</html>
