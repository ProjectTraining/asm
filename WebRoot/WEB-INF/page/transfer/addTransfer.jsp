<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link href="LigerUI/ligerUI/skins/Aqua/css/ligerui-all.css"
	rel="stylesheet" type="text/css" />
<link href="LigerUI/ligerUI/skins/Gray/css/all.css" rel="stylesheet"
	type="text/css" />
<link href="LigerUI/ligerUI/skins/ligerui-icons.css" rel="stylesheet"
	type="text/css" />
<link href="css/adddelmod.css" rel="stylesheet" type="text/css" />
<script src="script/jquery.js"></script>
<script src="script/jquery.form.js" type=text/javascript></script>
<script src="LigerUI/ligerUI/js/core/base.js" type="text/javascript"></script>
<script src="LigerUI/ligerUI/js/plugins/ligerGrid.js"
	type="text/javascript"></script>
<script src="LigerUI/ligerUI/js/plugins/ligerResizable.js"
	type="text/javascript"></script>
<script src="LigerUI/ligerUI/js/plugins/ligerCheckBox.js"
	type="text/javascript"></script>
<script src="LigerUI/ligerUI/js/plugins/ligerToolBar.js"
	type="text/javascript"></script>
<script src="script/list.js" type="text/javascript"></script>

<script src="jBox/jquery.jBox-2.3.min.js" type=text/javascript></script>
<script src="jBox/jquery.jBox-zh-CN.js" type=text/javascript></script>
<link type="text/css" rel="stylesheet" href="jBox/skins2/blue/jbox.css" />
<link rel="stylesheet" type="text/css"
	href="css/jquery.datetimepicker.css" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<title>移交资产登记</title>
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
	var submitAdd = function() {
		var transferUserId = $("#transferUserId").val();
		var receiverUserId = $("#receiverUserId").val();
		var assetId = $("#assetId").val();
		var transferDate = $("#transferDate").val();
		var receiverDate = $("#receiverDate").val();
		var transferType = $("#transferType").val();
		//alert($("#state").val());
		if (transferType.length <= 0) {
			$.jBox.tip('请将信息填写完整！');
			return;
		}
		$.ajax({
			cache : false,
			async : false,
			type : "POST",
			dataType : "json",
			data : {
				transferUserId : transferUserId,
				receiverUserId : receiverUserId,
				assetId : assetId,
				transferDate : transferDate,
				receiverDate : receiverDate,
				transferType : transferType
			},
			url : "transferAction_addTransfer.action",
			success : function(flag) {
				if (flag) {
					$.jBox.tip('添加成功！');
					setTimeout(SubmitCallback, 700);
				}
			}
		});
	};
	var SubmitCallback = function() {
		window.location = "transferAction_infoHome.action?timestamp="
						+ new Date().getTime();
	};
</script>
</head>
<body>
	<div class="contact">
		<form name="form1" method="post" action="transferAction_addTransfer.action">
			<h3>资产移交申请</h3>
			<ul>
				<li><label>申请人：</label> <select id="transferUserId"
					name="transferUserId">

						<s:iterator value="transferUserList" var="item">

							<option value="${item.userId}">${item.userName}</option>
						</s:iterator>
				</select>
				</li>
				<li><label>移交人：</label> <select id="receiverUserId"
					name="receiverUserId">

						<s:iterator value="receiverUserList" var="item">

							<option value="${item.userId}">${item.userName}</option>
						</s:iterator>
				</select>
				</li>
				<li><label>资产名称：</label> <select id="assetId"
					name="assetId">

						<s:iterator value="assetList" var="item">

							<option value="${item.assetId}">${item.assetName}</option>
						</s:iterator>
				</select>
				</li>
				<li><label>申请日期：</label> <input type="text"
					value="2016-05-10 00:00" id="transferDate" name="transferDate" /><br>
				<br></li>
				<li><label>确认日期：</label> <input type="text"
					value="2016-05-10 00:00" id="receiverDate" name="receiverDate" /><br>
				<br></li>
				<li><label>移交类型：</label> <input type="text" name="transferType"
					id="transferType" /></li>

				<li><img src="images/save.gif" onClick="submitAdd()">
				</li>
			</ul>

		</form>
	</div>

</body>
<script src="script/jquery.datetimepicker.js"></script>
<script>
	$("#transferDate").datetimepicker({
		value : '2016-05-08 00:00:00',
		step : 10,
		lang : "ch",
		format : "Y-m-d H:i:00"
	});

	$("#receiverDate").datetimepicker({
		value : '2016-05-08 00:00:00',
		step : 10,
		lang : "ch",
		format : "Y-m-d H:i:00"
	});
</script>
</html>
