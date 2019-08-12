# J2EE基础知识

## Servlet总结

​	Servlet主要负责接收用户请求HttpServletRequest,在doGet(),doPost()中做相应的处理,并将回应HttpServletResponse反馈给用户。Servlet可以设置初始化参数供Servlet内部使用。一个servlet只会有一个实例,在初始化时调用Init()方法,销毁时调用destroy()方法, **Servlet需要在web.xml中配置**,一个servlet可以设置多个URL访问,Servlet不是线程安全,因此谨慎使用类变量



## Servlet接口中有哪些方法及Servlet生命周期探秘

Servlet接口定义了5个方法,其中三个方法与Servlet生命周期相关

- `void init(ServletConfig config) throws ServletException`
- `void service(ServletRequest req, ServletResponse resp) throws ServletException, java.io.IOException`
- `void destroy()`
- `java.lang.String getServletInfo()`
- `ServletConfig getServletConfig()`

**生命周期:** Web容器加载Servlet并将其实例化后,Servlet生命周期开始,容器运行其init()方法进行Servlet初始化,请求到达时调用servlet的service()方法,service()方法会根据需要调用与请求对应的doGet或doPost等方法; 当服务器关闭或项目被卸载时服务器会将servlet实例销毁,此事调用destroy()方法。init和destroy只会执行一次,service方法客户端每请求servlet都会执行。



## get和Post请求区别

①get请求用来从服务器上获得资源，而post是用来向服务器提交数据；

②get将表单中数据按照name=value的形式，添加到action 所指向的URL 后面，并且两者使用"?"连接，而各个变量之间使用"&"连接；post是将表单中的数据放在HTTP协议的请求头或消息体中，传递到action所指向URL；

③get传输的数据要受到URL长度限制（最大长度是 2048 个字符）；而post可以传输大量的数据，上传文件通常要使用post方式；

④使用get时参数会显示在地址栏上，如果这些数据不是敏感数据，那么可以使用get；对于敏感数据还是应用使用post；

⑤get使用MIME类型application/x-www-form-urlencoded的URL编码（也叫百分号编码）文本的格式传递参数，保证被传送的参数由遵循规范的文本组成，例如一个空格的编码是"%20"。

补充：GET方式提交表单的典型应用是搜索引擎。GET方式就是被设计为查询用的。



##### 什么情况用 doGet()和doPost()

​	Form标签里的method属性为get时调用doGet(),为post时调用doPost()



## 转发(Forward)和重定向(Redirect)的区别

**转发是服务器 行为,重定向是客户端行为**

转发(Forward)通过RequestDispatcher对象的forward(HttpServletRequest request,HttpServletResponse response)方法实现的。RequestDispatcher可以通过HttpServletRequest的getRequestDispatcher()方法获得



重定向(Redirect)是利用服务器返回的 状态码来实现的。客户端浏览器请求服务器的时候,服务器会返回一个状态码,服务器通过HttpServletResponse的 setStatus(int status)方法设置状态码。如果服务器返回301或302,则浏览器会到新的网址重新请求该资源

1. **从地址栏显示来说**

forward是服务器请求资源,服务器直接访问目标地址的URL,把那个URL的响应内容读取过来,然后把这些内容再发给浏览器.浏览器根本不知道服务器发送的内容从哪里来的,所以它的地址栏还是原来的地址. redirect是服务端根据逻辑,发送一个状态码,告诉浏览器重新去请求那个地址.所以地址栏显示的是新的URL.

1. **从数据共享来说**

forward:转发页面和转发到的页面可以共享request里面的数据. redirect:不能共享数据.

1. **从运用地方来说**

forward:一般用于用户登陆的时候,根据角色转发到相应的模块. redirect:一般用于用户注销登陆时返回主页面和跳转到其它的网站等

1. **从效率来说**

forward:高. redirect:低.



## 自动刷新(Refresh)

自动刷新不仅可以实现一段时间之后自动跳转到另一个页面，还可以实现一段时间之后自动刷新本页面。Servlet中通过HttpServletResponse对象设置Header属性实现自动刷新例如：

```
Response.setHeader("Refresh","5;URL=http://localhost:8080/servlet/example.htm");
```

其中5为时间，单位为秒。URL指定就是要跳转的页面（如果设置自己的路径，就会实现每过5秒自动刷新本页面一次）\



## JSP和Servlet是什么关系

其实这个问题在上面已经阐述过了，Servlet是一个特殊的Java程序，它运行于服务器的JVM中，能够依靠服务器的支持向浏览器提供显示内容。JSP本质上是Servlet的一种简易形式，JSP会被服务器处理成一个类似于Servlet的Java程序，可以简化页面内容的生成。Servlet和JSP最主要的不同点在于，Servlet的应用逻辑是在Java文件中，并且完全从表示层中的HTML分离开来。而JSP的情况是Java和HTML可以组合成一个扩展名为.jsp的文件。有人说，Servlet就是在Java中写HTML，而JSP就是在HTML中写Java代码，当然这个说法是很片面且不够准确的。JSP侧重于视图，Servlet更侧重于控制逻辑，在MVC架构模式中，JSP适合充当视图（view）而Servlet适合充当控制器（controller）。