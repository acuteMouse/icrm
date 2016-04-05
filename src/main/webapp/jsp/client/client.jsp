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
        //        ajax加载客户类型
        function ajaxGetCustomerType() {
            $.ajax({
                url: 'customer/getCustomerType.action',
                dataType: "json",
                success: function (data) {
                    var datajson = eval(data);
//                                datajson格式：｛types:[{},{},{}]}
//                                alert(datajson.types[0].ct_name);
                    var optionNumber = $('#customerType').find('option').length;
//                                alert(optionNumber);
//                                防止重复加载
                    if (optionNumber <= datajson.types.length) {
                        for (var i = 0; i < datajson.types.length; i++) {
                            $('#customerType').append("<option value='" + datajson.types[i].id + "'>" + datajson.types[i].ct_name + "</option>");
                        }
                    }
                }
            });
        }
        //        ajax 加载行业类型
        function ajaxGetIndustryType() {
            $.ajax({
                url: 'customer/getIndustryType.action',
                dataType: "json",
                success: function (data) {
                    var datajson = eval(data);
//                                datajson格式：｛types:[{},{},{}]}
//                                alert(datajson.types[0].ct_name);
                    var optionNumber = $('#industryType').find('option').length;
//                                alert(optionNumber);//初始的时候都只有一个，一旦第二次加载，当前的option数量一定是大于要加载的数量
//                                防止重复加载下拉框
                    if (optionNumber <= datajson.types.length) {
                        for (var i = 0; i < datajson.types.length; i++) {
                            $('#industryType').append("<option value='" + datajson.types[i].id + "'>" + datajson.types[i].i_name + "</option>");
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
                            ajaxGetCustomerType();
                            ajaxGetIndustryType();
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
                    text: '添加客户',
                    iconCls: 'icon-add',
                    handler: function () {
                        flag = 'add';
                        $('#dd').dialog({
                            title: '添加客户'
                        });
                        $('#dd').dialog('open'); //打开dialog
                        $('#myform').find('input').val('');//清空表单类容
//                        加载客户类型的下拉框
                        ajaxGetCustomerType();
                        //加载客户行业类型的下拉框
                        ajaxGetIndustryType();
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
                                        }
                                    });
                                }
                            });

                        }

                    }

                }
                ],
                pagination: true,
                url: 'customer/getAllCustomer.action',
                idField: 'id',
                frozenColumns: [[{
                    field: 'checkbox',
                    width: 50,
                    checkbox: true
                }]],
                striped: true,
                columns: [[
                    {field: 'id', title: 'ID', width: 100},
                    {field: 'c_name', title: '名称', width: 100},
                    {field: 'c_address', title: '地址', width: 100},
                    {field: 'c_telphone', title: '联系电话', width: 100},
                    {field: 'c_email', title: '邮箱', width: 100},
                    {
                        field: 'c_user', title: '负责人', width: 100,
                        formatter: function (value, row, index) {
                            return new Object(row["c_user"]).u_trueName;
                        }
                    },
                    {
                        field: 'c_industry', title: '行业', width: 100,
                        formatter: function (value, row, index) {
                            return new Object(row["c_industry"]).i_name;
                        }
                    },
                    {
                        field: 'c_type', title: '客户类型', width: 100,
                        formatter: function (value, row, index) {
                            return new Object(row["c_type"]).ct_name;
                        }
                    },


                ]],
//                设置分页初始值，可选项
                pageNumber: 1,
                pageSize: 15,
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
                                url: flag == 'add' ? 'customer/customer_addCustomer.action' : 'customer/customer_updateCustomer.action',
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

        })
        ;
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

        名称:
        <input class="easyui-validatebox" type="text" name="c_name"
               required="true"/> </br>


        联系电话：
        <input class="easyui-validatebox" type="text" name="c_telphone"
               required="true"/> </br>
        邮箱：
        <input class="easyui-validatebox" data-options="validType:'email'" name="c_email"
               required="true"/> </br>
        地址：
        <input class="easyui-validatebox" type="text" name="c_address"
               required="true"/> </br>
        行业：
        <select id="industryType" name="industryId">
            <option value="">请选择</option>
        </select> </br>
        客户类型：
        <select id="customerType" name="c_typeId">
            <option value="">请选择</option>
        </select> </br>


        <div>
            <a id="btn1" class="easyui-linkbutton">保存</a>
            <a id="btn2" class="easyui-linkbutton">关闭</a>
        </div>
    </form>
</div>

</body>
</html>
