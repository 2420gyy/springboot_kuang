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
    System.out.println("basePath:" + basePath);
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="favicon.ico">
    <script src="js/jquery-2.2.3.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
    <title>查询所有用户</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="css/adminStyle.css"/>
    <style>
    </style>
</head>
<body>
<div class="container-fluid" id="adminBox " style="margin:0px;padding: 0px; ">
    <div class="row" style="margin:0px;padding: 0px;">
        <div class="col-sm-2" id="" style="margin:0px;padding: 0px;">
            <jsp:include page="adminNavLeft.jsp"/>
        </div>
        <div class="col-sm-10" id="findAllUserMain" style="padding: 20px">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <div class="page-header">
                        <h1>
                            全部用户 <small>共找到：<strong class="text-danger"> {{lineCount}} </strong>位用户</small>
                        </h1>
                    </div>
                </div>
                <div class="col-sm-6 userBox" v-for="(item,index) in users">
                    <div class="row userInfoBox">
                        <div class="col-sm-3">
                            <img :src="item.photo " class="img-thumbnail" width="100%"/>
                        </div>
                        <div class="col-sm-offset-1 col-sm-5 text-left">
                            <p>用户ID: <span class="badge"><strong>{{item.id}}</strong></span></p>
                            <p>用户名:<strong>{{item.userName}}</strong></p>
                            <p>密码:<span v-for="(item,index) in item.password.length" class="text-danger"> *</span>
                                <a href="javascript:void(0)" @click="refreshPwd(item.id)"> <span
                                        class="glyphicon glyphicon-refresh"></span> 重置</a>
                            </p>
                            <p>电话号码:<strong>{{item.tel}}</strong></p>
                            <p>家庭地址:<strong>{{item.address}}</strong></p>
                        </div>
                        <div class="col-sm-3 text-left" style="padding-top: 15px">
                            <button type="button" class="btn btn-sm btn-success col-sm-8" style="margin-top: 5px"
                                    data-toggle="modal" data-target="#myModal" @click="setUserInfo(item,index)">修改信息
                            </button>
                            <button type="button" class="btn btn-sm btn-danger col-sm-8" style="margin-top: 5px"
                                    v-if="item.state == 1 ? true :false" @click="disable(item.id,index,item.state)">禁用
                            </button>
                            <button type="button" class="btn btn-sm btn-info col-sm-8" style="margin-top: 5px"
                                    v-if="item.state == 0 ? true :false" @click="disable(item.id,index,item.state)">激活
                            </button>
                            <div class="col-sm-9" style="padding:0px;margin-top: 5px">
                                <select class="form-control" id="selRole" @change="changeRole(item.role,item.id)">
                                    <option value="0" selected v-if="item.role == 0 ? true : false">管理员</option>
                                    <option value="0" v-if="item.role != 0 ? true : false">管理员</option>
                                    <option value="1" selected v-if="item.role != 0 ? true : false">员工</option>
                                    <option value="1" v-if="item.role == 0 ? true : false">员工</option>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-12 text-center" v-if="users.length == 0 ? false : true">
                    <ul class="pagination">
                        <li><a href="javascript:void(0)" @click="findUsers(1)">首页</a></li>
                        <li><a href="javascript:void(0)" @click="findUsers('上一页')">&laquo;</a></li>
                        <li><a href="javascript:void(0)" v-for="index in pageCount">
                            <span v-if="index != pageNow" @click="findUsers(index)">{{ index }}</span>
                            <span v-if="index == pageNow" class="text-danger" @click="findUsers(index)">{{ index }}</span>
                        </a></li>
                        <li><a href="javascript:void(0)" @click="findUsers('下一页')">&raquo;</a></li>
                        <li><a href="javascript:void(0)" @click="findUsers(pageCount)">尾页</a></li>
                    </ul>
                </div>
            </div>

            <!-- 模态框（Modal） -->
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="myModalLabel">用户ID:<span
                                    class="badge"><strong>{{user.id}}</strong></span></h4>
                        </div>
                        <div class="modal-body">
                            <form class="form-horizontal" role="form">
                                <div class="form-group">
                                    <label for="userName" class="col-sm-3 control-label">用户名</label>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control" id="userName" name="userName"
                                               v-model="user.userName" @click="userNameOnclick" @blur="findUserByName"
                                               placeholder="请输入用户名">
                                    </div>
                                    <label for="username" class="col-sm-3 control-label"><p
                                            class="text-left text-danger" v-html="nameTip"></p></label>
                                </div>
                                <div class="form-group">
                                    <label for="password" class="col-sm-3 control-label">密码</label>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control" id="password" name="password"
                                               v-model="user.password" @click="pwdOnclick" placeholder="请输入密码">
                                    </div>
                                    <label for="password" class="col-sm-3 control-label"><p
                                            class="text-left text-danger" v-html="pwdTip"></p></label>
                                </div>
                                <div class="form-group">
                                    <label for="tel" class="col-sm-3 control-label">电话号码</label>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control" id="tel" name="tel" v-model="user.tel"
                                               @click="telOnclick" placeholder="请输入电话号码">
                                    </div>
                                    <label for="tel" class="col-sm-3 control-label"><p class="text-left text-danger"
                                                                                       v-html="telTip"></p></label>
                                </div>
                                <div class="form-group">
                                    <label for="address" class="col-sm-3 control-label">地址</label>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control" id="address" name="address"
                                               v-model="user.address" @click="addressOnclick" placeholder="请输入地址">
                                    </div>
                                    <label for="address" class="col-sm-3 control-label"><p class="text-left text-danger"
                                                                                           v-html="addressTip"></p>
                                    </label>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal">关闭</button>
                            <button type="button" class="btn btn-primary" @click="updateUserById">提交更改</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal -->
            </div>

        </div>
    </div>
