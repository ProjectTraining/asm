<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<TITLE></TITLE>
   <link href="LigerUI/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <link href="LigerUI/ligerUI/skins/Gray/css/all.css" rel="stylesheet" type="text/css" />
    <link href="LigerUI/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
    <link href="css/adddelmod.css" rel="stylesheet" type="text/css" />
    <script src="script/jquery.form.js"	type=text/javascript></script>
    <script src="LigerUI/ligerUI/js/core/base.js" type="text/javascript"></script> 

<script type="text/javascript" src="script/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="script/highcharts.js"></script> 
<script type="text/javascript" src="script/modules/exporting.js"></script> 

<SCRIPT type="text/javascript">
var chart; 
$(function(){
    SubmitQueryPO();
   
}); 

</SCRIPT>

<style type="text/css">



</style>
</HEAD>

  <div position="top" title="" style="height:50;padding-left:20%;padding-top:10px;">
            	<!-- 查询条件部分 -->
            	<div>

            		<form id="searchForm" name="searchForm" class="l-form liger-form" method="post">
		            	<table id="searchTable" class="searchTable">
		            		<tr>
		            	<th>
					            	资产名称：
					            </th>
		            			<td>
					            		<select id="assetSortId" name="assetSortId"  style="width:105px">
						 <option value=""></option>
    					 <s:iterator value="assetSortList" var="c1">
    					  	<option value="${c1.assetSortId}">${c1.assetSortName}</option>
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
            </div> <hr />
            <div position="center" title="";style="height:70%;padding-top:50px;">
            	<!-- 数据集部分 -->
			<div id="highcharts1" style="min-width:400px;padding-top:50px;height:70%;margin:0 auto;"> 

            </div>
<!-- 新建一个容器，存放在head部分定义的Chart内容 。这里的id一定是chart : {...}内的renderTo的值-->

<script>

function SubmitQueryPO(){
	var assetSortId= $("#assetSortId").val();
	 var x = [];//X轴
    var y = [];//Y轴
    var xtext =new Array("张三","李四");//X轴TEXT
    var color = ["gray","pink","red","blue","yellow","green","#fff"];
    $.ajax({
        type:'get',
        url:'chartAction_chartData.action?assetSortId='+assetSortId,//请求数据的地址
        success:function(data){
        	
        	
        	var json = eval(data);
   
        	
    
            var s = 1;
            for(var key in json.list){
                json.list[key].y = json.list[key].age; //给Y轴赋值
               //xtext = json.list[key].name;//给X轴TEXT赋值
                xtext[key]= json.list[key].name.toString();
               // alert(xtext[key]);
                json.list[key].color= color[key];
            }
             var chart = new Highcharts.Chart({
        chart:{
            renderTo:'highcharts1',
            type:'column' //显示类型 柱形
        },
        title:{
            text:'资产类别分布图' //图表的标题
        },
        xAxis:{
            categories:xtext,
            labels:{y:18}
        },
        yAxis:{
            title:{
                text:'资产总额(元)' //Y轴的名称
            },
             lineWidth: 2 //基线宽度 
        },
        plotOptions: {
    column: {
        pointPadding: 0.2,
        borderWidth: 1,
        pointWidth: 50
    }
},
        series:[{
            name:"类别名称"
        }]
    });
            
                chart.series[0].setData(json.list);//数据填充到highcharts上面
                
                
                
        },
        error:function(e){
        } 
    });
   
}


</script>
</HTML>
