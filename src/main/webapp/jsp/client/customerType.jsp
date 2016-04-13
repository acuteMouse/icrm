<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
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

    <title>--客户信息--</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <script type="text/javascript"
            src="js/jquery-easyui-1.2.6/jquery-1.7.2.min.js"></script>
    <link rel="stylesheet" type="text/css"
          href="js/jquery-easyui-1.2.6/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css"
          href="js/jquery-easyui-1.2.6/themes/icon.css"/>
    <script type="text/javascript"
            src="js/jquery-easyui-1.2.6/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="js/jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
        $(function () {
            //加载数据表格
            var flag = '';
            $('#dg').datagrid({
                toolbar: [{
                    text: '信息修改',
                    iconCls: 'icon-edit',
                    handler: function () {
                        flag = 'edit';
                        var arr = $('#dg').datagrid('getSelections');
                        if (arr.length != 1) {
                            $.messager.show({
                                title: '提示信息',
                                msg: '请选择要修改的单条信息',
                                timeout: 3000,
                                showType: 'slide'
                            });
                        } else {
                            $('#dd').dialog({
                                title: '修改信息'
                            });
                            $('#dd').dialog('open');
                            $('#myform').find('input').val('');
//                            验证提示清空
                            $('#msg').html("");
                            $('#myform').form('load', {
                                id: arr[0].id,
                                ct_name: arr[0].ct_name,
                            });

                        }
                    }
                }, {
                    text: '添加类型',
                    iconCls: 'icon-add',
                    handler: function () {
                        flag = 'add';
                        $('#dd').dialog({
                            title: '添加类型'
                        });
                        $('#dd').dialog('open'); //打开dialog
                        $('#myform').find('input').val('');//清空表单类容
                    }
                }, {
                    text: '删除',
                    iconCls: 'icon-no',
                    handler: function () {
                        var arr = $('#dg').datagrid('getSelections');
                        if (arr.length < 1) {
                            $.messager.show({
                                title: '提示信息',
                                msg: '请选择至少一行进行删除',
                                timeout: 2000,
                                showType: 'slide'
                            });
                        } else {
                            $.messager.confirm('友情提示', '确定要删除吗？', function (r) {
                                if (!r) {
                                    return '';
                                } else {
                                    var ids = '';
                                    for (var i = 0; i < arr.length; i++) {
                                        ids += arr[i].id + ','; //ids是string类型的，后台接受也应该用一个String的数组
                                    }
                                    ids = ids.substring(0, ids.length - 1);
                                    $.ajax({
                                        url: 'customer/customerType_delete.action',
                                        data: {'ids': ids},//发送数据
                                        type: "post",
                                        success: function () {
                                            $('#dg').datagrid('reload');
                                            $.messager.show({
                                                title: '提示信息',
                                                msg: '操作成功',
                                                timeout: 3000,
                                                showType: 'slide'
                                            });
                                        }
                                    });
                                }
                            });

                        }

                    }

                }
                ],
                pagination: true,
                url: 'customer/customerType_getAll.action',
                idField: 'id',
                frozenColumns: [[{
                    field: 'checkbox',
                    width: 50,
                    checkbox: true
                }]],
                striped: true,
                columns: [[
                    {field: 'id', title: 'ID', width: 100},
                    {field: 'ct_name', title: '名称', width: 100},
                ]],
//                设置分页初始值，可选项
                pageNumber: 1,
                pageSize: 15,
                AllowPaging: true,
                pageList: [15, 25, 35, 45, 55],
                fitColumns: true
            })
            ;
            //保存按钮，ajax提交表单
            $('#btn1').click(
                    function () {
                        if ($('#myform').form('validate')) {
                            $.ajax({
                                type: 'post',
                                url: flag == 'add' ? 'customer/customerType_add.action' : 'customer/customerType_update.action',
                                data: $('#myform').serialize(),
                                dataType: 'json',
                                success: function () {
                                    $('#dd').dialog('close');
                                    $('#dg').datagrid('reload');
                                    $.messager.show({
                                        title: '提示信息',
                                        msg: '操作成功',
                                        timeout: 3000,
                                        showType: 'slide'
                                    });
                                },
                                error: function (result) {
                                    $.messager.show({
                                        title: result.status,
                                        msg: result.message,
                                        timeout: 2000,
                                        showType: 'slide'
                                    });
                                }
                            });
                        } else {
                            $.messager.show({
                                title: '提示信息',
                                msg: '请确保输入的数据格式正确',
                                timeout: 3000,
                                showType: 'slide'
                            });

                        }
                    });
            //关闭按钮
            $('#btn2').click(function () {
                $('#dd').dialog('close');
            });

        });
        function checkTypeIsExited() {
            var typeName = $('input[name="ct_name"]').val();//获取填写的信息
//            alert(typeName);
//            异步验证是否可用
            $.ajax({
                url: "customer/customerType_checkTypeIsExited.action",
                data: "customerType.ct_name=" + typeName,
                type: "post",
                success: function (data) {
                    var msgjson = eval(data);
                    var msg = msgjson.msg;
                    $('#msg').html(msg);
                    if (msg == "可用") {//设置提示信息文字颜色为绿色
                        $('#msg').css({color: "darkgreen"});
                    } else { //颜色设为红色，不可用
                        $('#msg').css({color: "red"});
                    }
                }

            });
        }
    </script>
</head>

<body>
<%--数据表格--%>
<table id="dg"></table>
<%--添加信息框--信息修改框--%>
<div id="dd" class="easyui-dialog" title="添加客户" modal=true
     style="width: 400px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true"
     closed=true>
    <form id="myform" method="post" style="text-align: center;">
        <input type="hidden" value="" name="id">
        客户类型:
        <input class="easyui-validatebox" type="text" name="ct_name" onmouseout="checkTypeIsExited()"
               data-options="required:true"/><span id="msg"></span> </br>
        <div>
            <a id="btn1" class="easyui-linkbutton">保存</a>
            <a id="btn2" class="easyui-linkbutton">关闭</a>
        </div>
    </form>
</div>

</body>
</html>
