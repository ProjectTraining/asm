<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<script type="text/javascript">  
            function del(){  
                if(confirm("Are you sure?")){  
                    return true;  
                }  
                return false;  
            }  
    </script>
<title>添加商品入库</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="assets/css/amazeui.min.css" />
<link rel="stylesheet" href="assets/css/admin.css" />
</head>

<body>
	<div class="am-g">
		<div class="am-u-sm-11">
			<form name="form1" method="post"
				action="assetSortAction_addSort.action">
				<div align="center">
					<center>
						<table
							class="am-table am-table-bd am-table-striped admin-content-table"
							border="1" width="100%" cellspacing="0">

							<tr>
								<td width="27%" bgcolor="#DDDDFF" align="center">资产编号：</td>
								<td width="73%" bgcolor="#DDDDFF"><input type="text"
									placeholder="请输入资产编号" name="assetSortCode" id="assetSortCode"
									size="40">
								</td>
							</tr>
							<tr>
								<td width="27%" bgcolor="#DDDDFF" align="center">资产名：</td>
								<td width="73%" bgcolor="#DDDDFF"><input type="text"
									placeholder="请输入资产名" name="assetSortName" id="assetSortName"
									size="40">
								</td>
							</tr>
							<tr>
								<td width="27%" bgcolor="#DDDDFF" align="center">上级资产编号：</td>
								<td width="73%" bgcolor="#DDDDFF"><input type="text"
									placeholder="请输入上级资产编号" name="parentId" id="parentId" size="40">
								</td>
							</tr>
							<tr>
								<td width="27%" bgcolor="#DDDDFF" align="center">上级资产名：</td>
								<td width="73%" bgcolor="#DDDDFF"><input type="text"
									placeholder="请输入上级资产名" name="parentName" id="parentName"
									size="40">
								</td>
							</tr>
							<tr>
								<td width="30%" bgcolor="#DDDDFF" colspan="2"><div
										align="center">
										<center>
											<p>
												<input type="submit" tabindex="3" onclick="return del()"
													value="添加资产" />&nbsp;&nbsp; &nbsp;&nbsp;<input
													type="reset" value="清除" name="B2" tabindex="11" />
											</p>
										</center>
									</div>
								</td>
							</tr>

						</table>
					</center>
				</div>
			</form>
		</div>
	</div>
</body>
</html>


