<%@ page import="com.lyx.model.TUser" %><%--
  Created by IntelliJ IDEA.
  User: 24660
  Date: 2020/6/13
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
</head>
<body>
<%
    TUser user = (TUser)request.getAttribute("USER");
    if(user == null){
        response.sendRedirect("index.jsp");
    }
%>
<div class="container-fluid">
    <nav class="navbar navbar-inverse" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">无忧仓库</a>
            </div>
            <div>
                <!--向左对齐-->
                <ul class="nav navbar-nav navbar-left" style="margin-left: 30px">
                    <li><a href="javascript:void(0)" onclick="toHome()"><span class="glyphicon glyphicon-home"></span> 首页</a></li>
                    <li><a href="javascript:void(0)" onclick="toGoods()"><span class="glyphicon glyphicon-th-large"></span> 全部货物</a></li>
                    <li><a href="javascript:void(0)" onclick="toFindGoods()"><span class="glyphicon glyphicon-search"></span> 查询</a></li>
                    <% TUser u = (TUser) request.getSession().getAttribute("USER");
                        if(u != null && u.getRole() == 0){
                    %>
                    <li><a href="javascript:void(0)" onclick="toAdminHome()"><span class="glyphicon glyphicon-flash"></span> 后台</a></li>
                    <%}%>
                </ul>
                <!--向右对齐-->
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <img src="${USER.photo}" style="height: 5%;margin-top: 20%" class="img-circle">
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <span class="text-danger">欢迎您：</span> ${USER.userName} <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="javascript:void(0)" onclick="toPC()" >个人中心</a></li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="logout()">退出登录</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>
</body>

<script type="text/javascript">

    function logout() {
        axios.post('user/logout', { })
            .then(function (response) {
                console.log(response)
                if(response.data.result == "success"){
                    alert("退出成功！")
                    window.location.href = "page/toLogin";
                }
            })
    }
    function toPC() {
        window.location.href="page/toPersonalCenter"
    }
    function toGoods() {
        window.location.href="page/toGoods"
    }
    function toHome() {
        window.location.href="page/toHome"
    }
    function toFindGoods() {
        window.location.href="page/toFindGoods"
    }
    function toAdminHome() {
        window.location.href="page/toAdminHome"
    }
</script>

</html>
