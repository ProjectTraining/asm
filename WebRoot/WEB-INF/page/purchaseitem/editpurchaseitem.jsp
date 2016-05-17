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
	var purchaseItemId=$('#purchaseItemId').val();
	var assetSortId=$('#assetSortId').val();
	var purchaseOrderId=$('#purchaseOrderId').val();
	var parentAssertSortId=$("#cat option:selected").val();
	var assetSortId=$("#secondselect"+parentAssertSortId).find("option:selected").val();
	var unit=$('#unit').val();
	var assetType=$('#assetType').val();
	var assettName=$('#assettName').val();
	var num=$('#num').val();
	var remarks=$('#remarks').val();
	var manufacturer=$('#manufacturer').val();
	var supplier=$('#supplier').val();
	var price=$('#price').val();
	var userId=$('#userId').val();
	$.ajax({
				cache : false,
				async : false,
				type : "POST",
				dataType : "json",
				data : {
				purchaseItemId:purchaseItemId,
					assetSortId:assetSortId ,
					purchaseOrderId:purchaseOrderId ,
					preserveUserId:userId ,
					parentAssertSortId:parentAssertSortId ,
					unit:unit ,
					assetType:assetType ,
					assettName:assettName ,
					num:num ,
					remarks:remarks ,
					manufacturer:manufacturer ,
					supplier:supplier ,
					price:price 				
				},
				url : "purchaseItemAction_edit.action",
				success : function(flag) {
					if (flag) {
						$.jBox.tip('添加成功！');
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
			<h3>修改采购单明细</h3>
			<ul><input type="hidden" name="purchaseOrderId"
					id="purchaseOrderId" value="${purchaseItem.purchaseOrderId}" />
				<input type="hidden" name="purchaseItemId"
					id="purchaseItemId" value="${purchaseItem.purchaseItemId}" />
				<li><label>资产类型：</label>
				
				<select id="cat" name="cat"  style="width:105px">
							
					
    					 <s:iterator value="assetSortList" var="c1">
    					  	 <s:if test="%{purchaseItem.parentAssertSortId==#c1.assetSortId}">
					 	<option value="${c1.assetSortId}" selected="selected">${c1.assetSortName}</option>
					 </s:if>
					 <s:else>
					 	<option value="${c1.assetSortId}">${c1.assetSortName}</option>
					</s:else>	
					
    					  </s:iterator>
					 </select>
				 <s:iterator value="assetSortList" var="c1">
				 
				 <s:if test="%{purchaseItem.parentAssertSortId==#c1.assetSortId}">
				<span id="secondselect${c1.assetSortId}"  class="secondselect">
					 </s:if>
					 <s:else>
					 <span id="secondselect${c1.assetSortId}" style="display:none" class="secondselect">
					</s:else>	
				 
				 
				 
					 
					 	<select style="width:105px" >
							 
					 		 <s:iterator value="listAssetSort" var="c2">
					 		 	
								<!--2级分类结束-->
								 <s:if test="%{purchaseItem.assetSortId==#c2.assetSortId}">
					 	<option value="${c2.assetSortId}" selected="selected">${c2.assetSortName}</option>
					 </s:if>
					 <s:else>
					 		<option value="${c2.assetSortId}">${c2.assetSortName}</option>
					</s:else>	
					
					
								
							</s:iterator>
						</select>
						 </span>
					  </s:iterator>
					  
				<input type="hidden" name="assetSortId" value="${purchaseItem.assetSortId}" id="assetSortId"/>	  	
				</li>
				
				<li><label>资产名称：</label> <input type="text" name="assettName"
					id="assettName" value="${purchaseItem.assettName}" placeholder="请输入资产名称" required />
					
				</li>
				
				<li><label>型号：</label> <input type="text" name="assetType"
					id="assetType" value="${purchaseItem.assetType}" placeholder="请输入型号" required />
					
				</li>
				<li><label>保管人：</label> <select id="userId" name="userId">

						<s:iterator value="userList" var="item">
								<s:if test="%{purchaseItem.preserveUserId==#item.userId}">
					 <option value="${item.userId}" selected="selected">${item.userName}</option>
					 </s:if>
					 <s:else>
					 <option value="${item.userId}">${item.userName}</option>
					</s:else>	
						</s:iterator>
						
				</select></li>
				<li><label>数量：</label> <input type="text" name="num" value="${purchaseItem.num}"
					id="num" placeholder="请输入数量" required />
					
				</li>
				
				<li><label>单位：</label> <input type="text" name="unit" value="${purchaseItem.unit}"
					id="unit" placeholder="请输入单位" required />
					
				</li>
				
				<li><label>单价：</label> <input type="text" name="price" value="${purchaseItem.price}"
					id="price" placeholder="请输入单价" required />
					
				</li>
				
				<li><label>制造商：</label> <input type="text" name="manufacturer" value="${purchaseItem.manufacturer}"
					id="manufacturer" placeholder="请输入制造商" required />
					
				</li>
				
				<li><label>供应商：</label> <input type="text" name="supplier" value="${purchaseItem.supplier}"
					id="supplier" placeholder="请输入供应商" required />
					
				</li>
				
				
				<li><label>备注：</label> <input type="text" name="remarks" value="${purchaseItem.remarks}"
					id="remarks" placeholder="请输入备注" required />
					
				</li>
				

				<li><img src="images/save.gif" onClick="check()"></li>
			</ul>

		</form>
	</div>

</body>

</html>
