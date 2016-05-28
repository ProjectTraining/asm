<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>部门管理--部门列表</title>
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
            function TargetBtn(flag,id){ 
             	var form1 = document.getElementById('form1');
             	var name=document.getElementById(id).value;
             	//alert(name);
                form1.action="deptAction_"+flag+".action?deptname="+name;  // 
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
		        <s:label>根据部门名称查询：</s:label>
		        <s:textfield id="findDeptName" name="dept.deptName" label="部门名称：" value="" ></s:textfield>
		     </td>
		  </tr>
		  <tr>
		  	 <td style="width:40%">
		       <input id='addDeptName' type="button" name="btn1" value="增加部门"  onclick="TargetBtn('AddDept')"></input>
		     </td>
		     <td style="width:60%">
		       <s:submit id='bbb' value="查询" onclick="TargetBtn('Pageforweb','findDeptName')" ></s:submit>
		     </td>
		  </tr>
		 </table> 
        </s:form> 
		<table
				class="am-table am-table-bd am-table-striped admin-content-table">
				<thead>
					<tr>
					    <th></th>
						<th>部门名称</th>
						<th>删除操作</th>
						<th>修改操作</th>
					</tr>
				</thead>
				<tbody>
				<s:iterator value="#request.list" id="dept">
					<tr>
						<td> <input type="hidden" id="assetPickId" name="assetId" value="${dept.deptId}" /> </td>
						<td> <s:property value="#dept.deptName"/> </td>
						<td ><s:a href="deptAction_Remove.action?dept.deptId=%{#dept.deptId}"
						    onclick="return del()">删除</s:a></td>
				        <td><s:a
						      href="deptAction_DeptInfo.action?dept.deptId=%{#dept.deptId}"  onclick="return del()">修改</s:a></td>
					</tr>
				</s:iterator>
                </tbody>
			</table>
		</div>
	</div>
	<div class="am-u-sm-12">
	<s:iterator value="pageBean">    
        <tr>    
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
</body>
</html>