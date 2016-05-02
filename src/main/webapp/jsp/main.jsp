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
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/mainstyle.css">
    <script type="text/javascript" src="js/jquery.SuperSlide.js"></script>
    <script type="text/javascript">
        $(function () {
            //动态生成选项卡
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
            $('#updateInfo').click(function(){
                   var $userId= $('#userId').val();
                    $('#changeUserInfo').dialog({
                        title: '个人资料修改',
                        width: 400,
                        height: 400,
                        closed: false,
                        cache: false,
                        href: 'user/user_getUserById.action?user.id='+$userId,
                        modal: true

                    });
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
     style="width: 100%; height: 100%;padding: 0px;">
    <%--顶部--%>
    <div region="north" title="首页" split="true" style="height: 86px">
        <div class="top">
            <div id="top_t">
                <div id="logo" class="fl"></div>
                <div id="photo_info" class="fr">
                    <div id="photo" class="fl">
                        <a href="#"><img src="images/a.png" alt="" width="60" height="60"></a>
                    </div>
                    <div id="base_info" class="fr">
                        <div class="help_info">
                            <a href="1" id="hp">&nbsp;</a>
                            <a href="2" id="gy">&nbsp;</a>
                            <a href="user/user_signOut.action" id="out">&nbsp;</a>
                        </div>
                        <div class="info_center">
                           ${user.u_userName}
                            <span id="nt">欢迎您！</span><span></span>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <%--左侧菜单--%>
    <div region="west" iconCls="icon-ok" split="true" title="菜单" border="false"
         style="width: 200px;">
        <div id="aa" class="easyui-accordion" fit=true>
            <div title="客户管理" style="overflow: auto; padding: 10px;">
                <ul>
                    <li>
                        <img src="images/left.gif" alt="">
                        <a title="客户信息" rel="jsp/client/client.jsp">客户信息</a>
                    </li>
                    <li>
                        <img src="images/left.gif" alt="">
                        <a title="联系记录" rel="jsp/client/clientConnection.jsp">联系记录</a>
                    </li>
                    <li>
                        <img src="images/left.gif" alt="">
                        <a title="客户类型" rel="jsp/client/customerType.jsp">客户类型</a>
                    </li>
                    <li>
                        <img src="images/left.gif" alt="">
                        <a title="客户关怀" rel="jsp/client/clientConnection.jsp">客户关怀</a>
                    </li>
                    <li>
                        <img src="images/left.gif" alt="">
                        <a title="行业管理" rel="jsp/client/industry.jsp">行业管理</a>
                    </li>
                </ul>
            </div>
            <div title="系统管理" style="overflow: auto;padding: 10px;">
                <ul>
                    <li>
                        <img src="images/left.gif" alt="">
                        <a title="用户管理" rel="jsp/user/user.jsp">用户管理</a>
                    </li>
                    <li>
                        <img src="images/left.gif" alt="">
                        <a title="用户类型管理" rel="jsp/user/userType.jsp">用户类型管理</a>
                    </li>
                    <li>
                        <img src="images/left.gif" alt="">
                        <a title="部门管理" rel="jsp/user/department.jsp">部门管理管理</a>
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
<div id="changeUserInfo">
        <form id="userForm">

        </form>
</div>
</body>
</html>
