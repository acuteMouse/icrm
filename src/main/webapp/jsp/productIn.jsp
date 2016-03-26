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

		<title>进货-----</title>

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
		<link rel="stylesheet" type="text/css" href="css/common.css" />
		<script type="text/javascript"
			src="js/jquery-easyui-1.2.6/jquery.easyui.min.js"></script>
		<script type="text/javascript"
			src="js/jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript">
	$(function() {
		//加载数据表格 
		var flag = '';
		$('#dg').datagrid( {
			toolbar : [ {
				text : '添加信息',
				iconCls : 'icon-add',
				handler : function() {
					flag = 'add';
					$('#dd').dialog( {
						title : '添加信息'
					});
					$('#dd').dialog('open');
					$('#myform').find('input').val('');

				}
			} ],
			pagination:true,
			url : 'selectProductIn',
			idField : 'id',
			frozenColumns : [ [ {
				field : 'checkbox',
				width : 50,
				checkbox : true
			} ] ],
			
			striped : true,
			columns : [ [ {
				field : 'id',
				title : 'ID',
				width : 100
			}, {
				field : 'name',
				title : '产品名称',
				width : 100
			}, {
				field : 'price',
				title : '价格',
				width : 100
			} 
			, {
				field : 'number',
				title : '数量',
				width : 100
			}, {
				field : 'inTime',
				title : '购买日期',
				width : 100
			}, {
				field : 'inWho',
				title : '购买人',
				width : 100
			}, {
				field : 'inFrom',
				title : '供货商',
				width : 100
			}] ],

			fitColumns : true
		});
		//保存按钮
		$('#btn1').click(
				function() {
					if ($('#myform').form('validate')) {
						$.ajax( {
							type : 'post',
							url : flag="add"?'addProductIn':"updateProductIn",
							data : $('#myform').serialize(),
							dataType : 'json',
							success : function() {
								$('#dd').dialog('close');
								$('#dg').datagrid('reload');
								$.messager.show( {
									title : '提示信息',
									msg : '操作成功',
									timeout : 3000,
									showType : 'slide'
								});
							},
							error : function(result) {
								$.messager.show( {
									title : result.status,
									msg : result.message,
									timeout : 3000,
									showType : 'slide'
								});
							}
						});
					} else {
						$.messager.show( {
							title : '提示信息',
							msg : '请确保输入的数据格式等正确',
							timeout : 3000,
							showType : 'slide'
						});

					}
				});
		//关闭按钮
		$('#btn2').click(function() {
			$('#dd').dialog('close');
		});
	});
</script>
	</head>

	<body>
		<table id="dg"></table>
		<div id="dd" class="easyui-dialog" title="添加员工" modal=true
			style="width: 400px;"
			data-options="iconCls:'icon-save',resizable:true,modal:true"
			closed=true>
			<form id="myform" method="post" style="text-align: center;">
				<input type="hidden" value=" " name="id">
				<div>
					<label for="name">
						产品名称:
					</label>
					<input class="easyui-validatebox" type="text" name="name"
						required="true"></input>
				</div>
				<div>
					<label for="price">
						价格
					</label>
					<input class="easyui-validatebox" type="text" name="price"
						required="true"></input>
				</div>
				<div>
					<label for="number">
						数量
					</label>
					<input class="easyui-validatebox" type="text" name="number"
						required="true"></input>
				</div>
				<div>
					<label for="inTime">
						购买时间
					</label>
					<input class="easyui-datetimebox" type="text" name="inTime"
						 data-options="required:true,editable:false"></input>
				</div>
				<div>
					<label for="inWho">
						购买人
					</label>
					<input class="easyui-validatebox" type="text" name="inWho"
						required="true"></input>
				</div>
				<div>
					<label for="inFrom">
						供货商
					</label>
					<input class="easyui-validatebox" type="text" name="inFrom"
						required="true"></input>
				</div>
				<div>
					<a id="btn1" class="easyui-linkbutton">保存</a>
					<a id="btn2" class="easyui-linkbutton">关闭</a>
				</div>
			</form>
		</div>

	</body>
</html>
