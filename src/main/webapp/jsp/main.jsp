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

    <title>CRM</title>

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
    <link rel="stylesheet" type="text/css"
          href="css/common.css"/>
    <script type="text/javascript"
            src="js/jquery-easyui-1.2.6/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="js/jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js"></script>

    <script type="text/javascript">
        $(function () {
            $('a[title]').click(
                    function () {
                        var src = $(this).attr('rel');//rel，值
                        var title = $(this).html();
                        if ($('#tt').tabs('exists', title)) {
                            $('#tt').tabs('select', title);
                        } else {
                            $('#tt').tabs(
                                    'add',
                                    {
                                        title: title,
                                        content: '<iframe scrolling="auto" frameborder="0"  src="' + src + '" style="width:100%;height:100%;"></iframe>',
                                        closable: -true
                                    });
                        }
                    });

        });
    </script>
    <style type="text/css">
        a:hover {
            color: lightseagreen;
        }

        a {
            cursor: pointer;
            text-decoration: none;
            color: black;
            font-size: 14px;
        }

        li {
            list-style-type: none;
        }
    </style>
</head>

<body>
<div id="cc" class="easyui-layout" fit=true
     style="width: 100%; height: 100%;padding: 0px">
    <%--顶部--%>
    <div region="north" title="easyui-layout" split="false"
         style="height: 100px;">${user.u_userName }欢迎您
    </div>
    <%--左侧菜单--%>
    <div region="west" iconCls="icon-ok" split="true" title="菜单"
         style="width: 200px;">
        <div id="aa" class="easyui-accordion" fit=true>
            <div title="客户管理" style="overflow: auto; padding: 10px;">
                <ul>
                    <li>
                        <a title="客户信息" rel="jsp/client/client.jsp">客户信息</a>
                    </li>
                    <li>
                        <a title="联系记录" rel="jsp/client/clientConnection.jsp">联系记录</a>
                    </li>
                    <li>
                        <a title="客户类型" rel="jsp/client/clientConnection.jsp">客户类型</a>
                    </li>
                    <li>
                        <a title="客户关怀" rel="jsp/client/clientConnection.jsp">客户关怀</a>
                    </li>
                    <li>
                        <a title="行业管理" rel="jsp/system/changPassword.jsp">行业管理</a>
                    </li>
                </ul>
            </div>
            <div title="系统管理" style="overflow: auto;padding: 10px;">
                <ul>
                    <li>
                        <a title="用户管理" rel="jsp/system/changPassword.jsp">用户管理</a>
                    </li>
                    <li>
                        <a title="用户类型管理" rel="jsp/system/changPassword.jsp">用户类型管理</a>
                    </li>
                    <li>
                        <a title="部门管理" rel="jsp/system/changPassword.jsp">部门管理管理</a>
                    </li>

                </ul>
            </div>
        </div>
    </div>
    <%--中部信息展示--%>
    <div region="center" title="我的工作台" style="padding: 5px;">
        <div id="tt" class="easyui-tabs" fit=true
             style="width: 500px; height: 250px;">
        </div>
    </div>
</div>

</body>
</html>
