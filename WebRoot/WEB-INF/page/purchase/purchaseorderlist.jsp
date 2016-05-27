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
        MainGrid=$("#MainGrid").ligerGrid({  
                 
                    columns:[  
                        {display:"主键",name:"purchaseId",hide:"hidden"},
                        { display: '操作', isAllowHide:false,width: 80,minWidth:60,render: function (row)
							    {
									var html = "";
									
									
									html += "&nbsp;&nbsp;<span title='编辑采购单' class='l-icon-view grid-line-btn' onclick=\"viewPurchaseItem('"+row.purchaseId+"','"+row.state+"')\">&nbsp;</span>";
										if(row.state != '0' &&row.state != '2'){
										html += "<span title='确认入库' class='l-icon-ok grid-line-btn'  onclick=\"changeState('"+row.purchaseId+"','确认入库成功！','purchaseOrderAction_changeState.action?purchaseId=',2)\">&nbsp;</span>";
									}
									if(row.state != '0' &&row.state != '2'){
	html += "<span title='编辑' class='l-icon-edit grid-line-btn'  onclick=\"edit('"+row.purchaseId+"')\">&nbsp;</span>";
									}
									if(row.state != '2' &&row.state != '0'){
										html += "<span title='作废' class='l-icon-delete grid-line-btn' onclick=\"changeState('"+row.purchaseId+"','作废成功！','purchaseOrderAction_changeState.action?purchaseId=',0)\">&nbsp;</span>";
									}
									
							        return html;
							    }
							},   
                        {display:"采购日期",name:"purchaseDate"},  
                        {display:"采购部门",name:"deptName"},
                        {display:"采购人",name:"purchaseUserId"},
                        {display:"用途",name:"purchasePurpose"},
                        { display: '状态',   name:'state',render:function(row){
										if(row.state == '1'){
                                  			 return "<span style='color:#009900;font-weight:bold;'>未确认</span>";
                               			 }if(row.state == '2'){
                               			 return "<span style='color:#009900;font-weight:bold;'>确认</span>";
                               			 }
                               			 else{
                                   			return "<span style='color:#FF0000;font-weight:bold;'>作废</span>";
                                		}
									}}
									
						
						
                    ], 
                    toolbar:{ items: [
				                  { text: '增加采购单', click: addNewRecord,icon:'add'},
				                  { line:true },
			                  ]}, 
                    //data:docData,  
                    url:'purchaseOrderAction_listPurchaseOrder.action',  
                    sortName: 'purchaseId',  
                    width:"100%",height:"96%",  
                    pagesizeParmName:"pageSize",  
                    pageParmName:"pageNow",  
                    pageSize:10,  
                    rowHeight:40,  
                    dataAction:'local',
                    rownumbers:true,usePager:true
        });  
    });  
    var viewPurchaseItem = function(purchaseId,state){
		 	location.href = " <%=request.getContextPath()%>/purchaseItemAction_home.action?purchaseOrderId="+purchaseId+"&state="+state;
 };
     var edit = function(purchaseId){
		 	showDialog('purchaseOrderAction_listInfo.action?purchaseId='+purchaseId,'修改采购单',750,500);
 };
  var addNewRecord = function(){
		 	showDialog('purchaseOrderAction_addPage.action','添加采购单',750,500);
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
            		<form id="searchForm" name="searchForm" class="l-form liger-form" action="userAction_homePage.action" method="post">
		            	<table id="searchTable" class="searchTable">
		            		<tr>
		            	<th>
					            	采购日期：
					            </th>
		            			<td>
					            	<input type="text"  style="margin-top:20" value="2016-05-12 00:00" id="datetimepicker1"  name="startTime"/><br><br>
					            </td>
					            <th>
					            	至
					            </th>
		            			<td>
					            	<input type="text" style="margin-top:20"  value="2016-05-15 00:00" id="datetimepicker2"  name="endTime"/><br><br>
					            </td> 
					            
					           <td>&nbsp&nbsp
					            	部门：
	
								 
								 	
					<select id="deptId" name="deptId">
									<option value=""></option>
									<s:iterator value="deptList" var="item">
									
									<option value="${item.deptId}">${item.deptName}</option>		
									</s:iterator>
									</select> 
					
					            </td>
					            
		            			
					            
					            
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
				  <div id="MainGrid" keyname="purchaseId"></div>  
            </div>
  
</body> 

<script src="script/jquery.datetimepicker.js"></script>
<script>
$('#datetimepicker1').datetimepicker({value:'2015-01-01 00:00:00',step:10,lang:"ch",
      format:"Y-m-d H:i:00"});
     $('#datetimepicker2').datetimepicker({value:'2016-12-31 00:00:00',step:10,lang:"ch",
      format:"Y-m-d H:i:00"});

function SubmitQueryPO(){
	var deptId= $("#deptId").val();
	var startTime= $("#datetimepicker1").val();
	var endTime= $("#datetimepicker2").val();
	MainGrid.set({url:'purchaseOrderAction_listPurchaseOrder.action?purchaseDeptId='+deptId+'&startTime='+startTime+'&endTime=' +endTime});
	MainGrid.loadData(true);

}
</script>
</html>
