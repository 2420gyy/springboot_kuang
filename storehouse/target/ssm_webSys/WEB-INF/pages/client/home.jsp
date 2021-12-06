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
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="favicon.ico">
    <script src="js/jquery-2.2.3.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/bootstrap.js"  type="text/javascript" charset="utf-8"></script>
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="css/myStyle.css" />
    <link rel="stylesheet" type="text/css" href="css/login.css" />
</head>
<body>
<jsp:include page="navHead.jsp" />
<div class="container-fluid">
<div class="row">
    <div class="col-sm-12 text-center" id="homeBox">
        <h2 class="text-info">欢迎来到无忧仓库管理系统前台！</h2>
        <h4 class="" v-html="time"></h4>
        <div class="row">
            <div class="col-sm-offset-4 col-sm-4 text-center">
                <img src="${USER.photo}" style="width: 70% ; margin-bottom: 50px" class="img-thumbnail"/>
            </div>
        </div>
    </div>
</div>
</div>
<jsp:include page="footer.jsp" />
</body>

<script src="js/vue.js"  type="text/javascript" charset="utf-8"></script>
<script src="js/axios.js" type="text/javascript" charset="UTF-8"></script>
<script type="text/javascript">
    $(function () {
        setInterval(timeStr,1000);
    });
    function timeStr() {
            var myDate = new Date();
            var year = myDate.getFullYear();    //获取完整的年份(4位,1970-????)
            var month =  myDate.getMonth()+1;       //获取当前月份(0-11,0代表1月)
            var day = myDate.getDate();        //获取当前日(1-31)
            var hours = myDate.getHours()+1;       //获取当前小时数(0-23)
            var min = myDate.getMinutes()+1;     //获取当前分钟数(0-59)
            var seconds = myDate.getSeconds();     //获取当前秒数(0-59)
            vue.$data.time = year+"年"+month+"月"+day+"日  "+hours+":"+min+":"+seconds
    }
    var vue = new Vue({
        el:'#homeBox',
        data:{
           time:"获取时间中。。。"
        },
        methods: {}
    })
</script>
</html>
