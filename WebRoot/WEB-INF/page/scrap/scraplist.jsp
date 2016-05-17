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
                        {display:"主键",name:"scrapId",hide:"hidden"},
                        { display: '操作', isAllowHide:false,width: 80,minWidth:60,render: function (row)
							    {
									var html = "";
									
										html += "<span title='资产详情' class='l-icon-view grid-line-btn'  onclick=\"edit('"+row.scrapId+"')\">&nbsp;</span>";
								if(row.state == '0'){
                                  			html += "<span title='报废审核' class='l-icon-ok grid-line-btn'  onclick=\"changeState('"+row.scrapId+"','报废成功！','scrapAction_changeState.action?scrapId=',1)\">&nbsp;</span>";
                                		}
								
									 	
									
							        return html;
							    }
							},   
                        {display:"资产名称",name:"assetName"},  
                        {display:"报废人",name:"scrapUserName"},
                        {display:"报废日期",name:"scrapDate"},
                        {display:"审核人",name:"agreeUserName"},
                        {display:"审核日期",name:"agreeDate"},
                          { display: '状态',   name:'state',render:function(row){
										if(row.state == '0'){
                                  			 return "<span style='color:#009900;font-weight:bold;'>待审核</span>";
                               			 }else{
                                   			return "<span style='color:#FF0000;font-weight:bold;'>已报废</span>";
                                		}
									}}	
                    ], 
                    //data:docData,  
                    url:'scrapAction_list.action',  
                    sortName: 'scrapId',  
                    width:"100%",height:"96%",  
                    pagesizeParmName:"pageSize",  
                    pageParmName:"pageNow",  
                    pageSize:10,  
                    rowHeight:40,  
                    rownumbers:true,usePager:true
        });  
    });  

     var edit = function(scrapId){
		 	//showDialog('purchaseItemAction_editPage.action?purchaseItemId='+purchaseItemId,'修改采购单',750,500);
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
       <div position="center" title="">
            	<!-- 数据集部分 -->
				  <div id="MainGrid" keyname="scrapId"></div>  
       </div>
  
</body> 


</html>
