<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<link href="css/main.css" rel="stylesheet" type="text/css" />
    <link href="LigerUI/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <link href="LigerUI/ligerUI/skins/Gray/css/all.css" rel="stylesheet" type="text/css" />
    <link href="LigerUI/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
    <link href="css/adddelmod.css" rel="stylesheet" type="text/css" />
    <script src="LigerUI/jquery/jquery-1.3.2.min.js" type="text/javascript"></script>
    <script src="LigerUI/ligerUI/js/core/base.js" type="text/javascript"></script> 
    <script src="LigerUI/ligerUI/js/plugins/ligerGrid.js" type="text/javascript"></script>
    <script src="LigerUI/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script>
    <script src="LigerUI/ligerUI/js/plugins/ligerCheckBox.js" type="text/javascript"></script>
    <script src="LigerUI/ligerUI/js/plugins/ligerToolBar.js" type="text/javascript"></script>
     <script src="script/list.js" type="text/javascript"></script>
     
     <script src="jBox/jquery.jBox-2.3.min.js" type=text/javascript></script>
<script src="jBox/jquery.jBox-zh-CN.js" type=text/javascript></script>
<link type="text/css" rel="stylesheet" href="jBox/skins2/blue/jbox.css"/>
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
                        {display:"主键",name:"userId",hide:"hidden"},
                        { display: '操作', isAllowHide:false,width: 80,minWidth:60,render: function (row)
							    {
									var html = "";
									
										html += "<span title='编辑' class='l-icon-edit grid-line-btn'  onclick=\"edit('"+row.userId+"')\">&nbsp;</span>";
								
									 	html += "<span title='删除' class='l-icon-delete grid-line-btn' onclick=\"deleteObjFromMainGrid('"+row.userId+"','"+row.__id+"','userAction_remove.action?userId=')\">&nbsp;</span>";
									
							        return html;
							    }
							},   
                        {display:"用户名",name:"userName"},  
                        { display: '状态',   name:'state',render:function(row){
										if(row.state == '1'){
                                  			 return "<span style='color:#009900;font-weight:bold;'>在职</span>";
                               			 }else{
                                   			return "<span style='color:#FF0000;font-weight:bold;'>离职</span>";
                                		}
									}},
									
						{ display: '性别',   name:'sex',render:function(row){
										if(row.sex == '1'){
                                  			 return "<span style='color:#009900;font-weight:bold;'>男</span>";
                               			 }else{
                                   			return "<span style='color:#FF0000;font-weight:bold;'>女</span>";
                                		}
									}}
						
                    ], 
                    toolbar:{ items: [
				                  { text: '新增员工', click: addNewRecord,icon:'add'},
				                  { line:true },
			                  ]}, 
                    //data:docData,  
                    url:'userAction_listUser.action',  
                    sortName: 'userId',  
                    width:"100%",height:"100%",  
                    pagesizeParmName:"pageSize",  
                    pageParmName:"pageNow",  
                    pageSize:10,  
                    rowHeight:40,  
                    rownumbers:true,usePager:true
        });  
    });  
     var edit = function(userId){
		 	showDialog('userAction_listInfo.action?userId='+userId,'修改员工',720,500);
 };
  var addNewRecord = function(){
		 	showDialog('userAction_addPage.action','添加员工',720,500);
		 };
</script>
  </head>
  <body>  
  <div position="top" title="" style="padding-left:10px;">
            	<!-- 查询条件部分 -->
            	<div>
            		<form id="searchForm" name="searchForm" class="l-form liger-form" action="search" method="post">
		            	<table id="searchTable" class="searchTable">
		            		<tr>
		            			<th>
					            	用户名：
					            </th>
		            			<td>
					            	<input type="text" name="staffName" id="staffName"/>
					            </td>
					            <th>
					            	部门：
					            	<select id="selectDept" name="selectDept">
31: 								<c:forEach items="${requestScope.deptList} " var="item">
32: 									<option value="${item.id}">${item.name}</option>
33: 								</c:forEach>
34:									 </select>
					            </th>
		            			<td>
					            	<input type="text" name="userId" id="userId" style="width:100px;"/>
					            </td>
					            <th>
					            	员工状态：
					            </th>
		            			<td>
					            	
					            </td>
					            <th class="opt">
					           		
					            	<div title="查询" class='l-icon-search' style="cursor:hand" data-click="SubmitQuery" data-width="60" icon="search">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp查询</div>
					            </th>
				            </tr>
				         </table>
			         </form>
			     </div>
            </div>
            <div position="center" title="">
            	<!-- 数据集部分 -->
				  <div id="MainGrid" keyname="userId"></div>  
            </div>
  
</body>  
</html>
