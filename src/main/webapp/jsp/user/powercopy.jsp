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
    <title>权限管理</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <%--引入JQueryEasyUI--%>
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

    <script>
//        function getPowerTree() {
//            $.ajax({
//                url: 'user/power_getAll.action',
//                dataType: "json",
//                async: false,
//                success: function (data) {
//                    var datajson = eval(data);
//                    d = new dTree("d");
//                    d.add(0, -1, "权限设置");
//                    var powers = datajson.powers;
//                    for (var i = 0; i < powers.length; i++) {
//                        d.add(powers[i].id, powers[i].parentPower, powers[i].name, '', powers[i].url);
//                    }
//                    document.getElementById("right").innerHTML = d;
//                }
//            });
//        }
        //弹出dialog
        function showDialog(operatotion, nodeId) {
            $('#dd').dialog({
                title: '添加权限',
                width: 350,
                height: 160,
            });
//            添加时，把本节点作为父节点，传值到父节点的input中
            if (operatotion == 'add') {
                $('#nodeId').val(''); //节点id的input中值清空
                $('#parentId').val(nodeId);
            }
            //修改时，把本节点的信息加载到dialog中
            if (operatotion == 'update') {
                $('#parentId').val('');//父节点的input中值清空
                //加载节点信息
                $('#nodeId').val(nodeId);//id
//                $('#name').
            }
            $('#dd').dialog('open'); //打开dialog
        }
        //匹配数字，拿到节点id
        function shuzi(str) {
            var pattern = /\d+/;
            var nodeid = str.match(pattern);
            return nodeid;
        }
        //加载角色
        $(function () {
            $.ajax({
                url: 'user/user_ajaxGetAllType.action',
                dataType: "json",
                success: function (data) {
                    var datajson = eval(data);
                    for (var i = 0; i < datajson.types.length; i++) {
                        $('#left_ul').append("<li >" + datajson.types[i].ut_name + "</li>");
                    }
                }
            });
            //加载权限树,利用dtree插件
            getPowerTree();
            //键菜单按钮。
//            1.禁用浏览器自带的右键菜单
            var table = document.getElementById('container');
            table.oncontextmenu = function () {
                return false;
            }
//            2.给每个节点添加右键菜单
            $('.dtreeNode').mousedown(function (event) {
                var thisNode = $(this).find("img:last").attr("id");//获得点击的节点id，  id="id*" *是数字
                var $nodeId = shuzi(thisNode); //用正则拿到点击的节点正真id
                if (event.which == 3) { //判断是否是右键点击， 1 = 鼠标左键 left; 2 = 鼠标中键; 3 = 鼠标右键
                    var div = $("#nodeMenu");
                    if (div.is(":hidden")) {
                        div.show();
                        div.css("left", document.body.scrollLeft + event.pageX + 1);
                        div.css("top", document.body.scrollLeft + event.pageY);
                    } else {
                        div.hide();
                    }
                    //添加节点
                    $('#addNode').click(function () {
                        showDialog("add", $nodeId);

                    });
                    //删除
                    $('#deleteNode').click(function () {
                        $.ajax({
                            type: 'post',
                            url: 'user/power_delete.action',
                            data: "id=" + $nodeId,
                            success: function () {
                                div.hide(); //关闭右键菜单
                                getPowerTree();
                                $.messager.show({
                                    title: '提示信息',
                                    msg: '操作成功',
                                    timeout: 3000,
                                    showType: 'slide'
                                });
                            }
                        });
                    });
                    //修改
                    $('#updateNode').click(function () {
                        showDialog("update", $nodeId);
                    });
                }
            });

        });
    </script>
    <style>
        #container {
            margin: 0;
        }

        #left {
            width: 30%;
            height: 450px;
            /*background-color: blue;*/
            float: left;
        }

        #right {
            width: 300px;
            height: 450px;
            /*background-color: crimson;*/
            float: left;
        }

        ul {
            list-style-type: circle;
        }
    </style>
</head>
<body>
<div id="container">
    <div id="left">
        <ul id="left_ul">

        </ul>
    </div>
    <div id="right" class="dtree">

    </div>
</div>
<div id="nodeMenu" style="display: none;position: absolute;background-color: darkgray">
    <div id="addNode"><img src="js/jquery-easyui-1.2.6/themes/icons/edit_add.png" alt="">增加</div>
    <div id="deleteNode"><img src="js/jquery-easyui-1.2.6/themes/icons/cancel.png" alt="">删除</div>
    <div id="updateNode"><img src="js/jquery-easyui-1.2.6/themes/icons/pencil.png" alt="">修改</div>
</div>
<%--添加节点dialog--%>
<div id="dd" id="dd" class="easyui-dialog" title="添加客户" modal=true
     style="width: 400px;"
     data-options="iconCls:'icon-save',resizable:true"
     closed=true>
    <form action="user/power_add.action" method="post" id="powerForm">
        <%--父节点id,添加时用--%>
        <input type="text" name="parentPower" id="parentId">
        <%--该节点id，删除和修改时候用--%>
        <input type="text" name="id" id="nodeId"/>
        <table>
            <tr>
                <td> 权限名</td>
                <td><input type="text" id="name" name="name"/></td>
            </tr>
            <tr>
                <td>URL</td>
                <td><input type="text" id="url" name="url"/></td>
            </tr>
            <tr>
                <td>备注</td>
                <td><input type="text" id="remark" name="remark"/></td>
            </tr>
        </table>
        <div style="margin-left: 50px">
            <a id="btn1" class="easyui-linkbutton">保存</a>
            <a id="btn2" class="easyui-linkbutton">关闭</a>
        </div>
    </form>
</div>
</body>
</html>
