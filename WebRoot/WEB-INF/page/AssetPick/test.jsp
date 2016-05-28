<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>资产领用与归还</title>
  <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
  <meta name="description" content="这是一个 index 页面" />
  <meta name="keywords" content="index" />
  <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" />
  <meta name="renderer" content="webkit" />
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="assets/i/favicon.png" />
  <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png" />
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="assets/css/admin.css" />
  
  <!-- Attach our CSS -->
	  	<link rel="stylesheet" href="zhaonan/reveal.css" />	
	  	
		<!-- Attach necessary scripts -->
		<!-- <script type="text/javascript" src="jquery-1.4.4.min.js"></script> -->
		<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
		<script type="text/javascript" src="zhaonan/js/jquery.reveal.js"></script>
		
		<style type="text/css">
			body { font-family: "HelveticaNeue","Helvetica-Neue", "Helvetica", "Arial", sans-serif; }
			.big-link { display:block; margin-top: 20px; text-align: center; font-size: 30px; color: #06f; }
		</style>
  
  <script type="text/javascript">  
           function del(){  
                if(confirm("Are you sure?")){  
                    return true;  
                }  
                return false;  
            }  
            function InquireDept(){  // 点击按钮的一个函数，然后 action="deptAction_home.action",不过此处有问题，没跳转到
                var form = document.getElementById('form1');
                form.action="deptAction_ListData.action";
                form.submit();
           }
            function TargetBtn(flag){ 
             	var form1 = document.getElementById('form1');
                form1.action="deptAction_"+flag+".action";  // 
                form1.submit();  
            	//window.location.href="/asm/AddDept.jsp";
            }
        </script>
  
</head>
<body>
	<div class="am-g">
		<div class="am-u-sm-11">
		<s:form id="form1" name="form1"  namespace="/" >  
		 <table class="am-table am-table-bd am-table-striped admin-content-table">
		  <tr>
		     <td style="height:34px border:1px solid #000">
		        <s:label>根据资产名称查询：</s:label>
		        <s:textfield name="Asset.assetName" label="部门名称：" value="" ></s:textfield>
		     </td>
		  </tr>
		  <tr>
		     <td style="width:60%">
		       <s:submit id='bbb' value="查询" onclick="TargetBtn('home')" ></s:submit>
		     </td>
		     <td><a href="#" class="big-link" data-reveal-id="myModal" data-animation="fade">
			       测试按钮</a>
			</td>
		  </tr>
		 </table> 
        </s:form> 
		<table
				class="am-table am-table-bd am-table-striped admin-content-table">
				<thead>
					<tr>
						<th>资产名称</th>
						<th>入库时间</th>
						<th>资产总数量</th>
						<th>可领用数量</th>
						<th>状态</th>
					</tr>
				</thead>
				<tbody>
				<s:iterator value="#request.list" id="asset">
					<tr>
						<td> <s:property value="#asset.assetName"/> </td>
						<td> <s:property value="#asset.inStockDate"/> </td>
						<td> <s:property value="#asset.num"/> </td>
						<td> <s:property value="#asset.num"/> </td>
						<td> <s:property value="#asset.stockState"/> </td>
						<td align="center"><s:a href="#" data-reveal-id="myModal" data-animation="none">领用</s:a></td>
				        <td align="center"><s:a
						      href="AssetPickAction_DeptInfo.action?dept.deptId=%{#dept.deptId}">修改</s:a></td>
					</tr>
				</s:iterator>
                </tbody>
			</table>
		</div>
	
		<div class="am-u-sm-12" align="center">
			<s:iterator value="pageBeanAsset">
				<tr>
					<td colspan="6" align="center" bgcolor="#5BA8DE">共<s:property
							value="allRow" />条记录 共<s:property value="totalPage" />页 当前第<s:property
							value="currentPage" />页<br /> <s:if test="%{currentPage == 1}">    
                                                                              第一页  上一页    
                        </s:if> <!-- currentPage为当前页 --> <s:else>
							<a href="AssetPickAction_ListforAssetandPage.action?Assetpage=1">第一页</a>
							<a
								href="AssetPickAction_ListforAssetandPage.action?Assetpage=<s:property value="%{currentPage-1}"/>">上一页</a>
						</s:else> <s:if test="%{currentPage != totalPage}">
							<a
								href="AssetPickAction_ListforAssetandPage.action?Assetpage=<s:property value="%{currentPage+1}"/>">下一页</a>
							<a
								href="AssetPickAction_ListforAssetandPage.action?Assetpage=<s:property value="totalPage"/>">最后一页</a>
						</s:if> <s:else>    
                                                           下一页  最后一页    
                       </s:else>
					</td>
				</tr>
			</s:iterator>
		</div>
	</div>
   
    <div class="am-g">
    	<div class="am-u-sm-11">
		<s:form id="form2" name="form2"  namespace="/" >  
		 <table class="am-table am-table-bd am-table-striped admin-content-table">
		  <tr>
		     <td style="height:34px border:1px solid #000">
		        <s:label>根据资产名称查询：</s:label>
		        <s:textfield name="dept.deptName" label="部门名称：" value="" ></s:textfield>
		     </td>
		  </tr>
		  <tr>
		     <td style="width:60%">
		       <s:submit id='bbb' value="查询" onclick="TargetBtn('home')" ></s:submit>
		     </td>
		  </tr>
		 </table> 
        </s:form> 
		<table
				class="am-table am-table-bd am-table-striped admin-content-table">
				<thead>
					<tr>
						<th>领用资产名称</th>
						<th>领用资产数量</th>
						<th>领用时间</th>
						<th>当前状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				<s:iterator value="#request.list" id="asset">
					<tr>
						<td> <s:property value="#asset.deptId"/> </td>
						<td> <s:property value="#dept.deptName"/> </td>
						<td align="center"><s:a href="deptAction_Remove.action?dept.deptId=%{#dept.deptId}"
						    onclick="return del()">归还</s:a></td>
					</tr>
				</s:iterator>
                </tbody>
			</table>
		</div>
		<div class="am-u-sm-12" align="center">
	    <s:iterator value="pageBean">    
        <tr >    
         <td colspan="6" align="center" bgcolor="#5BA8DE">    
                       共<s:property value="allRow"/>条记录        
                       共<s:property value="totalPage"/>页        
                       当前第<s:property value="currentPage"/>页<br />    
         <s:if test="%{currentPage == 1}">    
                                    第一页  上一页    
         </s:if>    
         <!-- currentPage为当前页 -->    
         <s:else>    
           <a href="deptAction_Pageforweb.action?page=1">第一页</a>    
           <a href="deptAction_Pageforweb.action?page=<s:property value="%{currentPage-1}"/>">上一页</a>    
         </s:else>    
         <s:if test="%{currentPage != totalPage}">    
         <a href="deptAction_Pageforweb.action?page=<s:property value="%{currentPage+1}"/>">下一页</a>    
         <a href="deptAction_Pageforweb.action?page=<s:property value="totalPage"/>">最后一页</a>    
         </s:if>    
         <s:else>    
                                    下一页  最后一页    
         </s:else>    
         </td>    
        </tr>    
    </s:iterator>
	</div>
    </div>
 
<div id="myModal" class="reveal-modal">
					<h2 align="center">确认领用</h2>
					<s:form action="AssetPickAction_home.action"  namespace="/">
					<table>
					<tr>
					<s:label id="A11" property value=""/></tr>
					<tr>领用人<s:label id="A22"property value=""/></tr>
					<tr>领用时间<s:label id="A33"property value=""/></tr>
					<tr><s:submit value="确认"></s:submit></tr>
					</table>
					<p><button>确认</button></p>
					</s:form>
			</div>
</body>
</html>