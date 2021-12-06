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
    <title>注册</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="favicon.ico">
    <script src="js/jquery-2.2.3.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/bootstrap.js"  type="text/javascript" charset="utf-8"></script>
    <title>用户登录</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="css/login.css" />
</head>
<body>
<%
    Cookie[] cookies = request.getCookies();
//    for (Cookie cookie : cookies) {
//        out.println(cookie.getName()+"->"+cookie.getValue());
//    }
//    Cookie c_name = null;
//    Cookie c_pwd = null;
//    if (cookies != null && cookies.length > 0) {
//        for (Cookie c : cookies) {
//            if (c.getName().equals("cookie_name")) {
//                c_name = c;
//            }else if(c.getName().equals("cookie_pwd")){
//                c_pwd = c;
//            }
//        }
//    }
%>
    <div class="container-fluid">
        <div class="row" id="loginTitleBox">
            <div class="col-sm-12">
                <h1 class="text-center">用户注册</h1>
            </div>
        </div>
        <div class="row" >
            <div class="col-sm-offset-3 col-sm-6" id="loginMainBox">
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="userName" class="col-sm-3 control-label">用户名</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="userName" name="userName"  v-model="userName" @click="userNameOnClick" @blur="findUserByName" placeholder="请输入用户名">
                        </div>
                        <label for="username" class="col-sm-3 control-label"><p class="text-left text-danger" v-html="nameTip"></p></label>
                    </div>
                    <div class="form-group">
                        <label for="password" class="col-sm-3 control-label">密码</label>
                        <div class="col-sm-6">
                            <input type="password" class="form-control" id="password" name="password"  v-model="password" @click="pwdOnClick" placeholder="请输入姓">
                        </div>
                        <label for="password" class="col-sm-3 control-label"><p class="text-left text-danger" v-html="pwdTip"></p></label>
                    </div>
                    <div class="form-group">
                        <label for="tel" class="col-sm-3 control-label">电话号码</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="tel" name="tel"  v-model="tel"  @blur="telOnclick" placeholder="请输入电话号码">
                        </div>
                        <label for="tel" class="col-sm-3 control-label"><p class="text-left text-danger" v-html="telTip"></p></label>
                    </div>
                    <div class="form-group">
                        <label for="address" class="col-sm-3 control-label">地址</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="address" name="address"  v-model="address" @blur="addressOnclick"  placeholder="请输入地址">
                        </div>
                        <label for="address" class="col-sm-3 control-label"><p class="text-left text-danger" v-html="addressTip"></p></label>
                    </div>
                    <div class="form-group">
                        <label for="captcha" class="col-sm-3 control-label">验证码</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="captcha" name="captcha" @keyup.enter="register" v-model="captcha" @click="captchaOnClick" placeholder="请输验证码">
                        </div>
                        <div class="col-sm-3">
                            <img id="captchaImage" src="CaptchaController/registerRandomStringCode" class="img-thumbnail" @click="refreshCaptcha"/>
                        </div>
                        <label for="captcha" class="col-sm-3 control-label"><p class="text-left text-danger" v-html="captchaTip"></p></label>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-3">
                            <button type="button" @click="register"  class="btn btn-info">注册</button>
                            <button type="reset" class="btn btn-danger">重置</button>
                        </div>
                        <div class="col-sm-2">
                            <a href="page/toLogin" class="small">已有账号？去登录</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <footer class="footer navbar-fixed-bottom ">
            <div class="row" id="loginFootBox">
                <div class="col-sm-12">
                    <p class="text-center">版权所有 &copy;  软件工程j1 吕总 未经允许，不得抄袭</p>
                </div>
            </div>
        </footer>
    </div>
</body>

<script src="js/vue.js"  type="text/javascript" charset="utf-8"></script>
<script src="js/axios.js" type="text/javascript" charset="UTF-8"></script>
<script type="text/javascript">


    var vue = new Vue({
        el:'#loginMainBox',
        data:{
            userName:null,
            password:null,
            tel:null,
            address:null,
            captcha:null,
            nameTip:null,
            pwdTip:null,
            telTip:null,
            addressTip:null,
            captchaTip:null
        },
        methods:{
            refreshCaptcha:function(){
                $('#captchaImage').attr("src","CaptchaController/registerRandomStringCode?t="+(new Date().getTime()));
            },
            userNameOnClick:function(){
                this.nameTip = null;
            },
            pwdOnClick:function(){
                this.pwdTip = null;
            },
            captchaOnClick:function(){
                this.captchaTip = null;
            },
            telOnclick: function () {
                this.telTip = null;
            },
            addressOnclick: function () {
                this.addressTip = null;
            },
            findUserByName:function(){
                var that = this;
                axios.post('user/findUserByUserName', {userName: this.userName})
                    .then(function (response) {
                        console.log(response)
                        var result = response.data.result;
                        if(result == "success"){
                            that.userName = null;
                            that.nameTip = "用户名已经注册，请重新输入！"
                        }
                    })
            },
            register:function () {
                var that = this;
                var flag = false;
                if(this.userName == null || this.userName.trim() == ""){
                    this.nameTip = "用户名不能为空"
                    flag = true;
                }
                if(this.password == null || this.password.trim() == ""){
                    this.pwdTip = "密码不能为空"
                    flag = true;
                }
                if(this.captcha == null || this.captcha.trim() == ""){
                    this.captchaTip = "验证码不能为空"
                    flag = true;
                }
                if(this.address == null || this.address.trim() == ""){
                    this.addressTip = "地址不能为空"
                    flag = true;
                }
                if(this.tel == null || this.tel == ""){
                    this.telTip = "电话号码不能为空"
                    flag = true;
                }
                if(flag){
                    return;
                }
                axios.post('user/register', {userName: this.userName,password: this.password,tel:this.tel,address:this.address,captcha:this.captcha })
                    .then(function (response) {
                        console.log(response)
                        var result = response.data.result;
                        if(result == "success"){
                            alert("注册成功");
                        }else{
                            var info = response.data.failInfo;
                            alert(info);
                        }
                    })
            }
        }
    })
</script>
</html>
