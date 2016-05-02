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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>登录界面</title>

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css"/>

    <script src="<%=request.getContextPath() %>/js/jquery-easyui-1.2.6/jquery-1.7.2.min.js"
            type="text/javascript"></script>
    <script type="text/javascript">

    </script>
</head>

<body class="login_body">

<div class="login_div">
    <div class="col-xs-12 login_title">登录</div>
    <form action="<%=request.getContextPath() %>/user/user_login.action" method="post">
        <div class="nav">
            <div class="nav login_nav">
                <div class="col-xs-4 login_username">
                    用户名:
                </div>
                <div class="col-xs-6 login_usernameInput">
                    <input type="text" name="u_userName" id="name" value="" placeholder="&nbsp;&nbsp;用户名"/>
                </div>

            </div>
            <div class="nav login_psdNav">
                <div class="col-xs-4">
                    密&nbsp;&nbsp;&nbsp;码:
                </div>
                <div class="col-xs-6">
                    <input type="password" name="u_password" id="psd" value="" placeholder="&nbsp;&nbsp;密码"/>
                </div>
            </div>
            <div class="col-xs-12 login_btn_div">
                <input type="submit" class="sub_btn" value="登录" id="login"/>
            </div>
        </div>
    </form>
</div>
</body>
</html>