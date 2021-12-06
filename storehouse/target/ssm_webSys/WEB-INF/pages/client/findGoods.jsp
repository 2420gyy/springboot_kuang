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
    <title>查询</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="css/myStyle.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
</head>
<body>
<jsp:include page="navHead.jsp"/>
<div class="container-fluid">
    <div class="row" id="goodsMainBox">
        <div class="col-sm-3">
            <h3 class="text-left text-primary">查询货物<span class="glyphicon glyphicon-search"></span></h3>
        </div>
        <div class="col-sm-9">
                <div class="row" id="findGoodInputBox">
                    <div class="col-sm-6">
                        <div class="input-group">
                            <input type="text" class="form-control" v-model="findInfo">
                            <div class="input-group-btn">
                                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                    {{ querySel }}
                                    <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu pull-right">
                                    <li>
                                        <a href="javascript:void(0)" v-for="(item,index) in goodsTitles" @click="selCondition(item)">
                                            {{ item.titleName }}
                                        </a>
                                    </li>
                                </ul>
                            </div><!-- /btn-group -->
                        </div><!-- /input-group -->
                    </div><!-- /.col-lg-6 -->
                    <div class="col-sm-6 text-left">
                        <button type="button" class="btn btn-success col-sm-3" @click="findGoods"><span class="glyphicon glyphicon-search"></span>查询</button>
                    </div>
                </div><!-- /.row -->
        </div>
        <div class="col-sm-12"><hr/></div>
        <div class="col-sm-12 text-center" v-if="!isShow">
            <h3 class="text-info">{{ boxTip }}</h3>
        </div>
        <div class="col-sm-3" v-if="isShow" v-for="(item,index) in goods">
            <div class="row goodsBox">
                <div class="col-sm-12 goodsImgBox">
                    <img :src="item.goodsImage" class="goodsImage img-thumbnail"/>
                </div>
                <div class="col-sm-12 text-center">
                    <p>货物名:<strong class="text-danger">{{item.goodsName}}</strong></p>
                    <p>来源：{{item.goodsSource}}</p>
                    <p>库存：{{item.number}} {{item.company}}</p>
                </div>
                <div class="col-sm-offset-2 col-sm-8 text-center" :id="'outInput_' + index"
                     style="margin-bottom: 5px; display: none; ">
                    <div class="input-group input-group-sm">
                        <input type="text" class="form-control" placeholder="请输入出库的数量" v-model="updateNumber"/>
                        <a class="input-group-addon" href="javascript:void(0)" @click="updateGoods('出库' , item.id ,index)">
                            <span>提交出库</span></a>
                        <a class="input-group-addon" href="javascript:void(0)" @click="hidenInput">
                            <span class="glyphicon glyphicon-remove"></span></a>
                    </div>
                </div>
                <div class="col-sm-offset-2 col-sm-8 text-center" :id="'putInput_' + index"
                     style="margin-bottom: 5px; display: none; ">
                    <div class="input-group input-group-sm">
                        <input type="text" class="form-control" placeholder="请输入入库的数量" v-model="updateNumber"/>
                        <a class="input-group-addon" href="javascript:void(0)" @click="updateGoods('入库' , item.id ,index)">
                            <span>提交入库</span></a>
                        <a class="input-group-addon" href="javascript:void(0)" @click="hidenInput">
                            <span class="glyphicon glyphicon-remove"></span></a>
                    </div>
                </div>
                <div class="col-sm-12 text-center">
                    <button type="button" class="btn btn-info btn-sm" @click="putGoods(index)">入库</button>
                    <button type="button" class="btn btn-danger btn-sm" @click="outGoods(index)">出库</button>
                    <button type="button" class="btn btn-success btn-sm" @click="showGoodsInfo(item)">详情</button>
                </div>
            </div>
        </div>
        <div class="col-sm-12 text-center" v-if="isShow">
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
        <!-- 模态框（Modal） -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">{{ goodsInfo.goodsName }}</h4>
                    </div>
                    <div class="modal-body bg-success">
                        <div class="row">
                            <table class="table table-hover">
                                <tbody>
                                <tr>
                                    <td>货物id</td>
                                    <td>{{ goodsInfo.id}}</td>
                                </tr>
                                <tr>
                                    <td>来源</td>
                                    <td>{{ goodsInfo.goodsSource }}</td>
                                </tr>
                                <tr>
                                    <td>供货商</td>
                                    <td>{{ goodsInfo.supply}}</td>
                                </tr>
                                <tr>
                                    <td>联系电话</td>
                                    <td>{{ goodsInfo.supplyTel }}</td>
                                </tr>
                                <tr>
                                    <td>上架时间</td>
                                    <td>{{ goodsInfo.putTime }}</td>
                                </tr>
                                <tr>
                                    <td>库存</td>
                                    <td>{{ goodsInfo.number}} {{ goodsInfo.company }}</td>
                                </tr>
                                <tr>
                                    <td>简介</td>
                                    <td>{{ goodsInfo.note }}</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">关闭</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal -->
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>

