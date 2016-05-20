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
    	var stockTakingId=$('#stockTakingId').val();
        MainGrid=$("#MainGrid").ligerGrid({  
                 
                    columns:[  
                        {display:"主键",name:"stockTakingItemId",hide:"hidden"},
                        { display: '操作', isAllowHide:false,width: 80,minWidth:60,render: function (row)
							    {
									var html = "";
									
										html += "<span title='详细与编辑' class='l-icon-view grid-line-btn'  onclick=\"edit('"+row.stockTakingItemId+"')\">&nbsp;</span>";
								
									 	html += "<span title='删除' class='l-icon-delete grid-line-btn' onclick=\"deleteObjFromMainGrid('"+row.stockTakingItemId+"','"+row.__id+"','stockTakingItemAction_remove.action?stockTakingItemId=')\">&nbsp;</span>";
									
							        return html;
							    }
							},   
                        {display:"资产名称",name:"assetName"},  
                     
                        {display:"盘点时间",name:"stockTakingDate"},
                        { display: '状态',   name:'stockTakingResult',render:function(row){
										if(row.stockTakingResult == '1'){
                                  			 return "<span style='color:#009900;font-weight:bold;'>帐实相符</span>";
                               			 }if(row.stockTakingResult == '2'){
                               			 return "<span style='color:#009900;font-weight:bold;'>调整后帐实相符</span>";
                               			 }
                               			 if(row.stockTakingResult == '3'){
                               			 return "<span style='color:#FF0000;font-weight:bold;'>帐实不符</span>";
                               			 }
                               			 else{
                                   			return "<span style='color:#FF0000;font-weight:bold;'>调整后帐实不符</span>";
                                		}
									}}	
                    ], 
                    toolbar:{ items: [
				                  { text: '增加盘点明细', click: addNewRecord,icon:'add'},
				                  { line:true },
			                  ]}, 
                    //data:docData,  
                    url:'stockTakingItemAction_list.action?stockTakingId='+stockTakingId,  
                    sortName: 'stockTakingItemId',  
                    width:"100%",height:"96%",  
                    pagesizeParmName:"pageSize",  
                    pageParmName:"pageNow",  
                    pageSize:10,  
                    rowHeight:40,  
                    dataAction:'local',
                    rownumbers:true,usePager:true
        });  
    });  

     var edit = function(stockTakingItemId){
		 	showDialog('stockTakingItemAction_editPage.action?stockTakingItemId='+stockTakingItemId,'修改盘点明细',750,500);
 };
  var addNewRecord = function(){
var stockTakingId=$('#stockTakingId').val();
		 showDialog('stockTakingItemAction_addPage.action?stockTakingId='+stockTakingId,'添加盘点明细',750,500);
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
            	<input type="hidden" name="stockTakingId"
					id="stockTakingId" value="${stockTakingId}" />
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
				  <div id="MainGrid" keyname="stockTakingItemId"></div>  
            </div>
  
</body> 

<script>

function SubmitQueryPO(){
	var assettName= $("#assettName").val();
	var stockTakingId=$('#stockTakingId').val();
	MainGrid.set({url:'stockTakingItemAction_list.action?stockTakingId='+stockTakingId+'&assettName='+assettName});
	MainGrid.loadData(true);

}
function back(){
location.href = " <%=request.getContextPath()%>/stockTakingAction_listPage.action";

}
</script>
</html>
