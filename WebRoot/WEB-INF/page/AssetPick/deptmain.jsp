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
                if(confirm("你确定要删除吗?")){  
                    return true;  
                }  
                return false;  
            }  
            function returnAsset(){  
                if(confirm("你确定要归还资产吗?")){  
                    return true;  
                }  
                return false;  
            }  
            function InquireDept(){  // 点击按钮的一个函数，然后 action="deptAction_home.action",不过此处有问题，没跳转到
                var form = document.getElementById('form1');
                form.action="AssetPickAction_ListData.action";
                form.submit();
           }
            function TargetBtn(f,flag,id){ 
             	var form1 = document.getElementById(f);
             	var name=document.getElementById(id).value;
             	//document.getElementById("A33").value
            	//alert(flag,id);
                form1.action="AssetPickAction_"+flag+".action?assetname="+name;  //+flag 
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
		        <s:textfield id="finaAssetbyname" name="Asset.assetName" label="资产名称：" value="" ></s:textfield>
		     </td>
		     <td style="width:60%">
		       <s:submit id='Assetbyname' value="查询" onclick="TargetBtn('form1','FindAssetByName','finaAssetbyname')" ></s:submit>
		     </td>
		  </tr>
		 </table> 
        </s:form> 
		<table
				class="am-table am-table-bd am-table-striped admin-content-table">
				<thead>
					<tr>
					    <th></th>
						<th>资产名称</th>
						<th>入库时间</th>
						<th>资产总数量</th>
						<th>可领用数量</th>
						<th>状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				<s:iterator status="st" value="#request.list" id="asset">
					<tr>
					    <td><input type="hidden" id="assetId7${asset.assetId}*8" name="assetId" value="${asset.assetId}" /></td>
						<td id="Name${asset.assetId}"> <s:property  value="#asset.assetName"/> </td>
						<td id="Date${asset.assetId}" >  <s:date format="yyyy- MM-dd hh:mm:ss" name="#asset.inStockDate"/></td>
						<td id="Name${asset.assetId}" > <s:property  value="#asset.num"/> </td>
						<td> <s:property value="#asset.num"/> </td>
						<td> <s:if test="%{#asset.stockState==1}" >可领用</s:if>
						     <s:else>不可领用</s:else></td>
						<td><s:a href="#" onclick="js_method(this)" data-reveal-id="myModal" data-animation="none">领用</s:a></td>
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
							<a href="AssetPickAction_Home.action?Assetpage=1">第一页</a>
							<a
								href="AssetPickAction_Home.action?Assetpage=<s:property value="%{currentPage-1}"/>">上一页</a>
						</s:else> <s:if test="%{currentPage != totalPage}">
							<a
								href="AssetPickAction_Home.action?Assetpage=<s:property value="%{currentPage+1}"/>">下一页</a>
							<a
								href="AssetPickAction_Home.action?Assetpage=<s:property value="totalPage"/>">最后一页</a>
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
		        <s:textfield id="finaAssetPickbyname" name="Asset.assetName" label="资产名称：" value="" ></s:textfield>
		     </td>
		     <td style="width:60%">
		       <s:submit id='AssetPickbyname' value="查询" onclick="TargetBtn('form2','FindAssetPickByName','finaAssetPickbyname')" ></s:submit>
		     </td>
		  </tr>
		 </table> 
        </s:form> 
		<table
				class="am-table am-table-bd am-table-striped admin-content-table">
				<thead>
					<tr>
					    <th></th>
						<th>领用资产名称</th>
						<th>领用时间</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				<s:iterator value="#request.listAssetPick" id="assetpick">
					<tr>
					<td> <input type="hidden" id="assetPickId" name="assetId" value="${assetpick.assetPickId}" /></td>
					<td> <s:property value="#assetpick.asset.assetName"/> </td>
					<td> <s:property value="#assetpick.pickDate"/> </td>
					<td align="center"><s:a href="AssetPickAction_PageforAssetReturn.action?assetPick.assetPickId=%{#assetpick.assetPickId}"
						    onclick="return returnAsset()">归还</s:a></td>
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
           <a href="AssetPickAction_Home.action?page=1">第一页</a>    
           <a href="AssetPickAction_Home.action?page=<s:property value="%{currentPage-1}"/>">上一页</a>    
         </s:else>    
         <s:if test="%{currentPage != totalPage}">    
         <a href="AssetPickAction_Home.action?page=<s:property value="%{currentPage+1}"/>">下一页</a>    
         <a href="AssetPickAction_Home.action?page=<s:property value="totalPage"/>">最后一页</a>    
         </s:if>    
         <s:else>    
                                    下一页  最后一页    
         </s:else>    
         </td>    
        </tr>    
    </s:iterator>
	</div>
    </div>
    <div align="center" id="myModal" class="reveal-modal">
					<h2 align="center">确认领用</h2>
					<s:form action="AssetPickAction_AssetApply.action"  namespace="/" id="form1" name="form1" method="post">
					<input type="hidden" id="Aid" name="assetId" value="assetId" /> 
					<table align="center" style="height:10px border:10px width:100px">
					<tr><td style="height:10px border:1px width:40px"><s:label>资产名称 :</s:label></td>
					    <td style="height:10px border:1px width:40px"><s:textfield readonly="true" id="A11" /></td>
					    </tr>
					<tr><td style="height:10px border:1px width:40px"><s:label>资产数量 :</s:label></td>
					    <td style="height:10px border:1px width:40px"><s:textfield   readonly="true"  id="A22" /></td>
					</tr>
					<tr><td style="height:10px border:1px width:40px"><s:label>领用时间 :</s:label></td>
					    <td style="height:10px border:1px width:40px"><s:textfield  readonly="true" id="A33" name="assetPick.pickDate"/></td>
					    <td><s:date id="A44" format="yyyy- MM-dd hh:mm:ss" name="assetPick.pickDate" nice="false"></s:date></td>
					</tr>
					<tr><td align="center"  colspan='2'></td></tr>
					</table>
					<s:submit  style="width:20%" value="确认提交"></s:submit> 
			</s:form>
	</div>
	<script>
	function js_method(data){
		  var tr = $(data).parent().parent();//tr对象
          var tdcon = [];//本行所有数据
         // var a1=new Array();
          tr.find('td').each(function(i,td){
              if($(td).find('a').length == 0){//过滤修改列  <s:property  value="#asset.inStockDate"/>
                  tdcon.push($(td).html());
                 // a1.push($(td).html());  
              }
          });
          var ht=tdcon[0];///  indexOf()
          var hehe=tdcon[0].substring(ht.indexOf("7")+1,ht.indexOf("*8"));
		document.getElementById("Aid").value=tdcon[0].substring(ht.indexOf("7")+1,ht.indexOf("*8"));/// 资产名称
		     //a1.shift();  获取数组的第一个数据，然后删除
		document.getElementById("A11").value=hehe;//tdcon[1]; 
		document.getElementById("A22").value=tdcon[3];    //  资产数量
		//document.getElementById("A33").value=tdcon[2];    //  申请领用时间
		//document.getElementById("A44").value=tdcon[2];    //  申请领用时间
		//document.setElementById("assetPickId").value
		// 比如需要这样的格式 yyyy-MM-dd hh:mm:ss,将时间戳转化为时间格式 ,s:date
		var date = new Date();
		Y = date.getFullYear() + '-';
		M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
		D = date.getDate() + ' ';
		h = date.getHours() + ':';
		m = date.getMinutes() + ':';
		s = date.getSeconds(); 
		document.getElementById("A33").value=Y+M+D;
/* 		document.getElementById("A11").value=date.toLocaleDateString(); //获取当前日期
		document.getElementById("A22").value==date.toLocaleTimeString(); //获取当前时间
		document.getElementById("A33").value=date.toLocaleString( ); //获取日期与时 */
		//console.log(Y+M+D+h+m+s); 
	}
    $("bb").click(
    		function(){
    	      $("#A11").val();
    	      alert("fhdgjdfg");
    	      document.getElementById("A11").value="hello";
    	      $("A22").append("领用人zhaonan");
    	      $("A33").append("领用时间zhaonan");
	});
	</script>
</body>
</html>