</div>
</div>
</body>

<script src="js/vue.js" type="text/javascript" charset="utf-8"></script>
<script src="js/axios.js" type="text/javascript" charset="UTF-8"></script>
<script type="text/javascript">
    $(function () {
        findAllUsers();
    })

    function findAllUsers() {
        var data = {
            pageNow: vue.$data.pageNow,
            pageSize: vue.$data.pageSize,
            state: vue.$data.state
        }
        var that = vue.$data
        axios.post('user/findAllUsers', data)
            .then(function (response) {
                console.log(response)
                that.users = response.data.users;
                that.lineCount = response.data.pageInfo.lineCount;
                that.pageSize = response.data.pageInfo.pageSize;
                that.pageCount = response.data.pageInfo.pageCount;
                that.pageNow = response.data.pageInfo.pageNow;
                that.startCount = response.data.pageInfo.startCount;
            })
    }

    var vue = new Vue({
        el: '#findAllUserMain',
        data: {
            lineCount: null, //货物总数量
            pageSize: 6,     //页面大小
            pageCount: null,//页面数量
            pageNow: 1,      //当前页码
            state: -1,        //货物状态
            startCount: null, //页面起始货物条数
            users: [],
            nameTip: null,
            pwdTip: null,
            telTip: null,
            addressTip: null,
            oldUserName: null,
            updateIndex: null,
            user: {
                id: null,
                userName: null,
                password: null,
                tel: null,
                address: null,
                photo: null,
                state: null,
                role: null
            },
            oldUser: {
                id: null,
                userName: null,
                password: null,
                tel: null,
                address: null,
                photo: null,
                state: null,
                role: null
            }
        },
        methods: {
            changeRole: function (role, id) {
                if (id == "${USER.id}") {
                    alert("无法为自己更改权限！");
                    $("#selRole").val(role)
                    return;
                }
                var updateRole;
                if (role == 1) {
                    updateRole = 0;
                } else {
                    role = 1;
                }
                if (confirm("确定更改权限？")) {
                    axios.post('user/updateUserById', {role: updateRole, id: id})
                        .then(function (response) {
                            console.log(response)
                            if (response.data.result == "success") {
                                alert("修改成功！")
                            }

                        })
                }
            },
            findUserByName: function () {
                if (this.user.id == "${USER.id}") return;
                if (this.user.userName != this.oldUserName) {
                    var that = this;
                    axios.post('user/findUserByUserName', {userName: this.user.userName})
                        .then(function (response) {
                            console.log(response)
                            var result = response.data.result;
                            if (result == "success") {
                                that.user.userName = that.oldUserName;
                                that.nameTip = "用户名已经注册，请重新输入！"
                            }
                        })
                }
            },
            userNameOnclick: function () {
                this.nameTip = null;
            },
            pwdOnclick: function () {
                this.pwdTip = null;
            },
            telOnclick: function () {
                this.telTip = null;
            },
            addressOnclick: function () {
                this.addressTip = null;
            },
            setUserInfo: function (info, index) {
                this.user = info;
                this.oldUser = $.extend(true, {}, info);
                this.oldUserName = info.userName;
                this.updateIndex = index;
            },
            refreshPwd: function (info) {
                var that = this;
                axios.post('user/updateUserById', {password: 123456, id: info})
                    .then(function (response) {
                        console.log(response)
                        if (response.data.result == "success") {
                            alert("修改成功！")
                        }

                    })
            },
            reductionInfo: function () {
                this.users[this.updateIndex].userName = this.oldUser.userName;
                this.users[this.updateIndex].password = this.oldUser.password;
                this.users[this.updateIndex].tel = this.oldUser.tel;
                this.users[this.updateIndex].address = this.oldUser.address;
            },
            disable: function (id, index, state) {
                if (id == "${USER.id}") {
                    alert("无法禁用自己！");
                    return;
                }
                var that = this;
                var newState;
                if (state == 0) {
                    newState = 1;
                } else {
                    newState = 0;
                }
                axios.post('user/updateUserById', {id: id, state: newState})
                    .then(function (response) {
                        console.log(response)
                        var result = response.data.result;
                        if (result == "success") {
                            that.users[index].state = newState;
                            alert("修改成功！")
                        } else {
                            alert("修改失败，请联系管理员！");
                        }
                    })
            },
            checkUser:function(){
                var flag = true;
                if(this.oldUser.userName != this.user.userName) flag=false;
                if(this.oldUser.password != this.user.password) flag=false;
                if(this.oldUser.tel != this.user.tel) flag=false;
                if(this.oldUser.address != this.user.address) flag=false;
                if(flag == true){
                    alert("您还未做出修改！")
                }
                return flag;
            },
            updateUserById: function () {
                if (this.user.id == "${USER.id}") {
                    alert("警告：无法在此页面修改自己的信息，请去前台的个人中心修改！");
                    $("#myModal").modal('hide');
                    console.log(this.oldUser)
                    this.reductionInfo();
                    return;
                }
                if (this.user.userName == null || this.user.userName.trim() == "") {
                    this.nameTip = "用户名不能为空！";
                    this.reductionInfo();
                    return;
                }
                if (this.user.password == null || this.user.password.trim() == "") {
                    this.pwdTip = "密码不能为空！";
                    this.reductionInfo();
                    return;
                }
                if (this.user.tel == null || this.user.tel.trim() == "") {
                    this.telTip = "电话号码不能为空！";
                    this.reductionInfo();
                    return;
                }
                if (this.user.address == null || this.user.address.trim() == "") {
                    this.addressTip = "地址不能为空！";
                    this.reductionInfo();
                    return;
                }
                if(this.checkUser()){
                    return;
                }
                var that = this
                axios.post('user/updateUserById', {
                    id: this.user.id,
                    userName: this.user.userName,
                    password: this.user.password,
                    tel: this.user.tel,
                    address: this.user.address
                })
                    .then(function (response) {
                        console.log(response)
                        var result = response.data.result;
                        if (result == "success") {
                            alert("修改成功！")
                            $("#myModal").modal('hide');
                        } else {
                            alert("修改失败，请联系管理员！");
                            $("#myModal").modal('hide');
                        }
                    })
            },
            findUsers: function (info) {
                if (info == "上一页") {
                    if (this.pageNow == 1) {
                        alert("没有上一页了哦！")
                        return;
                    } else {
                        info = this.pageNow - 1;
                    }
                } else if (info == "下一页") {
                    if (this.pageNow == this.pageCount) {
                        alert("没有下一页了哦！")
                        return;
                    } else {
                        info = this.pageNow + 1;
                    }
                } else if (info == this.pageNow) {
                    alert("当前正在第" + info + "页哦！")
                    return;
                }
                this.pageNow = info;
                findAllUsers();
            }

        }
    })
</script>
</html>
