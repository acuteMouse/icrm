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

    <title>--用户信息--</title>

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
        //        ajax加载用户类型
        function ajaxGetUserType() {
            $.ajax({
                url: 'user/user_ajaxGetAllType.action',
                dataType: "json",
                success: function (data) {
                    var datajson = eval(data);
//                                datajson格式：｛types:[{},{},{}]}
//                                alert(datajson.types[0].ct_name);
                    var optionNumber = $('#role').find('option').length;
//                                alert(optionNumber);
//                                防止重复加载
                    if (optionNumber <= datajson.types.length) {
                        for (var i = 0; i < datajson.types.length; i++) {
                            $('#role').append("<option value='" + datajson.types[i].id + "'>" + datajson.types[i].ut_name + "</option>");
                        }
                    }
                }
            });
        }
        //        ajax 加载部门信息
        function ajaxGetDepartment() {
            $.ajax({
                url: 'user/department_ajaxGetAll.action',
                dataType: "json",
                success: function (data) {
                    var datajson = eval(data);
//                                datajson格式：｛types:[{},{},{}]}
//                                alert(datajson.types[0].ct_name);
                    var optionNumber = $('#department').find('option').length;
//                                alert(optionNumber);//初始的时候都只有一个，一旦第二次加载，当前的option数量一定是大于要加载的数量
//                                防止重复加载下拉框
                    if (optionNumber <= datajson.departments.length) {
                        for (var i = 0; i < datajson.departments.length; i++) {
                            $('#department').append("<option value='" + datajson.departments[i].id + "'>" + datajson.departments[i].d_name + "</option>");
                        }
                    }
                }
            });
        }
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
                            ajaxGetDepartment();
                            ajaxGetUserType();
                            $('#myform').form('load', {
                                id: arr[0].id,
                                c_name: arr[0].c_name,
                                c_telphone: arr[0].c_telphone,
                                c_address: arr[0].c_address,
                                c_email: arr[0].c_email,
                            });

                        }
                    }
                }, {
                    text: '添加',
                    iconCls: 'icon-add',
                    handler: function () {
                        flag = 'add';
                        $('#dd').dialog({
                            title: '添加'
                        });
                        $('#dd').dialog('open'); //打开dialog
                        $('#myform').find('input').val('');//清空表单类容
                        ajaxGetDepartment();//异步加载部门
                        ajaxGetUserType();
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
                                        url: 'customer/customer_deleteCustomer.action',
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
                                }
                            });

                        }

                    }

                }
                ],
                pagination: true,
                url: 'user/user_getAll.action',
                idField: 'id',
                frozenColumns: [[{
                    field: 'checkbox',
                    width: 50,
                    checkbox: true
                }]],
                striped: true,
                columns: [[
                    {field: 'id', title: 'ID', width: 100},
                    {field: 'u_trueName', title: '名称', width: 100},
                    {field: 'u_address', title: '地址', width: 100},
                    {field: 'u_age', title: '年龄', width: 100},
                    {field: 'u_sex', title: '性别', width: 100},
                    {field: 'u_telphone', title: '联系电话', width: 100},
                    {field: "u_startDate", title: '入职日期', width: 100},
                    {
                        field: 'u_role', title: '用户类型', width: 100,
                        formatter: function (value, row, index) {
                            return new Object(row["u_role"]).ct_name;
                        }
                    },
                    {
                        field: 'u_department', title: '部门', width: 100,
                        formatter: function (value, row, index) {
                            return new Object(row["u_department"]).ct_name;
                        }
                    },
                    {field: 'u_remark', title: "备注", width: 100},

                ]],
