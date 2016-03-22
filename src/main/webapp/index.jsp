<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登陆</title>
    <script src="js/jquery.min.js" type="text/javascript"></script>
    <script src="js/jquery.easyui.min.js" type="text/javascript"></script>
    <script src="js/easyui-lang-zh_CN.js" type="text/javascript"></script>
    <link href="css/easyui.css" type="text/css" rel="stylesheet"/>
    <link href="css/icon.css" type="text/css" rel="stylesheet"/>
    <link href="css/login.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<section class="login-form-wrap">
    <form class="login-form" action="post">
        <label><input type="text" name="" required placeholder="用户名"></label>
        <label><input type="password" name="password" required placeholder="密码"></label>
        <input type="submit" value="Login">
    </form>
</section>
</body>
</html>
