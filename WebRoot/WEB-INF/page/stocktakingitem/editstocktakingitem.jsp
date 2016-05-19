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
<script>
$(function (){
var options;
 $("#cat").change(
        function () {
        options=$("#cat option:selected"); 
        //options.val()
        $(".secondselect").hide();
        $("#secondselect"+options.val()).show();
        var categoryId=$("#secondselect"+options.val()).find("option:selected").val();
      
       $('#assetSortId').val(categoryId);
        $("#secondselect"+options.val()).change(
        function () {
        var categoryId= $("#secondselect"+options.val()).find("option:selected").val();
        $('#assetSortId').val(categoryId);
      
       // $('#form1').attr('action','storeAction_addProduct.action?categoryId='+categoryId);
     });
     });
 });
</script>
<script type="text/javascript">

	var check = function() {
	var stockTakingId=$('#stockTakingId').val();
	var stockTakingItemId=$('#stockTakingItemId').val();
	var stockTakingDate=$('#stockTakingDate').val();
	var assetId=$('#assetId').val();
	var stockTakingResult=$('#stockTakingResult').val();
	
	$.ajax({
				cache : false,
				async : false,
				type : "POST",
				dataType : "json",
				data : {
				stockTakingItemId:stockTakingItemId ,
					stockTakingId:stockTakingId ,
					stockTakingDate:stockTakingDate ,
					assetId:assetId ,
					stockTakingResult:stockTakingResult				
				},
				url : "stockTakingItemAction_edit.action",
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
			<h3>增加盘点明细</h3>
			<ul><input type="hidden" name="stockTakingItemId"
					id="stockTakingItemId" value="${stockTakingItem.stockTakingItemId}" />
				<input type="hidden" name="stockTakingId"
					id="stockTakingId" value="${stockTakingItem.stockTaking.stockTakingId}" />
				
				<li><label>资产名称：</label> <select id="assetId" name="assetId">					
						<s:iterator value="assetList" var="item">
								<s:if test="%{stockTakingItem.asset.assetId==#item.assetId}">
		
					 <option value="${item.assetId}" selected="selected">${item.assetName}</option>
					 </s:if>
					 <s:else>
					 <option value="${item.assetId}">${item.assetName}</option>
					</s:else>	
						</s:iterator>
						
						
						
						
						
				</select></li>
				
				<li><label>盘点日期：</label>
				<input type="text" value="${stockTakingItem.stockTakingDate}" id="stockTakingDate"  name="stockTakingDate"/><br><br>
				
				</li>
				
				<li>
					<label>盘点结果：</label>
					<div class="info">
					<select id="stockTakingResult" name="stockTakingResult" >
					<s:if test="%{stockTakingItem.stockTakingResult==1}">
		<option value ="1" selected="selected">帐实相符</option>
					 </s:if>
					 <s:else>
					<option value ="1" >帐实相符</option> 
					</s:else>
					<s:if test="%{stockTakingItem.stockTakingResult==2}">
						 <option value ="2" selected="selected">调整后帐实相符</option>
					 </s:if>
					 <s:else>
					  <option value ="2" >调整后帐实相符</option>
					</s:else>
					<s:if test="%{stockTakingItem.stockTakingResult==3}">
						  <option value ="3" selected="selected">帐实不符</option>
					 </s:if>
					 <s:else>
					  <option value ="3" >帐实不符</option>
					</s:else>
					<s:if test="%{stockTakingItem.stockTakingResult==4}">

						 <option value ="4" selected="selected">调整后帐实不符</option>
					 </s:if>
					 <s:else>
					  <option value ="4" >调整后帐实不符</option>
					</s:else>
					</select>
					</div>
				</li> 
				<li><img src="images/save.gif" onClick="check()"></li>
			</ul>

		</form>
	</div>

</body>
<script src="script/jquery.datetimepicker.js"></script>
<script>

$('#stockTakingDate').datetimepicker({value:$('#stockTakingDate').val(),step:10,lang:"ch",
      format:"Y-m-d H:i:00"});
    
</script>
</html>