//                设置分页初始值，可选项
                pageNumber: 1,
                pageSize: 15,
                AllowPaging: true,
                pageList: [15, 25, 35, 45, 55],
                fitColumns: true
            });
            //保存按钮，ajax提交表单
            $('#btn1').click(
                    function () {
                        if ($('#myform').form('validate')) {
                            $.ajax({
                                type: 'post',
                                url: flag == 'add' ? 'user/user_add.action' : 'user/user_update.action',
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
            $(".tabs-header").bind('contextmenu', function (e) {
                e.preventDefault();
                $('#rcmenu').menu('show', {
                    left: e.pageX,
                    top: e.pageY
                });
            });
            //关闭当前标签页
            $("#closecur").bind("click", function () {
                var tab = $('#tab').tabs('getSelected');
                var index = $('#tab').tabs('getTabIndex', tab);
                $('#tab').tabs('close', index);
            });
            //关闭所有标签页
            $("#closeall").bind("click", function () {
                var tablist = $('#tab').tabs('tabs');
                for (var i = tablist.length - 1; i >= 0; i--) {
                    $('#tab').tabs('close', i);
                }
            });
            //关闭非当前标签页（先关闭右侧，再关闭左侧）
            $("#closeother").bind("click", function () {
                var tablist = $('#tab').tabs('tabs');
                var tab = $('#tab').tabs('getSelected');
                var index = $('#tab').tabs('getTabIndex', tab);
                for (var i = tablist.length - 1; i > index; i--) {
                    $('#tab').tabs('close', i);
                }
                var num = index - 1;
                for (var i = num; i >= 0; i--) {
                    $('#tab').tabs('close', 0);
                }
            });
            //关闭当前标签页右侧标签页
            $("#closeright").bind("click", function () {
                var tablist = $('#tab').tabs('tabs');
                var tab = $('#tab').tabs('getSelected');
                var index = $('#tab').tabs('getTabIndex', tab);
                for (var i = tablist.length - 1; i > index; i--) {
                    $('#tab').tabs('close', i);
                }
            });
            //关闭当前标签页左侧标签页
            $("#closeleft").bind("click", function () {
                var tab = $('#tab').tabs('getSelected');
                var index = $('#tab').tabs('getTabIndex', tab);
                var num = index - 1;
                for (var i = 0; i <= num; i++) {
                    $('#tab').tabs('close', 0);
                }
            });
        })

    </script>
    <style type="text/css">

    </style>
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
        <table id="dialogTable">
            <tr>
                <td> 姓名:</td>
                <td><input class="easyui-validatebox" type="text" name="u_name" data-options="required:true"/></td>
            </tr>
            <tr>
                <td>
                    性别：
                </td>
                <td>
                    <input class="easyui-validatebox" type="text" name="u_sex" data-options="required:true"/>
                </td>
            </tr>
            <tr>
                <td>
                    电话：
                </td>
                <td>
                    <input class="easyui-validatebox" type="text" name="u_telphone"
                           data-options="required:true,validType:'length[7,11]'"/>
                </td>
            </tr>
            <tr>
                <td>
                    年龄：
                </td>
                <td>
                    <input class="easyui-validatebox" data-options="required:true" name="u_age"/>
                </td>
            </tr>
            <tr>
                <td>
                    地址：
                </td>
                <td>
                    <input class="easyui-validatebox" type="text" name="u_address" data-options="required:true"/> </br>
                </td>
            </tr>
            <tr>
                <td>
                    入职日期：
                </td>
                <td>
                    <input class="easyui-datebox" type="text" name="u_startDate" readonly="readonly"
                           data-options="required:true"/> </br>
                </td>
            </tr>
            <tr>
                <td>
                    部门：
                </td>
                <td>
                    <select id="department" name="departmentId">
                        <option value="">请选择</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    用户类型：
                </td>
                <td>
                    <select id="role" name="userTypeId">
                        <option value="">请选择</option>
                    </select>
                </td>
            </tr>
        </table>


        <div>
            <a id="btn1" class="easyui-linkbutton">保存</a>
            <a id="btn2" class="easyui-linkbutton">关闭</a>
        </div>
    </form>
</div>

<div id="rcmenu" class="easyui-menu" style="">
    <div data-options="iconCls:'icon-cancel'" id="closecur">
        关闭
    </div>
    <div id="closeall">
        关闭全部
    </div>
    <div id="closeother">
        关闭其他
    </div>
    <div class="menu-sep"></div>
    <div id="closeright">
        关闭右侧标签页
    </div>
    <div id="closeleft">
        关闭左侧标签页
    </div>
</div>
</body>
</html>