<script src="js/vue.js" type="text/javascript" charset="utf-8"></script>
<script src="js/axios.js" type="text/javascript" charset="UTF-8"></script>
<script type="text/javascript">
    $(function () {
        findAllGoodsTitle();
    })

    var vue = new Vue({
        el: '#goodsMainBox',
        data: {
            lineCount: null, //货物总数量
            pageSize: 4,     //页面大小
            pageCount: null,//页面数量
            pageNow: 1,      //当前页码
            state: 1,        //货物状态
            startCount: null, //页面起始货物条数
            goods: [],
            goodsTitles:[],
            findInfo:null,
            oldFindInfo:null,
            querySel:"请选择查询条件",
            title:null,
            updateNumber: null,
            warehousing: null,
            isShow:false,
            boxTip:"请查询！",
            goodsInfo: {
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
            selCondition:function(info){
                this.querySel = info.titleName;
                this.title = info;
            },
            showGoodsInfo: function (info) {
                this.goodsInfo = info;
                this.goodsInfo.putTime = this.dateFormat(info.putTime);
                $("#myModal").modal('show');
            },
            hidenInput:function(){
                for (var i = 0; i < this.pageSize; i++) {
                    var outInputId = "#outInput_" + i;
                    var putInputId = "#putInput_" + i;
                    $(outInputId).css({"display": "none"});
                    $(putInputId).css({"display": "none"});
                }
            },
            getGoods: function (info) {
                for (var i = 0; i < this.pageSize; i++) {
                    var outInputId = "#outInput_" + i;
                    var putInputId = "#putInput_" + i;
                    $(outInputId).css({"display": "none"});
                    $(putInputId).css({"display": "none"});
                }
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
                this.findGoods();
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
                return year + "-" + month + "-" + day + " " + hours + ":" + minutes + ":" + seconds;
            },
            outGoods: function (info) {
                this.updateNumber = null;
                for (var i = 0; i < this.pageSize; i++) {
                    var outInputId = "#outInput_" + i;
                    var putInputId = "#putInput_" + i;
                    if (info == i) {
                        $(outInputId).css({"display": "block"});
                    } else {
                        $(outInputId).css({"display": "none"});
                    }
                    $(putInputId).css({"display": "none"});
                }

            },
            putGoods: function (info) {
                this.updateNumber = null;
                for (var i = 0; i < this.pageSize; i++) {
                    var outInputId = "#outInput_" + i;
                    var putInputId = "#putInput_" + i;
                    if (info == i) {
                        $(putInputId).css({"display": "block"});
                    } else {
                        $(putInputId).css({"display": "none"});
                    }
                    $(outInputId).css({"display": "none"});
                }

            },
            updateGoods: function (info, id ,index ) {
                if(info == "出库" && this.goods[index].number < this.updateNumber){
                    alert("警告：库存不足，无法完成操作！")
                    this.updateNumber=null;
                    return;
                }
                if(Number(this.updateNumber) < 1 || this.updateNumber == null || this.updateNumber.trim() == ""){
                    alert("警告：操作的数量最少为1")
                    this.updateNumber=null;
                    return;
                }
                this.warehousing = info;
                var that = this;
                axios.post('goods/updateGoodsById', {warehousing:this.warehousing,id:id,number: this.updateNumber})
                    .then(function (response) {
                        console.log(response);
                        if(response.data.result == "success"){
                            alert("操作成功！")
                            if(info == "入库"){
                                console.log(that.goods[index]);
                                that.goods[index].number = Number(that.goods[index].number)+Number(that.updateNumber);
                            }else if(info == "出库"){
                                that.goods[index].number = Number(that.goods[index].number)-Number(that.updateNumber);
                            }
                            that.updateNumber =  null;
                        }else{
                            alert("操作失败，请联系管理员！")
                        }
                        for (var i = 0; i < that.pageSize; i++) {
                            var outInputId = "#outInput_" + i;
                            var putInputId = "#putInput_" + i;
                            $(outInputId).css({"display": "none"});
                            $(putInputId).css({"display": "none"});
                        }
                    })

            },
            findGoods:function() {
                if(this.oldFindInfo == null){
                    this.oldFindInfo = this.findInfo;
                }else if(this.oldFindInfo != this.findInfo){
                    this.oldFindInfo = this.findInfo;
                    this.pageNow = 1;
                }
                if(this.querySel == "请选择查询条件"){
                    alert("请先选择查询的条件!")
                    return;
                }
                var that = vue.$data;
                axios.post('goods/findGoodsByGoodsInfoLimit', { title:that.title.title, titleInfo:that.findInfo,pageNow:this.pageNow
                ,pageSize:this.pageSize,state:this.state
                }).then(function (response) {
                        console.log(response);
                        that.lineCount = response.data.pageInfo.lineCount;
                        that.pageSize = response.data.pageInfo.pageSize;
                        that.pageCount = response.data.pageInfo.pageCount;
                        that.pageNow = response.data.pageInfo.pageNow;
                        that.state = response.data.pageInfo.state;
                        that.startCount = response.data.pageInfo.startCount;
                        that.goods = response.data.goods;
                        if(that.goods.length == 0){
                            that.isShow = false;
                        } else{
                            that.isShow = true;
                        }
                        that.boxTip = "暂未找到结果！"
                })

            }

        }
    })
    function findAllGoodsTitle() {
        var that = vue.$data;
        axios.post('goodsTitle/findAllGoodsTitle', {})
            .then(function (response) {
                console.log(response)
                that.goodsTitles = response.data.goodsTitles;
            })
    }
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
                that.state = response.data.pageInfo.state;
                that.startCount = response.data.pageInfo.startCount;
                that.goods = response.data.goods;
                console.log(that.goods)
            })
    }
</script>
</html>
