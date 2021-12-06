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
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <style>
        #footBox{
            border-top: 2px solid #aaaaaa;
            font-size: 10px;
            padding: 7px;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <footer class="footer navbar-fixed-bottom ">
        <div class="row" id="footBox">
            <div class="col-sm-12">
                <p class="text-center">版权所有 &copy;  软件工程j1 吕总 未经允许，不得抄袭</p>
            </div>
        </div>
    </footer>
</div>

</body>
</html>
