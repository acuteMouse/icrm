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
                                msg: '一次只能修改一个',
                                timeout: 3000,
                                showType: 'slide'
                            });
                        } else {
                            $('#dd').dialog({
                                title: '修改信息'
                            });
                            $('#dd').dialog('open');
                            $('#myform').find('input').val('');
                            $('#myform').form('load', {
                                id: arr[0].id,
                                name: arr[0].name,
                                number: arr[0].number,

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
                        $.ajax({
                            url:'customer/getCustomerType.action',
                            type:"json",
                            success:function(data){
                                var datajson=eval(data);
//                                datajson格式：｛types:[{},{},{}]}
//                                alert(datajson.types[0].ct_name);
                                for(var i=0;i<datajson.types.length;i++){
                                    $('#customerType').append("<option value='Value'>"+datajson.types[i].ct_name+"</option>");
                                }
//                    $('input[name="c_type"]')
                            }
                        });//加载客户类型的下拉框
//                        $.ajax({
//                            url:'customer_getCustomerType.action',
//                            success:function(data){
//                                var dataList=eval(date);
//                                alert(dataList.length);
////                    $('input[name="c_type"]')
//                            }
//                        });//加载客户行业的下拉框
                    }
                }],
                pagination: true,
                url: 'customer/getAllCustomer.action',
                idField: 'c_id',
                frozenColumns: [[{
                    field: 'checkbox',
                    width: 50,
                    checkbox: true
                }]],
                striped: true,
                columns: [[
                    {field: 'c_id', title: 'ID', width: 100},
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

                fitColumns: true
            });
            //保存按钮，ajax提交表单
            $('#btn1').click(
                    function () {
                        if ($('#myform').form('validate')) {
                            $.ajax({
                                type: 'post',
                                url: 'updateProduct',
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
                                        timeout: 3000,
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
    </script>
</head>

<body>
<table id="dg"></table>
<div id="dd" class="easyui-dialog" title="添加客户" modal=true
     style="width: 400px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true"
     closed=true>
    <form id="myform" method="post" style="text-align: center;">
        <input type="hidden" value="" name="id">
        <div>
            <label for="c_name">
                名称:
            </label>
            <input class="easyui-validatebox" type="text" name="c_name"
                   required="true"/>
        </div>

        <div>
            <label for="c_telphone">
                联系电话：
            </label>
            <input class="easyui-validatebox" type="text" name="c_telphone"
                   required="true"/>
        </div>
        <div>
            <label for="c_eamail">
                邮箱：
            </label>
            <input class="easyui-validatebox" data-options="validType:'email'" name="c_eamail"
                   required="true"/>
        </div>
        <div>
            <label for="c_address">
                地址：
            </label>
            <input class="easyui-validatebox" type="text" name="c_address"
                   required="true"/>
        </div>
        <div>
            <label for="c_industry">
                行业：
            </label>
            <input class="easyui-validatebox" type="text" name="c_industry"
                   required="true"/>
        </div>
        <div>
            <label for="c_type">
                客户类型：
            </label>
            <select id="customerType">
                <option value="">请选择</option>
            </select>
        </div>


        <div>
            <a id="btn1" class="easyui-linkbutton">保存</a>
            <a id="btn2" class="easyui-linkbutton">关闭</a>
        </div>
    </form>
</div>

</body>
</html>
