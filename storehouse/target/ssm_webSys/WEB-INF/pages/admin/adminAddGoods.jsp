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
    <title>上架货物</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="css/adminStyle.css"/>
    <style>

        html, body {
            margin: 0px 0px;
            width: 100%;
            height: 100%;
        }
    </style>
</head>
<body style="height: 1000px">
<div class="container-fluid mainBox">
    <div class="row ">
        <div class="col-sm-2 leftBox">
            <jsp:include page="adminNavLeft.jsp"/>
        </div>
        <div class="col-sm-10 mainBox" id="addGoodsBox">
            <div class="row">
                <div class="col-sm-12 clearfix">
                    <div class="col-sm-12 column">
                        <div class="page-header col-sm-12">
                            <h1>
                                上架货物
                            </h1>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-offset-2 col-sm-8">
                    <table class="table table-bordered table-hover">
                        <tr>
                            <td rowspan="5" colspan="1" style="width: 280px">
                                <img :src="imgSrc" id="goodsImg" class="img-thumbnail" width="100%"/>
                                <input type="file" id="file1" class="form-control" style="display:none"
                                       v-on:input="selPhoto"/>
                            </td>
                            <td>
                                货物名
                            </td>
                            <td><input type="text" class="form-control" v-model="goodsName" placeholder="请输入货物名"></td>
                        </tr>
                        <tr>
                            <td>
                                货物来源
                            </td>
                            <td><input type="text" class="form-control" v-model="goodsSource" placeholder="请输入货物来源">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                供应商
                            </td>
                            <td><input type="text" class="form-control" v-model="supply" placeholder="请输入货物供应商"></td>
                        </tr>
                        <tr>
                            <td>
                                联系电话
                            </td>
                            <td><input type="text" class="form-control" v-model="supplyTel" placeholder="请输入供应商联系电话">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                简介
                            </td>
                            <td><input type="text" class="form-control" v-model="note" placeholder="请输入货物简介"></td>
                        </tr>
                        <tr>
                            <td>
                                <button type="button" class="btn btn-primary col-sm-4 col-sm-offset-8"
                                        onclick="$('input[id=file1]').click()">更换
                                </button>
                            </td>
                            <td>
                                单位
                            </td>
                            <td><input type="text" class="form-control" v-model="company" placeholder="请输入货物单位"></td>
                        </tr>
                        <tr>
                            <td colspan="3">
                                <button type="button" class="btn btn-success col-sm-2 col-sm-offset-10"
                                        @click="addGoods">提交
                                </button>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

<script src="js/vue.js" type="text/javascript" charset="utf-8"></script>
<script src="js/axios.js" type="text/javascript" charset="UTF-8"></script>
<script type="text/javascript">
    var vue = new Vue({
        el: '#addGoodsBox',
        data: {
            imgSrc: "img/goods.jpg",
            goodsName: null,
            goodsImage: null,
            goodsSource: null,
            supply: null,
            supplyTel: null,
            note: null,
            company:null
        },
        methods: {
            selPhoto: function () {
                var fileObj = document.getElementById("file1").files[0];
                var reader = new FileReader();
                reader.readAsDataURL(fileObj);
                reader.onload = function (e) {
                    $('#goodsImg').get(0).src = e.target.result;
                }
                this.uploadPhoto();
            },
            uploadPhoto() {
                var formData = new FormData();
                var fileObj = document.getElementById("file1").files[0];
                formData.append("upload", fileObj);
                var that = this;
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
                        that.imgSrc = data.photo;
                    }
                });
            },
            checkGoods: function () {
                var flag = false;
                if (this.imgSrc == "img/goods.jpg") {
                    if (!confirm("您还未上传货物图片，是否使用默认图片？")) {
                        flag = true;
                    }
                }
                if (this.goodsName == null || this.goodsName.trim() == "") flag = true;
                if (this.goodsSource == null || this.goodsSource.trim() == "") flag = true;
                if (this.supply == null || this.supply.trim() == "") flag = true;
                if (this.supplyTel == null || this.supplyTel.trim() == "") flag = true;
                if (this.note == null || this.note.trim() == "") flag = true;
                if (this.company == null || this.company.trim() == "") flag = true;
                return flag;
            },
            addGoods: function () {
                if (this.checkGoods()) {
                    alert("请将表格填写完整，信息不能未空！")
                    return;
                }
                var data = {
                    goodsImage: this.imgSrc,
                    goodsName: this.goodsName,
                    goodsSource: this.goodsSource,
                    supply: this.supply,
                    supplyTel: this.supplyTel,
                    note: this.note,
                    company: this.company,
                    userId:"${USER.id}"
                }
                console.log(data);
                var that = this;
                axios.post('goods/addGoods', data).then(function (response) {
                    console.log(response);
                    if (response.data.result == "success") {
                        alert("添加成功");
                        that.imgSrc = "img/goods.jpg",
                        that.goodsName = null,
                        that.goodsImage = null,
                        that.goodsSource = null,
                        that.supply = null,
                        that.supplyTel = null,
                        that.note = null,
                        that.company =  null
                    } else {
                        alert("添加失败！");
                    }
                })
            }

        }
    })
</script>
</html>
