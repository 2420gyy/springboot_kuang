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

        html,body{
            margin: 0px 0px;
            width:100%;
            height:100%;
        }
    </style>
</head>
<body>
<div class="container-fluid" id="adminBox">
<div class="row" id="adminHomeBox">
    <div class="col-sm-12" id="adminHomeLeft">
        <div id="userPhotoBox" class="row">
            <div class="col-sm-offset-1 col-sm-4 center-block">
                <img src="${USER.photo}" class="img-circle" id="userPhoto">
            </div>
            <div class="col-sm-7 text-left">
                <h5>用户名：${USER.userName}</h5>
                <p>权限：<span class="text-danger">${USER.role == 0 ? "管理员" : "员工"}</span></p>
            </div>
        </div>

        <div class="row panel-group" id="accordion">
            <div class="panel panel-default selGroup" style="border-radius: 0px; ">
                <div class="panel-heading titleBox"  style="border-radius: 0px; border:0px; background-color: #71969f; border-left: 0px ;border-right: 0px" >
                    <h4 class="panel-title">
                        <a  data-toggle="collapse" data-parent="#accordion" style="text-decoration:none;color: #f5f5f5;"
                           href="#collapseOne">
                            <strong><h5><span class="glyphicon glyphicon-user"></span> 用户管理</h5></strong>
                        </a>
                    </h4>
                </div>
                <div id="collapseOne" class="panel-collapse collapse listInfoBox" id="userAdmin" >
                    <div class="panel-body">
                       <div class="row" style="padding-left: 20px">
                           <div class="col-sm-12">
                               <a href="javascript:void(0)" @click="toAdminHome()" style="text-decoration:none;color: #f5f5f5;">
                                 <span><span class="glyphicon glyphicon-chevron-right"></span> 全部用户</span>
                               </a>
                           </div>
                           <div class="col-sm-12 margin-min">
                               <a href="javascript:void(0)" @click="toFindUser()" style="text-decoration:none;color: #f5f5f5;">
                               <span><span class="glyphicon glyphicon-chevron-right"></span> 查询用户</span>
                               </a>
                           </div>
                           <div class="col-sm-12 margin-min">
                               <a href="javascript:void(0)" @click="toAdminFindUserByState()" style="text-decoration:none;color: #f5f5f5;">
                               <span><span class="glyphicon glyphicon-chevron-right"></span> 未激活用户</span>
                               </a>
                           </div>
                       </div>
                    </div>
                </div>
            </div>

            <div class="panel panel-default selGroup" style="border-radius: 0px;border-bottom: 1px; border-top: 1px; margin-top: 0px">
                <div class="panel-heading titleBox"  style="border-radius: 0px; border:0px; background-color: #71969f; border-left: 0px ;border-right: 0px" >
                    <h4 class="panel-title">
                        <a  data-toggle="collapse" data-parent="#accordion" style="text-decoration:none;color: #f5f5f5;"
                            href="#collapse2">
                            <strong><h5><span class="glyphicon glyphicon-home"></span> 仓库管理</h5></strong>
                        </a>
                    </h4>
                </div>
                <div id="collapse2" class="panel-collapse collapse listInfoBox" id="goodsAdmin">
                    <div class="panel-body">
                        <div class="row" style="padding-left: 20px">
                            <div class="col-sm-12">
                                <a href="javascript:void(0)" @click="toAdminAllGoods()" style="text-decoration:none;color: #f5f5f5;">
                                <span><span class="glyphicon glyphicon-chevron-right"></span> 全部货物</span>
                                </a>
                            </div>
                            <div class="col-sm-12 margin-min">
                                <a href="javascript:void(0)" @click="toAdminFindGoods()" style="text-decoration:none;color: #f5f5f5;">
                                <span><span class="glyphicon glyphicon-chevron-right"></span> 查询货物</span>
                                </a>
                            </div>
                            <div class="col-sm-12 margin-min">
                                <a href="javascript:void(0)" @click="toAdminAddGoods()" style="text-decoration:none;color: #f5f5f5;">
                                <span><span class="glyphicon glyphicon-chevron-right"></span> 上架货物</span>
                                </a>
                            </div>
                            <div class="col-sm-12 margin-min">
                                <a href="javascript:void(0)" @click="toAdminAllGoodsByState()" style="text-decoration:none;color: #f5f5f5;">
                                    <span><span class="glyphicon glyphicon-chevron-right"></span> 已下架货物</span>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="panel panel-default selGroup" style="border-radius: 0px; margin-top: 0px">
                <div class="panel-heading titleBox"  style="border-radius: 0px; border:0px; background-color: #71969f; border-left: 0px ;border-right: 0px" >
                    <h4 class="panel-title">
                        <a  data-toggle="collapse"  data-parent="#accordion" style="text-decoration:none;color: #f5f5f5;"
                            href="#collapse3">
                            <strong><h5><span class="glyphicon glyphicon-tasks" ></span> 数据分析</h5></strong>
                        </a>
                    </h4>
                </div>
                <div id="collapse3" class="panel-collapse collapse  listInfoBox" >
                    <div class="panel-body">
                        <div class="row" style="padding-left: 20px">
                            <div class="col-sm-12">
                                <a href="javascript:void(0)" @click="toAdminGoodsAnalysis()" style="text-decoration:none;color: #f5f5f5;">
                                <span><span class="glyphicon glyphicon-chevron-right"></span> 仓库分析</span>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="panel panel-default selGroup" style="border-radius: 0px; margin-top: 0px">
                <div class="panel-heading titleBox"  style="border-radius: 0px; border:0px; background-color: #71969f; border-left: 0px ;border-right: 0px" >
                    <h4 class="panel-title">
                        <a  data-toggle="collapse" data-parent="#accordion" style="text-decoration:none;color: #f5f5f5;"
                            href="#collapse4">
                            <strong><h5><span class="glyphicon glyphicon-cog"></span> 系统设置</h5></strong>
                        </a>
                    </h4>
                </div>
                <div id="collapse4" class="panel-collapse collapse  listInfoBox" >
                    <div class="panel-body">
                        <div class="row" style="padding-left: 20px">
                            <div class="col-sm-12">
                                <a href="javascript:void(0)" @click="logout" style="text-decoration:none;color: #f5f5f5;">
                                    <span><span class="glyphicon glyphicon-off"></span> 注销</span>
                                </a>
                            </div>
                            <div class="col-sm-12 margin-min">
                                <a href="javascript:void(0)" @click="toClient" style="text-decoration:none;color: #f5f5f5;">
                                    <span><span class="glyphicon glyphicon-share"></span> 返回前台</span>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-sm-10" id="adminHomeMain">

    </div>

