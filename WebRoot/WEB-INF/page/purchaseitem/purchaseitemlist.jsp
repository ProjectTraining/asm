<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
     <script src="script/list.js?randomId=<%=Math.random()%>" type="text/javascript"></script>
     
     <script src="jBox/jquery.jBox-2.3.min.js" type=text/javascript></script>
<script src="jBox/jquery.jBox-zh-CN.js" type=text/javascript></script>
<link type="text/css" rel="stylesheet" href="jBox/skins2/blue/jbox.css"/>
<link rel="stylesheet" type="text/css" href="css/jquery.datetimepicker.css"/>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript"> 
    $(function(){  
    	var purchaseId=$('#purchaseOrderId').val();
        MainGrid=$("#MainGrid").ligerGrid({  
                 
                    columns:[  
                        {display:"主键",name:"purchaseItemId",hide:"hidden"},
                        { display: '操作', isAllowHide:false,width: 80,minWidth:60,render: function (row)
							    {
									var html = "";
									
										html += "<span title='详细与编辑' class='l-icon-view grid-line-btn'  onclick=\"edit('"+row.purchaseItemId+"')\">&nbsp;</span>";
								
									 	html += "<span title='删除' class='l-icon-delete grid-line-btn' onclick=\"changeState('"+row.purchaseItemId+"','作废成功！','purchaseOrderAction_changeState.action?purchaseItemId=',0)\">&nbsp;</span>";
									
							        return html;
							    }
							},   
                        {display:"资产名称",name:"assettName"},  
                        {display:"资产型号",name:"assetType"},
                        {display:"数量",name:"num"},
                        {display:"单位",name:"unit"},
                        {display:"价格",name:"price"}	
                    ], 
                    toolbar:{ items: [
				                  { text: '增加采购单明细', click: addNewRecord,icon:'add'},
				                  { line:true },
			                  ]}, 
                    //data:docData,  
                    url:'purchaseItemAction_listPurchaseItem.action?purchaseOrderId='+purchaseId,  
                    sortName: 'purchaseItemId',  
                    width:"100%",height:"96%",  
                    pagesizeParmName:"pageSize",  
                    pageParmName:"pageNow",  
                    pageSize:10,  
                    rowHeight:40,  
                    rownumbers:true,usePager:true
        });  
    });  
    var viewPurchaseItem = function(purchaseItemId){
		 	location.href = " <%=request.getContextPath()%>/manageAction_loginPage.action";
 };
     var edit = function(purchaseItemId){
		 	showDialog('purchaseItemAction_editPage.action?purchaseItemId='+purchaseItemId,'修改采购单',750,500);
 };
  var addNewRecord = function(){
var purchaseId=$('#purchaseOrderId').val();
		 showDialog('purchaseItemAction_addPage.action?purchaseOrderId='+purchaseId,'添加采购单明细',750,500);
		 };
</script>


<link rel="stylesheet" type="text/css" href="css/jquery.datetimepicker.css"/>
<style type="text/css">

.custom-date-style {
	background-color: red !important;
}

.input{	
}
.input-wide{
	width: 500px;
}

</style>
  </head>
  <body>  
  <div position="top" title="" style="padding-left:10px;">
            	<!-- 查询条件部分 -->
            	<div>
            	<input type="hidden" name="purchaseOrderId"
					id="purchaseOrderId" value="${purchaseItem.purchaseOrderId}" />
            		<form id="searchForm" name="searchForm" class="l-form liger-form" action="userAction_homePage.action" method="post">
		            	<table id="searchTable" class="searchTable">
		            		<tr>
		            	<th>
					            	资产名称：
					            </th>
		            			<td>
					            	<input type="text" name="assettName" id="assettName"/>
					            </td>
		            			
					            <th class="opt">
					            	<div title="返回" class='l-icon-back' style="cursor:hand" onClick="back()"   data-width="100" icon="back">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp返回</div>
					            </th>
					            
					            <th class="opt">
					            	<div title="查询" class='l-icon-search' style="cursor:hand" onClick="SubmitQueryPO()"   data-width="100" icon="search">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp查询</div>
					            </th>
				            </tr>
				         </table>
			         </form>
			     </div>
            </div> 
            <div position="center" title="">
            	<!-- 数据集部分 -->
				  <div id="MainGrid" keyname="purchaseItemId"></div>  
            </div>
  
</body> 

<script>

function SubmitQueryPO(){
	var assettName= $("#assettName").val();
	var purchaseId=$('#purchaseOrderId').val();
	MainGrid.set({url:'purchaseItemAction_listPurchaseItem.action?purchaseOrderId='+purchaseId+'&assettName='+assettName});
	MainGrid.loadData(true);

}
function back(){
location.href = " <%=request.getContextPath()%>/purchaseOrderAction_home.action";

}
</script>
</html>
