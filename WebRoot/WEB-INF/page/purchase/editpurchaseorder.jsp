<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
 <link href="LigerUI/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <link href="LigerUI/ligerUI/skins/Gray/css/all.css" rel="stylesheet" type="text/css" />
    <link href="LigerUI/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
    <link href="css/adddelmod.css" rel="stylesheet" type="text/css" />
    <script src="script/jquery.js"></script>
    <script src="script/jquery.form.js"	type=text/javascript></script>
    <script src="LigerUI/ligerUI/js/core/base.js" type="text/javascript"></script> 
    <script src="LigerUI/ligerUI/js/plugins/ligerGrid.js" type="text/javascript"></script>
    <script src="LigerUI/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script>
    <script src="LigerUI/ligerUI/js/plugins/ligerCheckBox.js" type="text/javascript"></script>
    <script src="LigerUI/ligerUI/js/plugins/ligerToolBar.js" type="text/javascript"></script>
     <script src="script/list.js" type="text/javascript"></script>
     
     <script src="jBox/jquery.jBox-2.3.min.js" type=text/javascript></script>
<script src="jBox/jquery.jBox-zh-CN.js" type=text/javascript></script>
<link type="text/css" rel="stylesheet" href="jBox/skins2/blue/jbox.css"/>
<link rel="stylesheet" type="text/css" href="css/jquery.datetimepicker.css"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<title>增加采购单</title>
<meta name="viewport" content="width=device-width,initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="keywords" content="HTML,CSS,XML,JavaScript">
<meta charset="utf-8" />
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
	width: 700px;
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

.contact ul li input[type=text],.contact ul li input[type=password] {
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

.tips_true,.tips_false {
	padding-left: 10px;
}

.tips_true {
	color: green;
}

.tips_false {
	color: red;
}
</style>


<script type="text/javascript">
	
	var check = function() {
	var state=$('#state').val();
	var purchaseId=$('#purchaseId').val();
		var purchaseDeptId=$('#purchaseDeptId').val();
		var userId=$('#userId').val();
		var purchaseDate=$('#purchaseDate').val();
		var purchasePurpose = $('#purchasePurpose').val();
		if(purchasePurpose.length<=0){
			$.jBox.tip('请输入采购用途！');
			return;
		}
	$.ajax({
				cache : false,
				async : false,
				type : "POST",
				dataType : "json",
				data : {
					purchaseId:purchaseId,
					purchaseDeptId : purchaseDeptId,
					userId : userId,
					purchaseDate : purchaseDate,
					purchasePurpose : purchasePurpose,
					state:state
				},
				url : "purchaseOrderAction_editPurchaseOrder.action",
				success : function(flag) {
					if (flag) {
						$.jBox.tip('修改成功！');
						setTimeout(SubmitCallback, 700);
					}
				}
	});

	};
	var SubmitCallback = function() {
		parent.MainGrid.loadData(true);
		parent.$.jBox.close('id-jbox-dialog');
	};
</script>
</head>
<body>
	<div class="contact">
		<form name="form1" method="post" action="userAction_register.action">
		<input type="hidden" name="userId"
					id="userId" value="${purchaseOrder.user.userId}" />
					<input type="hidden" name="state"
					id="state" value="${purchaseOrder.state}" />
					<input type="hidden" name="purchaseId"
					id="purchaseId" value="${purchaseOrder.purchaseId}" />
			<h3>增加采购单</h3>
			<ul>
				<li><label>采购部门：</label> <select id="purchaseDeptId" name="purchaseDeptId">

						<s:iterator value="deptList" var="item">
							<s:if test="%{purchaseOrder.purchaseDeptId==#item.deptId}">
					 <option value="${item.deptId}" selected="selected">${item.deptName}</option>
					 </s:if>
					 <s:else>
					 <option value="${item.deptId}">${item.deptName}</option>
					</s:else>	
					
						</s:iterator>
				</select></li>
				<li><label>经办人：</label> <select id="userId" name="userId">

						<s:iterator value="userList" var="item">
								<s:if test="%{purchaseOrder.user.userId==#item.userId}">
					 <option value="${item.userId}" selected="selected">${item.userName}</option>
					 </s:if>
					 <s:else>
					 <option value="${item.userId}">${item.userName}</option>
					</s:else>	
						</s:iterator>
				</select></li>
				<li><label>采购日期：</label>
				<input type="text" value="${purchaseOrder.purchaseDate}" id="purchaseDate"  name="purchaseDate"/><br><br>
				
				</li>
				<li><label>采购用途：</label> <input type="text" name="purchasePurpose"
					id="purchasePurpose" value="${purchaseOrder.purchasePurpose}" placeholder="请输入采购用途" required />
					
				</li>


				<li><img src="images/save.gif" onClick="check()"></li>
			</ul>

		</form>
	</div>

</body>
<script src="script/jquery.datetimepicker.js"></script>
<script>




$('#purchaseDate').datetimepicker({value:'2016-05-08 00:00:00',step:10,lang:"ch",
      format:"Y-m-d H:i:00"});
    

function show(){
	alert($("#purchaseDate").val());
}
</script>
</html>
