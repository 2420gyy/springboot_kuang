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
    <title>全部货物</title>
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
        <div class="col-sm-10 mainBox" id="adminFindAllGoods">
            <div class="col-sm-12 clearfix">
                <div class="col-sm-12 column">
                    <div class="page-header col-sm-12">
                        <h1>
                            全部货物<small>共找到：<strong class="text-danger">{{lineCount}}</strong> 种货物 </small>
                        </h1>
                    </div>
                </div>
            </div>
            <div class="col-sm-offset-1 col-sm-10" style="margin-top: 15px" v-for="(item,index) in goods">
                <div class="goodsBox row">
                    <div class="col-sm-4">
                        <div class="row">
                            <div class="col-sm-12" style="padding-top: 25px">
                                <img :src="item.goodsImage" class="img img-thumbnail center-block"  style="width: 100%;max-height: 160px;">
                            </div>
                        </div>

                    </div>
                    <div class="col-sm-8">
                        <table class="table table-hover table-bordered">
                            <caption>货物信息</caption>
                            <tr class="success">
                                <td>货物id</td>
                                <td>{{item.id}}</td>
                                <td>货物名</td>
                                <td>{{item.goodsName}}</td>
                                <td>货物来源</td>
                                <td>{{item.goodsSource}}</td>

                            </tr>
                            <tr class="danger">
                                <td>供应商</td>
                                <td>{{item.supply}}</td>
                                <td>联系电话</td>
                                <td>{{item.supplyTel}}</td>
                                <td>上架时间</td>
                                <td>{{dateFormat(item.putTime)}}</td>
                            </tr>
                            <tr class="success">
                                <td>库存</td>
                                <td>{{item.number}}{{item.company}}</td>
                                <td>简介</td>
                                <td colspan="3">{{item.note}}</td>
                            </tr>
                            <tr class="danger">
                                <td colspan="8">
                                    <button type="button" class="btn btn-success btn-sm col-sm-2" @click="setGoods(item,index)" data-toggle="modal" data-target="#myModal">修改</button>
                                    <button type="button" class="btn btn-danger btn-sm col-sm-2" style="margin-left: 5px"
                                            v-if="item.state == 1 ? true : false" @click="updateGoodsById(item.id,item.state,index)">下架</button>
                                    <button type="button" class="btn btn-info btn-sm col-sm-2" style="margin-left: 5px"
                                            v-if="item.state == 0 ? true : false" @click="updateGoodsById(item.id,item.state,index)">上架</button>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>

            <div class="col-sm-12 text-center">
                <ul class="pagination">
                    <li><a href="javascript:void(0)" @click="getGoods(1)">首页</a></li>
                    <li><a href="javascript:void(0)" @click="getGoods('上一页')">&laquo;</a></li>
                    <li><a href="javascript:void(0)" v-for="index in pageCount" @click="getGoods(index)">
                        <span v-if="index != pageNow">{{ index }}</span>
                        <span v-if="index == pageNow" class="text-danger">{{ index }}</span>
                    </a></li>
                    <li><a href="javascript:void(0)" @click="getGoods('下一页')">&raquo;</a></li>
                    <li><a href="javascript:void(0)" @click="getGoods(pageCount)">尾页</a></li>
                </ul>
            </div>

            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="myModalLabel">货物id:{{goodsInfo.id}}</h4>
                        </div>
                        <div class="modal-body">
                            <form class="form-horizontal" role="form">
                                <div class="form-group">
                                    <div class="col-sm-offset-4 col-sm-4 ">
                                        <input type="file" id="file1" class="form-control" style="display:none" v-on:input="selPhoto"/>
                                        <img :src="goodsInfo.goodsImage" id="goodsImg" class="img-thumbnail center-block" style="width: 100%">
                                    </div>
                                    <div class="col-sm-12 text-center" style="margin-top: 5px">
                                        <div class="btn btn-primary btn-sm" onclick="$('input[id=file1]').click()">更换</div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="goodsName" class="col-sm-3 control-label">货物名</label>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control" id="goodsName" name="goodsName"  v-model="goodsInfo.goodsName"  placeholder="请输入货物名">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="goodsSource" class="col-sm-3 control-label">来源</label>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control" id="goodsSource" name="goodsSource"  v-model="goodsInfo.goodsSource"  placeholder="请输入来源">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="supply" class="col-sm-3 control-label">供应商</label>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control" id="supply" name="supply"  v-model="goodsInfo.supply"  placeholder="请输入供应商">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="supplyTel" class="col-sm-3 control-label">联系方式</label>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control" id="supplyTel" name="supplyTel"  v-model="goodsInfo.supplyTel"  placeholder="请输入供应商联系方式">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="note" class="col-sm-3 control-label">简介</label>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control" id="note" name="note"  v-model="goodsInfo.note"  placeholder="请输入简介">
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <button type="button" class="btn btn-primary" @click="updateGoodsById(goodsInfo.id,-1,null)">提交更改</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal -->
            </div>

        </div>
    </div>
