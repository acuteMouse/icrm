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
