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
    <title>登录</title>
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
    <div class="container-fluid">
        <div class="row" id="loginTitleBox">
            <div class="col-sm-12">
                <h1 class="text-center">用户登录</h1>
            </div>
        </div>
        <div class="row" >
            <div class="col-sm-offset-3 col-sm-6" id="loginMainBox">
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="username" class="col-sm-3 control-label">用户名</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="username" name="username"  v-model="username" @click="userNameOnClick" placeholder="请输入用户名">
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
                        <label for="captcha" class="col-sm-3 control-label">验证码</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="captcha" name="captcha" @keyup.enter="login" v-model="captcha" @click="captchaOnClick" placeholder="请输验证码">
                        </div>
                        <div class="col-sm-3">
                            <img id="captchaImage" src="CaptchaController/loginRandomStringCode" class="img-thumbnail" @click="refreshCaptcha"/>
                        </div>
                        <label for="captcha" class="col-sm-3 control-label"><p class="text-left text-danger" v-html="captchaTip"></p></label>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-7">
                            <div class="checkbox">
                                <label>
                                    <input id="isChecked" type="checkbox" @click="checkbox">请记住我
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-3">
                            <button type="button" @click="login"  class="btn btn-info">登录</button>
                            <button type="reset" class="btn btn-danger">重置</button>
                        </div>
                        <div class="col-sm-2">
                            <a href="page/toRegister" class="small">还没有账号？前往注册</a>
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



    window.onload=function () {
        var cookies = document.cookie.split("; ");
        for(var i = 0 ; i < cookies.length ; i ++){
            console.log(cookies[i]);
            if(cookies[i].trim().split("=")[0] == "userName" ){
                vue.$data.username = cookies[i].trim().split("=")[1];
                $("#isChecked").prop("checked",true);
                vue.$data.isChecked=true;
            }else if(cookies[i].trim().split("=")[0] == "password"){
                vue.$data.password = cookies[i].trim().split("=")[1];
            }
        }
    }
    var vue = new Vue({
        el:'#loginMainBox',
        data:{
            username:null,
            password:null,
            isChecked:false,
            captcha:null,
            nameTip:null,
            pwdTip:null,
            captchaTip:null
        },
        methods:{
            checkbox:function(){
                this.isChecked = event.target.checked;
            },
            refreshCaptcha:function(){
                $('#captchaImage').attr("src","CaptchaController/loginRandomStringCode?t="+(new Date().getTime()));
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
            login:function () {
                var that = this;
                var flag = false;
                if(this.username == null || this.username == ""){
                    this.nameTip = "用户名不能为空"
                    flag = true;
                }
                if(this.password == null || this.password == ""){
                    this.pwdTip = "密码不能为空"
                    flag = true;
                }
                if(this.captcha == null || this.captcha == ""){
                    this.captchaTip = "验证码不能为空"
                    flag = true;
                }
                if(flag){
                    return;
                }
                axios.post('user/login', {userName: this.username,password: this.password,isChecked: this.isChecked,captcha:this.captcha })
                    .then(function (response) {
                        console.log(response)
                        var result = response.data.result;
                        if(result == "success"){
                            alert("登录成功");
                            window.location.href = "page/toHome";
                        }else{
                            var info = response.data.failInfo;
                            alert(info)
                            if(info == "用户名或密码错误！") {
                                that.userName=null;
                                that.password=null;
                            }
                            that.captcha = null;
                            that.refreshCaptcha();
                        }
                    })
            }

        }
    })
</script>
</html>