</div>
</div>
</body>
<script src="js/vue.js"  type="text/javascript" charset="utf-8"></script>
<script src="js/axios.js" type="text/javascript" charset="UTF-8"></script>
<script type="text/javascript">
    $(function () {
        var path=window.location.pathname;
        var pagename = path.split("/")[path.split("/").length - 1];
        if(pagename == "toAdminAllGoods"){
            $("goodsAdmin").addClass("in");
        }
    })
    var vue = new Vue({
        el:'#adminBox',
        data:{
           time:"获取时间中。。。"
        },
        methods: {
            toClient:function () {
                window.location.href="page/toHome"
            },
            toAdminHome:function(){
                window.location.href="page/toAdminHome"
            },
            toFindUser:function(){
                window.location.href="page/toAdminFindUser"
            },
            toAdminFindUserByState:function(){
                window.location.href="page/toAdminFindUserByState"
            },
            toAdminAllGoods:function(){
                window.location.href="page/toAdminAllGoods"
            },
            toAdminAllGoodsByState:function(){
                window.location.href="page/toAdminAllGoodsByState"
            },
            toAdminFindGoods:function(){
                window.location.href="page/toAdminFindGoods"
            },
            toAdminAddGoods:function(){
                window.location.href="page/toAdminAddGoods"
            },
            toAdminGoodsAnalysis:function(){
                window.location.href="page/toAdminGoodsAnalysis"
            },
            logout:function () {
                axios.post('user/logout', { })
                    .then(function (response) {
                        console.log(response)
                        if(response.data.result == "success"){
                            alert("退出成功！")
                            window.location.href = "page/toLogin";
                        }
                    })
            }
        }
    })
</script>
</html>
