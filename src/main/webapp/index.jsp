<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登陆</title>s
    <script src="js/jquery.min.js"/>
    <script src="js/jquery.easyui.min.js"/>
    <script src="js/easyui-lang-zh_CN.js"/>
    <link href="css/easyui.css"/>
    <link href="css/icon.css"/>

</head>
<body>
<div id="container" style="width: 600px;height: 800px;">
    <form id="ff" method="post">
        <div>
            <label for="name">Name:</label>
            <input class="easyui-validatebox" type="text" name="name" data-options="required:true"/>
        </div>
        <div>
            <label for="email">Email:</label>
            <input class="easyui-validatebox" type="text" name="email" data-options="validType:'email'"/>
        </div>

    </form>

</div>
</body>
</html>