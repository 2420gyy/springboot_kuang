vue:
生命周期
vuex
组件间传值
路由
全局事件总线
他的基础语法

js:
然后就是js里面常用的数组方法
对象方法

css:
css的flex布局


1.v-text/v-html : 文本节点 {{}}在网络不好时全部加载不等js，text则等到js加载完成才显示
2.v-bind : 属性节点 src/style
3.v-bind 绑定样式<标签 :class="{small1:isSmall,big1:isBig}">{{message}}/标签>
isSmall为data值，布尔形式； v-bind:class="['a','b']" 同时绑定两个
4.v-bind 三元表达式 :class="[isSmall?'small1':'big1',isBig?'':'big1']"
5.v-if 和v-show : v-if删除了DOM节点 v-show 控制display样式；复杂逻辑使用computed方式
6.vue会尽可能高效的复用元素，如果不想这么做，添加唯一值的key属性
7.列表 	数组形式：v-for="(item,index) in items" item和index位置不可换
对象形式：v-for="(value,key,index) in stuObj"
数字形式：count in 数字 从 1 开始 数字不能是负数
8.v-pre 不编译mustache模板表达式；v-once指令只渲染一次元素和组件，可以用于优化性能
9.v-model 动态双向绑定数据 使用input和textarea元素时
双向绑定修饰符:.lazy 回车或输入框失去焦点后数据才同步
.number 输入值自动转为数字类型(不是数字后就停止，除了e)
.trim 过滤输入的首尾空白字符
10. 监听事件 v-on:事件名='函数名' v-on:简写@ ；在methods种声明事件调用的函数
    调用的函数没有参数时可以不写(),这时默认传入原生事件对象event，可以使用$event，访问原生DOM事件对象
<!-- 
9/4 下午事件修饰符（1h）+vue实例对象61~80（2h）；晚上开始第六章vue组件 
 -->
11. 事件修饰符 在事件处理程序中调用event.preventDefault() 或event.stopPropagation()是非常常见的需求？？？
    可以在方法里实现，但是方法只有纯粹的逻辑，不能处理DOM事件细节，
    stop修饰符：事件冒泡-事件会逐级向上传播，中断则加上stop
12. DOM事件流分为冒泡事件流和捕获事件流，默认前者，.capture修饰捕获事件流 -不懂？？？
13. .self所修饰的事件，只有绑定该事件的元素触发该事件时执行；不受冒泡和捕获触发
14. .prevent修饰符阻止默认事件-含有超链接和方法的a标签，只会执行方法，链接无效
    .once只执行一次方法，事件只生效一次
15. 键盘事件修饰符：.up .down .left .right keyup键盘事件 keyup.enter 回车触发 keyup.ctrl.b
16. 鼠标事件修饰符：左 中 右 .left .middle .right  click.left
    阻止鼠标右击调用系统菜单的默认事件 @click.right.prevent

补充：
1.方法的增强写法
run:function(){}  ->>>  run(){}
2.v-if else 复杂逻辑使用computed方式
3.09-v-for哪些数组的方法是响应式的
4.js高阶函数
5.05-作业可以重复做 class后面可以加布尔值判断是否（哪个）使用类选择器，style后面是字符串改变
