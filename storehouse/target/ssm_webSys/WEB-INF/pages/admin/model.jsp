<%--
  Created by IntelliJ IDEA.
  User: 24660
  Date: 2020/6/13
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="favicon.ico">
    <script src="js/jquery-2.2.3.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
    <title>查询用户</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="css/adminStyle.css"/>
    <style>

        html,body{
            margin: 0px 0px;
            width:100%;
            height:100%;
        }
    </style>
</head>
<body style="height: 1000px">
<div class="container-fluid mainBox">
    <div class="row ">
       <div class="col-sm-2 leftBox">
           <jsp:include page="adminNavLeft.jsp"/>
       </div>
        <div class="col-sm-10 mainBox">

        </div>
    </div>
</div>
</body>

<script src="js/vue.js" type="text/javascript" charset="utf-8"></script>
<script src="js/axios.js" type="text/javascript" charset="UTF-8"></script>
<script type="text/javascript">

</script>
</html>