</div>
</body>

<script src="js/vue.js" type="text/javascript" charset="utf-8"></script>
<script src="js/axios.js" type="text/javascript" charset="UTF-8"></script>
<script type="text/javascript">
    $(function(){
        getGoods();
    })

    var vue = new Vue({
        el:'#adminFindAllGoods',
        data:{
            lineCount: null, //货物总数量
            pageSize: 6,     //页面大小
            pageCount: null,//页面数量
            pageNow: 1,      //当前页码
            state: -1,        //货物状态
            startCount: null, //页面起始货物条数
            goods: [],
            oldGoodsInfo:null,
            selGoodsIndex:null,
            goodsInfo:{
                id: null,
                goodsName: null,
                goodsImage: null,
                goodsSource: null,
                supply: null,
                supplyTel: null,
                putTime: null,
                note: null,
                user_id: null,
                number: null,
                company: null,
                state: null,
            }
        },
        methods: {
            selPhoto:function(){
                var fileObj = document.getElementById("file1").files[0];
                var reader = new FileReader();
                reader.readAsDataURL(fileObj);
                reader.onload=function(e){
                    $('#goodsImg').get(0).src = e.target.result;
                }
                this.uploadPhoto();
            },
            uploadPhoto(){
                var formData = new FormData();
                var fileObj = document.getElementById("file1").files[0];
                formData.append("upload",fileObj);
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
                        that.goodsInfo.goodsImage = data.photo;
                    }
                });
            },
            getGoods: function (info) {
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
                getGoods();
            },
            setGoods:function(item , index){
              this.goodsInfo=$.extend(true, {}, item);
              this.oldGoodsInfo = item;
              this.selGoodsIndex = index;
            },
            checkGoods:function(){
              var flag = true;
                if(this.goodsInfo.goodsImage != this.oldGoodsInfo.goodsImage) flag = false;
                if(this.goodsInfo.goodsSource != this.oldGoodsInfo.goodsSource) flag = false;
                if(this.goodsInfo.supply != this.oldGoodsInfo.supply) flag = false;
                if(this.goodsInfo.supplyTel != this.oldGoodsInfo.supplyTel) flag = false;
                if(this.goodsInfo.note != this.oldGoodsInfo.note) flag = false;
                if(this.goodsInfo.goodsName != this.oldGoodsInfo.goodsName) flag = false;
                if(flag == true) alert("您还未做出修改！")
              return flag;
            },
            updateGoodsById:function(id,state,index){
                if(state != -1){
                    if (state == 0){
                        state = 1;
                    }else {
                        state = 0;
                    }
                    var data = {
                        state : state,
                        id : id
                    }
                }else{
                    if(this.checkGoods()){
                        return;
                    }
                    var data = this.goodsInfo;
                }

              var that = this;
            axios.post('goods/AdminUpdateGoodsById', data)
                .then(function (response) {
                    console.log(response)
                    if(response.data.result == "success"){
                        alert("修改成功!");
                        $("#myModal").modal('hide');
                        getGoods();

                    }
                })

            },
            dateFormat: function (time) {
                var date = new Date(time);
                var year = date.getFullYear();
                /* 在日期格式中，月份是从0开始的，因此要加0
                 * 使用三元表达式在小于10的前面加0，以达到格式统一  如 09:11:05
                 * */
                var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
                var day = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
                var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
                var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
                var seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
                // 拼接
                return year + "-" + month + "-" + day;
            }

        }
    })



    function getGoods() {
        var data = {
            pageNow: vue.$data.pageNow,
            pageSize: vue.$data.pageSize,
            state: vue.$data.state
        }
        var that = vue.$data
        axios.post('goods/findGoodsLimitByState', data)
            .then(function (response) {
                console.log(response)
                that.lineCount = response.data.pageInfo.lineCount;
                that.pageSize = response.data.pageInfo.pageSize;
                that.pageCount = response.data.pageInfo.pageCount;
                that.pageNow = response.data.pageInfo.pageNow;
                that.startCount = response.data.pageInfo.startCount;
                that.goods = response.data.goods;
                console.log(that.goods)
            })
    }
</script>
</html>
