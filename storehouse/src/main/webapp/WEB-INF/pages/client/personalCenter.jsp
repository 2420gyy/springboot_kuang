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
    <title>个人中心</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="css/myStyle.css" />
</head>
<body>
<jsp:include page="navHead.jsp" />
<div class="container-fluid">
    <div class="row" id="pcBox">
        <div class="col-sm-4" id="userPhotoBox">
            <div class="row">
                <div class="col-sm-12">
                    <img src="${USER.photo == null ?  'img/1.jpg' : USER.photo}"  class="img-thumbnail center-block" id="userPhoto"/>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12 text-center">
                    <input type="file" id="file1" class="form-control" style="display:none" v-on:input="selPhoto"/>
                    <button type="button" class="btn btn-success" onclick="$('input[id=file1]').click()" >更换头像</button>
                </div>
                <div class="col-md-12 text-center">
                    <button type="button" id="updateImageBtn" class="btn btn-info " @click="updateUserById"  style="display:none">确认修改</button>
                </div>
            </div>
        </div>
        <div class="col-sm-8">
            <div class="row">
                <div class="col-sm-12">
                    <table class="table table-hover">
                        <caption>用户信息</caption>
                        <tbody>
                        <tr class="active">
                            <td>用户ID</td>
                            <td><strong v-Html="id"></strong></td></tr>
                        <tr class="info">
                            <td>用户名</td>
                            <td><strong v-Html="userName"></strong></td></tr>
                        <tr class="success">
                            <td>密码</td>
                            <td><strong v-Html="password"></strong></td></tr>
                        <tr class="warning">
                            <td>电话号码</td>
                            <td><strong v-Html="tel"></strong></td></tr>
                        <tr class="danger">
                            <td>地址</td>
                            <td><strong v-Html="address"></strong></td></tr>
                        </tbody>
                    </table>
                </div>
                <div class="col-sm-12">
                    <button type="button" class="btn btn-info btn-lg " data-toggle="modal" data-target="#myModal">修改信息</button>
                </div>
            </div>
        </div>

        <!-- 模态框（Modal） -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            &times;
                        </button>
                        <h4 class="modal-title" id="myModalLabel">
                            信息修改
                        </h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <label for="userName" class="col-sm-3 control-label">用户名</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="userName" name="userName"  v-model="userName" @click="userNameOnclick" @blur="findUserByName" placeholder="请输入用户名">
                                </div>
                                <label for="username" class="col-sm-3 control-label"><p class="text-left text-danger" v-html="nameTip" ></p></label>
                            </div>
                            <div class="form-group">
                                <label for="password" class="col-sm-3 control-label">密码</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="password" name="password"  v-model="password"  placeholder="请输入密码">
                                </div>
                                <label for="password" class="col-sm-3 control-label"><p class="text-left text-danger" ></p></label>
                            </div>
                            <div class="form-group">
                                <label for="tel" class="col-sm-3 control-label">电话号码</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="tel" name="tel"  v-model="tel"  placeholder="请输入电话号码">
                                </div>
                                <label for="tel" class="col-sm-3 control-label"><p class="text-left text-danger" ></p></label>
                            </div>
                            <div class="form-group">
                                <label for="address" class="col-sm-3 control-label">地址</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="address" name="address"  v-model="address"  placeholder="请输入地址">
                                </div>
                                <label for="address" class="col-sm-3 control-label"><p class="text-left text-danger" ></p></label>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">关闭
                        </button>
                        <button type="button" class="btn btn-primary" @click="updateUserById">
                            提交更改
                        </button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal -->

    </div>
</div>
<jsp:include page="footer.jsp" />
</body>

<script src="js/vue.js"  type="text/javascript" charset="utf-8"></script>
<script src="js/axios.js" type="text/javascript" charset="UTF-8"></script>
<script type="text/javascript">
    var vue = new Vue({
        el:'#pcBox',
        data:{
            id:"${USER.id}",
            userName: "${USER.userName}",
            password: "${USER.password}",
            tel: "${USER.tel}",
            address: "${USER.address}",
            photo:"${USER.photo}",
            nameTip:null
        },
        methods:{
            userNameOnclick:function(){
              this.nameTip = null;
            },
            findUserByName:function () {
                if(this.userName != "${USER.userName}"){
                    var that = this;
                    axios.post('user/findUserByUserName', {userName: this.userName})
                        .then(function (response) {
                            console.log(response)
                            var result = response.data.result;
                            if(result == "success"){
                                that.userName = "${USER.userName}";
                                that.nameTip = "用户名已经注册，请重新输入！"
                            }
                        })
                }
            },
            selPhoto:function(){
                var fileObj = document.getElementById("file1").files[0];
                var reader = new FileReader();
                reader.readAsDataURL(fileObj);
                reader.onload=function(e){
                    $('#userPhoto').get(0).src = e.target.result;
                }
                $("#updateImageBtn").css({"display":"block","margin":"0 auto","margin-top":"10px"});
                this.uploadPhoto();
            },
            uploadPhoto:function(){
                var that = this;
                var formData = new FormData();
                var fileObj = document.getElementById("file1").files[0];
                formData.append("upload",fileObj);
                $.ajax({
                    type: 'POST',
                    encType: 'multipart/form-data', //表明上传类型为文件
                    processData: false, //这里设置成false，表明上传数据不需转换成字符串
                    contentType: false,
                    cache: false,
                    url: 'file/fileUpload',
                    data: formData,
                    success: function (data) {
                        console.log(data)
                        that.photo = data.photo;
                    }
                });
            },
            updateUserById:function () {
                axios.post('user/updateUserByIdPersonal', {id:this.id,userName: this.userName,password:this.password,tel:this.tel,address:this.address,photo:this.photo})
                    .then(function (response) {
                        console.log(response)
                        var result = response.data.result;
                        if(result == "success"){
                            alert("修改成功！")
                            $("#updateImageBtn").css({"display":"none","margin":"0 auto","margin-top":"10px"});
                            $("#myModal").modal('hide');
                            window.location.href="page/toPersonalCenter"
                        }else{
                            alert("修改失败，请联系管理员！");
                            $("#myModal").modal('hide');
                        }
                    })
            }
        }
    })
</script>

</html>
