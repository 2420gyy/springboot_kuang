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
<%--    <script src="js/echarts.min.js" type="text/javascript" charset="utf-8"></script>--%>
    <title>仓库分析</title>
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
            <div class="col-sm-12 clearfix">
                <div class="col-sm-12 column">
                    <div class="page-header col-sm-12">
                        <h1>
                            库存分析
                        </h1>
                    </div>
                </div>
                <div class="col-sm-offset-2 col-sm-8 tableBox" id="main"></div>
            </div>

        </div>
    </div>
</div>
</body>

<script src="js/vue.js" type="text/javascript" charset="utf-8"></script>
<script src="js/axios.js" type="text/javascript" charset="UTF-8"></script>
<script type="text/javascript" src="https://echarts.baidu.com/dist/echarts.min.js"></script>
<script type="text/javascript">
    //基于准备好的dom，初始化echarts实例
    var myChart;
    myChart = echarts.init(document.getElementById('main'));
    // 指定图表的配置项和数据
    var option = {
        series: {
            type: 'pie',
            data: [
            ]
        }
    }
    $(function () {
        axios.post('goods/findAllGoods', {})
            .then(function (response) {
                console.log(response)
                var goods = response.data.goods;
                var data = new Array();
                for (var i = 0; i < goods.length; i++) {
                    if(goods[i].number != 0){
                        if(goods[i].company == "kg"){
                            goods[i].number = goods[i].number*0.1
                        }
                        var temp = {
                            name:goods[i].goodsName,
                            value:goods[i].number
                        }
                        data.push(temp)
                    }
                }
                console.log(data);
                option.series.data = data;
                console.log(option.series.data)
                myChart.setOption(option);
            })
    })
</script>
</html>
