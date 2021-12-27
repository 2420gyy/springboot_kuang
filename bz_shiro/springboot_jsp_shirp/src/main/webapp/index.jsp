<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>系统管理</h1>
<h3><a href="${pageContext.request.contextPath}/user/logout">退出系统</a></h3>

<ul>
    <shiro:hasAnyRoles name="admin,user">
        <li><a href="">用户管理</a>
        <ul>
            <shiro:hasPermission name="user:find:*">
                <li><a href="">查询用户</a></li>
            </shiro:hasPermission>
            <shiro:hasPermission name="user:add:*">
                <li><a href="">增加用户</a></li>
            </shiro:hasPermission>
            <shiro:hasPermission name="user:update:*">
                <li><a href="">编辑用户</a></li>
            </shiro:hasPermission>
            <shiro:hasPermission name="user:delete:*">
                <li><a href="">删除用户</a></li>
            </shiro:hasPermission>
        </ul>
        </li>
    </shiro:hasAnyRoles>
    <shiro:hasRole name="admin">
        <li><a href="">订单管理</a></li>
        <li><a href="">商品管理</a></li>
    </shiro:hasRole>
</ul>
</body>
</html>