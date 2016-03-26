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

		<title>建行塑业产品管理系统</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script type="text/javascript"
			src="js/jquery-easyui-1.2.6/jquery-1.7.2.min.js"></script>
		<link rel="stylesheet" type="text/css"
			href="js/jquery-easyui-1.2.6/themes/default/easyui.css" />
		<link rel="stylesheet" type="text/css"
			href="js/jquery-easyui-1.2.6/themes/icon.css" />
			<link rel="stylesheet" type="text/css"
			href="css/common.css" />
		<script type="text/javascript"
			src="js/jquery-easyui-1.2.6/jquery.easyui.min.js"></script>
		<script type="text/javascript"
			src="js/jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js"></script>

		<script type="text/javascript">
	$(function() {

		$('a[title]')
				.click(
						function() {
							var src = $(this).attr('title');
							var title = $(this).html();
							if ($('#tt').tabs('exists', title)) {
								$('#tt').tabs('select', title);
							} else {
								$('#tt')
										.tabs(
												'add',
												{
													title : title,
													content : '<iframe frameborder=0 style=width:100%;height:100% src=' + src + ' >__tag_42$86_',
													closable : true
												});
							}

						});

	});
	$('#myA').onmuse
</script>
	</head>

	<body>
		<div id="cc" class="easyui-layout" fit=true
			style="width: 100%; height: 100%;">
			<div region="north" title="easyui-layout" split="false"
				style="height: 100px;">${name }欢迎您 </div>
			<!-- 
		    <div region="south" title="South Title" split="true" style="height:100px;"></div>  
		    <div region="east" collapsed=true iconCls="icon-reload" title="East" split="true" style="width:100px;"></div>  
		     -->
			<div region="west" iconCls="icon-ok" split="true" title="菜单"
				style="width: 200px;">
				<div id="aa" class="easyui-accordion" fit=true>
					<div title="管理员管理" style="overflow: auto; padding: 10px;">
						<a  id="myA" title="jsp/ShowAdmin.jsp">管理员列表</a>
					</div>
					<div title="员工管理" style="padding: 10px;">
						<a  id="myA" title="jsp/showStaff.jsp">员工列表</a>
					</div>
					<div title="进货管理" style="padding: 10px;">
						<a  id="myProductIn" title="jsp/productIn.jsp">进货情况</a><br>
						<a  id="myProductIn" title="jsp/product.jsp">库存情况</a>
					</div>
					<div title="销售管理">
					</div>
					<div title="客户管理">
					</div>
					<div title="新闻管理">
					</div>
				</div>
			</div>
			<div region="center" title="主界面" style="padding: 5px;">
				<div id="tt" class="easyui-tabs" fit=true
					style="width: 500px; height: 250px;">

				</div>
			</div>
		</div>

	</body>
</html>
