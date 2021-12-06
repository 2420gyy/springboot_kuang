WebMvcAutoConfiguration
    ResourceProperties
        WebProperties
        Resources
private static final String[] CLASSPATH_RESOURCE_LOCATIONS = { "classpath:/META-INF/resources/",
				"classpath:/resources/", "classpath:/static/", "classpath:/public/" };
	这些目录下的index.html都可以识别

-----
变量$ 选择* 消息# URL@ 片段~
```<div th:object="${session.user}">
       <p>Name: <span th:text="*{firstName}">Sebastian</span>.</p>
       <p>Surname: <span th:text="*{lastName}">Pepper</span>.</p> 
       <p>Nationality: <span th:text={nationality}">Saturn</span>.</p>
   </div> 
   等价于
   <div>
       <p>Name: <span th:text="${session.user.firstName}">Sebastian</span>.</p> 
       <p>Surname: <span th:text="${session.user.lastName}">Pepper</span>.</p> 
       <p>Nationality: <span th:text="${session.user.nationality}">Saturn</span>.</p>
   </div>```

注意请求变了之后，静态地址也会变化，此时使用绝对路径

某些页面在登录前不能进入，使用拦截器
