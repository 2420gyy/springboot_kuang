<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>登录</h1>
<form action="${pageContext.request.contextPath}/user/login" method="post">
    用户名:<input type="text" name="username"></br>
    密码:<input type="text" name="password"></br>
    <input type="submit" value="登录">
</form>
</body>
</html>